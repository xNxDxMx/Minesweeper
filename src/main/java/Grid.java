package group2.hw5.minesweeper;

import java.util.Random;

/**
 * Grid Class for minesweeper
 *
 * Represents the Minesweeper board, managing cells, mines, 
 * and the logic for placing mines and calculating adjacent mine counts.
 * 
 * @author Julian Hinojosa
 * @author Nathaniel McPherson
 * @author Kyle Tschida
 */

 public class Grid {

    // --- Fields ---

    private int rows;             // Number of rows in the grid
    private int cols;             // Number of columns in the grid
    private final Cell[][] cells; // 2D array of cells
    private int totalMines;       // Total number of mines in the grid

    /**
     * Constructor for Grid.
     * 
     * Creates a grid of size 8x8 or 16x16 with a standard number of mines.
     *
     * @param size The size of the grid (must be 8 or 16)
     */
    public Grid(int size) {
        if (size != 8 && size != 16) {
            throw new IllegalArgumentException("Grid size must be 8 or 16");
        }

        this.rows = size;
        this.cols = size;
        this.totalMines = size == 8 ? 10 : 40; // Classic Minesweeper: 8x8 → 10 mines, 16x16 → 40 mines
        this.cells = new Cell[rows][cols];

        initializeGrid();          // Create empty cells
        placeMines();              // Randomly place mines
        calculateAdjacentMineCounts(); // Calculate number of neighboring mines for each cell
    }

    /**
     * Initializes the grid by creating new Cell objects for every position.
     */
    private void initializeGrid() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col] = new Cell(row, col); // Create a new cell at (row, col)
            }
        }
    }

    /**
     * Randomly places mines into the grid.
     * Ensures no cell gets more than one mine.
     */
    private void placeMines() {
        Random rand = new Random();
        int placedMines = 0;

        while (placedMines < totalMines) {
            int row = rand.nextInt(rows); // Random row
            int col = rand.nextInt(cols); // Random column

            Cell cell = cells[row][col];
            if (!cell.hasMine()) {
                cell.setMine(true); // Place a mine if there isn't one already
                placedMines++;
            }
        }
    }

    /**
     * Calculates the number of mines adjacent to each non-mine cell.
     * 
     * Uses 8-directional checking (N, NE, E, SE, S, SW, W, NW).
     */
    private void calculateAdjacentMineCounts() {
        // Direction vectors for all 8 neighboring positions
        int[] dRow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dCol = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Cell cell = cells[row][col];
                if (cell.hasMine()) {
                    continue; // Skip mine cells
                }

                int count = 0;
                // Check all 8 neighbors
                for (int i = 0; i < 8; i++) {
                    int newRow = row + dRow[i];
                    int newCol = col + dCol[i];
                    if (isInBounds(newRow, newCol) && cells[newRow][newCol].hasMine()) {
                        count++; // Increment count if neighbor has a mine
                    }
                }
                cell.setAdjacentMines(count); // Set the adjacent mine count
            }
        }
    }

    /**
     * Checks if a (row, col) coordinate is within the grid boundaries.
     * 
     * @param row The row index
     * @param col The column index
     * @return true if coordinates are inside the grid, false otherwise
     */
    public boolean isInBounds(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    /**
     * Gets the Cell at a specified (row, col).
     * 
     * @param row The row index
     * @param col The column index
     * @return The Cell object at the given coordinates
     * @throws IndexOutOfBoundsException if the coordinates are outside the grid
     */
    public Cell getCell(int row, int col) {
        if (!isInBounds(row, col)) {
            throw new IndexOutOfBoundsException("Cell coordinates out of bounds.");
        }
        return cells[row][col];
    }

    // --- Getters for grid information ---

    /**
     * @return the number of rows in the grid
     */
    public int getRows() {
        return rows;
    }

    /**
     * @return the number of columns in the grid
     */
    public int getCols() {
        return cols;
    }

    /**
     * @return the total number of mines in the grid
     */
    public int getTotalMines() {
        return totalMines;
    }

    /**
     * @return the 2D array of cells in the grid
     */
    public Cell[][] getCells() {
        return cells;
    }
}
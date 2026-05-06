package group2.hw5.minesweeper;

/**
 * Minesweeper Class for minesweeper
 * 
 * This class represents the core game logic:
 * - Managing the grid and player actions
 * - Handling reveal logic, flood fill, flags
 * - Determining win or loss conditions
 *
 * @author Julian Hinojosa
 * @author Nathaniel McPherson
 * @author Kyle Tschida
 */

 public class Minesweeper {

    // --- Fields ---

    private final Grid grid;          // The Minesweeper game board (grid of cells)
    private boolean gameOver;         // True if the game has ended
    private boolean gameWon;          // True if the player has won the game
    private int cellsToReveal;        // Number of non-mine cells that still need to be revealed to win

    /**
     * Constructor for Minesweeper.
     * 
     * Initializes a new game with a specified board size.
     * 
     * @param size The size of the board (must match allowed sizes for Grid)
     */
    public Minesweeper(int size) {
        this.grid = new Grid(size);
        this.gameOver = false;
        this.gameWon = false;
        this.cellsToReveal = (size * size) - grid.getTotalMines(); // Calculate total non-mine cells
    }

    /**
     * @return the grid object representing the Minesweeper board
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * @return true if the game is over
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * @return true if the player has won the game
     */
    public boolean isGameWon() {
        return gameWon;
    }

    // --- Core Gameplay Methods ---

    /**
     * Reveals the cell at the given (row, col).
     * 
     * If the revealed cell has a mine, the game is lost.
     * If the cell is empty (0 adjacent mines), recursively reveals its neighbors (flood fill).
     * If all non-mine cells are revealed, the player wins.
     *
     * @param row The row index
     * @param col The column index
     */
    public void revealCell(int row, int col) {
        // Do nothing if game is already over or out of bounds
        if (gameOver || !grid.isInBounds(row, col)) return;

        Cell cell = grid.getCell(row, col);

        // Only reveal cells that can be revealed (not flagged or already revealed)
        if (!cell.canBeRevealed()) return;

        // Reveal the cell
        cell.setRevealed(true);
        cellsToReveal--;

        // If a mine was revealed, end the game and reveal all mines
        if (cell.hasMine()) {
            gameOver = true;
            revealAllMines();
            return;
        }

        // If an empty cell was revealed, recursively reveal surrounding cells
        if (cell.isEmpty()) {
            floodReveal(row, col);
        }

        // If no more safe cells left to reveal, player wins
        if (cellsToReveal == 0) {
            gameWon = true;
            gameOver = true;
        }
    }

    /**
     * Recursive helper method to flood-reveal neighboring cells.
     * 
     * Reveals all connected empty cells and their immediate non-empty neighbors.
     *
     * @param row Current cell row
     * @param col Current cell column
     */
    private void floodReveal(int row, int col) {
        // Direction vectors for 8 adjacent neighbors
        int[] dRow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dCol = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            if (!grid.isInBounds(newRow, newCol)) continue;

            Cell neighbor = grid.getCell(newRow, newCol);

            // Reveal neighbor if possible
            if (neighbor.canBeRevealed()) {
                neighbor.setRevealed(true);
                cellsToReveal--;

                // If neighbor is also empty, continue flood reveal
                if (neighbor.isEmpty()) {
                    floodReveal(newRow, newCol);
                }
            }
        }
    }

    /**
     * Toggles a flag on a cell at (row, col).
     * 
     * If already flagged, unflags it.
     * Only allowed if the cell has not been revealed yet.
     *
     * @param row The row index
     * @param col The column index
     */
    public void toggleFlag(int row, int col) {
        if (gameOver || !grid.isInBounds(row, col)) return;

        Cell cell = grid.getCell(row, col);

        if (cell.isRevealed()) return; // Can't flag revealed cells

        cell.setFlagged(!cell.isFlagged()); // Toggle flag state
    }

    /**
     * Reveals all mines on the board.
     * 
     * Typically called when the player loses (after stepping on a mine).
     * Helps the UI show all mine locations.
     */
    private void revealAllMines() {
        for (int r = 0; r < grid.getRows(); r++) {
            for (int c = 0; c < grid.getCols(); c++) {
                Cell cell = grid.getCell(r, c);
                if (cell.hasMine()) {
                    cell.setRevealed(true); // Force reveal mines
                }
            }
        }
    }
}
package group2.hw5.minesweeper;

/**
 * Mine Class for minesweeper
 * 
 * Represents a mine object that is associated with a specific cell.
 * When a Mine is created, it automatically marks the linked cell as containing a mine.
 * 
 * @author Julian Hinojosa
 * @author Nathaniel McPherson
 * @author Kyle Tschida
 */

 public class Mine {

    private final Cell cell; // The cell where this mine is located

    /**
     * Constructor for Mine.
     * 
     * Links this Mine to a specific Cell and immediately marks that cell as containing a mine.
     * 
     * @param cell The cell where the mine will be placed
     */
    public Mine(Cell cell) {
        this.cell = cell;
        this.cell.setMine(true);  // Set the cell to have a mine immediately upon creation
    }

    /**
     * Checks if the associated cell currently contains a mine.
     * 
     * @return true if the cell has a mine
     */
    public boolean isMine() {
        return cell.hasMine();
    }
}
package group2.hw5.minesweeper;

/**
 * Flag Class for minesweeper
 *
 * Represents a flag placed on a specific cell by the player,
 * helping to mark suspected mines.
 * 
 * @author Julian Hinojosa
 * @author Nathaniel McPherson
 * @author Kyle Tschida
 */

 public class Flag {

    private final Cell cell; // The cell associated with this flag

    /**
     * Constructor for Flag.
     * Associates this flag with a specific cell.
     * @param cell The cell where the flag is placed
     */
    public Flag(Cell cell) {
        this.cell = cell;
    }

    /**
     * Places the flag on the associated cell.
     * Only places the flag if the cell is not already revealed.
     */
    public void placeFlag() {
        if (!cell.isRevealed()) { // Can't flag a revealed cell
            cell.setFlagged(true);
        }
    }

    /**
     * Removes the flag from the associated cell.
     */
    public void removeFlag() {
        cell.setFlagged(false);
    }

    /**
     * Checks if the associated cell is currently flagged.
     * 
     * @return true if the cell is flagged
     */
    public boolean isFlagged() {
        return cell.isFlagged();
    }
}
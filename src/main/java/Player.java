package group2.hw5.minesweeper;

/**
 * Player Class for minesweeper
 *
 * Tracks the player's status (won/lost), flag usage,
 * and handles flag management logic during the game.
 * 
 * @author Julian Hinojosa
 * @author Nathaniel McPherson
 * @author Kyle Tschida
 */

 public class Player {

    // --- Fields ---

    private boolean hasWon;       // True if the player has won the game
    private boolean hasLost;      // True if the player has lost the game
    private int flagsUsed;        // Number of flags the player has currently placed
    private int totalFlags;       // Maximum number of flags the player can place (equal to number of mines)

    /**
     * Constructor for Player.
     * 
     * Initializes a player with the allowed number of flags.
     * 
     * @param totalFlags The maximum number of flags available (usually = number of mines)
     */
    public Player(int totalFlags) {
        this.hasWon = false;
        this.hasLost = false;
        this.flagsUsed = 0;
        this.totalFlags = totalFlags;
    }

    // --- Getters ---

    /**
     * @return true if the player has won
     */
    public boolean hasWon() {
        return hasWon;
    }

    /**
     * @return true if the player has lost
     */
    public boolean hasLost() {
        return hasLost;
    }

    /**
     * @return the number of flags currently used by the player
     */
    public int getFlagsUsed() {
        return flagsUsed;
    }

    /**
     * @return the total number of flags available to the player
     */
    public int getTotalFlags() {
        return totalFlags;
    }

    // --- Methods for Game State ---

    /**
     * Marks the player as having won the game.
     */
    public void win() {
        hasWon = true;
    }

    /**
     * Marks the player as having lost the game.
     */
    public void lose() {
        hasLost = true;
    }

    // --- Methods for Flag Management ---

    /**
     * Checks whether the player can place another flag.
     * 
     * @return true if the player has flags left to place
     */
    public boolean canPlaceFlag() {
        return flagsUsed < totalFlags;
    }

    /**
     * Places a flag.
     * 
     * Increments the number of flags used, but only if the player has flags left.
     */
    public void placeFlag() {
        if (canPlaceFlag()) {
            flagsUsed++;
        }
    }

    /**
     * Removes a flag.
     * 
     * Decrements the number of flags used, but only if at least one flag is currently placed.
     */
    public void removeFlag() {
        if (flagsUsed > 0) {
            flagsUsed--;
        }
    }
}
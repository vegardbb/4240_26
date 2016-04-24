package com.snakeladders.model;

/*
@deprecated - to be removed, Mod. test - see how long it takes to cleanse this singleton off.
 */
public final class Die {
    // Model class for the die that decides how many fields to move during a turn.
    // Administered by the GameBoardController.

    // Fields
    private int highest = -1; // The highest number shown on die, 0 being the lowest. null by default. May be configured by the players.
    private int value = 1; // Current number on the die.

    // Singleton Magic. May be revised if harming testability
    private Die() {}
    private static final Die INSTANCE = new Die();

    public static Die getINSTANCE() { return INSTANCE; }

    // Suggestions:
    // Make class static in order to initialize only ONE die upon starting a new game. What if the attributes need changing??

    // This method is questionable.
    public void setHighestThrow(int nr) { if ( this.highest == -1 ) {this.highest = nr; }}

    public int getHighest() { return this.highest; }

    public int getValue() { return this.value; }

    public void setValue(int nr) { this.value = nr; }

    
    /*
    NOTE: This class is deprecated and will be removed from the project, because controllers can do its job of broadcasting the die number and capping it at 6. Thus we are rid of a singleton
    
    */
}
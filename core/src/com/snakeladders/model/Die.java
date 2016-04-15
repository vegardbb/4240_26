package com.snakeladders.model;


public final class Die {
    // Model class for the die that decides how many fields to move during a turn.
    // Administered by the GameBoardController.

    // Fields
    private int highest = -1; // The highest number shown on die, 0 being the lowest. null by default. May be configured by the players.
    private int throwed = 0; // Current number on the die.

    // Singleton Magic. May be revised if harming testability
    private Die() {}
    private static final Die INSTANCE = new Die();

    public static Die getDie() {
        return INSTANCE; }

    // Suggestions:
    // Make class static in order to initialize only ONE die upon starting a new game. What if the attributes need changing??

    // This method is questionable.
    public void setHighestThrow(int nr) { if ( this.highest == -1 ) {this.highest = nr; }}

    public int getHighest() { return this.highest; }

    public int getThrowed() { return this.throwed; }

    public void setThrowed(int nr) { this.throwed = nr; }

    /*

    Scenarios

    Testers

    Use Case Diagram

    Validate current architecture, and drive architectural increment.

     */

}
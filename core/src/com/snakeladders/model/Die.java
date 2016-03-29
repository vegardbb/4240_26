package com.snakeladders.model;

public class Die {
    // Model class for the die that decides how many fields to move during a turn.
    // Fields
    private int highest = null; // The highest number shown on die, 0 being the lowest. null by default. May be configured by the players.
    private int throwed = 0; // Current number on the die.
    
    // Singleton Magic. May be revised if harming testability
    private Die() {}
    // Suggestions:
    // Make class static in order to initialize only ONE die upon starting a new game.
    // TODO: Add model properties in accordance to libgdx view elements, such as a private Sprite, its dimenions etc.

    // This method is questionable.
    public void setHighestThrow(int nr) { if (this.highest == null ) {this.highest = nr; }} 

    public int getHighest() { return this.highest; }

    public int getThrowed() { return this.throwed; }

    public void setThrowed(int nr) { this.throwed = nr; }
}

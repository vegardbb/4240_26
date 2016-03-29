package com.snakeladders.model;

public class Player {
    private String name;
    private int nrthrows; // Amount of moves.
    private Field currentField; // Where am I on the board.
    // TODO: Add Sprite as its own private field
    // TODO: Add more statitics regarding fields landed on,
    // One could alternatively have a seperate Score instance for each player.
    private int chanceHad; // Statistics
    private int laddersUp;
    private int  laddersDown;
    
    private int xCoord; // Needed?
    private int yCoord;
}

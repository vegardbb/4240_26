package com.snakeladders.model;

public class Player {
    private String name;
    private int start; // When it is my turn. Also, acts as tie breaker.
    private Field currentField; // Where am I on the board.
    private boolean isActive;
    
    public Player(String name, int start) {
        this.isActive = true;
        this.currentField = null;
        this.start = start;
        this.name = name;
    }
}

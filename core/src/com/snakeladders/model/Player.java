package com.snakeladders.model;

public class Player {
    private String name;
    private int start; // When it is my turn. Also, acts as tie breaker.
    private Field currentField; // Where am I on the board.
    private boolean isActive;
    
    public Player(String name, int start) {
        this.setIsActive(true);
        this.setCurrentField(null);
        this.start = start;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getStart() {
        return start;
    }

    public Field getCurrentField() {
        return currentField;
    }

    public void setCurrentField(Field currentField) {
        this.currentField = currentField;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}

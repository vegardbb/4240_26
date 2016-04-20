package com.snakeladders.model;

public class Player {
    private String name;
    private int start; // When it is my turn. Also, acts as tie breaker.
    private Field currentField; // Where am I on the board. Also, serves as indirect mapping to view.
    private boolean isActive;
    private boolean skipField = false; // Enables you to skip going down a ladder or doing a chance Field
    private boolean wrongWay = false; // If true, the player goes the wrong way on the next turn
    private boolean doubleStep = false; // If true, the player goes twice the die on the next turn
    
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

    public float getXPos(){
        float x = currentField.getXpos();
        float offset = currentField.getSize()/2;
        switch (getStart()){
            case 1:case 2:
                x += offset;
                break;
        }
        return x;
    }

    public float getYPos(){
        float y = currentField.getYpos();
        float offset = currentField.getSize()/2;
        switch (getStart()){
            case 2:case 3:
                y += offset;
                break;
        }
        return y;
    }
}

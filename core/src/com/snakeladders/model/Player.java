package com.snakeladders.model;

public class Player {
    private String name;
    private int start; // When it is my turn.
    private Field currentField; // Where am I on the board. Also, serves as indirect mapping to view.
    private boolean skipField = false; // Enables you to skip going down a ladder or doing a chance Field. Removed.
    private boolean wrongWay = false; // If true, the player goes the wrong way on the next turn
    private boolean doubleStep = false; // If true, the player goes twice the die on the next turn
    
    public Player(String name, int start) {
        this.setCurrentField(null);
        this.start = start;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void resetTokens() {
        this.skipField = false;
        this.wrongWay = false;
        this.doubleStep = false;
    }
    public void setSkipField() {
        this.skipField = true;
    }
    public void setWrongWay() {
        this.wrongWay = true;
    }
    public void setDoubleStep() {
        this.doubleStep = true;
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

    public boolean isSkipField() {
        return skipField;
    }

    public boolean isWrongWay() {
        return wrongWay;
    }

    public boolean isDoubleStep() {
        return doubleStep;
    }
}

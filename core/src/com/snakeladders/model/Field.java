package com.snakeladders.model;

//import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class Field {
    /**
     Model class for the template field that contains all the things that make up the SnakeLadders Game

     This is a general template class extended by NormalField, ChanceField and LadderField.
     **/

    private int id;
    private int xStart; // The startposition in the upper left corner of the field, x-component
    private int yStart; // The startposition in the upper left corner of the field, y-component

    // TODO: Move teleporttoField to the telport class. Not nescessary in the other two fields
    //private Field teleportToField = null; //Used by ladderFields and occasionally chancefields, normally null for Normalfield.

    private Board board; // Reference to the board the field belongs to.    

    public Field(Board board, int i, int x, int y) {
        this.board = board;
        this.id = i;
        this.xStart = x;
        this.yStart = y;
    }
    public Board getBoard() {return this.board; }
    public int getId() {return this.id; }
    public int getXpos() {return this.xStart; }
    public int getYpos() {return this.yStart; }

}
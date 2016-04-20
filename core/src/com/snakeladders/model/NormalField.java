package com.snakeladders.model;

public class NormalField extends Field{
    /**
    Contents:

    private int id;
    //private Field teleportToField = null; //Used by ladderFields and occasionally chancefields, normally null for Normalfield.
    private Board board; // Reference to the board the field belongs to.
    
    **/

    public NormalField(Board board, int i, float x, float y, float size) {
        super(board, i, x, y, size);
    }
}
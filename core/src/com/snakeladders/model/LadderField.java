package com.snakeladders.model;

public class LadderField extends Field{
    /**
    Model class for the field that contains all the things that make up our implementation of Stigespillet

    Contents:

    All fields are generated by the GameScreenController Class. This class makes sure that you wo't be telwported ad infinitum.
    This class does nothing, aside from contributing to represent the state of the game.

    private int id;
    private Board board; // Reference to the board the field belongs to.
    **/

    private int ref; // The reference to the fieldID to teleport to, used by ladderUp case
    private Field teleportToField; //Used by ladderFields and occasionally chancefields, normally null for Normalfield.

    public LadderField(Board board, int i, Field teleportToField, float x, float y, float size) { //Note that x and y are floats to the corresponding fieldActor
        super(board, i, x, y, size);
        if (teleportToField != null) {
            this.teleportToField = teleportToField;
            this.ref = teleportToField.getId(); // May not be needed
        }

    }

    /*
    public LadderField(Board board, int i, int r, int x, int y) { // used in FieldFactory only
        super(board, i, x, y);
        this.ref = r; // Future teleportField
    } */

    public Field getTeleportToField() {return this.teleportToField; }
    //public void setTeleportToField(Field f) { if ((this.teleportToField==null) && (f.getId() == ref) ) { this.teleportToField = f; } }
    public void setTeleportToField(Field f) { this.teleportToField = f; }
}
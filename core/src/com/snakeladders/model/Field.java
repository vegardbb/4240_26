package com.snakeladders.model;

import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class Field extends Actor {
    /**
     Model class for the template field that contains all the things that make up the SnakeLadders Game

     This is a general template class extended by NormalField, ChanceField and LadderField.
     **/

    private int id;
    private Field teleportToField = null; //Used by ladderFields and occasionally chancefields, normally null for Normalfield.
    private Board board; // Reference to the board the field belongs to.
    
    public Field(Board board, int i, Field teleportToField) {
        this.board = board;
        this.id = i;
        this.teleportToField = teleportToField;
    }
    public Board getBoard() {return this.board; }
    public Field getTeleportToField() {return this.teleportToField; }
    public int getId() {return this.id; }

}
package com.snakeladders.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ChanceField extends Field{

    private int id;

    /**
    Model class for the field that contains all the things that make up our implementation of Stigespillet

    Contents:

    All fields are generated by the GameScreenController Class. This class makes sure that you wo't be telwported ad infinitum.
    This class does nothing, aside from contributing to represent the state of the game.
     **/

    /**
    Legend:
    KEEPCARD - sets the keepCard token on the relevant Player. With this flag on, the Player has the opportunity to skip a board event upon landing on a ladderField or another Chancefield.
    NEWTURN - the Player immediately rolls the die and moves on the board
    DOUBLE - on the next turn the Player moves twice as long as the die number indicates
    START - the Player is promptly teleported back to Start
    BACKWARDS - on the next turn the Player moves in the opposite direction
    **/
    private enum Type {KEEPCARD, NEWTURN, DOUBLE, START, BACKWARDS} // Class within me
    
//    private Type fieldtype; // We will not need this field. Also, we may as well consider leaving the teleporterField out of the constructor too, because normalField does not need it.
    //private Field teleportToField; //Used by ladderFields and occasionally chancefields, normally null for Normalfield.
    private Board board; // Reference to the board the field belongs to.

    public ChanceField(Board board, int i, float x, float y) {
        super(board, i, x, y);
        //this.fieldtype = randomChoice(); // Choose a type randomly.
    }
//    public Type getFieldType(){ return this.fieldtype; }

    // Fields for choosing a random ChanceField Type
    private static final List<Type> VALUES =
            Collections.unmodifiableList(Arrays.asList(Type.values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public Type randomChoice()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    } //private static


}
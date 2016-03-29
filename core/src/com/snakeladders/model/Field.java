package com.snakeladders.model;

public class Field {
    /**
    Model class for the template field that contains all the things that make up our Stigespill
    Contents:
    The Sprite. Located in assets directory. Animated sprites defined in image file. 
    All fields are made by a Field Factory.
    This is a general template class 

    **/
    private int id;
    //private Field previousField; // Relevant only if we were using a linked list of Fields for moving.
    //private Field nextField;  Relevant  only if we were using a linked list of Fields for moving players.
    //private Field teleportField; //Used by ladderFields only.
    private Board board; // Referene to the board the field belongs to.

    private int xCoord; // Needed?
    private int yCoord;
}
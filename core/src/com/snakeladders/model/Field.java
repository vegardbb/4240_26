package com.snakeladders.model;

public abstract class Field {
    /**
     Model template class for the template field that contains all the things that make up the SnakeLadders Game
     Here we use the Template pattern to avoid duplicate code in the model package, which would be detrimental to both modifiability (more work to change things) and testability (harder to control) 

     This is a general template class extended by NormalField, ChanceField and LadderField.
     **/

    private int id;
    private float xStart; // The startPosition in the upper left corner of the field, x-component
    private float yStart; // The startPosition in the upper left corner of the field, y-component
    private float size;

    public Field(int i, float x, float y, float size) {
        this.id = i;
        this.xStart = x;
        this.yStart = y;
        this.size = size;
    }
    public int getId() { return this.id; }
    public float getXpos() { return this.xStart; }
    public float getYpos() { return this.yStart; }
    public float getSize() { return this.size; }

}
package com.snakeladders.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ChanceField extends Field{

    /**
     Model class for the field that spurs one of five random events for the player landing on it.
     Exactly what happens is decided randomly.
     **/

    /**
     Legend for Type, the nested class that represents the five possible events that may occur when
       a player lands on this field.
     SWAP - Player Randomly switches places with another player.
     DOUBLE - on the next turn the Player moves twice as long as the die number indicates
     BACKWARDS - on the next turn the Player moves in the opposite direction
     KEEPAWAY - On the next turn the Player avoids any possible board event, and will neither climb
       a ladder nor do a chance event should they land on such a field
     JUMP - the Player is promptly teleported up to six fields forward
    **/
    public enum Type {KEEPAWAY, BACKWARDS, DOUBLE, JUMP, SWAP} // Class within me
    
    public ChanceField(Board board, int i, float x, float y, float size) {
        super(board, i, x, y, size);
    }

    // Fields for choosing a random ChanceField Type
    private static final List<Type> VALUES =
            Collections.unmodifiableList(Arrays.asList(Type.values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public Type randomChoice()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    } //private static


}
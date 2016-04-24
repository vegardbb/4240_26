package com.snakeladders.model;

public final class Die {
    /*
     Model class for the die that decides how many fields a player moves during a turn.
     Accessed by the GameScreenController.
     Quick grammar lesson: "die" = singular form of the more widely used term "dice", which is often
     erroneously used in singular form instead of "die".
      */

    // Fields
    private int value = 1;  // Current number on the die. The die on screen shows one eye at the
                            // start of the game.

    // Singleton Magic. Class is instantiated eagerly.
    private Die() {}
    private static final Die INSTANCE = new Die();

    public static Die getINSTANCE() { return INSTANCE; }

    // Getter and setter for the integer value shown on the die.
    public int getValue() { return this.value; }

    public void setValue(int nr) { this.value = nr; }

}
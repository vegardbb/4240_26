package com.snakeladders.model;

import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;

public final class Board extends Stage {
    /**
 Model class for the game board that contains all the things that make up our Stigespill
    Contents:
    An array with all players on it. Its contents remain the same throughout the game.
    An array of its randomly generated Fields. Do not forget the rules for generating fields are in the controller package. . Its contents remain the same throughout the game.
    A mapping between the players and the fields revealing where the players are at a given turn.

    TODO: Describe functionality on the Board Model.
    
    Note: Board, Player and Die are in fact, not actors, though they could have been so. The actors are in fact, in the controllers, and they implement the rules and works and irons in Stigespillet. For example, the GameScreenController  
    **/
    private int token = 0; // decides whose turn it is. Points to a Player in array of players.
    private ArrayList<Player> playersOnBoard = new ArrayList<Player>();
    private ArrayList<Field> boardfields = new ArrayList<Field>();

    public void setToken(int t) { this.token = t; }

    public void addPlayer(Player p) {
        playersOnBoard.add(p);
    }
    
    public void addField(Field p) {
        boardfields.add(p);
    }

    private static final Board INSTANCE = new Board();

    private Board() {}

    public static Board getInstance() {
        return INSTANCE;
    }


}
package com.snakeladders.model;

public class Board {
    /**
 Model class for the game board that contains all the things that make up our Stigespill
    Contents:
    An array with all players on it. Its contents remain the same throughout the game.
    An array of its randomly generated Fields. Do not forget the rules for generating fields are in the controller package. . Its contents remain the same throughout the game.
    A mapping between the players and the fields revealing where the players are at a given turn.

    TODO: Describe functionality on the Board Model.
    
    Note: Board, Player and Die are in fact, not actors, though they could have been so. The actors are in fact, in the controllers, and they implement the rules in Stigespillet.
    **/
    private int token = 0; // decides whose turn it is. Points to a Player in array of players.
    private Player[] playersOnBoard;
    private Field[] boardfields;

    public void setToken(int t) { this.token = t; }
    public Board(Player[] playersOnBoard, Field[] boardfields) {
        this.playersOnBoard = playersOnBoard;
        this.boardfields = boardfields;
    }
}
package com.snakeladders.model;

import java.util.ArrayList;

public final class Board {
    public enum State { RUNNING, PAUSE, GAMEOVER }
    private State currentState;
    private int token = 0; // decides whose turn it is. Points to a Player in array of players.
    private ArrayList<Player> playersOnBoard = new ArrayList<Player>();
    private ArrayList<Field> boardFields = new ArrayList<Field>();

    public static Board getINSTANCE() {
        return INSTANCE;
    }

    public void addPlayer(Player p) {
        getPlayersOnBoard().add(p);
    }
    
    public void addField(Field p) {
        getBoardFields().add(p);
    }

    private Board() {}
    // Eager initialisation of singleton, ie we have a Board instance up and running even if we quit the game once we start it.
    private static final Board INSTANCE = new Board();
    public static Board getInstance() {
        return getINSTANCE();
    }

    public void clearBoard(){
        playersOnBoard = new ArrayList<Player>();
        boardFields = new ArrayList<Field>();
        token = 0;
    }


    /**
 Model class for the game board that contains all the things that make up our Stigespill
    Contents:
    An array with all players on it. Its contents remain the same throughout the game.
    An array of its randomly generated Fields. Do not forget the rules for generating fields are in the controller package. . Its contents remain the same throughout the game.
    A mapping between the players and the fields revealing where the players are at a given turn.

    TODO: Describe functionality on the Board Model.

    Note: Board, Player and Die are in fact, not actors, though they could have been so.
      The actors are in fact, among the controllers, and they implement the rules and works and irons
      in Stigespillet. For example, the GameScreenController
     Board is not a stage, and the Players are not Actors, otherwise the model has a direct connection to the view, which violates the holiest tenet of MVC.
    **/

    public int getToken() {
        return token;
    }

    public ArrayList<Player> getPlayersOnBoard() {
        return playersOnBoard;
    }

    public ArrayList<Field> getBoardFields() {
        return boardFields;
    }

    public void incToken() {
        if (token >= playersOnBoard.size() - 1) {
            token = 0;
        } else {
            token++;
        }
    }

    public void setState(State state){
        currentState = state;
    }

    public State getCurrentState() {
        return currentState;
    }

    public Player getLeadingPlayer() {
        Player player = playersOnBoard.get(0);
        for (Player p:playersOnBoard){
            if (p.getCurrentField().getId() > player.getCurrentField().getId()){
                player = p;
            }
        }
        return player;
    }
}
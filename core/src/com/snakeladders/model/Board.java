package com.snakeladders.model;

import java.util.ArrayList;

public final class Board {
    /*
    Singleton Object that represents the board in the game.
    */
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
    // Eager initialisation of singleton, i.e. we have a Board instance up and running even if we quit the game once we start it.
    private static final Board INSTANCE = new Board();
    public static Board getInstance() {
        return getINSTANCE();
    }

    // Method to erase all game elements on the board when the game is over. The board itself, however, continues to exist in memory...
    public void clearBoard(){
        playersOnBoard = new ArrayList<Player>();
        boardFields = new ArrayList<Field>();
        token = 0;
    }

    // Getters for the elements on the board save the die
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
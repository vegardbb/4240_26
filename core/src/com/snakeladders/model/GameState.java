package com.snakeladders.model;

public class GameState {
    private enum Gs {MENU, PAUSE, RUNNING, GAMEOVER}
    private Gs gamestate;

    public Gs getGamestate() {
        return gamestate;
    }

    public void setGamestate(Gs gamestate) {
        this.gamestate = gamestate;
    }

}
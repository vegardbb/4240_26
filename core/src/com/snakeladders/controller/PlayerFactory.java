package com.snakeladders.controller;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.snakeladders.model.Assets;
import com.snakeladders.model.Board;
import com.snakeladders.model.Field;
import com.snakeladders.model.Player;
import com.snakeladders.view.PlayerActor;
import java.util.ArrayList;

class PlayerFactory {
    private final Stage stage;
    private Board board;

    public PlayerFactory(Stage stage) {
        this.stage = stage;
        this.board = Board.getINSTANCE();
    }

    public void generatePlayers(int playerCount){
        Field startField = board.getBoardFields().get(0);
        int size = (int) startField.getSize()/2;
        ArrayList<Texture> pieceTextures = Assets.getPieceTextures();

        for (int i = 0; i < playerCount; i++){
            Player player = new Player("Player " + (i + 1), i);
            player.setCurrentField(startField);
            board.addPlayer(player);
            stage.addActor(new PlayerActor(0.0f, 0.0f, size, pieceTextures.get(i), i));
        }
    }
}

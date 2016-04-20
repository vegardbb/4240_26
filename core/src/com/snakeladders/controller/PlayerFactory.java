package com.snakeladders.controller;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.snakeladders.model.Assets;
import com.snakeladders.model.Board;
import com.snakeladders.model.Field;
import com.snakeladders.model.Player;
import com.snakeladders.view.PlayerActor;

import java.util.ArrayList;

/**
 * Created by HellGoose-Laptop on 4/20/2016.
 */
class PlayerFactory {
    private final Stage stage;
    private GameScreenController controller;
    private Board board;

    public PlayerFactory(GameScreenController controller, Stage stage) {
        this.controller = controller;
        this.stage = stage;
        this.board = Board.getINSTANCE();
    }

    public void generatePlayers(int playerCount){
        Field startField = board.getBoardfields().get(0);
        float startX = startField.getXpos();
        float startY = startField.getYpos();
        ArrayList<Texture> pieceTextures = Assets.getPieceTextures();

        for (int i = 0; i < playerCount; i++){
            board.addPlayer(new Player("Spiller " + i + 1, i));
            stage.addActor(new PlayerActor(startX, startY, pieceTextures.get(i)));
        }
    }
}

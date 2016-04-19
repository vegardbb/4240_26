package com.snakeladders.controller;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.snakeladders.model.Assets;
import com.snakeladders.model.Board;
import com.snakeladders.model.LadderField;
import com.snakeladders.model.NormalField;
import com.snakeladders.model.Player;

import java.util.Random;// For usage on randomised boards. Debate how large a degree of "randomness" we want.

public class GameScreenController {
    /**
	Controller class for a splash screen. When touching the screen , the image disappears, screen disposed
	movePlayerLadder( ) // moving a player up or down a ladder
	------
    **/
	SnakeLadders game;
	Board board;
	//Stage gameBoard;

	public GameScreenController(SnakeLadders game) {
		this.game = game;
		this.board = Board.getINSTANCE();
//		this.gameBoard = gameBoard;
	}

	public static Skin getSkin() {
		return Assets.getSkin();
	}


	public void initGame(Stage stage, int playerCount) {
		Texture boardTexture = Assets.getBoardTexture();
		FieldFactory fieldFactory = new FieldFactory(stage);
		fieldFactory.generateFields(boardTexture);
//		PlayerFactory playerFactory = new PlayerFactory(stage);
//		playerFactory.generatePlayers(playerCount);
	}
}


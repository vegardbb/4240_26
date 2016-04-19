package com.snakeladders.controller;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.snakeladders.model.Assets;
import com.snakeladders.model.Board;
import com.snakeladders.model.LadderField;
import com.snakeladders.model.NormalField;

import java.util.Random;// For usage on randomised boards. Debate how large a degree of "randomness" we want.

public class GameScreenController {
    /**
	Controller class for a splash screen. When touching the screen , the image disappears, screen disposed
	movePlayerLadder( ) // moving a player up or down a ladder
	------
    **/
	SnakeLadders game;
	Board board;
	Stage gameBoard;

	public GameScreenController(SnakeLadders game) {
		this.game = game;
//		this.gameBoard = gameBoard;
	}

	public static Skin getSkin() {
		return Assets.getSkin();
	}


	public void initGame(Stage stage) {

	}
}


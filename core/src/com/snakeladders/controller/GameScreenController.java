package com.snakeladders.controller;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.snakeladders.model.Assets;
import com.snakeladders.model.Board;
import com.snakeladders.model.Field;
import com.snakeladders.model.LadderField;
import com.snakeladders.model.NormalField;
import com.snakeladders.model.Player;

import java.util.ArrayList;
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
		FieldFactory fieldFactory = new FieldFactory(stage, this);
		fieldFactory.generateFields(boardTexture);
//		PlayerFactory playerFactory = new PlayerFactory(stage);
//		playerFactory.generatePlayers(playerCount);
	}

	public void drawField(Batch batch, float parentAlpha, Sprite fieldSprite){
		batch.draw(fieldSprite.getTexture(), fieldSprite.getX(), fieldSprite.getY(), fieldSprite.getWidth(), fieldSprite.getHeight());
	}

	public void drawLadders(Stage stage){
		ArrayList<Field> fields = board.getBoardfields();
		for (Field f:fields){
			if (f instanceof LadderField) {
				ShapeRenderer shape = new ShapeRenderer();
				shape.setProjectionMatrix(stage.getCamera().combined);
				shape.begin(ShapeRenderer.ShapeType.Filled);

				float targetX = ((LadderField) f).getTeleportToField().getXpos();
				float targetY = ((LadderField) f).getTeleportToField().getYpos();
				float targetSize = ((LadderField) f).getTeleportToField().getSize();
				float offset = f.getSize()/20;
				shape.setColor(1.0f, 0.0f, 0.0f, 1.0f);
				if (f.getYpos() < targetY) {
					shape.setColor(0.0f, 1.0f, 0.0f, 1.0f);
					offset = -offset;
				}

				float startX = f.getXpos() + (f.getSize()/2) + offset;
				float startY = f.getYpos() + (f.getSize()/2);
				targetX += (targetSize/2) + offset;
				targetY += targetSize/2;

				shape.rectLine(startX, startY, targetX, targetY, f.getSize()/30);
				shape.end();
			}
		}
	}

	public static Texture getBackgroundTexture() {
		return Assets.getBackgroundTexture();
	}


}


package com.snakeladders.controller;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.snakeladders.model.Assets;
import com.snakeladders.model.Board;
import com.snakeladders.model.Field;
import com.snakeladders.model.LadderField;
import com.snakeladders.model.NormalField;
import com.snakeladders.model.Player;
import com.snakeladders.view.FieldActor;
import com.snakeladders.view.PlayerActor;
import com.snakeladders.view.DieActor;

import java.util.ArrayList;
import java.util.Random;// For usage on randomised boards. Debate how large a degree of "randomness" we want.

public class GameScreenController {
    /**
	TODO
	movePlayerLadder( ) // moving a player up or down a ladder
	------
    **/
	SnakeLadders game;
	Board board;
	Random r = new Random();
	//Stage gameBoard;

	public GameScreenController(SnakeLadders game) {
		this.game = game;
		this.board = Board.getINSTANCE();
	}

	public static Skin getSkin() {
		return Assets.getSkin();
	}
	public static Texture getDie() { return Assets.getDieTexture(); }

	public void initGame(Stage stage, int playerCount) {
		Texture boardTexture = Assets.getBoardTexture();
		FieldFactory fieldFactory = new FieldFactory(stage, this);
		fieldFactory.generateFields(boardTexture);
		PlayerFactory playerFactory = new PlayerFactory(this, stage);
		playerFactory.generatePlayers(playerCount);
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

	public void drawBoard(Stage stage){
		ArrayList<Player> players = board.getPlayersOnBoard();
		ArrayList<Field> fields = board.getBoardfields();
		Array<Actor> actors = stage.getActors();
		ArrayList<PlayerActor> playerActors = new ArrayList<PlayerActor>();
		ArrayList<FieldActor> fieldActors = new ArrayList<FieldActor>();
		for (Actor a:actors){
			if (a instanceof PlayerActor){
				playerActors.add((PlayerActor) a);
			} else if (a instanceof FieldActor){
				fieldActors.add((FieldActor) a);
			}
		}

		for (FieldActor fa:fieldActors ){
			Field field = null;
			for (Field f:fields){
				if (fa.getId() == f.getId()){
					field = f;
					break;
				}
			}
			if (field == null){ continue; }

			Sprite sprite = fa.getSprite();
			sprite.setPosition(field.getXpos(), field.getYpos());
			drawSprite(stage.getBatch(), sprite);
		}

		drawLadders(stage);

		for (PlayerActor pa:playerActors){
			Player player = null;
			for (Player p:players){
				if (p.getStart() == pa.getId()){
					player = p;
					break;
				}
			}
			if (player == null){ continue; }

			Sprite sprite = pa.getSprite();
			sprite.setPosition(player.getXPos(), player.getYPos());
			drawSprite(stage.getBatch(), sprite);
		}
	}


	public void drawSprite(Batch batch, Sprite sprite) {

		batch.begin();
		batch.draw(sprite.getTexture(), sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
		batch.end();
	}

	public void movePlayerTo(Player player, Field field) {
		player.setCurrentField(field);
	}

	public void throwDie(DieActor die) {
		int t = r.nextInt(6);
		die.setEyes(Assets.getEyeTextures()[t]);
	}
}


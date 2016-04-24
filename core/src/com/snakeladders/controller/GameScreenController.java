package com.snakeladders.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Array;
import com.snakeladders.model.Assets;
import com.snakeladders.model.Board;
import com.snakeladders.model.ChanceField;
import com.snakeladders.model.Die;
import com.snakeladders.model.Field;
import com.snakeladders.model.LadderField;
import com.snakeladders.model.Player;
import com.snakeladders.view.FieldActor;
import com.snakeladders.view.GameOverScreen;
import com.snakeladders.view.PlayerActor;
import com.snakeladders.view.DieActor;
import java.util.ArrayList;
import java.util.Random;

public class GameScreenController {
	private SnakeLadders game;
	private Board board;
	private Die die;
	private Stage stage;
	private String status = "Game on!"; // The message displayed to show the player what is going on.

	public GameScreenController(SnakeLadders game, Stage stage) {
		this.game = game;
		this.board = Board.getINSTANCE();
		this.die = Die.getINSTANCE();
		this.stage = stage;
	}

	public static TextField.TextFieldStyle getWindowStyle() {
		return Assets.getWindowStyle();
	}

	public Texture[] getDie() {
		return new Texture[]{Assets.getDieTexture(board.getToken()), Assets.getEyeTexture(die.getValue())};
	}

	public void initGame(int playerCount) {
		board.setState(Board.State.RUNNING);
		FieldFactory fieldFactory = new FieldFactory(stage, this);
		fieldFactory.generateFields();
		PlayerFactory playerFactory = new PlayerFactory(this, stage);
		playerFactory.generatePlayers(playerCount);
	}

	public void draw(){
		if (board.getCurrentState() == Board.State.GAMEOVER){
			System.out.println("GAME OVER!");
			drawGameOver();
		} else if (board.getCurrentState() == Board.State.RUNNING){
			drawBoard();
		}
	}

	private void drawGameOver() {
		game.setScreen(new GameOverScreen(game, board.getLeadingPlayer()));
		board.clearBoard();
	}

	public void drawLadders(){
		ArrayList<Field> fields = board.getBoardFields();
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

	public void drawBoard(){
		ArrayList<Player> players = board.getPlayersOnBoard();
		ArrayList<Field> fields = board.getBoardFields();
		Array<Actor> actors = stage.getActors();
		ArrayList<PlayerActor> playerActors = new ArrayList<PlayerActor>();
		ArrayList<FieldActor> fieldActors = new ArrayList<FieldActor>();
		DieActor dieActor = null;
		for (Actor a:actors){
			if (a instanceof PlayerActor){
				playerActors.add((PlayerActor) a);
			} else if (a instanceof FieldActor){
				fieldActors.add((FieldActor) a);
			} else if (a instanceof DieActor){
				dieActor = (DieActor) a;
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

		drawLadders();

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
		drawDie(stage.getBatch(), dieActor);
		drawStatus(stage.getBatch());
	}

	public void drawDie(Batch batch, DieActor dieActor){
		dieActor.setDieTexture(Assets.getDieTexture(board.getToken()));
		dieActor.setEyeTexture(Assets.getEyeTexture(die.getValue()));

		drawSprite(batch, dieActor.getDieSprite());
		drawSprite(batch, dieActor.getEyeSprite());
	}
	public void drawStatus(Batch batch) {
		BitmapFont f = Assets.getFont();
		batch.begin();
		f.draw(batch, this.status, 10, Gdx.graphics.getHeight() - 10);
		batch.end();
	}

	public void drawSprite(Batch batch, Sprite sprite) {

		batch.begin();
		batch.draw(sprite.getTexture(), sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
		batch.end();
	}

	public void movePlayerTo(Player player, Field field, final DieActor dieActor) {
		class MoveThread implements Runnable {
			private Player player;
			private Field field;
			private DieActor dieActor;
			public MoveThread (Player player, Field field, DieActor dieActor){
				this.player = player;
				this.field = field;
				this.dieActor = dieActor;
			}

			public void run(){
				while (player.getCurrentField().getId() != field.getId()){
					if (player.isWrongWay()) {player.setCurrentField(board.getBoardFields().get(player.getCurrentField().getId() - 1));}
					else {player.setCurrentField(board.getBoardFields().get(player.getCurrentField().getId() + 1));}
					try {
						Thread.sleep(300);
					} catch (Exception e){
						System.out.println(e.getMessage());
					}
				}

				if (player.isSkipField() && (field.getId() != board.getBoardFields().size() - 1)) {
					player.resetTokens();
					player.setCurrentField(field);
					dieActor.setTouchable(Touchable.enabled);
					return;
				}

				player.resetTokens();
				if (field instanceof LadderField){
					field = ((LadderField) field).getTeleportToField();
					status = player.getName() + "\nclimbs a\n" + "ladder!";
				} else if (field instanceof ChanceField){
					Random r =  new Random();
					ChanceField.Type event = ((ChanceField)field).randomChoice();
					if (event == ChanceField.Type.JUMP) {
						int random = r.nextInt(7);
						if (field.getId()+random >= board.getBoardFields().size() - 1) {random = board.getBoardFields().size()-random-1;}
						field = board.getBoardFields().get(field.getId()+random);
						status = player.getName() + "\nmoves " + random +"\nfields\nmore!";
						System.out.println("JUMP");
					}
					else if (event == ChanceField.Type.SWAP) {
						int random = r.nextInt(board.getPlayersOnBoard().size());
						Player p = board.getPlayersOnBoard().get(random);
						Field newField = board.getBoardFields().get(p.getCurrentField().getId());
						p.setCurrentField(field);
						field = newField;
						status = player.getName() + "\nswaps\n" + "fields w/\n"+p.getName();
						System.out.println("SWAP");
					}
					else if (event == ChanceField.Type.DOUBLE) {
						player.setDoubleStep();
						System.out.println("DOUBLE");
					}
					else if (event == ChanceField.Type.KEEPAWAY) {
						player.setSkipField();
						System.out.println("KEEPAWAY");
					}
					else if (event == ChanceField.Type.BACKWARDS) {
						player.setWrongWay();
						System.out.println("BACKWARDS");
					}
				} else if (field.getId() == board.getBoardFields().size() - 1){
					board.setState(Board.State.GAMEOVER);
				}

				player.setCurrentField(field);
				board.incToken();
				dieActor.setTouchable(Touchable.enabled);
			}}

		Thread t = new Thread(new MoveThread(player, field, dieActor));
		t.start();
	}

	public void throwDie(DieActor dieActor) {
		Random r = new Random();
		int t = r.nextInt(6) + 1;
		die.setValue(t);
		Player player = board.getPlayersOnBoard().get(board.getToken());
		ArrayList<Field> fields = board.getBoardFields();
		int nextFieldId;
		if (player.isDoubleStep() && !(player.isWrongWay())) {
			nextFieldId = player.getCurrentField().getId() + 2*t;
		}
		else if (player.isWrongWay()) { nextFieldId = player.getCurrentField().getId() - t; }
		else { nextFieldId = player.getCurrentField().getId() + t; }
		int maxFieldId = fields.size() - 1;
		if (nextFieldId > maxFieldId) { // If the player overshoots the goal, we will let them continue to goal.
			nextFieldId = maxFieldId;
		} else if (nextFieldId < 0) {nextFieldId = 0;}
		if (player.isWrongWay()) {status=player.getName() + "\n" + "goes the\n" + "wrong way!";}
		else if (player.isSkipField()) {status=player.getName() + "\n" + "avoids\n" + "ladders!";}
		else if (player.isDoubleStep()) {status=player.getName() + "\n" + "moves\n" + "2x the eyes!";}

		Field nextField = fields.get(nextFieldId);
		movePlayerTo(player, nextField, dieActor);
	}
}


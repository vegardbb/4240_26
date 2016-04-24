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
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
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
	private String status = "Klar, ferdig, gå!"; // Klar, fer

	public GameScreenController(SnakeLadders game, Stage stage) {
		this.game = game;
		this.board = Board.getINSTANCE();
		this.die = Die.getINSTANCE();
		this.stage = stage;
	}

	public static TextField.TextFieldStyle getWindowStyle() {
		return Assets.getWindowStyle();
	} public static Skin getSkin() {
		return Assets.getSkin();
	}

	public Texture[] getDie() {
		Texture[] dieTextures = {Assets.getDieTexture(board.getToken()), Assets.getEyeTexture(die.getValue())};
		return dieTextures;
	}

	public void initGame(int playerCount) {
		board.setState(Board.State.RUNNING);
		FieldFactory fieldFactory = new FieldFactory(stage, this);
		fieldFactory.generateFields();
		PlayerFactory playerFactory = new PlayerFactory(this, stage);
		playerFactory.generatePlayers(playerCount);
		//Instantiate die element
	}

	public void draw(){
		if (board.getCurrentState() == Board.State.GAMEOVER){
			System.out.println("GAME OVER!");
			drawGameOver();
		} else if (board.getCurrentState() == Board.State.RUNNING){
			drawBoard();
		} else if (board.getCurrentState() == Board.State.PAUSE) {} // draw pauseTable}
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

	public static Texture getBackgroundTexture() {
		return Assets.getBackgroundTexture();
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
		//f.setScale(.2f)
		f.draw(batch, this.status, 10,Gdx.graphics.getHeight()-10); // Should parametrize the floats, Gdx.graphics.getWidth()-
		batch.end();
	}

	public void drawSprite(Batch batch, Sprite sprite) {

		batch.begin();
		batch.draw(sprite.getTexture(), sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
		batch.end();
	}

	public void movePlayerTo(Player player, Field field, final DieActor dieActor) { // Send in the status box actor too!
		class MoveThread implements Runnable {
			private Player player;
			private Field field;
			public MoveThread (Player player, Field field, DieActor dieActor){
				this.player = player;
				this.field = field;
			}
			public void run(){
				while (player.getCurrentField().getId() != field.getId()){
					if (player.isWrongWay()) {player.setCurrentField(board.getBoardFields().get(player.getCurrentField().getId() - 1));}
					else {player.setCurrentField(board.getBoardFields().get(player.getCurrentField().getId() + 1));}
					try {
						Thread.sleep(300);
					} catch (Exception e){

					}
				}
				if (player.isSkipField() && (field.getId() != board.getBoardFields().size() - 1)) {
					player.resetTokens();
					player.setCurrentField(field);
					dieActor.setTouchable(Touchable.enabled);
					return; }
				player.resetTokens();
				if (field instanceof LadderField){
					field = ((LadderField) field).getTeleportToField();
					status = player.getName() + "\nklatrer\n" + "i stigen!";
				} else if (field instanceof ChanceField){
					// TODO: Implement Chance Events, AND implement a status/state message box in GameScreen, drawn wo help from me.
					Random r =  new Random();
					ChanceField.Type event = ((ChanceField)field).randomChoice();
					if (event == ChanceField.Type.JUMP) {
						int random = r.nextInt(7);
						if (field.getId()+random >= board.getBoardFields().size() - 1) {random = board.getBoardFields().size()-random-1;}
						field = board.getBoardFields().get(field.getId()+random);
						status = player.getName() + "\nflytter\n" + "fram!";
						System.out.println("JUMP");
					}
					else if (event == ChanceField.Type.SWAP) {
						int random = r.nextInt(board.getPlayersOnBoard().size());
						field = board.getBoardFields().get(board.getPlayersOnBoard().get(random).getCurrentField().getId());
						status = player.getName() + "\nbytter\n" + "plass!";
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
				dieActor.setTouchable(Touchable.enabled);
			}};

		Thread t = new Thread(new MoveThread(player, field, dieActor));
		t.start();
	}

	public void throwDie(DieActor dieActor) { // TODO: send in dialog box too
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
		if (player.isWrongWay()) {status=player.getName() + "\n" + "går feil\n" + "vei";}
		else if (player.isSkipField()) {status=player.getName() + "\n" + "slipper å\n" + "klatre!";}
		else if (player.isDoubleStep()) {status=player.getName() + "\n" + "flytter\n" + "dobbelt opp!";}

		Field nextField = fields.get(nextFieldId);
		status = player.getName() + "\nflytter\n" + t +" felt!";
		movePlayerTo(player, nextField, dieActor);

		// TODO: Message to dialog box
		board.incToken();
	}

}


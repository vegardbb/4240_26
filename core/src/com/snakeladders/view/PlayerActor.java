package com.snakeladders.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.snakeladders.controller.GameScreenController;
import com.snakeladders.controller.SnakeLadders;

public class PlayerActor extends Actor { // Image extends Widget, which in turn extends Actor
	private SnakeLadders game; // The controller which provides the Player its datamodel.
	private Sprite playerSprite;
	private GameScreenController controller;
	private int id;

	public PlayerActor(float x, float y, int size, Texture t, GameScreenController controller, int id){
		this.id = id;
		this.controller = controller;
		this.playerSprite = new Sprite(t, size, size);
		playerSprite.setX(x);
		playerSprite.setY(y);
		//setBounds(playerSprite.getX(),playerSprite.getY(),playerSprite.getWidth(),playerSprite.getHeight());
		setBounds(x, y, size, size);
		//setTouchable(false); //Touchable.enabled
	}
	// TODO: Add more methods if need be, needs a method for animating a move from one field to the next, one at the time
	@Override
	public void draw(Batch batch, float parentAlpha) {
		controller.drawSprite(batch, playerSprite);

	}

	public void moveTo(float x, float y) {
		MoveToAction moveToAction = new MoveToAction();
		moveToAction.setPosition(x,y);
		moveToAction.setDuration(5f);
		this.addAction(moveToAction);
	}

	public int getId() { return id; }
	public Sprite getSprite() { return playerSprite; }

}

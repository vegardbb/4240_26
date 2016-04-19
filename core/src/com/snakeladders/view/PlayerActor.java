package com.snakeladders.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.snakeladders.controller.SnakeLadders;
import com.snakeladders.model.Field;

public class PlayerActor extends Actor { // Image extends Widget, which in turn extends Actor
	private SnakeLadders game; // The controller which provides the Player its datamodel.
	Sprite fieldSprite;
	
	public PlayerActor(float x, float y, Texture t){
		this.fieldSprite = new Sprite(t);
		fieldSprite.setX(x);
		fieldSprite.setY(y);
		//setBounds(fieldSprite.getX(),fieldSprite.getY(),fieldSprite.getWidth(),fieldSprite.getHeight());
		setBounds(x, y, fieldSprite.getWidth(), fieldSprite.getHeight());
		//setTouchable(false); //Touchable.enabled
	}
	// TODO: Add more methods if need be, needs a method for animating a move from one field to the next, one at the time
	@Override
	public void draw(Batch batch, float parentAlpha) {
		fieldSprite.draw(batch);
	}
	public void moveTo(Field f) {
		MoveToAction moveToAction = new MoveToAction();
		moveToAction.setPosition(f.getXpos(),f.getYpos());
		moveToAction.setDuration(5f);
//		MyActor.this.addAction(moveToAction);
	}

}

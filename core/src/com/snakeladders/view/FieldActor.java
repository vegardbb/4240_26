package com.snakeladders.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.snakeladders.controller.SnakeLadders;

// No touching or moving this thing

public class FieldActor extends Actor { // Image extends Widget, which in turn extends Actor
	private SnakeLadders game; // The controller which provides the Field its datamodel.
	Sprite fieldSprite;
	
	public FieldActor(float x, float y, Texture t){
		this.fieldSprite = new Sprite(t);
		fieldSprite.setX(x);
		fieldSprite.setY(y);
		//setBounds(fieldSprite.getX(),fieldSprite.getY(),fieldSprite.getWidth(),fieldSprite.getHeight());
		setBounds(x, y, fieldSprite.getWidth(), fieldSprite.getHeight());
		//setTouchable(false); //Touchable.enabled
	}
	// TODO: Add more methods if need be
	@Override
	public void draw(Batch batch, float parentAlpha) {
		fieldSprite.draw(batch);
	}

}

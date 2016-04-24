package com.snakeladders.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.snakeladders.controller.GameScreenController;
import com.snakeladders.controller.SnakeLadders;

// No touching or moving this thing

public class FieldActor extends Actor {
	private SnakeLadders game; // The controller which provides the Field its datamodel.
	private GameScreenController controller; // The controller that draws the field on screen
	private Sprite fieldSprite;
	private int id; // Identifier coinciding with the id in the field model
	
	public FieldActor(int id, float x, float y, int width, int height, Texture t, GameScreenController controller){
		this.id = id;
		this.controller = controller;
		this.fieldSprite = new Sprite(t, width,height);
		fieldSprite.setX(x);
		fieldSprite.setY(y);
		setBounds(x, y, fieldSprite.getWidth(), fieldSprite.getHeight());
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		//controller.drawSprite(batch, fieldSprite);
	}

	public int getId(){ return this.id; }

	public Sprite getSprite() { return fieldSprite; }
}

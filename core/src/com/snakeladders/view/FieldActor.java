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
import com.snakeladders.model.Field;
import com.snakeladders.model.LadderField;

// No touching or moving this thing

public class FieldActor extends Actor { // Image extends Widget, which in turn extends Actor
	private SnakeLadders game; // The controller which provides the Field its datamodel.
	private GameScreenController controller;
	private Sprite fieldSprite;
	
	public FieldActor(float x, float y, int width, int height, Texture t, GameScreenController controller){
		this.controller = controller;
		this.fieldSprite = new Sprite(t, width,height);
		fieldSprite.setX(x);
		fieldSprite.setY(y);
		setBounds(x, y, fieldSprite.getWidth(), fieldSprite.getHeight());
		//setTouchable(false); //Touchable.enabled
	}
	// TODO: Add more methods if need be
	@Override
	public void draw(Batch batch, float parentAlpha) {
		controller.drawField(batch, parentAlpha, fieldSprite);
	}
}

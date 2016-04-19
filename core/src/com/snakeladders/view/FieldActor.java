package com.snakeladders.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.snakeladders.controller.SnakeLadders;
import com.snakeladders.model.Field;
import com.snakeladders.model.LadderField;

// No touching or moving this thing

public class FieldActor extends Actor { // Image extends Widget, which in turn extends Actor
	private SnakeLadders game; // The controller which provides the Field its datamodel.
	Sprite fieldSprite;
	Field field;
	
	public FieldActor(float x, float y, int width, int height, Texture t, Field f){
		this.field = f;
		this.fieldSprite = new Sprite(t, width,height);
		fieldSprite.setX(x);
		fieldSprite.setY(y);
		//setBounds(fieldSprite.getX(),fieldSprite.getY(),fieldSprite.getWidth(),fieldSprite.getHeight());
		setBounds(x, y, fieldSprite.getWidth(), fieldSprite.getHeight());
		//setTouchable(false); //Touchable.enabled
	}
	// TODO: Add more methods if need be
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(fieldSprite.getTexture(), fieldSprite.getX(), fieldSprite.getY(), fieldSprite.getWidth(), fieldSprite.getHeight());
		// TODO: Move to cotroller
		if (field instanceof LadderField){
			batch.end();
			ShapeRenderer shape = new ShapeRenderer();
			shape.setProjectionMatrix(batch.getProjectionMatrix());
			shape.begin(ShapeRenderer.ShapeType.Filled);
			shape.setColor(1.0f, 0.0f, 0.0f, 1.0f);
			float targetX = ((LadderField) field).getTeleportToField().getXpos();
			float targetY = ((LadderField) field).getTeleportToField().getYpos();
			shape.rectLine(field.getXpos(), field.getYpos(), targetX, targetY, 50.0f);
			shape.end();
			batch.begin();
		}
	}
}

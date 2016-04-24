package com.snakeladders.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class FieldActor extends Actor {
	private Sprite fieldSprite;
	private int id; // Identifier coinciding with the id in the field model
	
	public FieldActor(int id, float x, float y, int width, int height, Texture t){
		this.id = id;
		this.fieldSprite = new Sprite(t, width,height);
		fieldSprite.setX(x);
		fieldSprite.setY(y);
		setBounds(x, y, fieldSprite.getWidth(), fieldSprite.getHeight());
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {}

	public int getId(){ return this.id; }
	public Sprite getSprite() { return fieldSprite; }
}

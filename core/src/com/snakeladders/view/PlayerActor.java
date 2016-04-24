package com.snakeladders.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.snakeladders.controller.GameScreenController;

public class PlayerActor extends Actor {
	private Sprite playerSprite;
	private int id;

	public PlayerActor(float x, float y, int size, Texture t, int id){
		this.id = id;
		this.playerSprite = new Sprite(t, size, size);
		playerSprite.setX(x);
		playerSprite.setY(y);
		setBounds(x, y, size, size);
	}
	@Override
	public void draw(Batch batch, float parentAlpha) {}

	public int getId() { return id; }
	public Sprite getSprite() { return playerSprite; }
}

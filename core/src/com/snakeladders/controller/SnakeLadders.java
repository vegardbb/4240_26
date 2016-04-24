package com.snakeladders.controller;

import com.badlogic.gdx.Game;
import com.snakeladders.view.MainMenuScreen;
import com.snakeladders.model.Assets;

public class SnakeLadders extends Game {
	// Overrides the create method from the Game class
	@Override
	public void create() {
		Assets.load();
		//System.out.println("Hello");
		setScreen(new MainMenuScreen(this));
	}
}
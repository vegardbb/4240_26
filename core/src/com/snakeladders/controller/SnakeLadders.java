package com.snakeladders.controller;

import com.badlogic.gdx.Game;
import com.snakeladders.view.MainMenuScreen;
import com.snakeladders.model.Assets;

public class SnakeLadders extends Game {
	
	// We reckon this a controller class because it loads game models from Assets, which naturally resides in the model package
	
	// Overrides the create method from the Game class
	@Override
	public void create() {
		Assets.load();
		System.out.println("Hello"); // Compiles?
		setScreen(new MainMenuScreen(this));
	}
}
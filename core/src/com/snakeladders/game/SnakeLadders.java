package com.snakeladders.game;

import com.badlogic.gdx.Game;
import com.snakeladders.view.MainMenuScreen;

public class SnakeLadders extends Game {
	
	@Override
	public void create() {
		Assets.load();
		System.out.println("Hello"); // Compiles?
		setScreen(new MainMenuScreen(this));
	}
}
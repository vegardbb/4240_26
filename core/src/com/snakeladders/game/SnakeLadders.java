package com.snakeladders.game;

import com.badlogic.gdx.Game;
import com.minimaldevelop.libgdxgame.screens.MainMenuScreen;

public class Snakeladders extends Game {
	
	@Override
	public void create() {
		Assets.load();
		setScreen(new MainMenuScreen(this));
	}
}
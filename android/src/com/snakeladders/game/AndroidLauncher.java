package com.snakeladders.game;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.snakeladders.game.SnakeLadders;

public class AndroidLauncher extends AndroidApplication {
	// Main Acticity Class
	
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new SnakeLadders(), config);
	}
}

package com.minimaldevelop.libgdxgame;

import com.badlogic.gdx.Game;
import com.minimaldevelop.libgdxgame.screens.SplashScreen;

public class LibGdxGame extends Game {
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		Assets.load();
		setScreen(new SplashScreen(this));
	}
	/* Uten bruk av Scene2D
	package com.snakeladders.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class SnakeLadders extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg"); // Konstruer teksture basert fra fil
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	// TODO: Se igjennom applicationApdapter. Hvorfor import og samtidig arv?
	// Tegn pakkediagram, analyser krav.
	// Importer dokumentasjon inn i master - branch
	/**


	**/
}

	
	*/
}
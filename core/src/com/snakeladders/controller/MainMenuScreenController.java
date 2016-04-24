package com.snakeladders.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.snakeladders.model.Assets;
import com.snakeladders.view.GameScreen;

public class MainMenuScreenController {
    SnakeLadders game;

    public MainMenuScreenController(SnakeLadders game) {
        this.game = game;
    }

	// Initialises the game screen.
	public void newGame(int playerCount){ game.setScreen(new GameScreen(game, playerCount)); }

    // Exit the game
    public void exit(){
        game.dispose();
        Gdx.app.exit();
	}

    // The following getter emthods deliver the textures, the skin, the styles and the font needed to draw the Main Menu screen
    public static Skin getSkin() { return Assets.getSkin(); }
    public static BitmapFont getFont() { return Assets.getFont(); }
    public static Slider.SliderStyle getSliderStyle(){ return Assets.getSliderStyle(); }
    public static Texture getBackgroundTexture() { return Assets.getBackgroundTexture(); }
    public static TextButton.TextButtonStyle getTextButtonStyle() { return Assets.getTextButtonStyle(); }
}


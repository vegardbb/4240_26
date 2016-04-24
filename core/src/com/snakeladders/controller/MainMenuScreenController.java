package com.snakeladders.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.snakeladders.model.Assets; // The Assets class
import com.snakeladders.view.GameScreen;

public class MainMenuScreenController {
    SnakeLadders game;

    public MainMenuScreenController(SnakeLadders game) {
        this.game = game;
    }

    /**
	Initialises the game screen.
    **/
	public void newGame(int playerCount){
        game.setScreen(new GameScreen(game, playerCount));
	}

    public void exit(){
        game.dispose();
        Gdx.app.exit();
	}

    // The following getter emthods deliver the textures, the skin, the styles and the font needed to draw the Main Menu screen
    public static Skin getSkin() {
        return Assets.getSkin();
    }

    public static Texture getBackgroundTexture() {
        return Assets.getBackgroundTexture();
    }

    public static Texture getBoardTexture() {
        return Assets.getBoardTexture();
    }

    public static TextButton.TextButtonStyle getTextButtonStyle() {
        return Assets.getTextButtonStyle();
    }

    public static BitmapFont getFont() {
        return Assets.getFont();
    }

    public static TextureAtlas getButtonAtlas() {
        return Assets.getButtonAtlas();
    }

    public static Slider.SliderStyle getSliderStyle(){
        return Assets.getSliderStyle();
    }
}


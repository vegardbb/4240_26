package com.snakeladders.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.snakeladders.model.Board;
import com.snakeladders.view.ConfigScreen;
import com.snakeladders.model.Assets; // The Assets class
import com.snakeladders.view.GameScreen;

public class MainMenuScreenController {
    SnakeLadders game;

    public MainMenuScreenController(SnakeLadders game) {
        this.game = game;
    }

    /**
	This class controls the input from the MainMenuScreen
    **/

//	public void newGame() {
//        game.setScreen(new GameScreen(game));
	public void newGame(){
        Board board = Board.getInstance();
        game.setScreen(new GameScreen(game, 4));
        //TODO: more functionality may be required?
	}

    /**
     This class controls the input from the MainMenuScreen
     **/
    public void configureGame(){
        game.setScreen(new ConfigScreen(game));
        //TODO: more functionality may be required?
    }

    public void exit(){
        game.dispose();
        Gdx.app.exit();
	}

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


package com.snakeladders.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas; // Not used per now, may be required for the animation
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

//See also: http://www.netthreads.co.uk/2012/01/31/libgdx-example-of-using-scene2d-actions-and-event-handling/

public class Assets { // Each asset is publically available, visible to EveryOne.
    private static Skin skin; // JSON - file . Used for buttons and widgets, perchance.
    private static Texture backgroundTexture; // Used in the main menu
    private static Texture dieTexture; // Used in the main menu

    private static Texture yellowPieceTexture;
    private static Texture redPieceTexture;
    private static Texture bluePieceTexture;
    private static Texture greenPieceTexture; // Used in the main menu, copypasta ahoy

    private static Texture chanceFieldTexture; // Used in the main menu, copypasta ahoy
    private static Texture ladderDownFieldTexture; // Used in the main menu, copypasta ahoy
    private static Texture ladderUpFieldTexture; // Used in the main menu, copypasta ahoy
    private static Texture normalFieldTexture; // Used in the main menu, copypasta ahoy

    //public static Animation pieceAni; // Not used per now, intended as animation w/ movement only. No texturechange.
    private static Texture boardTexture; // The board, covering the screen

    // For generating buttons in the menu UI
    private static TextButton.TextButtonStyle textButtonStyle;
    private static SelectBox.SelectBoxStyle selectBoxStyle;
    private static SelectBox<Texture> selectBox;
    private static BitmapFont font;
    private static TextureAtlas buttonAtlas;
    private static Slider.SliderStyle sliderStyle;

    private static void generateFont() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("OpenSans-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 18;
        font = generator.generateFont(parameter); // font size 12 pixels
        generator.dispose(); // don't forget to dispose to avoid memory leaks!
    }

    public static void load () {
        // Implements asset loading.
        generateFont();
        backgroundTexture = new Texture(Gdx.files.internal("Game-Board.gif")); // For the splash screen
        dieTexture = new Texture(Gdx.files.internal("die.png"));
        yellowPieceTexture = new Texture(Gdx.files.internal("yellowpiece.png"));
        redPieceTexture = new Texture(Gdx.files.internal("redpiece.png"));
        bluePieceTexture = new Texture(Gdx.files.internal("bluepiece.png"));
        greenPieceTexture = new Texture(Gdx.files.internal("greenpiece.png"));
        chanceFieldTexture = new Texture(Gdx.files.internal("chancefield.png"));
        ladderDownFieldTexture = new Texture(Gdx.files.internal("downfield.png"));
        ladderUpFieldTexture = new Texture(Gdx.files.internal("upfield.png"));
        normalFieldTexture = new Texture(Gdx.files.internal("regfield.png"));
        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("ui-orange.atlas"));
        skin.addRegions(buttonAtlas);
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("button_04");
        textButtonStyle.down = skin.getDrawable("button_02");
        textButtonStyle.checked = skin.getDrawable("checkbox_on"); // Currently not used
        sliderStyle = new Slider.SliderStyle();
        sliderStyle.background = skin.getDrawable("slider_back_hor");
        sliderStyle.knob = skin.getDrawable("knob_01");
        /*selectBoxStyle = new SelectBox.SelectBoxStyle();
        selectBoxStyle.background = skin.getDrawable("selectbox_01");
        selectBoxStyle.font = font;
        selectBox = new SelectBox(skin);
        selectBox.setStyle(selectBoxStyle);
        selectBox.setItems(yellowPieceTexture, redPieceTexture, bluePieceTexture, greenPieceTexture);*/
    }
    // TODO: Comment out the Selectbox fields, send in an array of strings into generatePlayers - method

    // Getters
    public static Texture getBackgroundTexture() {
        return backgroundTexture;
    }
    public static Skin getSkin() {return skin;}

    public static Texture getBoardTexture() {
        return boardTexture;
    }

    public static TextButton.TextButtonStyle getTextButtonStyle() {
        return textButtonStyle;
    }

    public static BitmapFont getFont() {
        return font;
    }

    public static TextureAtlas getButtonAtlas() {
        return buttonAtlas;
    }

    public static Slider.SliderStyle getSliderStyle(){ return sliderStyle; }

    public static Texture getLadderUpFieldTexture() {
        return ladderUpFieldTexture;
    }

    public static Texture getLadderDownFieldTexture() {
        return ladderDownFieldTexture;
    }

    public static Texture getChanceFieldTexture() {
        return chanceFieldTexture;
    }

    public static Texture getNormalFieldTexture() {
        return normalFieldTexture;
    }
}

package com.snakeladders.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas; // Not used per now, may be required for the animation
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

import java.util.ArrayList;

//See also: http://www.netthreads.co.uk/2012/01/31/libgdx-example-of-using-scene2d-actions-and-event-handling/

public class Assets {
    private static Skin skin;
    private static Texture backgroundTexture;
    private static Texture dieTexture;

    private static Texture yellowPieceTexture;
    private static Texture redPieceTexture;
    private static Texture bluePieceTexture;
    private static Texture greenPieceTexture;

    private static Texture chanceFieldTexture;
    private static Texture ladderDownFieldTexture;
    private static Texture ladderUpFieldTexture;
    private static Texture normalFieldTexture;
    private static Texture startFieldTexture;
    private static Texture goalFieldTexture;

    private static Texture one; // One eye on the die
    private static Texture two; // Two eyes on the die
    private static Texture three; // Three eyes on the die
    private static Texture four; // Four eyes on the die
    private static Texture five; // Five eyes on the die
    private static Texture six; // Six eyes on the die
    private static Texture[] eyes; // Array of possibble die views.

    //public static Animation pieceAni; // Not used per now, intended as animation w/ movement only. No texturechange.
    private static Texture boardTexture; // The board, covering the screen

    // For generating buttons in the menu UI
    private static TextButton.TextButtonStyle textButtonStyle;
    private static SelectBox.SelectBoxStyle selectBoxStyle;
    private static SelectBox<Texture> selectBox;
    private static BitmapFont font;
    private static TextureAtlas buttonAtlas;
    private static Slider.SliderStyle sliderStyle;
    private static ImageTextButton.ImageTextButtonStyle diceStyle;

    private static void generateFont() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("OpenSans-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = Gdx.graphics.getWidth() / 20;
        font = generator.generateFont(parameter); // font size 12 pixels
        generator.dispose(); // don't forget to dispose to avoid memory leaks!
    }

    public static void load() {
        // Implements asset loading.
        generateFont();
        backgroundTexture = new Texture(Gdx.files.internal("Game-Board.gif")); // For the splash screen
        dieTexture = new Texture(Gdx.files.internal("die.png"));
        yellowPieceTexture = new Texture(Gdx.files.internal("yellowpiece.png"));
        redPieceTexture = new Texture(Gdx.files.internal("redpiece.png"));
        bluePieceTexture = new Texture(Gdx.files.internal("bluepiece.png"));
        greenPieceTexture = new Texture(Gdx.files.internal("greenpiece.png"));
        boardTexture = new Texture(Gdx.files.internal("boardtexture.png"));
        chanceFieldTexture = new Texture(Gdx.files.internal("chancefield.png"));
        ladderDownFieldTexture = new Texture(Gdx.files.internal("downfield.png"));
        ladderUpFieldTexture = new Texture(Gdx.files.internal("upfield.png"));
        normalFieldTexture = new Texture(Gdx.files.internal("regfield.png"));
        startFieldTexture = new Texture(Gdx.files.internal("startfield.png"));
        goalFieldTexture = new Texture(Gdx.files.internal("goalfield.png"));
        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("ui-orange.atlas")); // Major karma points of credit to Kenney.nl for making this CC0 - pack.
        getSkin().addRegions(getButtonAtlas());
        textButtonStyle = new TextButton.TextButtonStyle();
        getTextButtonStyle().font = getFont();
        getTextButtonStyle().up = getSkin().getDrawable("button_04");
        getTextButtonStyle().down = getSkin().getDrawable("button_02");
        getTextButtonStyle().checked = getSkin().getDrawable("checkbox_on"); // Currently not used
        sliderStyle = new Slider.SliderStyle();
        sliderStyle.background = skin.getDrawable("slider_back_hor");
        sliderStyle.knob = skin.getDrawable("knob_01");
        /*selectBoxStyle = new SelectBox.SelectBoxStyle();
        selectBoxStyle.background = skin.getDrawable("selectbox_01");
        selectBoxStyle.font = font;
        selectBox = new SelectBox(skin);
        selectBox.setStyle(selectBoxStyle);
        selectBox.setItems(yellowPieceTexture, redPieceTexture, bluePieceTexture, greenPieceTexture);*/
        one = new Texture(Gdx.files.internal("die1.png"));
        two = new Texture(Gdx.files.internal("die2.png"));
        three = new Texture(Gdx.files.internal("die3.png"));
        four = new Texture(Gdx.files.internal("die4.png"));
        five = new Texture(Gdx.files.internal("die5.png"));
        six = new Texture(Gdx.files.internal("die6.png"));
        eyes = new Texture[]{one, two, three, four, five, six};

    }
    // TODO: Comment out the Selectbox fields, send in an array of strings into generatePlayers - method

    // Getters
    public static Texture getBackgroundTexture() {
        return backgroundTexture;
    }

    public static Skin getSkin() {
        return skin;
    }

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

    public static Slider.SliderStyle getSliderStyle() {
        return sliderStyle;
    }

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

    public static Texture getGoalFieldTexture() {
        return goalFieldTexture;
    }

    public static Texture getStartFieldTexture() {
        return startFieldTexture;
    }

    public static ArrayList<Texture> getPieceTextures() {
        ArrayList<Texture> pieceTextures = new ArrayList<Texture>();
        pieceTextures.add(yellowPieceTexture);
        pieceTextures.add(redPieceTexture);
        pieceTextures.add(bluePieceTexture);
        pieceTextures.add(greenPieceTexture);
        return pieceTextures;
    }

    public static Texture getDieTexture() {
        return dieTexture;
    }

    /**
     * @return Texture[]
     */
    public static Texture[] getEyeTextures() {
        return eyes;
    }

    public static SelectBox.SelectBoxStyle getSelectBoxStyle() {
        return selectBoxStyle;
    }

    public static SelectBox<Texture> getSelectBox() {
        return selectBox;
    }
}

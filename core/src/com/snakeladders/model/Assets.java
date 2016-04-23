package com.snakeladders.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas; // Not used per now, may be required for the animation
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import java.util.ArrayList;

//See also: http://www.netthreads.co.uk/2012/01/31/libgdx-example-of-using-scene2d-actions-and-event-handling/

public class Assets {
    private static Skin skin;
    private static Texture backgroundTexture;

    private static Texture[] dieTextures;
    private static Texture yellowDieTexture;
    private static Texture redDieTexture;
    private static Texture blueDieTexture;
    private static Texture greenDieTexture;

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

    private static Texture boardTexture; // The board, covering the screen

    // For generating buttons in the menu UI
    private static TextButton.TextButtonStyle textButtonStyle;
    private static TextField.TextFieldStyle winStyle ;
    private static BitmapFont font;
    private static TextureAtlas buttonAtlas;
    private static Slider.SliderStyle sliderStyle;
    private static ImageTextButton.ImageTextButtonStyle diceStyle;

    private static void generateFont() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("OpenSans-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = Gdx.graphics.getWidth() / 20;
        font = generator.generateFont(parameter);
        font.setColor(Color.BLUE);
        generator.dispose(); // Don't forget to dispose to avoid memory leaks!
    }

    public static void load() {
        // Implements asset loading.
        generateFont();
        backgroundTexture = new Texture(Gdx.files.internal("MainMenuBackground.png")); // For the splash screen

        yellowDieTexture = new Texture(Gdx.files.internal("diceyellow.png"));
        redDieTexture = new Texture(Gdx.files.internal("dicered.png"));
        blueDieTexture = new Texture(Gdx.files.internal("diceblue.png"));
        greenDieTexture = new Texture(Gdx.files.internal("dicegreen.png"));
        dieTextures = new Texture[] {yellowDieTexture, redDieTexture, blueDieTexture, greenDieTexture};

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
        skin.addRegions(getButtonAtlas());

        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = getFont();
        textButtonStyle.up = getSkin().getDrawable("button_04");
        textButtonStyle.down = getSkin().getDrawable("button_02");
        textButtonStyle.checked = getSkin().getDrawable("checkbox_on"); // Currently not used

        winStyle = new TextField.TextFieldStyle();
        winStyle.background = getSkin().getDrawable("textbox_02");
        winStyle.font = getFont();
        winStyle.messageFontColor = new Color(Color.BLUE);
        winStyle.fontColor = new Color(Color.RED);

        sliderStyle = new Slider.SliderStyle();
        sliderStyle.background = skin.getDrawable("slider_back_hor");
        sliderStyle.knob = skin.getDrawable("knob_01");

        one = new Texture(Gdx.files.internal("dice1.png"));
        two = new Texture(Gdx.files.internal("dice2.png"));
        three = new Texture(Gdx.files.internal("dice3.png"));
        four = new Texture(Gdx.files.internal("dice4.png"));
        five = new Texture(Gdx.files.internal("dice5.png"));
        six = new Texture(Gdx.files.internal("dice6.png"));
        eyes = new Texture[]{one, two, three, four, five, six};

    }
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

    public static Texture getDieTexture(int i) { return dieTextures[i]; }

    public static Texture getEyeTexture(int i) { return eyes[i - 1]; }

    public static TextField.TextFieldStyle getWindowStyle() {return winStyle;}
}

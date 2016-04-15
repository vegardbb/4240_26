package com.snakeladders.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas; // Not used per now, may be required for the animation
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

//See also: http://www.netthreads.co.uk/2012/01/31/libgdx-example-of-using-scene2d-actions-and-event-handling/

public class Assets { // Each asset is publically available, visible to EveryOne.
    public static Skin skin; // JSON - file . Used for buttons and widgets, perchance.
    public static Texture backgroundTexture; // Used in the main menu
    public static Animation pieceAni; // Not used per now, intended as animation w/ movement only. No texturechange.
    public static Texture boardTexture; // The board, covering the screen

    // For generating buttons in the menu UI
    public static TextButtonStyle textButtonStyle;
    public static BitmapFont font;
    public static Skin skin;
    public static TextureAtlas buttonAtlas;    

    private static void generateFont() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("OpenSans-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 12;
        font = generator.generateFont(parameter); // font size 12 pixels
        generator.dispose(); // don't forget to dispose to avoid memory leaks!
    }

    public static void load () {
        // Implements asset loading.
        generateFont();
        backgroundTexture = new Texture(Gdx.files.internal("splash.png")); // For the splash screen
        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("ui-orange.atlas"));
        skin.addRegions(buttonAtlas);
        textButtonStyle = new TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("button_04");
        textButtonStyle.down = skin.getDrawable("button_02");
        textButtonStyle.checked = skin.getDrawable("checkbox_on");
        }
         // Animation, Texture, Textureregion, TextureAtlas. 
}

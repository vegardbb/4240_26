package com.minimaldevelop.libgdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas; // Not used per now, may be required for the animation
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

//See also: http://www.netthreads.co.uk/2012/01/31/libgdx-example-of-using-scene2d-actions-and-event-handling/

public class Assets { // Each asset is publically available, visible to EveryOne.
    public static Skin skin; // JSON - file . Used for buttons and widgets, perchance.
    public static Texture backgroundTexture; // Used in the main menu
    public static Animation pieceAni; // Not used per now, intended as animation w/ movement only. No texturechange.
    public static Texture boardTexture; // The board, covering the screen
    // TODO: Piece - actors extends Actor and has their own asset texture laoded from the Assets - folder, depending on their int-id, so no piece texture here.
    public static TextButton.TextButtonStyle style; // TextButtinStyle used instead of uiskin
    public static ButtonStyle styley;

    public static void load () {
        // Implements asset loading.
        backgroundTexture = new Texture(Gdx.files.internal("data/splash.png")); // For the splash screen
        //skin = new Skin(Gdx.files.internal("data/uiskin.json")); // VBB - I do not know what this is doing, but the file is not in the asset folder
        skin = new Skin(); // Not allowed
        }
         // Animation, Texture, Textureregion, TextureAtlas. 
}

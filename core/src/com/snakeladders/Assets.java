package com.minimaldevelop.libgdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

//See also: http://www.netthreads.co.uk/2012/01/31/libgdx-example-of-using-scene2d-actions-and-event-handling/

public class Assets {
	public static Skin skin; // Animation, Texture, Textureregion, TextureAtlas
	public static Texture backgroundTexture;
	
	public static void load () {
		// Implement asset loading.
		backgroundTexture = new Texture(Gdx.files.internal("data/splash.png"));
		}
}

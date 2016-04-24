package com.snakeladders.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class DieActor extends Actor {
    private Sprite dieSprite;
    private Sprite eyeSprite;

    public DieActor(float x, float y, Texture t, Texture eye){
        int size = Gdx.graphics.getWidth()/7;

        this.dieSprite = new Sprite(t, size,size);
        dieSprite.setX(x + Gdx.graphics.getWidth()/50);
        dieSprite.setY(y);
        setBounds(x, y, dieSprite.getWidth(), dieSprite.getHeight());

        eyeSprite = new Sprite(eye, size, size);
        eyeSprite.setX(x + Gdx.graphics.getWidth()/50);
        eyeSprite.setY(y);
    }
    public void setEyeTexture(Texture eye) {
        this.eyeSprite.setTexture(eye);
    }
    public void setDieTexture(Texture die) { this.dieSprite.setTexture(die); }

    @Override
    public void draw(Batch batch, float parentAlpha) {}

    public Sprite getDieSprite() { return dieSprite; }
    public Sprite getEyeSprite() { return eyeSprite; }
}



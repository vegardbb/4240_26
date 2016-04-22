package com.snakeladders.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.snakeladders.controller.SnakeLadders;
import com.snakeladders.model.Die;

public class DieActor extends Actor {

    /*
    TODO:
    - Draw six eye textures
    - Implement throwDie method in GameScreenController
        - Use Random.nextint(6)
        - Use setEyes method in six way switch
    - Define new assets
     */
    private SnakeLadders game; // The controller which provides the Die its datamodel
    private Sprite dieSprite;
    private Sprite eyeSprite;

    public DieActor(float x, float y, int width, int height, Texture t, Texture eye, SnakeLadders game){
        this.game = game;
        height = Gdx.graphics.getWidth()/7;
        width = Gdx.graphics.getWidth()/7;

        this.dieSprite = new Sprite(t, width,height);
        dieSprite.setX(x + Gdx.graphics.getWidth()/50);
        dieSprite.setY(y);
        setBounds(x, y, dieSprite.getWidth(), dieSprite.getHeight());

        eyeSprite = new Sprite(eye, width, height);
        eyeSprite.setX(x + Gdx.graphics.getWidth()/50);
        eyeSprite.setY(y);
    }
    public void setEyeTexture(Texture eye) {
        this.eyeSprite.setTexture(eye);
    }
    public void setDieTexture(Texture die) { this.dieSprite.setTexture(die); }
    // TODO: Add more methods if need be
    @Override
    public void draw(Batch batch, float parentAlpha) {
        //batch.draw(dieSprite.getTexture(), dieSprite.getX(), dieSprite.getY(), dieSprite.getWidth(), dieSprite.getHeight());
    }

    public Sprite getDieSprite() { return dieSprite; }
    public Sprite getEyeSprite() { return eyeSprite; }
}



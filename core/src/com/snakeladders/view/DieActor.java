package com.snakeladders.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.snakeladders.controller.SnakeLadders;
import com.snakeladders.model.Die;

/**
 * Created by vegardbb on 20.04.16.
 */
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
    Sprite dieSprite;

    public DieActor(float x, float y, int width, int height, Texture t, SnakeLadders game){
        this.game = game;
        this.dieSprite = new Sprite(t, width,height);
        dieSprite.setX(x);
        dieSprite.setY(y);
        setBounds(x, y, dieSprite.getWidth(), dieSprite.getHeight());
    }
    public void setEyes(Texture eyes) {
        this.dieSprite.setTexture(eyes);
    }
    // TODO: Add more methods if need be
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(dieSprite.getTexture(), dieSprite.getX(), dieSprite.getY(), dieSprite.getWidth(), dieSprite.getHeight());
    }
}



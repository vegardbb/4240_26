package com.snakeladders.view;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.Screen;
import com.snakeladders.controller.SnakeLadders;
import com.snakeladders.model.Assets; // TODO: Replace with controller

/**
 * Created by Kristoffer on 15/04/2016.
 */
public class GameScreen implements Screen {

    SnakeLadders game;

    public GameScreen(SnakeLadders game) {
        this.game = game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        // TODO Auto-generated method stub
        //Camera camera = stage.getCamera();
        //camera.position.y = fallingMan.getY() - 5f;

        Gdx.gl.glClearColor(1f, 0f, 1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //staticStage.act(delta);
        //staticStage.draw();
        //boardStage.draw()
        //stage.act(delta);
        //stage.draw();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

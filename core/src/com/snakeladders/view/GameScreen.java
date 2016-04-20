package com.snakeladders.view;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera; // not used yet. Important
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.snakeladders.controller.GameScreenController;
import com.snakeladders.controller.MainMenuScreenController;
import com.snakeladders.controller.SnakeLadders;
import com.snakeladders.model.Assets; // TODO: Replace with controller

/**
 * Created by Kristoffer on 15/04/2016.
 */
public class GameScreen implements Screen {
    Stage stage;
    SnakeLadders game;
    TextButton diceButton;
    OrthographicCamera camera = new OrthographicCamera((float)Gdx.graphics.getWidth(),(float)Gdx.graphics.getHeight());
    GameScreenController controller;

    public GameScreen(SnakeLadders game, int playerCount) { // The controller should then
        this.game = game;
        this.controller = new GameScreenController(game);
        stage = new Stage(); // Commit: Move stage constructor to screen constructor because we want to keep it throughout the gameplay
        //Initialize the players, the fields and the die. To do this, we need the stage we just brought to life.
        this.controller.initGame(stage, playerCount); // This method generates all the fields to the stage, and generates and adds the playerActors to the stage.
    }

    @Override
    public void show() {
        
        Gdx.input.setInputProcessor(stage);
        Table table = new Table(GameScreenController.getSkin());
        Image backImage = new Image(MainMenuScreenController.getBackgroundTexture());

        diceButton = new TextButton("1", MainMenuScreenController.getDiceStyle()); // TODO: Change  to dieTexture, and use GameScreenController to get that texture. Add dieActor and send dieTexture into it.

        diceButton.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Throwing Dice");
                return true;
            }
        });

        table.setFillParent(true); // TODO: Change positions on Table...
        table.align(Align.left);
//        table.debug();
        table.add(diceButton).width(Gdx.graphics.getWidth()/6).height(Gdx.graphics.getHeight()/8);

        //stage.addActor(backImage); // Turns out the background is a dumb actor.
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {

        // TODO Auto-generated method stub
        //Camera camera = stage.getCamera();
        //camera.position.y = fallingMan.getY() - 5f;

        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //staticStage.act(delta);
        //staticStage.draw();
        //boardStage.draw()
        stage.act(delta);
        //stage.draw();
        controller.drawBoard(stage);
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

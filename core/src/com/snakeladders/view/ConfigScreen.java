package com.snakeladders.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.snakeladders.controller.MainMenuScreenController;
import com.snakeladders.controller.SnakeLadders;

/**
 * Created by HellGoose-Laptop on 4/15/2016.
 */
public class ConfigScreen implements Screen {
    private SnakeLadders game;
    private Stage stage;
    TextButton startGameButton;
    TextButton exitButton;
    MainMenuScreenController controller;

    public ConfigScreen(SnakeLadders game) {
        this.game = game;
        this.controller = new MainMenuScreenController(game);
        System.out.println("Switched to config screen");
    }

    @Override
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        Table table = new Table(MainMenuScreenController.getSkin());

        startGameButton = new TextButton("New Game", MainMenuScreenController.getTextButtonStyle());
        exitButton = new TextButton("Exit", MainMenuScreenController.getTextButtonStyle());
        Image backImage = new Image(MainMenuScreenController.getBackgroundTexture());

        startGameButton.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {
                System.out.println("New Game");
                controller.newGame();
                return true;
            }
        });

        exitButton.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {
                controller.exit();
                System.out.println("Exit Game");
                return true;
            }
        });

        table.setFillParent(true); // TODO: Change positions on Table...
//        table.debug();
        table.add(startGameButton).width(150).height(50);
        table.row();
        table.add(exitButton).width(150).height(50).padTop(10);

        stage.addActor(backImage); // Turns out the background is a dumb actor.
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 0f, 1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta); // Does not do anything to the models
        stage.draw();
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

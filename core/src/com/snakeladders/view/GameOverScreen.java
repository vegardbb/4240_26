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
import com.snakeladders.model.Player;

public class GameOverScreen implements Screen {
    private SnakeLadders game;
    private Player winner;
    private Stage stage;

    public GameOverScreen (SnakeLadders game, Player winner){
        this.game = game;
        this.winner = winner;
    }

    @Override
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        Image backImage = new Image(MainMenuScreenController.getBackgroundTexture());
        Table table = new Table(MainMenuScreenController.getSkin());
        TextButton menuScreenButton = new TextButton(winner.getName() + " WON! :D", MainMenuScreenController.getTextButtonStyle());


        menuScreenButton.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {
                game.setScreen(new MainMenuScreen(game));
                System.out.println("Starting Game");
                return true;
            }
        });
        table.setFillParent(true);
        table.add(menuScreenButton).width(Gdx.graphics.getWidth()/2).height(Gdx.graphics.getHeight()/6);

        stage.addActor(backImage);
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 0f, 1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
        stage.getBatch().begin();
        stage.getBatch().end();
    }

    @Override
    public void resize(int width, int height) {}
    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void hide() {}
    @Override
    public void dispose() {}
}

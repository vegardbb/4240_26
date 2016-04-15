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
import com.snakeladders.controller.SnakeLadders; // The Game class
import com.snakeladders.controller.MainMenuScreenController; // The controller

public class MainMenuScreen implements Screen {
    
    SnakeLadders game;
    Stage stage; 
    TextButton startGameButton;
    TextButton exitButton;
    MainMenuScreenController controller;
    
    public MainMenuScreen(SnakeLadders game) {
        this.game = game;
        this.controller = new MainMenuScreenController(game);
    }

    @Override
    public void render(float delta) {
        // TODO Auto-generated method stub
        Gdx.gl.glClearColor(1f, 0f, 1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta); // Does not do anything to the models
        stage.draw();
//        Table.drawDebug(stage);  // For testing and debugging
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        Table table = new Table(MainMenuScreenController.getSkin());
        
        startGameButton = new TextButton("Configure Game", MainMenuScreenController.getTextButtonStyle());
        exitButton = new TextButton("Exit", MainMenuScreenController.getTextButtonStyle());
        Image backImage = new Image(MainMenuScreenController.getBackgroundTexture());
        
        startGameButton.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                    int pointer, int button) {
                controller.configureGame();
                System.out.println("Configure Game");
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
    public void hide() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
        /*
        Concerning the die
        */
        
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub

    }

}

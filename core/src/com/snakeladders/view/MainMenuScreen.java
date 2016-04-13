package com.snakeladders.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.snakeladders.game.Assets; // The Assets class
import com.snakeladders.game.SnakeLadders; // The Game class

public class MainMenuScreen implements Screen {
    
    SnakeLadders game;
    Stage stage;
    TextButton startGameButton;
    TextButton optionsButton;
    TextButton exitButton;
    
    public MainMenuScreen(SnakeLadders game) {
        this.game = game;
    }

    @Override
    public void render(float delta) {
        // TODO Auto-generated method stub
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

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
        // TODO Auto-generated method stub
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        
        Table table = new Table(Assets.skin);
        
        startGameButton = new TextButton("New Game", Assets.skin);
        optionsButton = new TextButton("Options", Assets.skin);
        exitButton = new TextButton("Exit", Assets.skin);
        Image backImage = new Image(Assets.backgroundTexture);
        
        startGameButton.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                    int pointer, int button) {
                // TODO Auto-generated method stub
                game.setScreen(new GameScreen(game));
                
                return true;
            }
            
        });
        
        table.setFillParent(true);
//        table.debug(); 
        table.add(startGameButton).width(150).height(50);
        table.row();
        table.add(optionsButton).width(150).height(50).padTop(10);
        table.row();
        table.add(exitButton).width(150).height(50).padTop(10);
        
        stage.addActor(backImage);
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
        
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        
    }

}

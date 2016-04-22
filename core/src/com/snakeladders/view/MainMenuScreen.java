package com.snakeladders.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.snakeladders.controller.SnakeLadders; // The Game class
import com.snakeladders.controller.MainMenuScreenController; // The controller
import com.snakeladders.model.Assets;

public class MainMenuScreen implements Screen {
    
    private SnakeLadders game;
    private Stage stage;
    private TextButton startGameButton;
    private TextButton exitButton;
    private MainMenuScreenController controller;
    private Slider playerCountSlider;
    private Label playerCountText;

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
        table.align(Align.top);
        
        startGameButton = new TextButton("Start Game", MainMenuScreenController.getTextButtonStyle());
        exitButton = new TextButton("Exit", MainMenuScreenController.getTextButtonStyle());
        playerCountSlider = new Slider(2,4,1,false, MainMenuScreenController.getSliderStyle());
        playerCountText = new Label("2 Players", new Label.LabelStyle(Assets.getFont(), Color.BLACK));
        playerCountText.setFontScale(2);
        Image backImage = new Image(MainMenuScreenController.getBackgroundTexture());
        
        startGameButton.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                    int pointer, int button) {
                controller.newGame((int) playerCountSlider.getValue());
                System.out.println("Starting Game");
                return true;
            }
        });

        exitButton.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y,int pointer, int button) {
                controller.exit();
                System.out.println("Exit Game");
                return true;
            }
        });

        playerCountSlider.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                playerCountText.setText(Integer.toString((int)playerCountSlider.getValue()) + " Players");
            }
        });



        table.setFillParent(true); // TODO: Change positions on Table...
//        table.debug();
        table.add(playerCountText);
        table.row();
        table.add(playerCountSlider);
        table.row();
        table.add(startGameButton).width(Gdx.graphics.getWidth()/2).height(Gdx.graphics.getHeight()/6);
        table.row();
        table.add(exitButton).width(Gdx.graphics.getWidth()/2).height(Gdx.graphics.getHeight() / 6);
        
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

package com.snakeladders.view;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera; // not used yet. Important
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.snakeladders.controller.GameScreenController;
import com.snakeladders.controller.MainMenuScreenController;
import com.snakeladders.controller.SnakeLadders;
import com.snakeladders.model.Assets; // TODO: Replace with controller

/**
 * Created by Kristoffer on 15/04/2016.
 */
public class GameScreen implements Screen {
    private enum ScreenState {PAUSE, RUNNING, GAMEOVER}
    private ScreenState state;
    Stage stage;
    SnakeLadders game;
    //TextButton diceButton;
    DieActor d;
    OrthographicCamera camera = new OrthographicCamera((float)Gdx.graphics.getWidth(),(float)Gdx.graphics.getHeight());
    GameScreenController controller;

    public GameScreen(SnakeLadders game, int playerCount) { // The controller should then
        this.game = game;
        this.controller = new GameScreenController(game);
        stage = new Stage(); // Commit: Move stage constructor to screen constructor because we want to keep it throughout the gameplay
        //Initialize the players, the fields and the die. To do this, we need the stage we just brought to life.
        this.controller.initGame(stage, playerCount); // This method generates all the fields to the stage, and generates and adds the playerActors to the stage.
        this.state = ScreenState.RUNNING; // Thegame is running.
    }

    @Override
    public void show() {
        
        Gdx.input.setInputProcessor(stage);
        //Table table = new Table(GameScreenController.getSkin());
        Texture texture = controller.getDie();
        int w = texture.getWidth();
        int h = texture.getHeight();
        this.d = new DieActor((float)0,(float)h,w,h,texture, game); // 
        d.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Throwing Dice");
                controller.throwDie(d);
                return true;
            }
        });
        d.addListener(new DragListener() {
            public void drag(InputEvent event, float x, float y, int pointer) {
                d.moveBy(x - d.getWidth() / 2, y - d.getHeight() / 2);
            }
        });

        d.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Throwing Dice");
                return true;
            }
        });

        //table.setFillParent(true); // TODO: Change positions on Table...
        //table.align(Align.left);
//        table.debug();

        //stage.addActor(table);
        stage.addActor(d);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        //stage.draw();
        controller.draw(stage);
        try{
            Thread.sleep(100);
        } catch (Exception e){

        }
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

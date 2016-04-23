package com.snakeladders.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera; // not used yet. Important
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.snakeladders.controller.GameScreenController;
import com.snakeladders.controller.SnakeLadders;

/**
 * Created by Kristoffer on 15/04/2016.
 */
public class GameScreen implements Screen {
    private Stage stage;
    private SnakeLadders game;
    private DieActor d;
    TextField tf;
    private OrthographicCamera camera = new OrthographicCamera((float)Gdx.graphics.getWidth(),(float)Gdx.graphics.getHeight());
    private GameScreenController controller;

    public GameScreen(SnakeLadders game, int playerCount) { // The controller should then
        this.game = game;
        stage = new Stage(); // Commit: Move stage constructor to screen constructor because we want to keep it throughout the gameplay
        this.controller = new GameScreenController(game, stage);
        //Initialize the players, the fields and the die. To do this, we need the stage we just brought to life.
        this.controller.initGame( playerCount); // This method generates all the fields to the stage, and generates and adds the playerActors to the stage.
    }

    @Override
    public void show() {
        
        Gdx.input.setInputProcessor(stage);
        //Table table = new Table(GameScreenController.getSkin());
        Texture texture[] = controller.getDie();
        int w = texture[0].getWidth();
        int h = texture[0].getHeight();
        this.d = new DieActor((float)0,(float)h,w,h,texture[0], texture[1], game); //
        //this.tf = new TextField("Status", GameScreenController.getSkin());
        this.tf = new TextField("Status", GameScreenController.getWindowStyle());
        this.tf.setX(0);
        this.tf.setY(h/2);
        // this.tf. setBackground(GameScreenController.getWindowStyle());

        d.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                d.setTouchable(Touchable.disabled);
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
        stage.addActor(tf);
        this.tf.setText("Spillet starter.");
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        //stage.draw();
        controller.draw();
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

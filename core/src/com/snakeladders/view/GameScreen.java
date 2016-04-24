package com.snakeladders.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.snakeladders.controller.GameScreenController;
import com.snakeladders.controller.SnakeLadders;

public class GameScreen implements Screen {
    private Stage stage;
    private DieActor d;
    private GameScreenController controller;

    public GameScreen(SnakeLadders game, int playerCount) {
        stage = new Stage();
        this.controller = new GameScreenController(game, stage);
        this.controller.initGame( playerCount);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        Texture texture[] = controller.getDieTextures();
        float y = Gdx.graphics.getWidth()/10;
        this.d = new DieActor(0.0f, y,texture[0], texture[1]); //

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

        stage.addActor(d);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //stage.act(delta);
        controller.draw();
        try{
            Thread.sleep(100);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
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

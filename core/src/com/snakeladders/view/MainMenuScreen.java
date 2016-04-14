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
        
        startGameButton = new TextButton("New Game", Assets.skin); // TODO: Replace skin with TextButtonStyle, which uses a font
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
        /*
        On functunalities in the view:
        Each piece/token is represented by a png file asset (in the asset folder), is of size 20x20 pixels with transparent background.
        Each field is also 20x20 pixels, represented on the board file as an empty, white 20x20 quadrat surrounded by black
        Each board is a big png file, also in assets folder
        Each of the three types of fields are also represented as an image file of size 20x20 in the assets folder under android.
        We have a total of eight different pieces, limiting number of players to 8
        Textures in Assets, note that the names are intuitively suggestive:
        - backgroundTexture
        - boardTexture, identified by a name/string. We start out with two different boards in the assets folder.
        - pieceTexture, identified by name of colour on button, string.
        - dieTexture 
        - chanceFieldTexture ( predetermined )
        - NormalFieldTexture ( predetermined )
        - LadderFieldTexture ( predetermined )
        
        Actors on GameScreen, which need be implemented:
        - Die
        - One Piece for each player in the game.
        
        About the screens:
        Only one screen contains animated objects (things on the screen) that are interacted with that needs be implemented - the GameScreen.
        */
    }

}

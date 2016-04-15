package com.snakeladders.controller;

import com.snakeladders.view.PlayerInfoScreen;
import com.snakeladders.controller.SnakeLadders;

public class MainMenuScreenController {
    SnakeLadders game;

    public MainMenuScreenController(SnakeLadders game) {
        this.game = game;
    }

    /**
	This class controls the input from the MainMenuScreen
	TODO: Implement exitbutton method
	TODO: Implement newGameButton
    **/
    public void MainMenuScreenController(SnakeLadders game){

    }

	public void newGame(){
        game.setScreen(new PlayerInfoScreen(game));
	}

	public void exit(){
        //game.exit();
	}
}


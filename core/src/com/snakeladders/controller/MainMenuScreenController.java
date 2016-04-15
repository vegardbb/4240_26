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
    **/
    public void MainMenuScreenController(SnakeLadders game){

    }

	public void newGame(){
        game.setScreen(new PlayerInfoScreen(game));
        //TODO: more functionality may be required?
	}

	public void exit(){
        //game.exit();
	}
}


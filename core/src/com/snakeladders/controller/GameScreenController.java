package com.snakeladders.controller;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.snakeladders.game.Assets;
import com.snakeladders.model.Board;
import com.snakeladders.model.LadderField;
import com.snakeladders.model.NormalField;

import java.util.Random;// For usage on randomised boards. Debate how large a degree of "randomness" we want.

public class GameScreenController {
    /**
	Controller class for a splash screen. When touching the screen , the image disappears, screen disposed
	movePlayerLadder( ) // moving a player up or down a ladder
	------

    **/
	Stage gameboard;
	/*void initGame() { // Should be in game controller, where the players have committed, and the fields on board model gets generated
		int fields = getNrFields("chosen-board"); // Hardcoded/given or counted?
		int maxLaddersDown = (int) (fields/5);
		int maxLaddersUp = (int) (fields/10);
		for (int i = 0; i<fields; i++) {
			Random r = new Random();
			int d = r.nextInt(2); // java random
			if ((d==0) && (i>3) && (maxLaddersUp>0)) { // Ladderfield going up
				board.addField(new LadderField(board,i,null)); // Important to distinguish ladder-Up from ladder down in the list of Fields
				//...
				drawField(Assets.ladderUpFieldTexture, xFields[i], yFields[i] ); // TODO: Implement this in the same game controller
				//TODO: Implement getNextFieldStartX(), getNextFieldStartY(), suggesting xFields and yFields in Board model - Aye
				maxLaddersUp--;
			}
			else if ((d==1) && (i>3) && (maxLaddersDown>0)) { // Ladderfield going down
				int m = nextInt(i-2);
				board.addField(new LadderField(board,i,board.getField(m+2)));
				//...
				drawField(Assets.ladderDownFieldTexture, xFields[i], yFields[i] ); // TODO: Implement this in the appropriate view
				maxLaddersDown--;
			}
			else  if (d==2) {// generate chancefield.
			}
			else { // Next field on the board shall be a normal field
				board.addField(new NormalField(board,i));
				drawField(assets.normalFieldTexture, xFields[i], yFields[i] ); // TODO: Implement drawField in the same game controller
			}
		}
	}*/
}


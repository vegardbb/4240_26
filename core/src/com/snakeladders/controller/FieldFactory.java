package com.snakeladders.controller;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.snakeladders.model.Assets;
import com.snakeladders.model.Board;
import com.snakeladders.model.ChanceField;
import com.snakeladders.model.Field;
import com.snakeladders.model.LadderField;
import com.snakeladders.model.NormalField;
import com.snakeladders.view.FieldActor;
import java.util.ArrayList;
import java.util.Random;

class FieldFactory {
	private final Stage stage;

	public FieldFactory(Stage stage) {
		this.stage = stage; // The stage on which we add fieldActors. Nescessary field?
		//this.controller = stage.getGame(); // eller controller?
	} // TODO: Do Factory - option in refactoring menu in Android Studio

	//Method generateFields, class FieldFactory
	//@param Texture boardTexture	The chosen texture to geenrate the fields on top of.
	void generateFields(Texture boardTexture) {
		final int BOARD_SIZE = 7;
		final int FIELD_COUNT = BOARD_SIZE*BOARD_SIZE;
		final int MAX_LADDERS_DOWN = Math.round((float)FIELD_COUNT/10);
		final int MAX_LADDERS_UP = MAX_LADDERS_DOWN;

		final float BOARD_WIDTH = stage.getHeight();
		final float BOARD_HEIGHT = BOARD_WIDTH;
		final int FIELD_HEIGHT = (int)BOARD_HEIGHT/BOARD_SIZE;
		final int FIELD_WIDTH = (int)BOARD_WIDTH/BOARD_SIZE;

		int remainingLaddersUp = MAX_LADDERS_UP;
		int remainingLaddersDown = MAX_LADDERS_DOWN;

		Texture ladderUpFieldTexture = Assets.getLadderUpFieldTexture();
		Texture ladderDownFieldTexture = Assets.getLadderDownFieldTexture();
		Texture chanceFieldTexture = Assets.getChanceFieldTexture();
		Texture normalFieldTexture = Assets.getNormalFieldTexture();
		Texture startFieldTexture = Assets.getStartFieldTexture();
		Texture goalFieldTexture = Assets.getGoalFieldTexture();
		Board board = Board.getInstance();
		Random r = new Random();
		//int spacew = 5; // Randomised or a parameter

		for (int y = 0; y < BOARD_SIZE; y++) {
			float yPos = y*FIELD_HEIGHT;
			for (int x = 0; x < BOARD_SIZE; x++){
				int fieldNr = BOARD_SIZE*y + x;
				float xPos = x*FIELD_WIDTH + (stage.getWidth() - BOARD_HEIGHT)/2;

				int d = r.nextInt(3);

				if ((d==0) && !(y==0 && x<3) && (remainingLaddersUp>0)) { // Ladderfield going up, sends in null in the teleport-parameter, because linear.

					board.addField(new LadderField(board,fieldNr,null,x,y)); // Important to distinguish ladder-Up from ladder down in the list of Fields
					stage.addActor( new FieldActor(xPos, yPos, FIELD_WIDTH, FIELD_HEIGHT, ladderUpFieldTexture));
					// Problem: Linking the actor and the model loosely together? Solution: x and y
					remainingLaddersUp--;
				}
				else if ((d==1) && (y>0) && (remainingLaddersDown>0) && (fieldNr<FIELD_COUNT-1)) { // Ladderfield going down
					int endOfLastRow = fieldNr - x - 1;
					int m = r.nextInt(endOfLastRow);
					board.addField(new LadderField(board,fieldNr,board.getBoardfields().get(m),x,y));
					stage.addActor( new FieldActor(xPos, yPos, FIELD_WIDTH, FIELD_HEIGHT, ladderDownFieldTexture));
					remainingLaddersDown--;
				}
				else  if ((d==2) && (fieldNr > 0) && (fieldNr < FIELD_COUNT-1)) {	// generate chancefield.
											// On a chancefield, one out of a set of possible events may happen,
											// this event is not static, ie it may wary each time a player lands on it.
					board.addField(new ChanceField(board,fieldNr,x,y));
					stage.addActor( new FieldActor(xPos, yPos, FIELD_WIDTH, FIELD_HEIGHT, chanceFieldTexture));
				}
				else { // Next field on the board shall be a normal field. The start field for all players - i=0, is always a normalField, and the last field is also a normalField
					board.addField(new NormalField(board,fieldNr,x,y));
					if (x == 0 && y == 0){
						stage.addActor( new FieldActor(xPos, yPos, FIELD_WIDTH, FIELD_HEIGHT, startFieldTexture));
					}
					else if (x == BOARD_SIZE-1 && y == BOARD_SIZE-1){
						stage.addActor( new FieldActor(xPos, yPos, FIELD_WIDTH, FIELD_HEIGHT, goalFieldTexture));
					}
					else{
						stage.addActor( new FieldActor(xPos, yPos, FIELD_WIDTH, FIELD_HEIGHT, normalFieldTexture));
					}

				}
			}
		} // Reiterate over the boards ladderfields to set the teleportfield
		ArrayList<Field> boardFields = board.getBoardfields(); // May be revised
		for (Field f: boardFields){
			if (f instanceof LadderField) {
				LadderField lf = (LadderField) f;
				if (lf.getTeleportToField() == null) {
					int n = lf.getId();
					int m = r.nextInt(boardFields.size()-n);
					lf.setTeleportToField(boardFields.get(m+n));
				}
			}
		}
	} // Field initialisation done
}
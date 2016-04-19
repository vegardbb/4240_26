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
	void generateFields(Texture boardTexture) { //
		int h = boardTexture.getHeight();
		int w = boardTexture.getWidth();
		Texture ladderUpFieldTexture = Assets.getLadderUpFieldTexture();
		Texture ladderDownFieldTexture = Assets.getLadderDownFieldTexture();
		Texture chanceFieldTexture = Assets.getChanceFieldTexture();
		Texture normalFieldTexture = Assets.getNormalFieldTexture();
		int nrFields = ((int) w/20) * ((int) h/20);
		Board board = Board.getInstance();
		Random r = new Random();
		//int spacew = 5; // Randomised or a parameter
		int maxLaddersDown = (int) (nrFields/5);
		int maxLaddersUp = (int) (nrFields/10);
		int i = 0; //Field ID.
		int x = 0;
		int y = h-30;
		while (  y>0 ) {	// configure this while clause to determine space between fields in
												// the horizontal direction. May be parametrized
			while ( x<(w-30) ) { // configure this while clause to determine space between fields in
												// the vertical direction. May be parametrized
				int d = r.nextInt(2); // java random	Board board, int i, Field teleportToField, int x, int y
				if ((d==0) && (i>3) && (maxLaddersUp>0)) { // Ladderfield going up, sends in null in the teleport-parameter, because linear.
					board.addField(new LadderField(board,i,null,x,y)); // Important to distinguish ladder-Up from ladder down in the list of Fields
					stage.addActor( new FieldActor((float)(x), (float)(y), ladderUpFieldTexture));
					// Problem: Linking the actor and the model loosely together? Solution: x and y
					maxLaddersUp--;
					i++;
				}
				else if ((d==1) && (i>2) && (maxLaddersDown>0) && (i<nrFields-1)) { // Ladderfield going down
					int m = r.nextInt(i - 2);
					board.addField(new LadderField(board,i,board.getBoardfields().get(m+2),x,y));
					stage.addActor( new FieldActor((float)(x), (float)(y), ladderDownFieldTexture));
					maxLaddersDown--;
					i++;
				}
				else  if ((d==2) && (i>0) && (i<nrFields-1)) {	// generate chancefield.
											// On a chancefield, one out of a set of possible events may happen,
											// this event is not static, ie it may wary each time a player lands on it.
					board.addField(new ChanceField(board,i,x,y));
					stage.addActor( new FieldActor((float)(x), (float)(y), chanceFieldTexture));
					i++;
				}
				else { // Next field on the board shall be a normal field. The start field for all players - i=0, is always a normalField, and the last field is also a normalField
					board.addField(new NormalField(board,i,x,y));
					stage.addActor( new FieldActor((float)(x), (float)(y), normalFieldTexture));
					i++;
				}
				x += 30;
			}
			x=0;
			y = h-20;
		} // Reiterate over the boards ladderfields to set the teleportfield
		ArrayList<Field> boardfields = board.getBoardfields(); // May be revised
		for (Field f: boardfields){
			if (f instanceof LadderField) {
				LadderField lf = (LadderField) f;
				if (lf.getTeleportToField() == null) {
					int n = lf.getId();
					int m = r.nextInt(nrFields-n);
					lf.setTeleportToField(boardfields.get(m+n));
				}
			}
		}
	} // Field initialisation done
}
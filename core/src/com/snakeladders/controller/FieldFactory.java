package com.snakeladders.controller;

class FieldFactory {
	public FieldFactory(Stage stage) {
		this.stage = stage; // The stage on which we add fieldActors. Nescessary field?
		//this.controller = stage.getGame(); // eller controller?
	} // TODO: Do Factory - option in refactoring menu in Android Studio

	//Method generateFields, class FieldFactory
	//@param : w = boardTexture.getWidth, h = boardTexture.getHeight(), int spacew
	void generateFields(Texture boardTexture) { //
		Texture ladderUpFieldTexture = Assets.getLadderUpFieldTexture();
		Texture ladderDownFieldTexture = Assets.getLadderDownFieldTexture();
		Texture chanceFieldTexture = Assets.getChanceFieldTexture();
		Texture normalTexture = Assets.getNormalTexture();
		int nrFields = ((int) w/20) * ((int) h/20);
		Board board = Board.getInstance();
		Random r = new Random();
		int maxLaddersDown = (int) (nrFields/5);
		int maxLaddersUp = (int) (nrFields/10);
		int i = 0; //Field ID.
		while ( int x = 0; x< w-20; x += 30 ) {	// configure this while clause to determine space between fields in
												// the horizontal direction. May be parametrized
			while ( int y = h-20; y>0; y -= 30 ) { // configure this while clause to determine space between fields in
												// the vertical direction. May be parametrized
				int d = r.nextInt(2); // java random	Board board, int i, Field teleportToField, int x, int y
				if ((d==0) && (i>3) && (maxLaddersUp>0)) { // Ladderfield going up, sends in null in the teleport-parameter, because linear.
					board.addField(new LadderField(board,i,null,x,y)); // Important to distinguish ladder-Up from ladder down in the list of Fields
					stage.addActor( new fieldActor((float)(x), (float)(y), ladderUpFieldTexture));
					// Problem: Linking the actor and the model loosely together? Solution: x and y
					maxLaddersUp--;
					i++;
				}
				else if ((d==1) && (i>2) && (maxLaddersDown>0)) { // Ladderfield going down
					int m = nextInt(i-2);
					board.addField(new LadderField(board,i,board.getField(m+2),x,y));
					stage.addActor( new fieldActor((float)(x), (float)(y), ladderDownFieldTexture));
					maxLaddersDown--;
					i++;
				}
				else  if ((d==2) && (i>0)) {	// generate chancefield.
											// On a chancefield, one out of a set of possible events may happen,
											// this event is not static, ie it may wary each time a player lands on it.
					board.addField(new ChanceField(board,i,x,y));
					stage.addActor( new fieldActor((float)(x), (float)(y), chanceFieldTexture));
					i++;
				}
				else { // Next field on the board shall be a normal field. The start field for all players - i=0, is always a normalField
					board.addField(new NormalField(board,i,x,y));
					stage.addActor( new fieldActor((float)(x), (float)(y), normalFieldTexture));
					i++;
				}
			}
		} // Reiterate over the boards ladderfields to set the teleportfield
		ArrayList<Field> boardfields = board.getBoardfields(); // May be revised
		for (Field f: boardFields){
			if ((f.getTeleportToField() == null) && (f instanceof LadderField)) {
				int n = f.getId();
				int m = nextInt(nrFields-n);
				f.setTeleportToField(boardfields.get(m+n));
			}
		}
	}
}
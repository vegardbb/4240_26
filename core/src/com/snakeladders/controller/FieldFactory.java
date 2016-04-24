package com.snakeladders.controller;

import com.badlogic.gdx.Gdx;
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
    private GameScreenController controller;

    public FieldFactory(Stage stage, GameScreenController controller) {
        this.stage = stage;
        this.controller = controller;
    }

    //Method generateFields, class FieldFactory
    void generateFields() {
        final int BOARD_SIZE = 7;
        final int FIELD_COUNT = BOARD_SIZE * BOARD_SIZE;
        final int MAX_SPECIAL_FIELDS = Math.round((float) FIELD_COUNT / 10);

        final float BOARD_PIXEL_DIMENSION = Gdx.graphics.getHeight();
        final int FIELD_PIXEL_DIMENSION = (int) BOARD_PIXEL_DIMENSION / BOARD_SIZE;

        int remainingLaddersUp = MAX_SPECIAL_FIELDS;
        int remainingLaddersDown = MAX_SPECIAL_FIELDS;
        int remainingChanceFields = MAX_SPECIAL_FIELDS;

        Texture ladderUpFieldTexture = Assets.getLadderUpFieldTexture();
        Texture ladderDownFieldTexture = Assets.getLadderDownFieldTexture();
        Texture chanceFieldTexture = Assets.getChanceFieldTexture();
        Texture normalFieldTexture = Assets.getNormalFieldTexture();
        Texture startFieldTexture = Assets.getStartFieldTexture();
        Texture goalFieldTexture = Assets.getGoalFieldTexture();
        Board board = Board.getInstance();
        Random r = new Random();

        for (int y = 0; y < BOARD_SIZE; y++) {
            float yPos = y * FIELD_PIXEL_DIMENSION;
            for (int x = 0; x < BOARD_SIZE; x++) {
                try {
                    Thread.sleep(10);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
                int fieldNr = BOARD_SIZE * y + x;
                float xPos = x * FIELD_PIXEL_DIMENSION + (Gdx.graphics.getWidth() - BOARD_PIXEL_DIMENSION) / 2;

                float fieldsLeft = FIELD_COUNT - fieldNr;
                float chanceFieldProb = remainingChanceFields/fieldsLeft;
                float ladderDownProb = chanceFieldProb + remainingLaddersDown/fieldsLeft;
                float ladderUpProb = ladderDownProb + remainingLaddersUp/fieldsLeft;

                int d = r.nextInt(100);

                if (d < 65 - ladderUpProb*fieldNr){
                    Field field = new NormalField(fieldNr, xPos, yPos, FIELD_PIXEL_DIMENSION);
                    board.addField(field);

                    Texture fieldTexture = normalFieldTexture;
                    if (x == 0 && y == 0) { fieldTexture = startFieldTexture; }
                    else if (x == BOARD_SIZE - 1 && y == BOARD_SIZE - 1) { fieldTexture = goalFieldTexture; }

                    stage.addActor(new FieldActor(fieldNr, xPos, yPos, FIELD_PIXEL_DIMENSION, FIELD_PIXEL_DIMENSION, fieldTexture, controller));
                } else {
                    float random = r.nextFloat()*ladderUpProb;
                    if ((random <= chanceFieldProb) && (fieldNr > 0) && (remainingChanceFields > 0) &&  (fieldNr < FIELD_COUNT - 1)) {    // generate chancefield.
                        // On a chancefield, one out of a set of possible events may happen,
                        // this event is not static, ie it may wary each time a player lands on it.
                        Field field = new ChanceField(fieldNr, xPos, yPos, FIELD_PIXEL_DIMENSION);
                        board.addField(field);
                        stage.addActor(new FieldActor(fieldNr, xPos, yPos, FIELD_PIXEL_DIMENSION, FIELD_PIXEL_DIMENSION, chanceFieldTexture, controller));
                        remainingChanceFields--;

                    } else if ((random <= ladderDownProb) && (y > 0) && (remainingLaddersDown > 0) && (fieldNr < FIELD_COUNT - 1)) { // Ladderfield going down
                        int endOfLastRow = fieldNr - x - 1;
                        int m = r.nextInt(endOfLastRow);
                        Field field = new LadderField(fieldNr, board.getBoardFields().get(m), xPos, yPos, FIELD_PIXEL_DIMENSION);
                        board.addField(field);
                        stage.addActor(new FieldActor(fieldNr, xPos, yPos, FIELD_PIXEL_DIMENSION, FIELD_PIXEL_DIMENSION, ladderDownFieldTexture, controller));
                        remainingLaddersDown--;

                    } else if ((random <= ladderUpProb) && !(y == 0 && x < 3) && (remainingLaddersUp > 0) && (fieldNr < (FIELD_COUNT - BOARD_SIZE))) { // Ladderfield going up, sends in null in the teleport-parameter, because linear.
                        Field field = new LadderField(fieldNr, null, xPos, yPos, FIELD_PIXEL_DIMENSION);
                        board.addField(field); // Important to distinguish ladder-Up from ladder down in the list of Fields
                        stage.addActor(new FieldActor(fieldNr, xPos, yPos, FIELD_PIXEL_DIMENSION, FIELD_PIXEL_DIMENSION, ladderUpFieldTexture, controller));
                        // Problem: Linking the actor and the model loosely together? Solution: x and y
                        remainingLaddersUp--;

                    } else {
                        Field field = new NormalField(fieldNr, xPos, yPos, FIELD_PIXEL_DIMENSION);
                        board.addField(field);

                        Texture fieldTexture = normalFieldTexture;
                        if (x == 0 && y == 0) { fieldTexture = startFieldTexture; }
                        else if (x == BOARD_SIZE - 1 && y == BOARD_SIZE - 1) { fieldTexture = goalFieldTexture; }

                        stage.addActor(new FieldActor(fieldNr, xPos, yPos, FIELD_PIXEL_DIMENSION, FIELD_PIXEL_DIMENSION, fieldTexture, controller));
                    }
                }


            }
        } // Reiterate over the boards ladderfields to set the teleportfield
        ArrayList<Field> boardFields = board.getBoardFields(); // May be revised
        for (Field f : boardFields) {
            if (f instanceof LadderField) {
                LadderField lf = (LadderField) f;
                if (lf.getTeleportToField() == null) {
                    int n = lf.getId();
                    int y = (int)Math.floor(n/BOARD_SIZE);
                    int minPos = (y+1)*BOARD_SIZE;
                    int m = minPos + r.nextInt(boardFields.size() - minPos - 2);
                    lf.setTeleportToField(boardFields.get(m));
                }
            }
        }
    } // Field initialisation done
}
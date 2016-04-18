package com.snakeladders.view;

class fieldActor extends Actor { // Image extends Widget, which in turn extends Actor
	private Snakeladders game; // The controller which provides the Field its datamodel.
	Sprite fieldSprite;
	
	public fieldActor(float x, float y, Texture t){
		this.fieldSprite = new Sprite(t);
		fieldSprite.setX(x); // require float, nodvendig?
		fieldSprite.sety(Y); // require float
		//setBounds(fieldSprite.getX(),fieldSprite.getY(),fieldSprite.getWidth(),fieldSprite.getHeight());
		setBounds(x,y,fieldSprite.getWidth(),fieldSprite.getHeight());
	}
}

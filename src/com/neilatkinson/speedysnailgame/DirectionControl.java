package com.neilatkinson.speedysnailgame;

import com.neilatkinson.framework.Image;
import com.neilatkinson.framework.Input.TouchEvent;

public class DirectionControl extends GameControl {

	private int buttonWidth;
	private int buttonHeight;


	public DirectionControl(GameScreen gameScreen, Image image, int x, int y, int srcX, int srcY, int width, int height) {
		super(gameScreen, image, x, y, srcX, srcY, width, height);
		buttonWidth = this.width / 3;
		buttonHeight = this.height / 3;
	}

	public boolean upButtonPressed(TouchEvent touchEvent) {
		int upButtonX = getPositionX() + buttonWidth;
		int upButtonY = getPositionY();
		return inBounds(touchEvent, upButtonX, upButtonY, buttonWidth, buttonHeight);
	}

	public boolean leftButtonPressed(TouchEvent touchEvent) {
		int leftButtonX = getPositionX();
		int leftButtonY = getPositionY() + buttonHeight;
		return inBounds(touchEvent, leftButtonX, leftButtonY, buttonWidth, buttonHeight);
	}

	public boolean downButtonPressed(TouchEvent touchEvent) {
		int downButtonX = getPositionX() + buttonWidth;
		int downButtonY = getPositionY() + 2 * buttonHeight;
		return inBounds(touchEvent, downButtonX, downButtonY, buttonWidth, buttonHeight);
	}

	public boolean rightButtonPressed(TouchEvent touchEvent) {
		int rightButtonX = getPositionX() + 2 * buttonWidth;
		int rightButtonY = getPositionY() + buttonHeight;
		return inBounds(touchEvent, rightButtonX, rightButtonY, buttonWidth, buttonHeight);
	}
	

}

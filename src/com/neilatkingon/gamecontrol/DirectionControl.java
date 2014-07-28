package com.neilatkingon.gamecontrol;

import com.neilatkinson.framework.Image;
import com.neilatkinson.framework.Input.TouchEvent;

public class DirectionControl extends ImageControl {

	private int buttonWidth;
	private int buttonHeight;


	public DirectionControl(Image image, int x, int y, int srcX, int srcY, int width, int height) {
		super(image, x, y, srcX, srcY, width, height);
		this.buttonWidth = this.width / 3;
		this.buttonHeight = this.height / 3;
	}

	public boolean upButtonPressed(TouchEvent touchEvent) {
		int upButtonX = positionX() + buttonWidth;
		int upButtonY = positionY();
		return inBounds(touchEvent, upButtonX, upButtonY, buttonWidth, buttonHeight);
	}

	public boolean leftButtonPressed(TouchEvent touchEvent) {
		int leftButtonX = positionX();
		int leftButtonY = positionY() + buttonHeight;
		return inBounds(touchEvent, leftButtonX, leftButtonY, buttonWidth, buttonHeight);
	}

	public boolean downButtonPressed(TouchEvent touchEvent) {
		int downButtonX = positionX() + buttonWidth;
		int downButtonY = positionY() + 2 * buttonHeight;
		return inBounds(touchEvent, downButtonX, downButtonY, buttonWidth, buttonHeight);
	}

	public boolean rightButtonPressed(TouchEvent touchEvent) {
		int rightButtonX = positionX() + 2 * buttonWidth;
		int rightButtonY = positionY() + buttonHeight;
		return inBounds(touchEvent, rightButtonX, rightButtonY, buttonWidth, buttonHeight);
	}
	

}

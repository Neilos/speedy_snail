package com.neilatkinson.speedysnailgame;

import com.neilatkinson.framework.Image;
import com.neilatkinson.framework.Input.TouchEvent;

public class PauseButton extends GameControl {

	public PauseButton(GameScreen gameScreen, Image image, int x, int y, int srcX, int srcY, int width, int height) {
		super(gameScreen, image, x, y, srcX, srcY, width, height);
	}
	
	public boolean isPressed(TouchEvent touchEvent) {
		return inBounds(touchEvent, getPositionY(), getPositionY(), width, height);
	}

}

package com.neilatkinson.speedysnailgame;

import java.util.ArrayList;

import com.neilatkinson.gameobject.Animation;
import com.neilatkinson.gameobject.GameObject;
import com.neilatkinson.gameobject.Zone;

public class PlayerCharacter extends GameObject {

	public PlayerCharacter(GameScreen gameScreen,
			int centerX, int centerY, int moveSpeed, int speedX, int speedY,
			Zone area, int health, int damage, boolean isDead, boolean isMovingUp,
			boolean isMovingLeft, boolean isMovingDown, boolean isMovingRight,
			Animation moveUpAnimation, Animation moveLeftAnimation,
			Animation moveDownAnimation, Animation moveRightAnimation,
			Animation faceUpAnimation, Animation faceLeftAnimation,
			Animation faceDownAnimation, Animation faceRightAnimation,
			Animation currentAnimation, int passiveDuration,
			ArrayList<Class<? extends GameObject>> damageableTypes) {

		super(gameScreen, centerX, centerY, moveSpeed, speedX, speedY,
				area, health, damage, isDead, isMovingUp, isMovingLeft, isMovingDown,
				isMovingRight, moveUpAnimation, moveLeftAnimation, moveDownAnimation,
				moveRightAnimation, faceUpAnimation, faceLeftAnimation,
				faceDownAnimation, faceRightAnimation, currentAnimation, passiveDuration,
				damageableTypes);

	}

    @Override
    public void moveUp() {
    	gameScreen.setBackgroundSpeedX(0);
    	setSpeedX(0);
		if (nearTopOfScreen()) {
			gameScreen.setBackgroundSpeedY(maxUpSpeed());
			setSpeedY(0);
		} else {
			gameScreen.setBackgroundSpeedY(0);
			setSpeedY(-maxUpSpeed());
		}
		((GameScreen) gameScreen).updateBackground();
	}

    @Override
    public void moveLeft() {
    	gameScreen.setBackgroundSpeedY(0);
    	setSpeedY(0);
		if (nearLeftOfScreen()) {
			gameScreen.setBackgroundSpeedX(maxLeftSpeed());
			setSpeedX(0);
		} else {
			gameScreen.setBackgroundSpeedX(0);
			setSpeedX(-maxLeftSpeed());
		}
		((GameScreen) gameScreen).updateBackground();
	}

    @Override
    public void moveDown() {
    	gameScreen.setBackgroundSpeedX(0);
    	setSpeedX(0);
		if (nearBottomOfScreen()) {
			gameScreen.setBackgroundSpeedY(-maxDownSpeed());
			setSpeedY(0);
		} else {
			gameScreen.setBackgroundSpeedY(0);
			setSpeedY(maxDownSpeed());
		}
		((GameScreen) gameScreen).updateBackground();
	}

    @Override
    public void moveRight() {
    	gameScreen.setBackgroundSpeedY(0);
    	setSpeedY(0);
		if (nearRightOfScreen()) {
			gameScreen.setBackgroundSpeedX(-maxRightSpeed());
			setSpeedX(0);
		} else {
			gameScreen.setBackgroundSpeedX(0);
			setSpeedX(maxRightSpeed());
		}
		((GameScreen) gameScreen).updateBackground();
	}

    @Override
    public void remainStationary() {
		gameScreen.setBackgroundSpeedX(0);
		gameScreen.setBackgroundSpeedY(0);
		setSpeedX(0);
		setSpeedY(0);
	}

}

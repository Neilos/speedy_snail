package com.neilatkinson.speedysnailgame;

import com.neilatkinson.gameobject.Animation;
import com.neilatkinson.gameobject.Damageable;
import com.neilatkinson.gameobject.GameObject;

import android.graphics.Rect;

public class PlayerCharacter extends GameObject {

	public PlayerCharacter(GameScreen gameScreen,
			int centerX, int centerY, int moveSpeed, int speedX, int speedY,
			Rect vicinity, int health, boolean isDead, boolean isMovingUp,
			boolean isMovingLeft, boolean isMovingDown, boolean isMovingRight,
			Animation moveUpAnimation, Animation moveLeftAnimation,
			Animation moveDownAnimation, Animation moveRightAnimation,
			Animation faceUpAnimation, Animation faceLeftAnimation,
			Animation faceDownAnimation, Animation faceRightAnimation,
			Animation currentAnimation) {

		super(gameScreen, centerX, centerY, moveSpeed, speedX, speedY,
				vicinity, health, isDead, isMovingUp, isMovingLeft, isMovingDown,
				isMovingRight, moveUpAnimation, moveLeftAnimation, moveDownAnimation,
				moveRightAnimation, faceUpAnimation, faceLeftAnimation,
				faceDownAnimation, faceRightAnimation, currentAnimation);

	}

    public void update() {
    	move();
    }


    @Override
    public void moveUp() {
    	gameScreen.setBackgroundSpeedX(0);
    	setSpeedX(0);
		if (nearTopOfScreen()) {
			gameScreen.setBackgroundSpeedY(moveSpeed);
			setSpeedY(0);
		} else {
			gameScreen.setBackgroundSpeedY(0);
			setSpeedY(-moveSpeed);
		}
	}

    @Override
    public void moveLeft() {
    	gameScreen.setBackgroundSpeedY(0);
    	setSpeedY(0);
		if (nearLeftOfScreen()) {
			gameScreen.setBackgroundSpeedX(moveSpeed);
			setSpeedX(0);
		} else {
			gameScreen.setBackgroundSpeedX(0);
			setSpeedX(-moveSpeed);
		}
	}

    @Override
    public void moveDown() {
    	gameScreen.setBackgroundSpeedX(0);
    	setSpeedX(0);
		if (nearBottomOfScreen()) {
			gameScreen.setBackgroundSpeedY(-moveSpeed);
			setSpeedY(0);
		} else {
			gameScreen.setBackgroundSpeedY(0);
			setSpeedY(moveSpeed);
		}
	}

    @Override
    public void moveRight() {
    	gameScreen.setBackgroundSpeedY(0);
    	setSpeedY(0);
		if (nearRightOfScreen()) {
			gameScreen.setBackgroundSpeedX(-moveSpeed);
			setSpeedX(0);
		} else {
			gameScreen.setBackgroundSpeedX(0);
			setSpeedX(moveSpeed);
		}
	}

    @Override
    public void remainStationary() {
		gameScreen.setBackgroundSpeedX(0);
		gameScreen.setBackgroundSpeedY(0);
		setSpeedX(0);
		setSpeedY(0);
	}

	@Override
	public void attack(Damageable damageable) {
		
	}

	@Override
	public void takeDamage(int damage) {
		
	}

	@Override
	public void heal(int damage) {
		
	}

	@Override
	public void die() {
		
	}

}

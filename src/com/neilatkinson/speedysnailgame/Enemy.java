package com.neilatkinson.speedysnailgame;

import java.util.ArrayList;

import android.graphics.Rect;

import com.neilatkinson.gameobject.Animation;
import com.neilatkinson.gameobject.GameObject;

public abstract class Enemy extends GameObject {
	
	public GameObject playerCharacter;

	public Enemy(GameScreen gameScreen, int centerX,
			int centerY, int moveSpeed, int speedX, int speedY, Rect area,
			int health, int damage, boolean isDead, boolean isMovingUp,
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
				faceDownAnimation, faceRightAnimation, currentAnimation, passiveDuration, damageableTypes);
		this.playerCharacter = gameScreen.getPlayerCharacter();
	}

	@Override
	public void update(int elapsedTime) {
		follow();
		move(elapsedTime);
	}

	private void follow() {
		int xDistanceToPlayer = playerCharacter.centerX() - centerX();
		int yDistanceToPlayer = playerCharacter.centerY() - centerY();
		
		if (Math.abs(xDistanceToPlayer) >= Math.abs(yDistanceToPlayer)) {
			// Move in the x direction
			if (xDistanceToPlayer > 0) {
				setMovingRight();
			} else if (xDistanceToPlayer < 0) {
				setMovingLeft();
			} else {
				setStopped();
			}
		} else {
			// Move in the y direction
			if (yDistanceToPlayer > 0) {
				setMovingDown();
			} else if (yDistanceToPlayer < 0){
				setMovingUp();
			} else {
				setStopped();
			}
		}
		
	}

}

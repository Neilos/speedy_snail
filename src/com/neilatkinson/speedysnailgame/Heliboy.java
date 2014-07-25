package com.neilatkinson.speedysnailgame;

import android.graphics.Rect;

import com.neilatkinson.gameobject.Animation;
import com.neilatkinson.gameobject.GameObject;

public class Heliboy extends Enemy {

	public Heliboy(GameScreen gameScreen, GameObject playerCharacter, int centerX,
			int centerY, int moveSpeed, int speedX, int speedY, Rect area,
			int health, boolean isDead, boolean isMovingUp,
			boolean isMovingLeft, boolean isMovingDown, boolean isMovingRight,
			Animation moveUpAnimation, Animation moveLeftAnimation,
			Animation moveDownAnimation, Animation moveRightAnimation,
			Animation faceUpAnimation, Animation faceLeftAnimation,
			Animation faceDownAnimation, Animation faceRightAnimation,
			Animation currentAnimation) {

		super(gameScreen, centerX, centerY, moveSpeed, speedX, speedY,
				area, health, isDead, isMovingUp, isMovingLeft, isMovingDown,
				isMovingRight, moveUpAnimation, moveLeftAnimation, moveDownAnimation,
				moveRightAnimation, faceUpAnimation, faceLeftAnimation,
				faceDownAnimation, faceRightAnimation, currentAnimation);
	}

}

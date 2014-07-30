package com.neilatkinson.speedysnailgame;

import java.util.ArrayList;

import com.neilatkinson.gameobject.Animation;
import com.neilatkinson.gameobject.GameObject;
import com.neilatkinson.gameobject.Zone;

public class SnailPlayerCharacter extends PlayerCharacter {

	public SnailPlayerCharacter(GameScreen gameScreen, int centerX,
			int centerY, int moveSpeed, int speedX, int speedY, Zone area,
			int health, int damage, boolean isDead, boolean isMovingUp,
			boolean isMovingLeft, boolean isMovingDown, boolean isMovingRight,
			Animation moveUpAnimation, Animation moveLeftAnimation,
			Animation moveDownAnimation, Animation moveRightAnimation,
			Animation faceUpAnimation, Animation faceLeftAnimation,
			Animation faceDownAnimation, Animation faceRightAnimation,
			Animation currentAnimation, int passiveDuration,
			ArrayList<Class<? extends GameObject>> damageableTypes) {

		super(gameScreen, centerX, centerY, moveSpeed, speedX, speedY, area,
				health, damage, isDead, isMovingUp, isMovingLeft, isMovingDown,
				isMovingRight, moveUpAnimation, moveLeftAnimation,
				moveDownAnimation, moveRightAnimation, faceUpAnimation,
				faceLeftAnimation, faceDownAnimation, faceRightAnimation,
				currentAnimation, passiveDuration, damageableTypes);

	}

}

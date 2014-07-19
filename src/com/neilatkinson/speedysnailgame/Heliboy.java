package com.neilatkinson.speedysnailgame;

import com.neilatkinson.gameobject.Animation;

public class Heliboy extends Enemy {

	public Heliboy(
			GameScreen gameScreen,
			int moveSpeed,
			int startingCenterX,
			int startingCenterY,
			Animation moveUpAnimation,
			Animation moveLeftAnimation,
			Animation moveDownAnimation,
			Animation moveRightAnimation,
			int startingHealth) {
		
		super(gameScreen,
				moveSpeed,
				startingCenterX, startingCenterY,
				moveUpAnimation, moveLeftAnimation, moveDownAnimation, moveRightAnimation,
				startingHealth);
	}

}

package com.neilatkinson.speedysnailgame;

import com.neilatkinson.gameobject.Animation;

public class Heliboy extends Enemy {

	public Heliboy(
			GameScreen gameScreen,
			int moveSpeed,
			int startingCenterX,
			int startingCenterY,
			int startingHealth) {
		
		super(gameScreen,
				moveSpeed,
				startingCenterX, startingCenterY,
				startingHealth);
	}

	@Override
	public void setUpAnimations() {
		currentAnimation = new Animation();

		moveUpAnimation = new Animation();
		moveLeftAnimation = new Animation();
		moveDownAnimation = new Animation();
		moveRightAnimation = new Animation();

		stationaryFacingUpAnimation = new Animation();
		stationaryFacingLeftAnimation = new Animation();
		stationaryFacingDownAnimation = new Animation();
		stationaryFacingRightAnimation = new Animation();

		moveUpAnimation.addFrame(Assets.heliboy, 100, null ,null ,null , null);
		moveUpAnimation.addFrame(Assets.heliboy2, 100, null ,null ,null , null);
		moveUpAnimation.addFrame(Assets.heliboy3, 100, null ,null ,null , null);
		moveUpAnimation.addFrame(Assets.heliboy4, 100, null ,null ,null , null);
		moveUpAnimation.addFrame(Assets.heliboy5, 100, null ,null ,null , null);
		moveUpAnimation.addFrame(Assets.heliboy4, 100, null ,null ,null , null);
		moveUpAnimation.addFrame(Assets.heliboy3, 100, null ,null ,null , null);
		moveUpAnimation.addFrame(Assets.heliboy2, 100, null ,null ,null , null);

		moveLeftAnimation.addFrame(Assets.heliboy, 100, null ,null ,null , null);
		moveLeftAnimation.addFrame(Assets.heliboy2, 100, null ,null ,null , null);
		moveLeftAnimation.addFrame(Assets.heliboy3, 100, null ,null ,null , null);
		moveLeftAnimation.addFrame(Assets.heliboy4, 100, null ,null ,null , null);
		moveLeftAnimation.addFrame(Assets.heliboy5, 100, null ,null ,null , null);
		moveLeftAnimation.addFrame(Assets.heliboy4, 100, null ,null ,null , null);
		moveLeftAnimation.addFrame(Assets.heliboy3, 100, null ,null ,null , null);
		moveLeftAnimation.addFrame(Assets.heliboy2, 100, null ,null ,null , null);

		moveDownAnimation.addFrame(Assets.heliboy, 100, null ,null ,null , null);
		moveDownAnimation.addFrame(Assets.heliboy2, 100, null ,null ,null , null);
		moveDownAnimation.addFrame(Assets.heliboy3, 100, null ,null ,null , null);
		moveDownAnimation.addFrame(Assets.heliboy4, 100, null ,null ,null , null);
		moveDownAnimation.addFrame(Assets.heliboy5, 100, null ,null ,null , null);
		moveDownAnimation.addFrame(Assets.heliboy4, 100, null ,null ,null , null);
		moveDownAnimation.addFrame(Assets.heliboy3, 100, null ,null ,null , null);
		moveDownAnimation.addFrame(Assets.heliboy2, 100, null ,null ,null , null);

		moveRightAnimation.addFrame(Assets.heliboy, 100, null ,null ,null , null);
		moveRightAnimation.addFrame(Assets.heliboy2, 100, null ,null ,null , null);
		moveRightAnimation.addFrame(Assets.heliboy3, 100, null ,null ,null , null);
		moveRightAnimation.addFrame(Assets.heliboy4, 100, null ,null ,null , null);
		moveRightAnimation.addFrame(Assets.heliboy5, 100, null ,null ,null , null);
		moveRightAnimation.addFrame(Assets.heliboy4, 100, null ,null ,null , null);
		moveRightAnimation.addFrame(Assets.heliboy3, 100, null ,null ,null , null);
		moveRightAnimation.addFrame(Assets.heliboy2, 100, null ,null ,null , null);

		stationaryFacingUpAnimation = moveUpAnimation;
		stationaryFacingLeftAnimation = moveLeftAnimation;
		stationaryFacingDownAnimation = moveDownAnimation;
		stationaryFacingRightAnimation = moveRightAnimation;

		currentAnimation = stationaryFacingRightAnimation;
	}

}

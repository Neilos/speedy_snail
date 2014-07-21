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

		moveUpAnimation.addFrame(Assets.heliboy, 100);
		moveUpAnimation.addFrame(Assets.heliboy2, 100);
		moveUpAnimation.addFrame(Assets.heliboy3, 100);
		moveUpAnimation.addFrame(Assets.heliboy4, 100);
		moveUpAnimation.addFrame(Assets.heliboy5, 100);
		moveUpAnimation.addFrame(Assets.heliboy4, 100);
		moveUpAnimation.addFrame(Assets.heliboy3, 100);
		moveUpAnimation.addFrame(Assets.heliboy2, 100);

		moveLeftAnimation.addFrame(Assets.heliboy, 100);
		moveLeftAnimation.addFrame(Assets.heliboy2, 100);
		moveLeftAnimation.addFrame(Assets.heliboy3, 100);
		moveLeftAnimation.addFrame(Assets.heliboy4, 100);
		moveLeftAnimation.addFrame(Assets.heliboy5, 100);
		moveLeftAnimation.addFrame(Assets.heliboy4, 100);
		moveLeftAnimation.addFrame(Assets.heliboy3, 100);
		moveLeftAnimation.addFrame(Assets.heliboy2, 100);

		moveDownAnimation.addFrame(Assets.heliboy, 100);
		moveDownAnimation.addFrame(Assets.heliboy2, 100);
		moveDownAnimation.addFrame(Assets.heliboy3, 100);
		moveDownAnimation.addFrame(Assets.heliboy4, 100);
		moveDownAnimation.addFrame(Assets.heliboy5, 100);
		moveDownAnimation.addFrame(Assets.heliboy4, 100);
		moveDownAnimation.addFrame(Assets.heliboy3, 100);
		moveDownAnimation.addFrame(Assets.heliboy2, 100);

		moveRightAnimation.addFrame(Assets.heliboy, 100);
		moveRightAnimation.addFrame(Assets.heliboy2, 100);
		moveRightAnimation.addFrame(Assets.heliboy3, 100);
		moveRightAnimation.addFrame(Assets.heliboy4, 100);
		moveRightAnimation.addFrame(Assets.heliboy5, 100);
		moveRightAnimation.addFrame(Assets.heliboy4, 100);
		moveRightAnimation.addFrame(Assets.heliboy3, 100);
		moveRightAnimation.addFrame(Assets.heliboy2, 100);

		stationaryFacingUpAnimation = moveUpAnimation;
		stationaryFacingLeftAnimation = moveLeftAnimation;
		stationaryFacingDownAnimation = moveDownAnimation;
		stationaryFacingRightAnimation = moveRightAnimation;

		currentAnimation = stationaryFacingRightAnimation;
	}

}

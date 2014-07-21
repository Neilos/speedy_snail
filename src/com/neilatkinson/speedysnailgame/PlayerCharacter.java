package com.neilatkinson.speedysnailgame;

import com.neilatkinson.gameobject.Animation;
import com.neilatkinson.gameobject.Damageable;
import com.neilatkinson.gameobject.GameObject;

import android.graphics.Rect;

public class PlayerCharacter extends GameObject {

    final int JUMPSPEED = -15;

    public Rect rect = new Rect(0, 0, 0, 0);
    public Rect rect2 = new Rect(0, 0, 0, 0);
    public Rect rect3 = new Rect(0, 0, 0, 0);
    public Rect rect4 = new Rect(0, 0, 0, 0);
    public Rect yellowRed = new Rect(0, 0, 0, 0);
    public Rect footleft = new Rect(0,0,0,0);
    public Rect footright = new Rect(0,0,0,0);

    public PlayerCharacter(
    		GameScreen gameScreen,
    		int moveSpeed, 
    		int startingCenterX, 
    		int startingCenterY) {

    	super(gameScreen, 
			moveSpeed,
			startingCenterX, startingCenterY);

        rect = new Rect(0, 0, 0, 0);
        rect2 = new Rect(0, 0, 0, 0);
        rect3 = new Rect(0, 0, 0, 0);
        rect4 = new Rect(0, 0, 0, 0);
        yellowRed = new Rect(0, 0, 0, 0);
        footleft = new Rect(0,0,0,0);
        footright = new Rect(0,0,0,0);

        setRegion();
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

		moveUpAnimation.addFrame(Assets.characterJump, 1000, null ,null ,null , null);

		moveLeftAnimation.addFrame(Assets.character, 1250, null ,null ,null , null);
		moveLeftAnimation.addFrame(Assets.character2, 50, null ,null ,null , null);
		moveLeftAnimation.addFrame(Assets.character3, 50, null ,null ,null , null);
		moveLeftAnimation.addFrame(Assets.character2, 50, null ,null ,null , null);

		moveDownAnimation.addFrame(Assets.characterDown, 1000, null ,null ,null , null);

		moveRightAnimation.addFrame(Assets.character, 1250, null ,null ,null , null);
		moveRightAnimation.addFrame(Assets.character2, 50, null ,null ,null , null);
		moveRightAnimation.addFrame(Assets.character3, 50, null ,null ,null , null);
		moveRightAnimation.addFrame(Assets.character2, 50, null ,null ,null , null);

		stationaryFacingUpAnimation.addFrame(Assets.character, 1250, null ,null ,null , null);
		stationaryFacingUpAnimation.addFrame(Assets.character2, 50, null ,null ,null , null);
		stationaryFacingUpAnimation.addFrame(Assets.character3, 50, null ,null ,null , null);
		stationaryFacingUpAnimation.addFrame(Assets.character2, 50, null ,null ,null , null);

		stationaryFacingLeftAnimation.addFrame(Assets.character, 1250, null ,null ,null , null);
		stationaryFacingLeftAnimation.addFrame(Assets.character2, 50, null ,null ,null , null);
		stationaryFacingLeftAnimation.addFrame(Assets.character3, 50, null ,null ,null , null);
		stationaryFacingLeftAnimation.addFrame(Assets.character2, 50, null ,null ,null , null);

		stationaryFacingDownAnimation.addFrame(Assets.character, 1250, null ,null ,null , null);
		stationaryFacingDownAnimation.addFrame(Assets.character2, 50, null ,null ,null , null);
		stationaryFacingDownAnimation.addFrame(Assets.character3, 50, null ,null ,null , null);
		stationaryFacingDownAnimation.addFrame(Assets.character2, 50, null ,null ,null , null);

		stationaryFacingRightAnimation.addFrame(Assets.character, 1250, null ,null ,null , null);
		stationaryFacingRightAnimation.addFrame(Assets.character2, 50, null ,null ,null , null);
		stationaryFacingRightAnimation.addFrame(Assets.character3, 50, null ,null ,null , null);
		stationaryFacingRightAnimation.addFrame(Assets.character2, 50, null ,null ,null , null);

		currentAnimation = stationaryFacingRightAnimation;
	}


    public void update() {
    	move();
        setRegion();
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


    public void setRegion() {
    	rect.set(centerX - 34, centerY - 63, centerX + 34, centerY);
        rect2.set(rect.left, rect.top + 63, rect.left+68, rect.top + 128);
        rect3.set(rect.left - 26, rect.top+32, rect.left, rect.top+52);
        rect4.set(rect.left + 68, rect.top+32, rect.left+94, rect.top+52);
        yellowRed.set(centerX - 110, centerY - 110, centerX + 70, centerY + 70);
        footleft.set(centerX - 50, centerY + 20, centerX, centerY + 35);
        footright.set(centerX, centerY + 20, centerX+50, centerY+35);
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

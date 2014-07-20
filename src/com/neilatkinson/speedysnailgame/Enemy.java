package com.neilatkinson.speedysnailgame;

import com.neilatkinson.gameobject.Animation;
import com.neilatkinson.gameobject.Damageable;
import com.neilatkinson.gameobject.GameObject;

import android.graphics.Rect;

public class Enemy extends GameObject {

	private Background bg = GameScreen.getBg1();
	protected PlayerCharacter playerCharacter;

	public Enemy(
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
		playerCharacter = gameScreen.getPlayerCharacter();
		setRegion();
	}

	public void update() {
        follow();
        setRegion();
        resolveCollisions();
    }

	public void setRegion() {
		region.set(centerX - 25, centerY - 25, centerX + 25, centerY + 35);
	}

	@Override
	public void resolveCollisions() {
		if (Rect.intersects(region, playerCharacter.yellowRed)) {
			if (Rect.intersects(region, playerCharacter.rect)
				|| Rect.intersects(region, playerCharacter.rect2)
	            || Rect.intersects(region, playerCharacter.rect3)
	            || Rect.intersects(region, playerCharacter.rect4)) {
			}
        }
	}

	private void follow() {
		int xDistanceToPlayer = playerCharacter.getCenterX() - centerX;
		int yDistanceToPlayer = playerCharacter.getCenterY() - centerY;
		
		if (Math.abs(xDistanceToPlayer) >= Math.abs(yDistanceToPlayer)) {
			// Move in the x direction
			if (xDistanceToPlayer > 0) {
				setMovingRight();
			} else if (xDistanceToPlayer < 0) {
				setMovingLeft();
			} else {
				stop();
			}
		} else {
			// Move in the y direction
			if (yDistanceToPlayer > 0) {
				setMovingDown();
			} else if (yDistanceToPlayer < 0){
				setMovingUp();
			} else {
				stop();
			}
		}
		move();
	}

	@Override
	public void attack(Damageable damageable) {
		// TODO Auto-generated method stub
	}

}

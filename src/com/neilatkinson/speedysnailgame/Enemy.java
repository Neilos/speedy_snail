package com.neilatkinson.speedysnailgame;

import com.neilatkinson.gameobject.Damageable;
import com.neilatkinson.gameobject.GameObject;

public abstract class Enemy extends GameObject {

	protected PlayerCharacter playerCharacter;

	public Enemy(
			GameScreen gameScreen,
			int moveSpeed, 
			int startingCenterX, 
			int startingCenterY,
			int startingHealth) {

		super(gameScreen,
			moveSpeed,
			startingCenterX, startingCenterY,
			startingHealth);
		playerCharacter = gameScreen.getPlayerCharacter();
		setRegion();
	}

	public void update() {
        follow();
        setRegion();
    }

	public void setRegion() {
		region.set(centerX - 25, centerY - 25, centerX + 25, centerY + 35);
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
		move();
	}

	@Override
	public void attack(Damageable damageable) {
		// TODO Auto-generated method stub
	}

}

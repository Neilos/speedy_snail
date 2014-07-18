package com.neilatkinson.speedysnailgame;

import com.neilatkinson.gameobject.Damageable;
import com.neilatkinson.gameobject.DestroyableObject;

import android.graphics.Rect;

public class Enemy extends DestroyableObject {

	private Background bg = GameScreen.getBg1();
	protected PlayerCharacter playerCharacter;

	public Enemy(
			GameScreen gameScreen,
			int moveSpeed, 
			int startingCenterX, 
			int startingCenterY,
			int startingHealth) {
		super(moveSpeed, startingCenterX, startingCenterY, startingHealth);
		playerCharacter = gameScreen.getPlayerCharacter();
		setRegion();
	}

	public void update() {
        follow();
        centerX += speedX;
        speedX = bg.getSpeedX() * 5 + moveSpeed;
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
		if (centerX < -95 || centerX > 810){
            moveSpeed = 0;
        }
        else if (Math.abs(playerCharacter.getCenterX() - centerX) < 5) {
            moveSpeed = 0;
        }
        else {
            if (playerCharacter.getCenterX() >= centerX) {
                moveSpeed = 1;
            } else {
                moveSpeed = -1;
            }
        }
	}

	@Override
	public void attack(Damageable damageable) {
		// TODO Auto-generated method stub
	}

}

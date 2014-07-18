package com.neilatkinson.speedysnailgame;

import android.graphics.Rect;

public class Enemy {
	
	private int centerX, speedX, centerY;
	private Background bg = GameScreen.getBg1();
	protected PlayerCharacter robot;
	
	public Rect r = new Rect(0, 0, 0, 0);
	public int health = 5;
	
	private int movementSpeed;

	public Enemy(GameScreen gameScreen) {
		robot = gameScreen.getPlayerCharacter();
	}

	public void update() {
        follow();
        centerX += speedX;
        speedX = bg.getSpeedX() * 5 + movementSpeed;
        r.set(centerX - 25, centerY - 25, centerX + 25, centerY + 35);

        if (Rect.intersects(r, PlayerCharacter.yellowRed)) {
            checkCollision();
        }
    }

	private void checkCollision() {
		if (Rect.intersects(r, PlayerCharacter.rect)
			|| Rect.intersects(r, PlayerCharacter.rect2)
            || Rect.intersects(r, PlayerCharacter.rect3)
            || Rect.intersects(r, PlayerCharacter.rect4)) {
			
        }
	}

	private void follow() {
		if (centerX < -95 || centerX > 810){
            movementSpeed = 0;
        }
        else if (Math.abs(robot.getCenterX() - centerX) < 5) {
            movementSpeed = 0;
        }
        else {
            if (robot.getCenterX() >= centerX) {
                movementSpeed = 1;
            } else {
                movementSpeed = -1;
            }
        }
	}
	
	public void die() {

    }

    public void attack() {

    }

    public int getSpeedX() {
        return speedX;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

}

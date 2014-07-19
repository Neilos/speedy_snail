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
    
    private Background bg1 = GameScreen.getBg1();
    private Background bg2 = GameScreen.getBg2();

    public PlayerCharacter(
    		GameScreen gameScreen,
    		int moveSpeed, 
    		int startingCenterX, 
    		int startingCenterY,
    		Animation moveUpAnimation,
    		Animation moveLeftAnimation,
    		Animation moveDownAnimation,
    		Animation moveRightAnimation) {

    	super(gameScreen, 
			moveSpeed,
			startingCenterX, startingCenterY, 
			moveUpAnimation, moveLeftAnimation, moveDownAnimation, moveRightAnimation);

        rect = new Rect(0, 0, 0, 0);
        rect2 = new Rect(0, 0, 0, 0);
        rect3 = new Rect(0, 0, 0, 0);
        rect4 = new Rect(0, 0, 0, 0);
        yellowRed = new Rect(0, 0, 0, 0);
        footleft = new Rect(0,0,0,0);
        footright = new Rect(0,0,0,0);

        setRegion();

        bg1 = GameScreen.getBg1();
        bg2 = GameScreen.getBg2();
    }

    public void update() {
        // Moves Character or Scrolls Background accordingly.

        if (speedX < 0) {
            centerX += speedX;
        }
        if (speedX == 0 || speedX < 0) {
            bg1.setSpeedX(0);
            bg2.setSpeedX(0);

        }
        if (centerX <= 200 && speedX > 0) {
            centerX += speedX;
        }
        if (speedX > 0 && centerX > 200) {
            bg1.setSpeedX(-moveSpeed / 5);
            bg2.setSpeedX(-moveSpeed / 5);
        }

        // Updates Y Position
        centerY += speedY;

        // Prevents going beyond X coordinate of 0
        if (centerX + speedX <= 60) {
            centerX = 61;
        }

        setRegion();
    }
    
    @Override
    public void moveRight() {
    	super.moveRight();
    	if (centerX > 200) {
	        bg1.setSpeedX(-moveSpeed / 5);
	        bg2.setSpeedX(-moveSpeed / 5);
    	}
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
	public void resolveCollisions() {
		// TODO Auto-generated method stub
		
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

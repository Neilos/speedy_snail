package com.neilatkinson.gameobject;

import android.graphics.Rect;

public abstract class GameObject implements Collidable, Updateable, AttackCapable, Damageable, Moveable {
	
	protected int centerX;
	protected int centerY;
	protected int moveSpeed;
	protected int speedX;
	protected int speedY;
	protected Rect region;

	public GameObject(
			int moveSpeed, 
			int startingCenterX, 
			int startingCenterY) {
		this.moveSpeed = moveSpeed;
		this.centerX = startingCenterX;
	    this.centerY = startingCenterY;
	    this.speedX = 0;
	    this.speedY = 0;
	    this.region = new Rect(0, 0, 0, 0);
	}
	
	public void setRegion() {
		region.set(centerX - 34, centerY - 63, centerX + 34, centerY);
	}

	@Override
	public void moveUp() {
		speedX = 0;
		speedY = -moveSpeed;
	}

	@Override
	public void moveLeft() {
		speedX = -moveSpeed;
		speedY = 0;
	}

	@Override
	public void moveDown() {
		speedX = 0;
		speedY = moveSpeed;
	}

	@Override
	public void moveRight() {
		speedX = moveSpeed;
		speedY = 0;
	}
	
	@Override
	public void stop() {
		speedX = 0;
		speedY = 0;
	}

	@Override
	public boolean isMovingUp() {
		return getSpeedY() < 0;
	}

	@Override
	public boolean isMovingLeft() {
		return getSpeedX() < 0;
	}

	@Override
	public boolean isMovingDown() {
		return getSpeedY() > 0;
	}

	@Override
	public boolean isMovingRight() {
		return getSpeedY() > 0;
	}

	@Override
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	@Override
	public int getSpeedX() {
		return speedX;
	}

	@Override
	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	@Override
	public int getSpeedY() {
		return speedY;
	}

	@Override
	public boolean collidedWith(GameObject otherObject) {
		return Rect.intersects(this.region, otherObject.region);
	}

	@Override
	public int getCenterX() {
		return centerX;
	}

	@Override
	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	@Override
	public int getCenterY() {
		return centerY;
	}

	@Override
	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

}

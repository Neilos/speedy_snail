package com.neilatkinson.gameobject;

import com.neilatkinson.framework.Image;
import com.neilatkinson.framework.Screen;
import com.neilatkinson.gameobject.Animation;

import android.graphics.Rect;

public abstract class GameObject implements Collidable, Updateable, AttackCapable, Damageable, Moveable {
	
	protected Screen gameScreen;
	protected int centerX;
	protected int centerY;
	protected int moveSpeed;
	protected int speedX;
	protected int speedY;
	protected Rect region;
	protected Animation currentAnimation;
	protected Animation moveUpAnimation;
	protected Animation moveLeftAnimation;
	protected Animation moveDownAnimation;
	protected Animation moveRightAnimation;
	protected int health;
	protected boolean isDestroyed;


	public GameObject(
			Screen gameScreen,
			int moveSpeed, 
			int startingCenterX, 
			int startingCenterY,
			Animation moveUpAnimation,
			Animation moveLeftAnimation,
			Animation moveDownAnimation,
			Animation moveRightAnimation,
			int startingHealth) {

		this(gameScreen,
			moveSpeed,
			startingCenterX, startingCenterY,
			moveUpAnimation, moveLeftAnimation, moveDownAnimation, moveRightAnimation);

		this.health = startingHealth;
	}
	

	public GameObject(
			Screen gameScreen,
			int moveSpeed, 
			int startingCenterX, 
			int startingCenterY,
			Animation moveUpAnimation,
			Animation moveLeftAnimation,
			Animation moveDownAnimation,
			Animation moveRightAnimation) {

		this.gameScreen = gameScreen;
		this.moveSpeed = moveSpeed;
		this.centerX = startingCenterX;
	    this.centerY = startingCenterY;
	    this.speedX = 0;
	    this.speedY = 0;
	    this.region = new Rect(0, 0, 0, 0);
	    this.moveUpAnimation = moveUpAnimation;
		this.moveLeftAnimation = moveLeftAnimation;
		this.moveDownAnimation = moveDownAnimation;
		this.moveRightAnimation = moveRightAnimation;
		this.currentAnimation = moveRightAnimation;

		this.isDestroyed = false;
	}

	public void setRegion() {
		region.set(centerX - 34, centerY - 63, centerX + 34, centerY);
	}

	public void update() {

	}

	@Override
	public void moveUp() {
		speedX = 0;
		speedY = -moveSpeed;
		currentAnimation = moveUpAnimation;
	}

	@Override
	public void moveLeft() {
		speedX = -moveSpeed;
		speedY = 0;
		currentAnimation = moveLeftAnimation;
	}

	@Override
	public void moveDown() {
		speedX = 0;
		speedY = moveSpeed;
		currentAnimation = moveDownAnimation;
	}

	@Override
	public void moveRight() {
		speedX = moveSpeed;
		speedY = 0;
		currentAnimation = moveRightAnimation;
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

	public Image getImage() {
		return currentAnimation.getImage();
	}

	@Override
	public void animate(long elapsedTime) {
		currentAnimation.update(elapsedTime);
	}
	
	@Override
	public void takeDamage(int damage) {
		this.health -= damage;
		if (health <= 0)
			die();
	}

	@Override
	public void heal(int damage) {
		this.health += damage;
	}

	@Override
	public void die() {
		this.isDestroyed = true;
	}


}

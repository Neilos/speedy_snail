package com.neilatkinson.gameobject;

import com.neilatkinson.framework.Image;
import com.neilatkinson.framework.Screen;
import com.neilatkinson.gameobject.Animation;
import com.neilatkinson.speedysnailgame.Background;
import com.neilatkinson.speedysnailgame.GameScreen;

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
	private boolean isMovingUp;
	private boolean isMovingLeft;
	private boolean isMovingDown;
	private boolean isMovingRight;
	protected Background bg;


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
		
		this.bg = GameScreen.getBg1();
		this.isDestroyed = false;
	}

	public void setRegion() {
		region.set(centerX - 34, centerY - 63, centerX + 34, centerY);
	}
	
	@Override
	public void move() {
		if (isMovingUp()) {
	        speedX = bg.getSpeedX();
		    speedY = bg.getSpeedY() - moveSpeed;
    	} else if (isMovingLeft()) {
    		speedX = bg.getSpeedX() - moveSpeed;
		    speedY = bg.getSpeedY();
    	} else if (isMovingDown()) {
    		speedX = bg.getSpeedX();
		    speedY = bg.getSpeedY() + moveSpeed;
    	} else if (isMovingRight()) {
    		speedX = bg.getSpeedX() + moveSpeed;
		    speedY = bg.getSpeedY();
    	} else {
    		speedX = bg.getSpeedX();
    		speedY = bg.getSpeedY();
    	}
		
		// Update X Position
        centerX += speedX;

        // Update Y Position
        centerY += speedY;

        setRegion();
	}


	@Override
	public void setMovingUp() {
		isMovingUp = true;
		isMovingLeft = false;
		isMovingDown = false;
		isMovingRight = false;
		currentAnimation = moveUpAnimation;
	}

	@Override
	public void setMovingLeft() {
		isMovingUp = false;
		isMovingLeft = true;
		isMovingDown = false;
		isMovingRight = false;
		currentAnimation = moveLeftAnimation;
	}

	@Override
	public void setMovingDown() {
		isMovingUp = false;
		isMovingLeft = false;
		isMovingDown = true;
		isMovingRight = false;
		currentAnimation = moveDownAnimation;
	}

	@Override
	public void setMovingRight() {
		isMovingUp = false;
		isMovingLeft = false;
		isMovingDown = false;
		isMovingRight = true;
		currentAnimation = moveRightAnimation;
	}
	
	@Override
	public void stop() {
		isMovingUp = false;
		isMovingLeft = false;
		isMovingDown = false;
		isMovingRight = false;
	}

	@Override
	public boolean isMovingUp() {
		return isMovingUp;
	}

	@Override
	public boolean isMovingLeft() {
		return isMovingLeft;
	}

	@Override
	public boolean isMovingDown() {
		return isMovingDown;
	}

	@Override
	public boolean isMovingRight() {
		return isMovingRight;
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

	@Override
	public boolean nearTopOfScreen() {
		return centerY <= 100;
	}

	@Override
	public boolean nearLeftOfScreen() {
		return centerX <= 200;
	}

	@Override
	public boolean nearBottomOfScreen() {
		return centerY >= gameScreen.getHeight() - 100;
	}

	@Override
	public boolean nearRightOfScreen() {
		return centerX >= gameScreen.getWidth() - 200;
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

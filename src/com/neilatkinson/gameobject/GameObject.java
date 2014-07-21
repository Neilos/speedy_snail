package com.neilatkinson.gameobject;

import java.util.ArrayList;

import com.neilatkinson.framework.Image;
import com.neilatkinson.framework.Screen;
import com.neilatkinson.gameobject.Animation;
import android.graphics.Rect;

public abstract class GameObject implements Collidable, Updateable, AttackCapable, Damageable, Moveable {
	
	protected Screen gameScreen;
	protected int centerX;
	protected int centerY;
	protected final int moveSpeed;
	protected int speedX;
	protected int speedY;
	protected Rect region;

	protected Animation currentAnimation;
	protected Animation moveUpAnimation;
	protected Animation moveLeftAnimation;
	protected Animation moveDownAnimation;
	protected Animation moveRightAnimation;
	protected Animation stationaryFacingUpAnimation;
	protected Animation stationaryFacingLeftAnimation;
	protected Animation stationaryFacingDownAnimation;
	protected Animation stationaryFacingRightAnimation;

	private int health;
	private boolean isDead;
	private boolean isMovingUp;
	private boolean isMovingLeft;
	private boolean isMovingDown;
	private boolean isMovingRight;

	public GameObject(
			Screen gameScreen,
			int moveSpeed, 
			int startingCenterX, 
			int startingCenterY,
			int startingHealth) {

		this(gameScreen, moveSpeed, startingCenterX, startingCenterY);
		this.health = startingHealth;
	}

	public GameObject(
			Screen gameScreen,
			int moveSpeed, 
			int startingCenterX, 
			int startingCenterY) {

		this.gameScreen = gameScreen;
		this.moveSpeed = moveSpeed;
		this.centerX = startingCenterX;
	    this.centerY = startingCenterY;
	    this.speedX = 0;
	    this.speedY = 0;
	    this.region = new Rect(0, 0, 0, 0);

		this.isDead = false;

		setUpAnimations();

	}

	public abstract void setUpAnimations();

	public void setRegion() {
		region.set(centerX - 34, centerY - 63, centerX + 34, centerY);
	}
	
	@Override
	public void move() {
		if (isMovingUp()) {
	        moveUp();
		} else if (isMovingLeft()) {
    		moveLeft();
		} else if (isMovingDown()) {
    		moveDown();
    	} else if (isMovingRight()) {
    		moveRight();
    	} else {
    		remainStationary();
    	}

		// Update Position
        centerX += getSpeedX();
        centerY += getSpeedY();

        setRegion();
	}


	public void moveUp() {
		setSpeedX(gameScreen.getBackgroundSpeedX());
		setSpeedY(-moveSpeed + gameScreen.getBackgroundSpeedY());
	}

	public void moveLeft() {
		setSpeedX(-moveSpeed + gameScreen.getBackgroundSpeedX());
		setSpeedY(gameScreen.getBackgroundSpeedY());
	}

	public void moveDown() {
		setSpeedX(gameScreen.getBackgroundSpeedX());
		setSpeedY(moveSpeed + gameScreen.getBackgroundSpeedY());
	}

	public void moveRight() {
		setSpeedX(moveSpeed + gameScreen.getBackgroundSpeedX());
		setSpeedY(gameScreen.getBackgroundSpeedY());
	}

	public void remainStationary() {
		setSpeedX(gameScreen.getBackgroundSpeedX());
		setSpeedY(gameScreen.getBackgroundSpeedY());
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
	public void setStopped() {
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
	public void animate(int elapsedTime) {
		currentAnimation.update(elapsedTime);
	}
	
	@Override
	public void takeDamage(int damage) {
		if (!isDead()) {
			this.health -= damage;
			if (health <= 0)
				die();
		}
	}

	@Override
	public void heal(int damage) {
		if (!isDead()){
			this.health += damage;
		}
	}

	@Override
	public void die() {
		this.isDead = true;
	}
	
	public boolean isDead() {
		return isDead;
	}
	
	public boolean inVicinityOf(GameObject otherObject) {
		return Rect.intersects(otherObject.currentAnimation.getVicinity(), currentAnimation.getVicinity());
	}

	
	public ArrayList<Rect> collisionZones() {
		return currentAnimation.getCollisionZones();
	}
	
	public ArrayList<Rect> attackZones() {
		return currentAnimation.getAttackZones();
	}
	
	public ArrayList<Rect> damageZones() {
		return currentAnimation.getDamageZones();
	}

	
	@Override
	public void resolveCollisions(ArrayList<Rect> collisions) {
		int numberOfCollisions = collisions.size();
		for (int i = 0; i < numberOfCollisions; i++) {
			Rect collision = collisions.get(i);
			int xIntrusion = collision.width() / 2;
			int yIntrusion = collision.height() / 2;

			if (collision.centerX() > centerX) {
				centerX -= xIntrusion;
			} else {
				centerX += xIntrusion;
			}

			if (collision.centerY() > centerY) {
				centerY -= yIntrusion;
			} else {
				centerY += yIntrusion;
			}
		}
	}

}

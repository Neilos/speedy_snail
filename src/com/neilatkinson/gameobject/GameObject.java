package com.neilatkinson.gameobject;

import java.util.ArrayList;

import com.neilatkinson.framework.Image;
import com.neilatkinson.framework.Screen;
import com.neilatkinson.gameobject.Animation;

import android.graphics.Rect;

public abstract class GameObject implements Collidable, Updateable, AttackCapable, Damageable, Moveable {
	
	protected Screen gameScreen;
	private int centerX;
	private int centerY;
	protected final int moveSpeed;
	protected int speedX;
	protected int speedY;
	protected Rect vicinity;

	private Animation currentAnimation;
	private Animation moveUpAnimation;
	private Animation moveLeftAnimation;
	private Animation moveDownAnimation;
	private Animation moveRightAnimation;
	private Animation faceUpAnimation;
	private Animation faceLeftAnimation;
	private Animation faceDownAnimation;
	private Animation faceRightAnimation;

	private int health;
	private boolean isDead;
	private boolean isMovingUp;
	private boolean isMovingLeft;
	private boolean isMovingDown;
	private boolean isMovingRight;

	public GameObject(
			Screen gameScreen,
			int centerX,
			int centerY,
			final int moveSpeed,
			int speedX,
			int speedY,
			Rect vicinity,
			int health,
			boolean isDead,
			boolean isMovingUp,
			boolean isMovingLeft,
			boolean isMovingDown,
			boolean isMovingRight,
			Animation moveUpAnimation,
			Animation moveLeftAnimation,
			Animation moveDownAnimation,
			Animation moveRightAnimation,
			Animation faceUpAnimation,
			Animation faceLeftAnimation,
			Animation faceDownAnimation,
			Animation faceRightAnimation,
			Animation currentAnimation) {

		this.gameScreen = gameScreen;
		this.centerX = centerX;
		this.centerY = centerY;
		this.moveSpeed = moveSpeed;
		this.speedX = speedX;
		this.speedY = speedY;
		this.vicinity = vicinity;
		this.health = health;
		this.isDead = isDead;
		this.isMovingUp = isMovingUp;
		this.isMovingLeft = isMovingLeft;
		this.isMovingDown = isMovingDown;
		this.isMovingRight = isMovingRight;
		this.moveUpAnimation = moveUpAnimation;
		this.moveLeftAnimation = moveLeftAnimation;
		this.moveDownAnimation = moveDownAnimation;
		this.moveRightAnimation = moveRightAnimation;
		this.faceUpAnimation = faceUpAnimation;
		this.faceLeftAnimation = faceLeftAnimation;
		this.faceDownAnimation = faceDownAnimation;
		this.faceRightAnimation = faceRightAnimation;
		this.currentAnimation = currentAnimation;

	}
	
	public void updateZones(int zoneOffsetX, int zoneOffsetY) {
		vicinity().offset(zoneOffsetX, zoneOffsetY);
		updateCollisionZones(zoneOffsetX, zoneOffsetY);
		updateDamageZones(zoneOffsetX, zoneOffsetY);
		updateAttackZones(zoneOffsetX, zoneOffsetY);
	}

	public void updateAttackZones(int zoneOffsetX, int zoneOffsetY) {
		ArrayList<Rect> attackZones = attackZones();
		int numberOfAttackZones = attackZones.size();
		for (int a = 0; a < numberOfAttackZones; a++) {
			Rect attackZone = attackZones.get(a); 
			attackZone.offset(zoneOffsetX, zoneOffsetY);
		}
	}

	public void updateDamageZones(int zoneOffsetX, int zoneOffsetY) {
		ArrayList<Rect> damageZones = damageZones();
		int numberOfDamageZones = damageZones.size();
		for (int d = 0; d < numberOfDamageZones; d++) {
			Rect damageZone = damageZones.get(d);  
			damageZone.offset(zoneOffsetX, zoneOffsetY);
		}
	}

	public void updateCollisionZones(int zoneOffsetX, int zoneOffsetY) {
		ArrayList<Rect> collisionZones = collisionZones();
		int numberOfCollisionZones = collisionZones.size();
		for (int c = 0; c < numberOfCollisionZones; c++) {
			Rect collisionZone = collisionZones.get(c);
			collisionZone.offset(zoneOffsetX, zoneOffsetY);
		}
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
        updatePosition(centerX() + speedX(), centerY() + speedY());
	}


	@Override
	public void moveUp() {
		setSpeedX(gameScreen.getBackgroundSpeedX());
		setSpeedY(-moveSpeed + gameScreen.getBackgroundSpeedY());
	}

	@Override
	public void moveLeft() {
		setSpeedX(-moveSpeed + gameScreen.getBackgroundSpeedX());
		setSpeedY(gameScreen.getBackgroundSpeedY());
	}

	@Override
	public void moveDown() {
		setSpeedX(gameScreen.getBackgroundSpeedX());
		setSpeedY(moveSpeed + gameScreen.getBackgroundSpeedY());
	}

	@Override
	public void moveRight() {
		setSpeedX(moveSpeed + gameScreen.getBackgroundSpeedX());
		setSpeedY(gameScreen.getBackgroundSpeedY());
	}

	@Override
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
		if (isMovingUp()) {
			currentAnimation = faceUpAnimation;
			isMovingUp = false;
		} else if (isMovingLeft()) {
			currentAnimation = faceLeftAnimation;
			isMovingLeft = false;
		} else if (isMovingDown()) {
			currentAnimation = faceDownAnimation;
			isMovingDown = false;
		} else if (isMovingRight()) {
			currentAnimation = faceRightAnimation;
			isMovingRight = false;
		}
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
	public boolean isMoving() {
		return isMovingUp() || isMovingLeft() || isMovingDown() || isMovingRight();
	}


	@Override
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	@Override
	public int speedX() {
		return speedX;
	}

	@Override
	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	@Override
	public int speedY() {
		return speedY;
	}

	@Override
	public int currentSpeed() {
		return Math.max(speedX(), speedY());
	}


	@Override
	public int centerX() {
		return centerX;
	}

	@Override
	public int centerY() {
		return centerY;
	}

	@Override
	public void updatePosition(int newCenterX, int newCenterY) {
		int oldCenterX = centerX();
		int offsetX = newCenterX - oldCenterX;
		this.centerX = newCenterX;

		int oldCenterY = centerY();
		int offsetY = newCenterY - oldCenterY;
		this.centerY = newCenterY;

        updateZones(offsetX, offsetY);
	}


	@Override
	public boolean nearTopOfScreen() {
		return centerY() <= 100;
	}

	@Override
	public boolean nearLeftOfScreen() {
		return centerX() <= 200;
	}

	@Override
	public boolean nearBottomOfScreen() {
		return centerY() >= gameScreen.getHeight() - 100;
	}

	@Override
	public boolean nearRightOfScreen() {
		return centerX() >= gameScreen.getWidth() - 200;
	}


	public Image getImage() {
		return currentAnimation.getImage();
	}

	@Override
	public void animate(int elapsedTime) {
		currentAnimation.update(elapsedTime);
	}

	@Override
	public void attack(Damageable damageable) {
		// TODO Auto-generated method stub
		
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
	
	public Rect vicinity() {
		return vicinity;
	}

	
	public boolean inVicinityOf(GameObject otherObject) {
		return Rect.intersects(otherObject.vicinity(), vicinity());
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
			int offsetX;
			int offsetY;

			if (collision.centerX() > centerX()) {
				offsetX = centerX() - xIntrusion;
			} else {
				offsetX = centerX() + xIntrusion;
			}

			if (collision.centerY() > centerY()) {
				offsetY = centerY() - yIntrusion;
			} else {
				offsetY = centerY() + yIntrusion;
			}
			
			updatePosition(offsetX, offsetY);
		}
	}

}

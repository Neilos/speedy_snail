package com.neilatkinson.gameobject;

import java.util.ArrayList;

import com.neilatkinson.framework.Graphics;
import com.neilatkinson.framework.Image;
import com.neilatkinson.framework.Screen;
import com.neilatkinson.gameobject.Animation;

import android.graphics.Color;
import android.graphics.Rect;

public abstract class GameObject implements Collidable, Updateable, AttackCapable, Damageable, Moveable {
	
	protected Screen gameScreen;
	private int centerX;
	private int centerY;
	protected int speedX;
	protected int speedY;
	protected final int moveSpeed;
	protected int maxUpSpeed;
	protected int maxLeftSpeed;
	protected int maxDownSpeed;

	protected int maxRightSpeed;
	protected Rect area;

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
			Rect area,
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
		this.area = area;
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
		
		resetMaxSpeeds();
	}
	
	public void updateZones(int zoneOffsetX, int zoneOffsetY) {
		area().offset(zoneOffsetX, zoneOffsetY);
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
	public void update(int elapsedTime) {
		move(elapsedTime);
	}

	@Override
	public void move(int elapsedTime) {
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
		updatePosition(centerX() + speedX(), centerY() + speedY());
		animate(elapsedTime);
        resetMaxSpeeds();
	}


	@Override
	public void moveUp() {
		setSpeedX(gameScreen.getBackgroundSpeedX());
		setSpeedY(-maxUpSpeed() + gameScreen.getBackgroundSpeedY());
	}

	@Override
	public void moveLeft() {
		setSpeedX(-maxLeftSpeed() + gameScreen.getBackgroundSpeedX());
		setSpeedY(gameScreen.getBackgroundSpeedY());
	}

	@Override
	public void moveDown() {
		setSpeedX(gameScreen.getBackgroundSpeedX());
		setSpeedY(maxDownSpeed() + gameScreen.getBackgroundSpeedY());
	}

	@Override
	public void moveRight() {
		setSpeedX(maxRightSpeed() + gameScreen.getBackgroundSpeedX());
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

	public int maxUpSpeed() {
		return maxUpSpeed;
	}

	public int maxLeftSpeed() {
		return maxLeftSpeed;
	}

	public int maxDownSpeed() {
		return maxDownSpeed;
	}

	public int maxRightSpeed() {
		return maxRightSpeed;
	}

	public void updateMaxUpSpeed(int newMaxUpSpeed) {
		if (newMaxUpSpeed < maxUpSpeed) {
			this.maxUpSpeed = newMaxUpSpeed;
		}
	}

	public void updateMaxLeftSpeed(int newMaxLeftSpeed) {
		if (newMaxLeftSpeed < maxLeftSpeed) {
			this.maxLeftSpeed = newMaxLeftSpeed;
		}
	}
	
	public void updateMaxDownSpeed(int newMaxDownSpeed) {
		if (newMaxDownSpeed < maxDownSpeed) {
			this.maxDownSpeed = newMaxDownSpeed;
		}
	}
	
	public void updateMaxRightSpeed(int newMaxRightSpeed) {
		if (newMaxRightSpeed < maxRightSpeed) {
			this.maxRightSpeed = newMaxRightSpeed;
		}
	}
	private void resetMaxSpeeds() {
		this.maxUpSpeed = moveSpeed;
		this.maxLeftSpeed = moveSpeed;
		this.maxDownSpeed = moveSpeed;
		this.maxRightSpeed = moveSpeed;
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

	public void animate(int elapsedTime) {
		currentAnimation.update(elapsedTime);
	}

	@Override
	public void attack(Damageable damageable) {
		damageable.takeDamage(1);
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
	
	public Rect area() {
		return area;
	}
	
	public Rect vicinity() {
		return new Rect(area().left - moveSpeed - 1,
				area().top - moveSpeed - 1,
				area().right + moveSpeed + 1,
				area().bottom + moveSpeed + 1);
	}

	public boolean inVicinityOf(GameObject otherObject) {
		return Rect.intersects(otherObject.area(), vicinity());
	}

	
	public ArrayList<Rect> collisionZones() {
		return currentAnimation.getCollisionZones();
	}
	
	public ArrayList<Rect> getProjectedCollisionZones() {
        ArrayList<Rect> projectedCollisionZones = new ArrayList<Rect>();

        ArrayList<Rect> collisionZones = collisionZones();
        int collisionZonesCount = collisionZones().size();
        for (int i = 0; i < collisionZonesCount; i++) {
            Rect projectedCollisionZone = new Rect(collisionZones.get(i));
            if (isMovingUp()) {
                projectedCollisionZone.offset(0, -moveSpeed);
            } else if (isMovingLeft()) {
                projectedCollisionZone.offset(-moveSpeed, 0);
            } else if (isMovingDown()) {
                projectedCollisionZone.offset(0, moveSpeed);
            } else if (isMovingRight()) {
                projectedCollisionZone.offset(moveSpeed, 0);
            } else {
                
            }
            projectedCollisionZones.add(projectedCollisionZone);
        }
        
        return projectedCollisionZones;
    }
	
	public ArrayList<Rect> attackZones() {
		return currentAnimation.getAttackZones();
	}
	
	public ArrayList<Rect> damageZones() {
		return currentAnimation.getDamageZones();
	}

	
	public void drawSelf(Graphics graphics) {
		int left = centerX() - area().width() / 2;
		int top = centerY() - area().height() / 2;
		graphics.drawImage(getImage(), left, top);
		drawVicinity(graphics);
		drawCollisionZones(graphics);
//		drawAttackZones(graphics);
//		drawDamageZones(graphics);
	}

	private void drawDamageZones(Graphics graphics) {
		for(int i = 0; i < damageZones().size(); i++){
			Rect damageZone = damageZones().get(i);
			graphics.drawRect(  damageZone.left,
								damageZone.top,
								damageZone.width(),
								damageZone.height(),
								Color.argb(40, 0, 255, 0));
		}
	}

	private void drawAttackZones(Graphics graphics) {
		for(int i = 0; i < attackZones().size(); i++){
			Rect attackZone = attackZones().get(i);
			graphics.drawRect(  attackZone.left,
								attackZone.top,
								attackZone.width(),
								attackZone.height(),
								Color.argb(40, 0, 255, 0));
		}
	}

	private void drawCollisionZones(Graphics graphics) {
		for(int i = 0; i < collisionZones().size(); i++){
			Rect collisionZone = collisionZones().get(i);
			graphics.drawRect(  collisionZone.left,
								collisionZone.top,
								collisionZone.width(),
								collisionZone.height(),
								Color.argb(40, 0, 0, 255));
		}
	}

	private void drawVicinity(Graphics graphics) {
		graphics.drawRect( vicinity().left, vicinity().top, vicinity().width(), vicinity().height(), Color.argb(20, 100, 100, 100));
	}


	@Override
	public void evaluateCollisionWith(GameObject otherObject) {
		ArrayList<Rect> collisionIntrusionZones = getCollisionIntrusionZones(otherObject);
		if (collisionIntrusionZones.size() > 0) {
			Collision collision = new Collision(this, otherObject, collisionIntrusionZones);
			updateMaxSpeeds(collision);
		}
	}

	private ArrayList<Rect> getCollisionIntrusionZones(GameObject otherObject) {
		ArrayList<Rect> collisionIntrusionZones = new ArrayList<Rect>();
		ArrayList<Rect> otherObjectCollisionZones = otherObject.collisionZones();
		ArrayList<Rect> myProjectedCollisionZones = getProjectedCollisionZones();

		for (int i = 0; i < myProjectedCollisionZones.size(); i++) {
			for (int j = 0; j < otherObjectCollisionZones.size(); j++) {
				Rect myCollisionZone = myProjectedCollisionZones.get(i);
				Rect otherObjectCollisionZone = otherObjectCollisionZones.get(j);
				Rect collisionZone = new Rect(myCollisionZone);
				if (collisionZone.intersect(otherObjectCollisionZone)) {
					collisionIntrusionZones.add(collisionZone);
				}
			}
		}
		return collisionIntrusionZones;
	}

	public void updateMaxSpeeds(Collision collision) {
		if (isMovingUp()) {
			updateMaxUpSpeed(moveSpeed - collision.yDimension());
		} else if (isMovingLeft()) {
			updateMaxLeftSpeed(moveSpeed - collision.xDimension());
		} else if (isMovingDown()) {
			updateMaxDownSpeed(moveSpeed - collision.yDimension());
		} else if (isMovingRight()) {
			updateMaxRightSpeed(moveSpeed - collision.xDimension());
		}
	}

}

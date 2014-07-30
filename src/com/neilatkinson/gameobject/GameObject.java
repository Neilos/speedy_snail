package com.neilatkinson.gameobject;

import java.util.ArrayList;

import com.neilatkinson.framework.Graphics;
import com.neilatkinson.framework.Screen;
import com.neilatkinson.framework.implementation.AndroidGame;
import com.neilatkinson.gameobject.Animation;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.Log;

public abstract class GameObject implements Collidable, Updateable, AttackCapable, Damageable, Moveable {
	
	protected enum Attitude {
		Aggressive, Passive
	}
	
	private class ReturnToAggressiveAttitude extends AsyncTask<Long, Integer, Attitude> {
		@Override
	    protected Attitude doInBackground(Long... durations) {
			long duration = durations[0];
			try {
				Thread.sleep(duration);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return null;
			}
			return Attitude.Aggressive;
	    }
	
		@Override
	    protected void onProgressUpdate(Integer... progress) {
	    }
	
		@Override
	    protected void onPostExecute(Attitude newAttitude) {
			attitude = newAttitude;
	    }
	}
	
	private class Ouch {
		
		private Rect area;
		private int pain;

		public Ouch(Rect impact, int pain) {
			this.area = impact;
			this.pain = pain;
		}
		
		public void drawSelf(Graphics graphics) {
			Log.i("ouch", "That hurt");
			graphics.drawCircle(area.centerX(), area.centerY(), pain * 10, Color.argb(40, 255, 0, 0));
		}
	}

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
	protected Zone area;

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
	private int damage;
	private boolean isDead;
	private boolean isMovingUp;
	private boolean isMovingLeft;
	private boolean isMovingDown;
	private boolean isMovingRight;
	private ArrayList<Ouch> ouches;
	private Attitude attitude;

	protected Activity game;
	protected long passiveDuration;
	private ArrayList<Class<? extends GameObject>> damageableTypes;

	public GameObject(
			Screen gameScreen,
			int centerX,
			int centerY,
			final int moveSpeed,
			int speedX,
			int speedY,
			Zone area,
			int health,
			int damage,
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
			Animation currentAnimation,
			int passiveDuration,
			ArrayList<Class<? extends GameObject>> damageableTypes) {

		this.gameScreen = gameScreen;
		this.centerX = centerX;
		this.centerY = centerY;
		this.moveSpeed = moveSpeed;
		this.speedX = speedX;
		this.speedY = speedY;
		this.area = area;
		this.health = health;
		this.damage = damage;
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
		this.passiveDuration = passiveDuration;
		this.damageableTypes = damageableTypes;

		this.attitude = Attitude.Aggressive;
		game = ((AndroidGame) gameScreen.game);
		this.ouches = new ArrayList<Ouch>();
		resetMaxSpeeds();
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
		updatePosition(elapsedTime, centerX() + speedX(), centerY() + speedY());
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
		setCurrentAnimation(moveUpAnimation);
	}

	@Override
	public void setMovingLeft() {
		isMovingUp = false;
		isMovingLeft = true;
		isMovingDown = false;
		isMovingRight = false;
		setCurrentAnimation(moveLeftAnimation);
	}

	@Override
	public void setMovingDown() {
		isMovingUp = false;
		isMovingLeft = false;
		isMovingDown = true;
		isMovingRight = false;
		setCurrentAnimation(moveDownAnimation);
	}

	@Override
	public void setMovingRight() {
		isMovingUp = false;
		isMovingLeft = false;
		isMovingDown = false;
		isMovingRight = true;
		setCurrentAnimation(moveRightAnimation);
	}

	protected void setCurrentAnimation(Animation newAnimation) {
		currentAnimation = newAnimation;
	}

	@Override
	public void setStopped() {
		if (isMovingUp()) {
			setCurrentAnimation(faceUpAnimation);
			isMovingUp = false;
		} else if (isMovingLeft()) {
			setCurrentAnimation(faceLeftAnimation);
			isMovingLeft = false;
		} else if (isMovingDown()) {
			setCurrentAnimation(faceDownAnimation);
			isMovingDown = false;
		} else if (isMovingRight()) {
			setCurrentAnimation(faceRightAnimation);
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
			// prevent sudden jolts done by preventing negative speeds
			this.maxUpSpeed = Math.max(newMaxUpSpeed, 0);
		}
	}

	public void updateMaxLeftSpeed(int newMaxLeftSpeed) {
		if (newMaxLeftSpeed < maxLeftSpeed) {
			// prevent sudden jolts right by preventing negative speeds
			this.maxLeftSpeed = Math.max(newMaxLeftSpeed, 0);
		}
	}
	
	public void updateMaxDownSpeed(int newMaxDownSpeed) {
		if (newMaxDownSpeed < maxDownSpeed) {
			// prevent sudden jolts up by preventing negative speeds
			this.maxDownSpeed = Math.max(newMaxDownSpeed, 0);
		}
	}
	
	public void updateMaxRightSpeed(int newMaxRightSpeed) {
		if (newMaxRightSpeed < maxRightSpeed) {
			// prevent sudden jolts left by preventing negative speeds
			this.maxRightSpeed = Math.max(newMaxRightSpeed, 0);
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
	public void updatePosition(int elapsedTime, int newCenterX, int newCenterY) {
		this.centerX = newCenterX;
		this.centerY = newCenterY;
		area().offsetTo(newCenterX, newCenterY);
		currentAnimation.update(elapsedTime, newCenterX, newCenterY);
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

	public void animate(int elapsedTime) {
		
	}


	@Override
	public boolean canAttack(Damageable damageable) {
		return (attitude == Attitude.Aggressive & canDamage(damageable));
	}
	
	protected boolean canDamage(Damageable damageable) {
		for (Class<? extends GameObject> klass : damageableTypes) {
			if (klass.isInstance(damageable)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Rect getImpact(Damageable damageable) {
		for (Zone attackZone : attackZones()) {
			for (Zone damageZone : damageable.damageZones()) {
				if (Rect.intersects(attackZone.rect(), damageZone.rect())) {
					Rect intersection = new Rect(attackZone.rect());
					intersection.intersect(damageZone.rect());
					return intersection;
				}
			}
		}
		return new Rect();
	}

	@Override
	public void attack(Damageable damageable, Rect impact) {
		damageable.takeDamage(damage, impact);
		this.attitude = Attitude.Passive;
		Log.i("Damage", this + " attacking " + damageable);
		new ReturnToAggressiveAttitude().execute(passiveDuration);
	}

	@Override
	public void takeDamage(int damage, Rect impact) {
		if (!isDead()) {
			this.health -= damage;
			this.ouches.add(new Ouch(impact, damage));
			if (health() <= 0)
				die();
		}
	}
	

	protected ArrayList<Ouch> ouches() {
		return ouches;
	}

	public int health() {
		return health;
	}

	@Override
	public void die() {
		this.isDead = true;
	}
	
	public boolean isDead() {
		return isDead;
	}
	
	public Zone area() {
		return area;
	}
	
	public Rect vicinity() {
		return new Rect(area().left() - moveSpeed - 1,
				area().top() - moveSpeed - 1,
				area().right() + moveSpeed + 1,
				area().bottom() + moveSpeed + 1);
	}

	public boolean inVicinityOf(GameObject otherObject) {
		return Rect.intersects(otherObject.area().rect(), vicinity());
	}


	public ArrayList<Zone> collisionZones() {
		return currentAnimation.getCollisionZones();
	}

	public ArrayList<Zone> getProjectedCollisionZones() {
        ArrayList<Zone> projectedCollisionZones = new ArrayList<Zone>();

        for (Zone zone : collisionZones()) {
            Zone projectedCollisionZone = zone.deepClone();
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
	
	public ArrayList<Zone> attackZones() {
		return currentAnimation.getAttackZones();
	}
	
	public ArrayList<Zone> damageZones() {
		return currentAnimation.getDamageZones();
	}


	public void drawSelf(Graphics graphics) {
		int left = centerX() - area().width() / 2;
		int top = centerY() - area().height() / 2;
		currentAnimation.drawImage(graphics, left, top);
		drawAttackImpacts(graphics);
//		drawVicinity(graphics);
//		drawCollisionZones(graphics);
//		drawDamageZones(graphics);
//		drawAttackZones(graphics);
	}
	
	private void drawAttackImpacts(Graphics graphics) {
		if (!ouches().isEmpty()) {
			for (Ouch ouch : ouches()) {
				ouch.drawSelf(graphics);
			}
			ouches().clear();
		}
	}

	private void drawDamageZones(Graphics graphics) {
		for(int i = 0; i < damageZones().size(); i++){
			Zone damageZone = damageZones().get(i);
			graphics.drawRect(  damageZone.left(),
								damageZone.top(),
								damageZone.width(),
								damageZone.height(),
								Color.argb(40, 255, 0, 0));
		}
	}

	private void drawAttackZones(Graphics graphics) {
		for(int i = 0; i < attackZones().size(); i++){
			Zone attackZone = attackZones().get(i);
			graphics.drawRect(  attackZone.left(),
								attackZone.top(),
								attackZone.width(),
								attackZone.height(),
								Color.argb(40, 0, 255, 0));
		}
	}

	private void drawCollisionZones(Graphics graphics) {
		for(int i = 0; i < collisionZones().size(); i++){
			Zone collisionZone = collisionZones().get(i);
			graphics.drawRect(  collisionZone.left(),
								collisionZone.top(),
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
		ArrayList<Zone> collisionIntrusionZones = getCollisionIntrusionZones(otherObject);
		if (collisionIntrusionZones.size() > 0) {
			Collision collision = new Collision(this, otherObject, collisionIntrusionZones);
			updateMaxSpeeds(collision);
		}
	}

	private ArrayList<Zone> getCollisionIntrusionZones(GameObject otherObject) {
		ArrayList<Zone> collisionIntrusionZones = new ArrayList<Zone>();
		ArrayList<Zone> otherObjectCollisionZones = otherObject.collisionZones();
		ArrayList<Zone> myProjectedCollisionZones = getProjectedCollisionZones();

		for (Zone myCollisionZone : myProjectedCollisionZones) {
			for (Zone otherObjectCollisionZone : otherObjectCollisionZones) {
				Zone collisionZone = myCollisionZone.deepClone();
				if (collisionZone.rect().intersect(otherObjectCollisionZone.rect())) {
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

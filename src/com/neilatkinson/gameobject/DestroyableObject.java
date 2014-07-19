package com.neilatkinson.gameobject;

import com.neilatkinson.speedysnailgame.GameScreen;

// An object of this type can be destroyed
public abstract class DestroyableObject extends GameObject {

	protected int health;
	protected boolean isDestroyed;

	public DestroyableObject(
			GameScreen gameScreen,
			int moveSpeed, 
			int startingCenterX, 
			int startingCenterY,
			int startingHealth) {
		super(gameScreen, moveSpeed, startingCenterX, startingCenterY);
		this.health = startingHealth;
		this.isDestroyed = false;
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

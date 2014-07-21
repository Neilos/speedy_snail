package com.neilatkinson.gameobject;

public interface Damageable {

	public void takeDamage(int damage);
	public void heal(int damage);
	public void die();
	public boolean isDead();

}

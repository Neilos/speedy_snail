package com.neilatkinson.gameobject;

public interface Damageable extends Interactable {

	public void takeDamage(int damage);
	public void heal(int damage);
	public void die();
	public boolean isDead();

}

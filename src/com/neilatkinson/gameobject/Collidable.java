package com.neilatkinson.gameobject;

public interface Collidable {

	public void resolveCollisions();
	boolean collidedWith(GameObject gameObject);
	void setRegion();

}

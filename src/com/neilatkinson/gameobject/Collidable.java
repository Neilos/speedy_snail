package com.neilatkinson.gameobject;

public interface Collidable extends Interactable  {

	public Collision evaluateCollisionWith(GameObject otherObject);

}

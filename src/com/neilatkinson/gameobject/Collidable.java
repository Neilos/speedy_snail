package com.neilatkinson.gameobject;

public interface Collidable extends Interactable  {

	public void evaluateCollisionWith(GameObject otherObject);

}

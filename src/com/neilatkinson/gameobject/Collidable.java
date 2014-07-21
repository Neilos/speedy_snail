package com.neilatkinson.gameobject;

import java.util.ArrayList;

import android.graphics.Rect;

public interface Collidable extends Interactable  {

	public void resolveCollisions(ArrayList<Rect> collisions);
	void setRegion();

}

package com.neilatkinson.gameobject;

import java.util.ArrayList;

import android.graphics.Rect;

public class Collision {
	private GameObject collidingObject;
	private GameObject otherObject;
	private int xDimension;
	private int yDimension;
	private ArrayList<Rect> collisionIntrusionZones;
	
	public Collision(GameObject object, GameObject otherObject, ArrayList<Rect> collisionIntrusionZones){
		this.collidingObject = object;
		this.otherObject = otherObject;
		setCollisionIntrusionZones(collisionIntrusionZones);
	}

	public int yDimension() {
		return yDimension;
	}

	public int xDimension() {
		return xDimension;
	}

	public void setCollisionIntrusionZones(ArrayList<Rect> collisionIntrusionZones) {
		this.collisionIntrusionZones = collisionIntrusionZones;
		calculateXYDimension();
	}

	public boolean didHappen() {
		return yDimension() > 0 && xDimension() > 0;
	}
	
	private void calculateXYDimension() {
		xDimension = 0;
		yDimension = 0;
		
		int zoneCount = collisionIntrusionZones.size();
		for (int i = 0; i < zoneCount; i++) {
			Rect zone = collisionIntrusionZones.get(i);
			if (zone.width() > xDimension) {
				xDimension = zone.width();
			}
			if (zone.height() > yDimension) {
				yDimension = zone.height();
			}
		}
	}

	public GameObject getCollidingObject() {
		return collidingObject;
	}

	public GameObject getOtherObject() {
		return otherObject;
	}
}

package com.neilatkinson.gameobject;

import java.util.Comparator;

public class SortByGameObjectSpeed implements Comparator<GameObject> {

	@Override
	public int compare(GameObject object1, GameObject object2) {
		return object2.currentSpeed() - object1.currentSpeed();
	}
}

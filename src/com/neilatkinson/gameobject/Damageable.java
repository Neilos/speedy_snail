package com.neilatkinson.gameobject;

import java.util.ArrayList;

import android.graphics.Rect;

public interface Damageable extends Interactable {

	public void die();
	public boolean isDead();
	public ArrayList<Zone> damageZones();
	public ArrayList<Zone> attackZones();
	public void takeDamage(int damage, Rect impact);

}

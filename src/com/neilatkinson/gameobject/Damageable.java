package com.neilatkinson.gameobject;

import java.util.ArrayList;

import android.graphics.Rect;

public interface Damageable extends Interactable {

	public void die();
	public boolean isDead();
	public ArrayList<Rect> damageZones();
	public ArrayList<Rect> attackZones();
	public void takeDamage(int damage, Rect damageZone);

}

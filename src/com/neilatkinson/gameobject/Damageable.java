package com.neilatkinson.gameobject;

import java.util.ArrayList;

import android.graphics.Rect;

public interface Damageable extends Interactable {

	public void takeDamage(int damage);
	public void heal(int damage);
	public void die();
	public boolean isDead();
	public ArrayList<Rect> damageZones();
	public ArrayList<Rect> attackZones();

}

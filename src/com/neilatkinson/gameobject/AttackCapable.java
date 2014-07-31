package com.neilatkinson.gameobject;

import android.graphics.Rect;

public interface AttackCapable {

	public boolean canAttack(Damageable damageable);
	public Rect getImpact(Damageable damageable);
	public void attack(Damageable damageable, Rect attackZone);
	
}

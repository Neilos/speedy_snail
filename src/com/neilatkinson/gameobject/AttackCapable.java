package com.neilatkinson.gameobject;

public interface AttackCapable {

	public boolean canAttack(Damageable damageable);
	public boolean inRangeOf(Damageable damageable);
	public void attack(Damageable damageable);

}

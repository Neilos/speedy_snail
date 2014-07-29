package com.neilatkinson.gameobject;

public interface AttackCapable {

	public boolean canAttack(Damageable damageable);
	public void tryAttacking(Damageable damageable);

}

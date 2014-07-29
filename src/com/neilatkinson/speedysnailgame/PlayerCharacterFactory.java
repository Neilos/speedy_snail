package com.neilatkinson.speedysnailgame;

import java.util.ArrayList;

import android.graphics.Rect;

import com.neilatkinson.framework.Image;
import com.neilatkinson.gameobject.Animation;
import com.neilatkinson.gameobject.GameObject;

public class PlayerCharacterFactory {

	public static PlayerCharacter build(GameScreen gameScreen, int centerX, int centerY) {
		int moveSpeed = 5;
		int speedX = 0;
		int speedY = 0;
		int health = 5;
		int damage = 1;
		boolean isDead = false;
		boolean isMovingUp = false;
		boolean isMovingLeft = false;
		boolean isMovingDown = false;
		boolean isMovingRight = false;
		Rect vicinity;
		int passiveDuration = 1000;

		ArrayList<Class<? extends GameObject>> damageableTypes = new ArrayList<Class<? extends GameObject>>();

		Animation moveUpAnimation = new Animation();
		Animation moveLeftAnimation = new Animation();
		Animation moveDownAnimation = new Animation();
		Animation moveRightAnimation = new Animation();

		Animation faceUpAnimation = new Animation();
		Animation faceLeftAnimation = new Animation();
		Animation faceDownAnimation = new Animation();
		Animation faceRightAnimation = new Animation();

		Image frameImage;
		int duration;
		ArrayList<Rect> collisionZones = new ArrayList<Rect>();
		ArrayList<Rect> damageZones = new ArrayList<Rect>();
	    ArrayList<Rect> attackZones = new ArrayList<Rect>();

	    vicinity = new Rect(centerX - 61, centerY - 63, centerX + 61, centerY + 63);

	    Rect rect = new Rect(centerX - 34, centerY - 63, centerX + 34, centerY);
	    Rect rect2 = new Rect(rect.left, rect.top + 63, rect.left + 68, rect.top + 128);
	    Rect rect3 = new Rect(rect.left - 26, rect.top + 32, rect.left, rect.top + 52);
	    Rect rect4 = new Rect(rect.left + 68, rect.top + 32, rect.left + 94, rect.top + 52);
	    Rect footleft = new Rect(centerX - 50, rect2.bottom - 15, centerX, rect2.bottom);
	    Rect footright = new Rect(centerX, rect2.bottom - 15, centerX + 50, rect2.bottom);

		collisionZones.add(new Rect(rect));
		collisionZones.add(new Rect(rect2));
		collisionZones.add(new Rect(rect3));
		collisionZones.add(new Rect(rect4));
		collisionZones.add(new Rect(footleft));
		collisionZones.add(new Rect(footright));
		
		Rect damageAttackRect = new Rect(rect.left - 1, rect.top - 1, rect.right + 1, rect.bottom + 1);
		Rect damageAttackRect2 = new Rect(rect2.left - 1, rect2.top - 1, rect2.right + 1, rect2.bottom + 1);
		Rect damageAttackRect3 = new Rect(rect3.left - 1, rect3.top - 1, rect3.right + 1, rect3.bottom + 1);
		Rect damageAttackRect4 = new Rect(rect4.left - 1, rect4.top - 1, rect4.right + 1, rect4.bottom + 1);
		Rect damageAttackRectFootleft = new Rect(footleft.left - 1, footleft.top - 1, footleft.right + 1, footleft.bottom + 1);
		Rect damageAttackRectFootright = new Rect(footright.left - 1, footright.top - 1, footright.right + 1, footright.bottom + 1);

		damageZones.add(new Rect(damageAttackRect));
		damageZones.add(new Rect(damageAttackRect2));
		damageZones.add(new Rect(damageAttackRect3));
		damageZones.add(new Rect(damageAttackRect4));
		damageZones.add(new Rect(damageAttackRectFootleft));
		damageZones.add(new Rect(damageAttackRectFootright));

		attackZones.add(new Rect(damageAttackRect));
		attackZones.add(new Rect(damageAttackRect2));
		attackZones.add(new Rect(damageAttackRect3));
		attackZones.add(new Rect(damageAttackRect4));
		attackZones.add(new Rect(damageAttackRectFootleft));
		attackZones.add(new Rect(damageAttackRectFootright));

		// moveUpAnimation
	    frameImage = Assets.character;
		duration = 1250;
		moveUpAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.character2;
		duration = 50;
		moveUpAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.character3;
		duration = 50;
		moveUpAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.character2;
		duration = 1000;
		moveUpAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);


		// moveLeftAnimation
	    frameImage = Assets.character;
		duration = 1250;
	    moveLeftAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.character2;
		duration = 50;
	    moveLeftAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.character3;
		duration = 50;
	    moveLeftAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.character2;
		duration = 1000;
	    moveLeftAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);


		// moveDownAnimation

	    frameImage = Assets.character;
		duration = 1250;
		moveDownAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.character2;
		duration = 50;
		moveDownAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.character3;
		duration = 50;
		moveDownAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.character2;
		duration = 50;
		moveDownAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

	    
		// moveRightAnimation

		frameImage = Assets.character;
		duration = 1250;
	    moveRightAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.character2;
		duration = 50;
	    moveRightAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.character3;
		duration = 50;
	    moveRightAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.character2;
		duration = 50;
	    moveRightAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

	    
		// faceUpAnimation

		frameImage = Assets.character;
		duration = 1250;
	    faceUpAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.character2;
		duration = 50;
	    faceUpAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.character3;
		duration = 50;
	    faceUpAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.character2;
		duration = 50;
	    faceUpAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);


		// faceLeftAnimation

		frameImage = Assets.character;
		duration = 1250;
	    faceLeftAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.character2;
		duration = 50;
	    faceLeftAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.character3;
		duration = 50;
	    faceLeftAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.character2;
		duration = 50;
	    faceLeftAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

	    
		// faceDownAnimation

		frameImage = Assets.character;
		duration = 1250;
	    faceDownAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.character2;
		duration = 50;
	    faceDownAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.character3;
		duration = 50;
	    faceDownAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.character2;
		duration = 50;
	    faceDownAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

	    
		// faceRightAnimation

		frameImage = Assets.character;
		duration = 1000;
	    faceRightAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.character2;
		duration = 1000;
	    faceRightAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.character3;
		duration = 1000;
	    faceRightAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.character2;
		duration = 1000;
	    faceRightAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

		Animation currentAnimation = faceRightAnimation;
		
		PlayerCharacter playerCharacter = 
				new PlayerCharacter(
						gameScreen,
						centerX,
						centerY,
						moveSpeed,
						speedX,
						speedY,
						vicinity,
						health,
						damage,
						isDead,
						isMovingUp,
						isMovingLeft,
						isMovingDown,
						isMovingRight,
						moveUpAnimation,
						moveLeftAnimation,
						moveDownAnimation,
						moveRightAnimation,
						faceUpAnimation,
						faceLeftAnimation,
						faceDownAnimation,
						faceRightAnimation,
						currentAnimation,
						passiveDuration,
						damageableTypes);

		return playerCharacter;
	}

}

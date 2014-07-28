package com.neilatkinson.speedysnailgame;

import java.util.ArrayList;

import android.graphics.Rect;

import com.neilatkinson.framework.Image;
import com.neilatkinson.gameobject.Animation;
import com.neilatkinson.gameobject.GameObject;

public class HeliboyFactory {
	
	public static Heliboy build(GameScreen gameScreen, int centerX, int centerY) {
		GameObject playerCharacter = gameScreen.getPlayerCharacter();
		int moveSpeed = 1;
		int speedX = 0;
		int speedY = 0;
		int health = 2;
		boolean isDead = false;
		boolean isMovingUp = false;
		boolean isMovingLeft = false;
		boolean isMovingDown = false;
		boolean isMovingRight = false;
		Rect vicinity;
		int passiveDuration = 5000;

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

	    vicinity = new Rect(centerX - 46, centerY - 48, centerX + 48, centerY + 48);
	    Rect rect = new Rect(vicinity.left + 11, vicinity.top + 6, vicinity.left + 73, vicinity.top + 86);

		collisionZones.add(new Rect(rect));
		damageZones.add(new Rect(rect.left - 1, rect.top -1, rect.right + 1, rect.bottom + 1));
	    attackZones.add(new Rect(rect.left - 1, rect.top -1, rect.right + 1, rect.bottom + 1));

		// moveUpAnimation
	    frameImage = Assets.heliboy;
		duration = 100;
		moveUpAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.heliboy2;
		duration = 100;
		moveUpAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.heliboy3;
		duration = 100;
		moveUpAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.heliboy4;
		duration = 100;
		moveUpAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
		
		frameImage = Assets.heliboy5;
		duration = 100;
		moveUpAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
		
		frameImage = Assets.heliboy4;
		duration = 100;
		moveUpAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
		
		frameImage = Assets.heliboy3;
		duration = 100;
		moveUpAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.heliboy2;
		duration = 100;
		moveUpAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
		
		
		// moveLeftAnimation
	    frameImage = Assets.heliboy;
		duration = 100;
		moveLeftAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.heliboy2;
		duration = 100;
		moveLeftAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.heliboy3;
		duration = 100;
		moveLeftAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.heliboy4;
		duration = 100;
		moveLeftAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
		
		frameImage = Assets.heliboy5;
		duration = 100;
		moveLeftAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
		
		frameImage = Assets.heliboy4;
		duration = 100;
		moveLeftAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
		
		frameImage = Assets.heliboy3;
		duration = 100;
		moveLeftAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.heliboy2;
		duration = 100;
		moveLeftAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
		
		
		// moveDownAnimation
	    frameImage = Assets.heliboy;
		duration = 100;
		moveDownAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.heliboy2;
		duration = 100;
		moveDownAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.heliboy3;
		duration = 100;
		moveDownAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.heliboy4;
		duration = 100;
		moveDownAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
		
		frameImage = Assets.heliboy5;
		duration = 100;
		moveDownAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
		
		frameImage = Assets.heliboy4;
		duration = 100;
		moveDownAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
		
		frameImage = Assets.heliboy3;
		duration = 100;
		moveDownAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.heliboy2;
		duration = 100;
		moveDownAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
		
		
		// moveRightAnimation
	    frameImage = Assets.heliboy;
		duration = 100;
		moveRightAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.heliboy2;
		duration = 100;
		moveRightAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.heliboy3;
		duration = 100;
		moveRightAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.heliboy4;
		duration = 100;
		moveRightAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
		
		frameImage = Assets.heliboy5;
		duration = 100;
		moveRightAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
		
		frameImage = Assets.heliboy4;
		duration = 100;
		moveRightAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
		
		frameImage = Assets.heliboy3;
		duration = 100;
		moveRightAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.heliboy2;
		duration = 100;
		moveRightAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);


		faceUpAnimation = moveUpAnimation;
		faceLeftAnimation = moveLeftAnimation;
		faceDownAnimation = moveDownAnimation;
		faceRightAnimation = moveRightAnimation;

		Animation currentAnimation = faceLeftAnimation;
		
		Heliboy heliboy = new Heliboy(
						gameScreen,
						playerCharacter,
						centerX,
						centerY,
						moveSpeed,
						speedX,
						speedY,
						vicinity,
						health,
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
						passiveDuration);

		return heliboy;
	}

}

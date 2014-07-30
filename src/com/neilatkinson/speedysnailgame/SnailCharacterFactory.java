package com.neilatkinson.speedysnailgame;

import java.util.ArrayList;

import android.graphics.Rect;

import com.neilatkinson.framework.Image;
import com.neilatkinson.gameobject.Animation;
import com.neilatkinson.gameobject.GameObject;

public class SnailCharacterFactory {

	public static SnailPlayerCharacter build(GameScreen gameScreen, int centerX, int centerY) {
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
		int passiveDuration = 0;

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
		
		Rect area = new Rect(centerX - 25, centerY - 25, centerX + 25, centerY + 25);
	    frameImage = Assets.snail;
		duration = 50;
		int srcWidth = 50;
		int srcHeight = 50;
		
		int srcY;

		ArrayList<Rect> collisionZones = new ArrayList<Rect>();
		ArrayList<Rect> damageZones = new ArrayList<Rect>();
		ArrayList<Rect> attackZones = new ArrayList<Rect>();
		collisionZones.add(new Rect(area));
		damageZones.add(new Rect(area));
	    attackZones.add(new Rect(area));

		// moveUpAnimation
	    srcY = 2 * srcHeight;
		for (int frameCounter = 0; frameCounter < 9; frameCounter ++) {
			int srcX = frameCounter * srcWidth;
		    moveUpAnimation.addFrame(frameImage, srcX, srcY, srcWidth, srcHeight, duration,
		    		collisionZones, damageZones, attackZones);
		}


		// moveLeftAnimation
		srcY = 3 * srcHeight;
		for (int i = 0; i < 9; i ++) {
			int srcX = i * srcWidth;
		    moveLeftAnimation.addFrame(frameImage, srcX, srcY, srcWidth, srcHeight, duration,
		    		collisionZones, damageZones, attackZones);
		}


		// moveDownAnimation
		srcY = 0;
		for (int i = 0; i < 9; i ++) {
			int srcX = i * srcWidth;
		    moveDownAnimation.addFrame(frameImage, srcX, srcY, srcWidth, srcHeight, duration,
		    		collisionZones, damageZones, attackZones);
		}


		// moveRightAnimation
		srcY = srcHeight;
		for (int i = 0; i < 9; i ++) {
			int srcX = i * srcWidth;
		    moveRightAnimation.addFrame(frameImage, srcX, srcY, srcWidth, srcHeight, duration,
		    		collisionZones, damageZones, attackZones);
		}
		
		// faceUpAnimation
	    srcY = 2 * srcHeight;
		for (int frameCounter = 0; frameCounter < 9; frameCounter ++) {
			int srcX = frameCounter * srcWidth;
		    faceUpAnimation.addFrame(frameImage, srcX, srcY, srcWidth, srcHeight, duration,
		    		collisionZones, damageZones, attackZones);
		}


		// faceLeftAnimation
		srcY = 3 * srcHeight;
		for (int i = 0; i < 9; i ++) {
			int srcX = i * srcWidth;
		    faceLeftAnimation.addFrame(frameImage, srcX, srcY, srcWidth, srcHeight, duration,
		    		collisionZones, damageZones, attackZones);
		}


		// faceDownAnimation
		srcY = 0;
		for (int i = 0; i < 9; i ++) {
			int srcX = i * srcWidth;
		    faceDownAnimation.addFrame(frameImage, srcX, srcY, srcWidth, srcHeight, duration,
		    		collisionZones, damageZones, attackZones);
		}


		// faceRightAnimation
		srcY = srcHeight;
		for (int i = 0; i < 9; i ++) {
			int srcX = i * srcWidth;
		    faceRightAnimation.addFrame(frameImage, srcX, srcY, srcWidth, srcHeight, duration,
		    		collisionZones, damageZones, attackZones);
		}


	    Animation currentAnimation = moveUpAnimation;
		
		SnailPlayerCharacter playerCharacter = 
				new SnailPlayerCharacter(
						gameScreen,
						centerX,
						centerY,
						moveSpeed,
						speedX,
						speedY,
						area,
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

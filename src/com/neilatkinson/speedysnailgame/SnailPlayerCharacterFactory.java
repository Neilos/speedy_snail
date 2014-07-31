package com.neilatkinson.speedysnailgame;

import java.util.ArrayList;

import android.graphics.Rect;

import com.neilatkinson.framework.Image;
import com.neilatkinson.gameobject.Animation;
import com.neilatkinson.gameobject.GameObject;
import com.neilatkinson.gameobject.Zone;

public class SnailPlayerCharacterFactory {

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
		int passiveDuration = 1000;
		Zone area = new Zone(new Rect(centerX - 25, centerY - 25, centerX + 25, centerY + 25), 0, 0);
		int areaWidth = area.width();
		int areaHeight = area.height();
		int spriteWidth = areaWidth;
		int spriteHeight = areaHeight;

		ArrayList<Class<? extends GameObject>> damageableTypes = new ArrayList<Class<? extends GameObject>>();

		Animation moveUpAnimation = new Animation();
		Animation moveLeftAnimation = new Animation();
		Animation moveDownAnimation = new Animation();
		Animation moveRightAnimation = new Animation();

		Animation faceUpAnimation = new Animation();
		Animation faceLeftAnimation = new Animation();
		Animation faceDownAnimation = new Animation();
		Animation faceRightAnimation = new Animation();

		Image frameImage = Assets.snail;
		int duration = 40;


		// moveDownAnimation
		ArrayList<Zone> moveDownCollisionZones = generateMoveDownCollisionZones(area);
		ArrayList<Zone> moveDownDamageZones = generateMoveDownDamageZones(area);
	    ArrayList<Zone> moveDownAttackZones = generateMoveDownAttackZones(area);

	    moveDownAnimation.addFrame(frameImage, 0, 0,
	    		areaWidth, areaHeight, duration,
				moveDownCollisionZones, moveDownDamageZones, moveDownAttackZones);
	    
	    moveDownAnimation.addFrame(frameImage, 1 * spriteWidth, 0,
	    		areaWidth, areaHeight, duration,
				moveDownCollisionZones, moveDownDamageZones, moveDownAttackZones);
	    
	    moveDownAnimation.addFrame(frameImage, 2 * spriteWidth, 0,
	    		areaWidth, areaHeight, duration,
				moveDownCollisionZones, moveDownDamageZones, moveDownAttackZones);
	    
	    moveDownAnimation.addFrame(frameImage, 3 * spriteWidth, 0,
	    		areaWidth, areaHeight, duration,
				moveDownCollisionZones, moveDownDamageZones, moveDownAttackZones);
	    
	    moveDownAnimation.addFrame(frameImage, 4 * spriteWidth, 0,
	    		areaWidth, areaHeight, duration,
				moveDownCollisionZones, moveDownDamageZones, moveDownAttackZones);

	    moveDownAnimation.addFrame(frameImage, 5 * spriteWidth, 0,
	    		areaWidth, areaHeight, duration,
				moveDownCollisionZones, moveDownDamageZones, moveDownAttackZones);
	    
	    moveDownAnimation.addFrame(frameImage, 6 * spriteWidth, 0,
	    		areaWidth, areaHeight, duration,
				moveDownCollisionZones, moveDownDamageZones, moveDownAttackZones);
	    
	    moveDownAnimation.addFrame(frameImage, 7 * spriteWidth, 0,
	    		areaWidth, areaHeight, duration,
				moveDownCollisionZones, moveDownDamageZones, moveDownAttackZones);
	    
	    moveDownAnimation.addFrame(frameImage, 8 * spriteWidth, 0,
	    		areaWidth, areaHeight, duration,
				moveDownCollisionZones, moveDownDamageZones, moveDownAttackZones);
	    

		// moveRightAnimation
		ArrayList<Zone> moveRightCollisionZones = generateMoveRightCollisionZones(area);
		ArrayList<Zone> moveRightDamageZones = generateMoveRightDamageZones(area);
	    ArrayList<Zone> moveRightAttackZones = generateMoveRightAttackZones(area);
	    
	    moveRightAnimation.addFrame(frameImage, 0, 1 * spriteHeight,
	    		areaWidth, areaHeight, duration,
				moveRightCollisionZones, moveRightDamageZones, moveRightAttackZones);
	    
	    moveRightAnimation.addFrame(frameImage, 1 * spriteWidth, 1 * spriteHeight,
	    		areaWidth, areaHeight, duration,
				moveRightCollisionZones, moveRightDamageZones, moveRightAttackZones);
	    
	    moveRightAnimation.addFrame(frameImage, 2 * spriteWidth, 1 * spriteHeight,
	    		areaWidth, areaHeight, duration,
				moveRightCollisionZones, moveRightDamageZones, moveRightAttackZones);
	    
	    moveRightAnimation.addFrame(frameImage, 3 * spriteWidth, 1 * spriteHeight,
	    		areaWidth, areaHeight, duration,
				moveRightCollisionZones, moveRightDamageZones, moveRightAttackZones);

	    moveRightAnimation.addFrame(frameImage, 4 * spriteWidth, 1 * spriteHeight,
	    		areaWidth, areaHeight, duration,
				moveRightCollisionZones, moveRightDamageZones, moveRightAttackZones);
	    
	    moveRightAnimation.addFrame(frameImage, 5 * spriteWidth, 1 * spriteHeight,
	    		areaWidth, areaHeight, duration,
				moveRightCollisionZones, moveRightDamageZones, moveRightAttackZones);
	    
	    moveRightAnimation.addFrame(frameImage, 6 * spriteWidth, 1 * spriteHeight,
	    		areaWidth, areaHeight, duration,
				moveRightCollisionZones, moveRightDamageZones, moveRightAttackZones);
	    
	    moveRightAnimation.addFrame(frameImage, 7 * spriteWidth, 1 * spriteHeight,
	    		areaWidth, areaHeight, duration,
				moveRightCollisionZones, moveRightDamageZones, moveRightAttackZones);
	    
	    moveRightAnimation.addFrame(frameImage, 8 * spriteWidth, 1 * spriteHeight,
	    		areaWidth, areaHeight, duration,
				moveRightCollisionZones, moveRightDamageZones, moveRightAttackZones);
	    

		// moveUpAnimation
		ArrayList<Zone> moveUpCollisionZones = generateMoveUpCollisionZones(area);
		ArrayList<Zone> moveUpDamageZones = generateMoveUpDamageZones(area);
	    ArrayList<Zone> moveUpAttackZones = generateMoveUpAttackZones(area);

	    moveUpAnimation.addFrame(frameImage, 0, 2 * spriteHeight,
				areaWidth, areaHeight, duration,
				moveUpCollisionZones, moveUpDamageZones, moveUpAttackZones);

		moveUpAnimation.addFrame(frameImage, 1 * spriteWidth, 2 * spriteHeight,
				areaWidth, areaHeight, duration,
				moveUpCollisionZones, moveUpDamageZones, moveUpAttackZones);
	    
		moveUpAnimation.addFrame(frameImage, 2 * spriteWidth, 2 * spriteHeight,
				areaWidth, areaHeight, duration,
				moveUpCollisionZones, moveUpDamageZones, moveUpAttackZones);
	    
		moveUpAnimation.addFrame(frameImage, 3 * spriteWidth, 2 * spriteHeight,
				areaWidth, areaHeight, duration,
				moveUpCollisionZones, moveUpDamageZones, moveUpAttackZones);

		moveUpAnimation.addFrame(frameImage, 4 * spriteWidth, 2 * spriteHeight,
				areaWidth, areaHeight, duration,
				moveUpCollisionZones, moveUpDamageZones, moveUpAttackZones);
		
		moveUpAnimation.addFrame(frameImage, 5 * spriteWidth, 2 * spriteHeight,
				areaWidth, areaHeight, duration,
				moveUpCollisionZones, moveUpDamageZones, moveUpAttackZones);
		
		moveUpAnimation.addFrame(frameImage, 6 * spriteWidth, 2 * spriteHeight,
				areaWidth, areaHeight, duration,
				moveUpCollisionZones, moveUpDamageZones, moveUpAttackZones);
		
		moveUpAnimation.addFrame(frameImage, 7 * spriteWidth, 2 * spriteHeight,
				areaWidth, areaHeight, duration,
				moveUpCollisionZones, moveUpDamageZones, moveUpAttackZones);

		moveUpAnimation.addFrame(frameImage, 8 * spriteWidth, 2 * spriteHeight,
				areaWidth, areaHeight, duration,
				moveUpCollisionZones, moveUpDamageZones, moveUpAttackZones);


		// moveLeftAnimation
		ArrayList<Zone> moveLeftCollisionZones = generateMoveLeftCollisionZones(area);
		ArrayList<Zone> moveLeftDamageZones = generateMoveLeftDamageZones(area);
	    ArrayList<Zone> moveLeftAttackZones = generateMoveLeftAttackZones(area);

		moveLeftAnimation.addFrame(frameImage, 0, 3 * spriteHeight,
				areaWidth, areaHeight, duration,
				moveLeftCollisionZones, moveLeftDamageZones, moveLeftAttackZones);
	    
		moveLeftAnimation.addFrame(frameImage, 1 * spriteWidth, 3 * spriteHeight,
				areaWidth, areaHeight, duration,
				moveLeftCollisionZones, moveLeftDamageZones, moveLeftAttackZones);
	    
		moveLeftAnimation.addFrame(frameImage, 2 * spriteWidth, 3 * spriteHeight,
				areaWidth, areaHeight, duration,
				moveLeftCollisionZones, moveLeftDamageZones, moveLeftAttackZones);
	    
		moveLeftAnimation.addFrame(frameImage, 3 * spriteWidth, 3 * spriteHeight,
				areaWidth, areaHeight, duration,
				moveLeftCollisionZones, moveLeftDamageZones, moveLeftAttackZones);

		moveLeftAnimation.addFrame(frameImage, 4 * spriteWidth, 3 * spriteHeight,
				areaWidth, areaHeight, duration,
				moveLeftCollisionZones, moveLeftDamageZones, moveLeftAttackZones);
		
		moveLeftAnimation.addFrame(frameImage, 5 * spriteWidth, 3 * spriteHeight,
				areaWidth, areaHeight, duration,
				moveLeftCollisionZones, moveLeftDamageZones, moveLeftAttackZones);
		
		moveLeftAnimation.addFrame(frameImage, 6 * spriteWidth, 3 * spriteHeight,
				areaWidth, areaHeight, duration,
				moveLeftCollisionZones, moveLeftDamageZones, moveLeftAttackZones);
		
		moveLeftAnimation.addFrame(frameImage, 7 * spriteWidth, 3 * spriteHeight,
				areaWidth, areaHeight, duration,
				moveLeftCollisionZones, moveLeftDamageZones, moveLeftAttackZones);
		
		moveLeftAnimation.addFrame(frameImage, 8 * spriteWidth, 3 * spriteHeight,
				areaWidth, areaHeight, duration,
				moveLeftCollisionZones, moveLeftDamageZones, moveLeftAttackZones);


		// faceUpAnimation
	    faceUpAnimation = moveUpAnimation;

		// faceLeftAnimation
	    faceLeftAnimation = moveLeftAnimation;
	    
		// faceDownAnimation
	    faceDownAnimation = moveDownAnimation;

		// faceRightAnimation	    
		faceRightAnimation = moveRightAnimation;

		Animation currentAnimation = faceRightAnimation;
		
		PlayerCharacter playerCharacter = 
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


	private static ArrayList<Zone> generateMoveLeftAttackZones(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect rect = new Rect(area.left() + 6, area.top() + 34, area.right() - 30, area.bottom() - 10);
		zones.add(new Zone(rect, rect.centerX() - area.centerX(), rect.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveLeftDamageZones(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect rect = new Rect(area.left() + 7, area.top() + 19, area.right() - 7, area.bottom() - 3);
		zones.add(new Zone(rect, rect.centerX() - area.centerX(), rect.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveLeftCollisionZones(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect rect = new Rect(area.left() + 8, area.top() + 20, area.right() - 8, area.bottom() - 4);
		zones.add(new Zone(rect, rect.centerX() - area.centerX(), rect.centerY() - area.centerY()));		
		return zones;
	}


	private static ArrayList<Zone> generateMoveUpAttackZones(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect rect = new Rect(area.left() + 19, area.top() + 9, area.right() - 19, area.bottom() - 37);
		zones.add(new Zone(rect, rect.centerX() - area.centerX(), rect.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveUpDamageZones(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect rect = new Rect(area.left() + 11, area.top() + 9, area.right() - 11, area.bottom() - 3);
		zones.add(new Zone(rect, rect.centerX() - area.centerX(), rect.centerY() - area.centerY()));	
		return zones;
	}

	private static ArrayList<Zone> generateMoveUpCollisionZones(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect rect = new Rect(area.left() + 12, area.top() + 10, area.right() - 12, area.bottom() - 4);
		zones.add(new Zone(rect, rect.centerX() - area.centerX(), rect.centerY() - area.centerY()));		
		return zones;
	}


	private static ArrayList<Zone> generateMoveRightAttackZones(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect rect = new Rect(area.left() + 30, area.top() + 34, area.right() - 6, area.bottom() - 10);
		zones.add(new Zone(rect, rect.centerX() - area.centerX(), rect.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveRightDamageZones(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect rect = new Rect(area.left() + 7, area.top() + 19, area.right() - 7, area.bottom() - 3);
		zones.add(new Zone(rect, rect.centerX() - area.centerX(), rect.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveRightCollisionZones(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect rect = new Rect(area.left() + 8, area.top() + 20, area.right() - 8, area.bottom() - 4);
		zones.add(new Zone(rect, rect.centerX() - area.centerX(), rect.centerY() - area.centerY()));		
		return zones;
	}


	private static ArrayList<Zone> generateMoveDownAttackZones(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect rect2 = new Rect(area.left() + 19, area.top() + 37, area.right() - 19, area.bottom() - 3);
		zones.add(new Zone(rect2, rect2.centerX() - area.centerX(), rect2.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveDownDamageZones(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();

		Rect rect = new Rect(area.left() + 11, area.top() + 11, area.right() - 11, area.bottom() - 11);
		zones.add(new Zone(rect, rect.centerX() - area.centerX(), rect.centerY() - area.centerY()));
		
		Rect rect2 = new Rect(area.left() + 19, area.top() + 37, area.right() - 19, area.bottom() - 3);
		zones.add(new Zone(rect2, rect2.centerX() - area.centerX(), rect2.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveDownCollisionZones(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();

		Rect rect = new Rect(area.left() + 12, area.top() + 12, area.right() - 12, area.bottom() - 12);
		zones.add(new Zone(rect, rect.centerX() - area.centerX(), rect.centerY() - area.centerY()));
		
		Rect rect2 = new Rect(area.left() + 20, area.top() + 38, area.right() - 20, area.bottom() - 4);
		zones.add(new Zone(rect2, rect2.centerX() - area.centerX(), rect2.centerY() - area.centerY()));
		return zones;
	}
}
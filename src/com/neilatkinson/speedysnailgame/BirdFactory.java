package com.neilatkinson.speedysnailgame;

import java.util.ArrayList;

import android.graphics.Rect;

import com.neilatkinson.framework.Image;
import com.neilatkinson.gameobject.Animation;
import com.neilatkinson.gameobject.GameObject;
import com.neilatkinson.gameobject.Zone;

public class BirdFactory {

	public static Enemy build(GameScreen gameScreen, int centerX, int centerY) {
		int moveSpeed = 2;
		int speedX = 0;
		int speedY = 0;
		int health = 1;
		int damage = 1;
		boolean isDead = false;
		boolean isMovingUp = false;
		boolean isMovingLeft = false;
		boolean isMovingDown = false;
		boolean isMovingRight = false;
		int passiveDuration = 1000;
		Zone area = new Zone(new Rect(centerX - 32, centerY - 25, centerX + 32, centerY + 25), 0, 0);
		int areaWidth = area.width();
		int areaHeight = area.height();
		int spriteYspacing = 14;
		int spriteWidth = areaWidth;
		int spriteHeight = areaHeight;

		ArrayList<Class<? extends GameObject>> damageableTypes = new ArrayList<Class<? extends GameObject>>();
		damageableTypes.add(PlayerCharacter.class);

		ArrayList<Class<? extends GameObject>> collidableTypes = new ArrayList<Class<? extends GameObject>>();
		collidableTypes.add(PlayerCharacter.class);

		Animation moveUpAnimation = new Animation();
		Animation moveLeftAnimation = new Animation();
		Animation moveDownAnimation = new Animation();
		Animation moveRightAnimation = new Animation();

		Animation faceUpAnimation = new Animation();
		Animation faceLeftAnimation = new Animation();
		Animation faceDownAnimation = new Animation();
		Animation faceRightAnimation = new Animation();

		Image frameImage = Assets.bird;
		int duration = 40;


		// moveDownAnimation
		ArrayList<Zone> moveDownCollisionZonesFrame0 = generateMoveDownCollisionZonesFrame0(area);
		ArrayList<Zone> moveDownDamageZonesFrame0 = generateMoveDownDamageZonesFrame0(area);
	    ArrayList<Zone> moveDownAttackZonesFrame0 = generateMoveDownAttackZonesFrame0(area);
	    moveDownAnimation.addFrame(frameImage, 0, 0,
	    		areaWidth, areaHeight, duration,
				moveDownCollisionZonesFrame0, moveDownDamageZonesFrame0, moveDownAttackZonesFrame0);
	    
	    ArrayList<Zone> moveDownCollisionZonesFrame1 = generateMoveDownCollisionZonesFrame1(area);
		ArrayList<Zone> moveDownDamageZonesFrame1 = generateMoveDownDamageZonesFrame1(area);
	    ArrayList<Zone> moveDownAttackZonesFrame1 = generateMoveDownAttackZonesFrame1(area);
	    moveDownAnimation.addFrame(frameImage, 1 * spriteWidth, 0,
	    		areaWidth, areaHeight, duration,
				moveDownCollisionZonesFrame1, moveDownDamageZonesFrame1, moveDownAttackZonesFrame1);
	    
	    ArrayList<Zone> moveDownCollisionZonesFrame2 = generateMoveDownCollisionZonesFrame2(area);
		ArrayList<Zone> moveDownDamageZonesFrame2 = generateMoveDownDamageZonesFrame2(area);
	    ArrayList<Zone> moveDownAttackZonesFrame2 = generateMoveDownAttackZonesFrame2(area);
	    moveDownAnimation.addFrame(frameImage, 2 * spriteWidth, 0,
	    		areaWidth, areaHeight, duration,
				moveDownCollisionZonesFrame2, moveDownDamageZonesFrame2, moveDownAttackZonesFrame2);
	    

		// moveLeftAnimation
		ArrayList<Zone> moveLeftCollisionZonesFrame0 = generateMoveLeftCollisionZonesFrame0(area);
		ArrayList<Zone> moveLeftDamageZonesFrame0 = generateMoveLeftDamageZonesFrame0(area);
	    ArrayList<Zone> moveLeftAttackZonesFrame0 = generateMoveLeftAttackZonesFrame0(area);
		moveLeftAnimation.addFrame(frameImage, 0, 1 * (spriteHeight + spriteYspacing),
				areaWidth, areaHeight, duration,
				moveLeftCollisionZonesFrame0, moveLeftDamageZonesFrame0, moveLeftAttackZonesFrame0);
	    
		ArrayList<Zone> moveLeftCollisionZonesFrame1 = generateMoveLeftCollisionZonesFrame1(area);
		ArrayList<Zone> moveLeftDamageZonesFrame1 = generateMoveLeftDamageZonesFrame1(area);
	    ArrayList<Zone> moveLeftAttackZonesFrame1 = generateMoveLeftAttackZonesFrame1(area);
		moveLeftAnimation.addFrame(frameImage, 1 * spriteWidth, 1 * (spriteHeight + spriteYspacing),
				areaWidth, areaHeight, duration,
				moveLeftCollisionZonesFrame1, moveLeftDamageZonesFrame1, moveLeftAttackZonesFrame1);
	    
		ArrayList<Zone> moveLeftCollisionZonesFrame2 = generateMoveLeftCollisionZonesFrame2(area);
		ArrayList<Zone> moveLeftDamageZonesFrame2 = generateMoveLeftDamageZonesFrame2(area);
	    ArrayList<Zone> moveLeftAttackZonesFrame2 = generateMoveLeftAttackZonesFrame2(area);
		moveLeftAnimation.addFrame(frameImage, 2 * spriteWidth, 1 * (spriteHeight + spriteYspacing),
				areaWidth, areaHeight, duration,
				moveLeftCollisionZonesFrame2, moveLeftDamageZonesFrame2, moveLeftAttackZonesFrame2);

		
		// moveRightAnimation
		ArrayList<Zone> moveRightCollisionZonesFrame0 = generateMoveRightCollisionZonesFrame0(area);
		ArrayList<Zone> moveRightDamageZonesFrame0 = generateMoveRightDamageZonesFrame0(area);
	    ArrayList<Zone> moveRightAttackZonesFrame0 = generateMoveRightAttackZonesFrame0(area);
	    moveRightAnimation.addFrame(frameImage, 0, 2 * (spriteHeight + spriteYspacing),
	    		areaWidth, areaHeight, duration,
				moveRightCollisionZonesFrame0, moveRightDamageZonesFrame0, moveRightAttackZonesFrame0);
	    
	    ArrayList<Zone> moveRightCollisionZonesFrame1 = generateMoveRightCollisionZonesFrame1(area);
		ArrayList<Zone> moveRightDamageZonesFrame1 = generateMoveRightDamageZonesFrame1(area);
	    ArrayList<Zone> moveRightAttackZonesFrame1 = generateMoveRightAttackZonesFrame1(area);
	    moveRightAnimation.addFrame(frameImage, 1 * spriteWidth, 2 * (spriteHeight + spriteYspacing),
	    		areaWidth, areaHeight, duration,
				moveRightCollisionZonesFrame1, moveRightDamageZonesFrame1, moveRightAttackZonesFrame1);
	    
	    ArrayList<Zone> moveRightCollisionZonesFrame2 = generateMoveRightCollisionZonesFrame2(area);
		ArrayList<Zone> moveRightDamageZonesFrame2 = generateMoveRightDamageZonesFrame2(area);
	    ArrayList<Zone> moveRightAttackZonesFrame2 = generateMoveRightAttackZonesFrame2(area);
	    moveRightAnimation.addFrame(frameImage, 2 * spriteWidth, 2 * (spriteHeight + spriteYspacing),
	    		areaWidth, areaHeight, duration,
				moveRightCollisionZonesFrame2, moveRightDamageZonesFrame2, moveRightAttackZonesFrame2);
	    

		// moveUpAnimation
		ArrayList<Zone> moveUpCollisionZonesFrame0 = generateMoveUpCollisionZonesFrame0(area);
		ArrayList<Zone> moveUpDamageZonesFrame0 = generateMoveUpDamageZonesFrame0(area);
	    ArrayList<Zone> moveUpAttackZonesFrame0 = generateMoveUpAttackZonesFrame0(area);
	    moveUpAnimation.addFrame(frameImage, 0, 3 * (spriteHeight + spriteYspacing),
				areaWidth, areaHeight, duration,
				moveUpCollisionZonesFrame0, moveUpDamageZonesFrame0, moveUpAttackZonesFrame0);

	    ArrayList<Zone> moveUpCollisionZonesFrame1 = generateMoveUpCollisionZonesFrame1(area);
		ArrayList<Zone> moveUpDamageZonesFrame1 = generateMoveUpDamageZonesFrame1(area);
	    ArrayList<Zone> moveUpAttackZonesFrame1 = generateMoveUpAttackZonesFrame1(area);
		moveUpAnimation.addFrame(frameImage, 1 * spriteWidth, 3 * (spriteHeight + spriteYspacing),
				areaWidth, areaHeight, duration,
				moveUpCollisionZonesFrame1, moveUpDamageZonesFrame1, moveUpAttackZonesFrame1);
	    
		ArrayList<Zone> moveUpCollisionZonesFrame2 = generateMoveUpCollisionZonesFrame2(area);
		ArrayList<Zone> moveUpDamageZonesFrame2 = generateMoveUpDamageZonesFrame2(area);
	    ArrayList<Zone> moveUpAttackZonesFrame2 = generateMoveUpAttackZonesFrame2(area);
		moveUpAnimation.addFrame(frameImage, 2 * spriteWidth, 3 * (spriteHeight + spriteYspacing),
				areaWidth, areaHeight, duration,
				moveUpCollisionZonesFrame2, moveUpDamageZonesFrame2, moveUpAttackZonesFrame2);


		// faceUpAnimation
	    faceUpAnimation = moveUpAnimation;

		// faceLeftAnimation
	    faceLeftAnimation = moveLeftAnimation;

		// faceDownAnimation
	    faceDownAnimation = moveDownAnimation;

		// faceRightAnimation	    
		faceRightAnimation = moveRightAnimation;

		Animation currentAnimation = faceRightAnimation;

		Enemy bird = 
				new Bird(
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
						damageableTypes,
						collidableTypes);

		return bird;
	}

//	=============================================================================
//	#############################################################################
//	=============================================================================
	private static ArrayList<Zone> generateMoveLeftAttackZonesFrame0(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect beak = new Rect(area.left() + 16, area.top() + 21, area.right() - 44, area.bottom() - 24);
		zones.add(new Zone(beak, beak.centerX() - area.centerX(), beak.centerY() - area.centerY()));
		
		Rect claws = new Rect(area.left() + 38, area.top() + 27, area.right() - 20, area.bottom() - 15);
		zones.add(new Zone(claws, claws.centerX() - area.centerX(), claws.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveLeftDamageZonesFrame0(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect head = new Rect(area.left() + 19, area.top() + 17, area.right() - 37, area.bottom() - 23);
		zones.add(new Zone(head, head.centerX() - area.centerX(), head.centerY() - area.centerY()));
		
		Rect body = new Rect(area.left() + 25, area.top() + 20, area.right() - 23, area.bottom() - 18);
		zones.add(new Zone(body, body.centerX() - area.centerX(), body.centerY() - area.centerY()));
		return zones;	}

	private static ArrayList<Zone> generateMoveLeftCollisionZonesFrame0(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect body = new Rect(area.left() + 26, area.top() + 21, area.right() - 24, area.bottom() - 19);
		zones.add(new Zone(body, body.centerX() - area.centerX(), body.centerY() - area.centerY()));
		return zones;
	}

//	=============================================================================
	private static ArrayList<Zone> generateMoveLeftAttackZonesFrame1(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect beak = new Rect(area.left() + 16, area.top() + 19, area.right() - 44, area.bottom() - 26);
		zones.add(new Zone(beak, beak.centerX() - area.centerX(), beak.centerY() - area.centerY()));
		
		Rect claws = new Rect(area.left() + 38, area.top() + 25, area.right() - 20, area.bottom() - 17);
		zones.add(new Zone(claws, claws.centerX() - area.centerX(), claws.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveLeftDamageZonesFrame1(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect head = new Rect(area.left() + 19, area.top() + 15, area.right() - 37, area.bottom() - 25);
		zones.add(new Zone(head, head.centerX() - area.centerX(), head.centerY() - area.centerY()));
		
		Rect body = new Rect(area.left() + 25, area.top() + 18, area.right() - 23, area.bottom() - 20);
		zones.add(new Zone(body, body.centerX() - area.centerX(), body.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveLeftCollisionZonesFrame1(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect body = new Rect(area.left() + 26, area.top() + 19, area.right() - 24, area.bottom() - 21);
		zones.add(new Zone(body, body.centerX() - area.centerX(), body.centerY() - area.centerY()));
		return zones;
	}
	
//	=============================================================================
	private static ArrayList<Zone> generateMoveLeftAttackZonesFrame2(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect beak = new Rect(area.left() + 16, area.top() + 10, area.right() - 44, area.bottom() - 35);
		zones.add(new Zone(beak, beak.centerX() - area.centerX(), beak.centerY() - area.centerY()));
		
		Rect claws = new Rect(area.left() + 38, area.top() + 16, area.right() - 20, area.bottom() - 26);
		zones.add(new Zone(claws, claws.centerX() - area.centerX(), claws.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveLeftDamageZonesFrame2(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect head = new Rect(area.left() + 19, area.top() + 6, area.right() - 37, area.bottom() - 34);
		zones.add(new Zone(head, head.centerX() - area.centerX(), head.centerY() - area.centerY()));
		
		Rect body = new Rect(area.left() + 25, area.top() + 9, area.right() - 23, area.bottom() - 29);
		zones.add(new Zone(body, body.centerX() - area.centerX(), body.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveLeftCollisionZonesFrame2(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect body = new Rect(area.left() + 26, area.top() + 10, area.right() - 24, area.bottom() - 30);
		zones.add(new Zone(body, body.centerX() - area.centerX(), body.centerY() - area.centerY()));
		return zones;
	}


//	=============================================================================
//	#############################################################################
//	=============================================================================
	private static ArrayList<Zone> generateMoveUpAttackZonesFrame0(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect claws = new Rect(area.left() + 24, area.top() + 28, area.right() - 24, area.bottom() - 18);
		zones.add(new Zone(claws, claws.centerX() - area.centerX(), claws.centerY() - area.centerY()));
		
		Rect head = new Rect(area.left() + 30, area.top() + 14, area.right() - 30, area.bottom() - 32);
		zones.add(new Zone(head, head.centerX() - area.centerX(), head.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveUpDamageZonesFrame0(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect rect = new Rect(area.left() + 25, area.top() + 18, area.right() - 25, area.bottom() - 21);
		zones.add(new Zone(rect, rect.centerX() - area.centerX(), rect.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveUpCollisionZonesFrame0(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect rect = new Rect(area.left() + 26, area.top() + 18, area.right() - 26, area.bottom() - 22);
		zones.add(new Zone(rect, rect.centerX() - area.centerX(), rect.centerY() - area.centerY()));
		return zones;
	}

//	=============================================================================
	private static ArrayList<Zone> generateMoveUpAttackZonesFrame1(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect claws = new Rect(area.left() + 24, area.top() + 30, area.right() - 24, area.bottom() - 16);
		zones.add(new Zone(claws, claws.centerX() - area.centerX(), claws.centerY() - area.centerY()));
		
		Rect head = new Rect(area.left() + 30, area.top() + 16, area.right() - 30, area.bottom() - 30);
		zones.add(new Zone(head, head.centerX() - area.centerX(), head.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveUpDamageZonesFrame1(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect rect = new Rect(area.left() + 25, area.top() + 20, area.right() - 25, area.bottom() - 19);
		zones.add(new Zone(rect, rect.centerX() - area.centerX(), rect.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveUpCollisionZonesFrame1(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect rect = new Rect(area.left() + 26, area.top() + 20, area.right() - 26, area.bottom() - 20);
		zones.add(new Zone(rect, rect.centerX() - area.centerX(), rect.centerY() - area.centerY()));
		return zones;
	}
	
//	=============================================================================
	private static ArrayList<Zone> generateMoveUpAttackZonesFrame2(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect claws = new Rect(area.left() + 24, area.top() + 22, area.right() - 24, area.bottom() - 22);
		zones.add(new Zone(claws, claws.centerX() - area.centerX(), claws.centerY() - area.centerY()));
		
		Rect head = new Rect(area.left() + 30, area.top() + 8, area.right() - 30, area.bottom() - 38);
		zones.add(new Zone(head, head.centerX() - area.centerX(), head.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveUpDamageZonesFrame2(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect rect = new Rect(area.left() + 25, area.top() + 12, area.right() - 25, area.bottom() - 29);
		zones.add(new Zone(rect, rect.centerX() - area.centerX(), rect.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveUpCollisionZonesFrame2(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect rect = new Rect(area.left() + 26, area.top() + 12, area.right() - 26, area.bottom() - 28);
		zones.add(new Zone(rect, rect.centerX() - area.centerX(), rect.centerY() - area.centerY()));
		return zones;
	}
	

//	=============================================================================
//	#############################################################################
//	=============================================================================
	private static ArrayList<Zone> generateMoveRightAttackZonesFrame0(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect beak = new Rect(area.left() + 44, area.top() + 10, area.right() - 16, area.bottom() - 35);
		zones.add(new Zone(beak, beak.centerX() - area.centerX(), beak.centerY() - area.centerY()));
		
		Rect claws = new Rect(area.left() + 20, area.top() + 16, area.right() - 38, area.bottom() - 26);
		zones.add(new Zone(claws, claws.centerX() - area.centerX(), claws.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveRightDamageZonesFrame0(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect head = new Rect(area.left() + 37, area.top() + 6, area.right() - 19, area.bottom() - 34);
		zones.add(new Zone(head, head.centerX() - area.centerX(), head.centerY() - area.centerY()));
		
		Rect body = new Rect(area.left() + 23, area.top() + 9, area.right() - 25, area.bottom() - 29);
		zones.add(new Zone(body, body.centerX() - area.centerX(), body.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveRightCollisionZonesFrame0(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect body = new Rect(area.left() + 24, area.top() + 10, area.right() - 26, area.bottom() - 30);
		zones.add(new Zone(body, body.centerX() - area.centerX(), body.centerY() - area.centerY()));
		return zones;
	}

//	=============================================================================	
	private static ArrayList<Zone> generateMoveRightAttackZonesFrame1(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect beak = new Rect(area.left() + 44, area.top() + 19, area.right() - 16, area.bottom() - 26);
		zones.add(new Zone(beak, beak.centerX() - area.centerX(), beak.centerY() - area.centerY()));
		
		Rect claws = new Rect(area.left() + 20, area.top() + 25, area.right() - 38, area.bottom() - 17);
		zones.add(new Zone(claws, claws.centerX() - area.centerX(), claws.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveRightDamageZonesFrame1(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect head = new Rect(area.left() + 37, area.top() + 15, area.right() - 19, area.bottom() - 25);
		zones.add(new Zone(head, head.centerX() - area.centerX(), head.centerY() - area.centerY()));
		
		Rect body = new Rect(area.left() + 23, area.top() + 18, area.right() - 25, area.bottom() - 20);
		zones.add(new Zone(body, body.centerX() - area.centerX(), body.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveRightCollisionZonesFrame1(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect body = new Rect(area.left() + 24, area.top() + 19, area.right() - 26, area.bottom() - 21);
		zones.add(new Zone(body, body.centerX() - area.centerX(), body.centerY() - area.centerY()));
		return zones;
	}

//	=============================================================================
	private static ArrayList<Zone> generateMoveRightAttackZonesFrame2(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect beak = new Rect(area.left() + 44, area.top() + 21, area.right() - 16, area.bottom() - 24);
		zones.add(new Zone(beak, beak.centerX() - area.centerX(), beak.centerY() - area.centerY()));
		
		Rect claws = new Rect(area.left() + 20, area.top() + 27, area.right() - 38, area.bottom() - 15);
		zones.add(new Zone(claws, claws.centerX() - area.centerX(), claws.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveRightDamageZonesFrame2(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect head = new Rect(area.left() + 37, area.top() + 17, area.right() - 19, area.bottom() - 23);
		zones.add(new Zone(head, head.centerX() - area.centerX(), head.centerY() - area.centerY()));
		
		Rect body = new Rect(area.left() + 23, area.top() + 20, area.right() - 25, area.bottom() - 18);
		zones.add(new Zone(body, body.centerX() - area.centerX(), body.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveRightCollisionZonesFrame2(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect body = new Rect(area.left() + 24, area.top() + 10, area.right() - 26, area.bottom() - 30);
		zones.add(new Zone(body, body.centerX() - area.centerX(), body.centerY() - area.centerY()));
		return zones;
	}

//	=============================================================================
//	#############################################################################
//	=============================================================================
	private static ArrayList<Zone> generateMoveDownAttackZonesFrame0(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect claws = new Rect(area.left() + 24, area.top() + 24, area.right() - 24, area.bottom() - 18);
		zones.add(new Zone(claws, claws.centerX() - area.centerX(), claws.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveDownDamageZonesFrame0(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect rect = new Rect(area.left() + 25, area.top() + 15, area.right() - 25, area.bottom() - 23);
		zones.add(new Zone(rect, rect.centerX() - area.centerX(), rect.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveDownCollisionZonesFrame0(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect rect = new Rect(area.left() + 26, area.top() + 16, area.right() - 26, area.bottom() - 24);
		zones.add(new Zone(rect, rect.centerX() - area.centerX(), rect.centerY() - area.centerY()));
		return zones;
	}

//	=============================================================================
	private static ArrayList<Zone> generateMoveDownAttackZonesFrame1(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect claws = new Rect(area.left() + 24, area.top() + 26, area.right() - 24, area.bottom() - 16);
		zones.add(new Zone(claws, claws.centerX() - area.centerX(), claws.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveDownDamageZonesFrame1(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect rect = new Rect(area.left() + 25, area.top() + 17, area.right() - 25, area.bottom() - 21);
		zones.add(new Zone(rect, rect.centerX() - area.centerX(), rect.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveDownCollisionZonesFrame1(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect rect = new Rect(area.left() + 26, area.top() + 18, area.right() - 26, area.bottom() - 22);
		zones.add(new Zone(rect, rect.centerX() - area.centerX(), rect.centerY() - area.centerY()));
		return zones;
	}
	
//	=============================================================================
	private static ArrayList<Zone> generateMoveDownAttackZonesFrame2(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect claws = new Rect(area.left() + 24, area.top() + 18, area.right() - 24, area.bottom() - 22);
		zones.add(new Zone(claws, claws.centerX() - area.centerX(), claws.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveDownDamageZonesFrame2(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect rect = new Rect(area.left() + 25, area.top() + 10, area.right() - 25, area.bottom() - 24);
		zones.add(new Zone(rect, rect.centerX() - area.centerX(), rect.centerY() - area.centerY()));
		return zones;
	}

	private static ArrayList<Zone> generateMoveDownCollisionZonesFrame2(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		Rect rect = new Rect(area.left() + 26, area.top() + 11, area.right() - 26, area.bottom() - 25);
		zones.add(new Zone(rect, rect.centerX() - area.centerX(), rect.centerY() - area.centerY()));
		return zones;
	}
}

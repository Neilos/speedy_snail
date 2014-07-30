package com.neilatkinson.speedysnailgame;

import java.util.ArrayList;

import android.graphics.Rect;

import com.neilatkinson.framework.Image;
import com.neilatkinson.gameobject.Animation;
import com.neilatkinson.gameobject.GameObject;
import com.neilatkinson.gameobject.Zone;

public class SnailCharacterFactory {

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
		int duration = 50;


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
				moveUpAttackZones, moveUpAttackZones, moveUpAttackZones);

		moveUpAnimation.addFrame(frameImage, 1 * spriteWidth, 2 * spriteHeight,
				areaWidth, areaHeight, duration,
				moveUpAttackZones, moveUpAttackZones, moveUpAttackZones);
	    
		moveUpAnimation.addFrame(frameImage, 2 * spriteWidth, 2 * spriteHeight,
				areaWidth, areaHeight, duration,
				moveUpAttackZones, moveUpAttackZones, moveUpAttackZones);
	    
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
		// TODO Auto-generated method stub
		ArrayList<Zone> zones = new ArrayList<Zone>();
		zones.add(new Zone(new Rect(area.left() - 1, area.top() -1, area.right() + 1, area.bottom() + 1), 0, 0));
		return zones;
	}

	private static ArrayList<Zone> generateMoveLeftDamageZones(Zone area) {
		// TODO Auto-generated method stub
		ArrayList<Zone> zones = new ArrayList<Zone>();
		zones.add(new Zone(new Rect(area.left() - 1, area.top() -1, area.right() + 1, area.bottom() + 1), 0, 0));
		return zones;
	}

	private static ArrayList<Zone> generateMoveLeftCollisionZones(Zone area) {
		// TODO Auto-generated method stub
		ArrayList<Zone> zones = new ArrayList<Zone>();
		zones.add(area.deepClone());		
		return zones;
	}

	private static ArrayList<Zone> generateMoveUpAttackZones(Zone area) {
		// TODO Auto-generated method stub
		ArrayList<Zone> zones = new ArrayList<Zone>();
		zones.add(new Zone(new Rect(area.left() - 1, area.top() -1, area.right() + 1, area.bottom() + 1), 0, 0));
		return zones;
	}

	private static ArrayList<Zone> generateMoveUpDamageZones(Zone area) {
		// TODO Auto-generated method stub
		ArrayList<Zone> zones = new ArrayList<Zone>();
		zones.add(new Zone(new Rect(area.left() - 1, area.top() -1, area.right() + 1, area.bottom() + 1), 0, 0));
		return zones;
	}

	private static ArrayList<Zone> generateMoveUpCollisionZones(Zone area) {
		// TODO Auto-generated method stub
		ArrayList<Zone> zones = new ArrayList<Zone>();
		zones.add(area.deepClone());		
		return zones;
	}

	private static ArrayList<Zone> generateMoveRightAttackZones(Zone area) {
		// TODO Auto-generated method stub
		ArrayList<Zone> zones = new ArrayList<Zone>();
		zones.add(new Zone(new Rect(area.left() - 1, area.top() -1, area.right() + 1, area.bottom() + 1), 0, 0));
		return zones;
	}

	private static ArrayList<Zone> generateMoveRightDamageZones(Zone area) {
		// TODO Auto-generated method stub
		ArrayList<Zone> zones = new ArrayList<Zone>();
		zones.add(new Zone(new Rect(area.left() - 1, area.top() -1, area.right() + 1, area.bottom() + 1), 0, 0));
		return zones;
	}

	private static ArrayList<Zone> generateMoveRightCollisionZones(Zone area) {
		// TODO Auto-generated method stub
		ArrayList<Zone> zones = new ArrayList<Zone>();
		zones.add(area.deepClone());		
		return zones;
	}

	private static ArrayList<Zone> generateMoveDownAttackZones(Zone area) {
		// TODO Auto-generated method stub
		ArrayList<Zone> zones = new ArrayList<Zone>();
		zones.add(new Zone(new Rect(area.left() - 1, area.top() -1, area.right() + 1, area.bottom() + 1), 0, 0));
		return zones;
	}

	private static ArrayList<Zone> generateMoveDownDamageZones(Zone area) {
		// TODO Auto-generated method stub
		ArrayList<Zone> zones = new ArrayList<Zone>();
		zones.add(new Zone(new Rect(area.left() - 1, area.top() -1, area.right() + 1, area.bottom() + 1), 0, 0));
		return zones;
	}

	private static ArrayList<Zone> generateMoveDownCollisionZones(Zone area) {
		// TODO Auto-generated method stub
		ArrayList<Zone> zones = new ArrayList<Zone>();
		zones.add(area.deepClone());		
		return zones;
	}
}
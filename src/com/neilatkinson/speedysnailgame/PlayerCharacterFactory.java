package com.neilatkinson.speedysnailgame;

import java.util.ArrayList;

import android.graphics.Rect;

import com.neilatkinson.framework.Image;
import com.neilatkinson.gameobject.Animation;
import com.neilatkinson.gameobject.GameObject;
import com.neilatkinson.gameobject.Zone;

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
		int passiveDuration = 1000;
		Zone area = new Zone(new Rect(centerX - 61, centerY - 63, centerX + 61, centerY + 63), 0, 0);
		int areaWidth = area.width();
		int areaHeight = area.height();

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


		// moveUpAnimation
	    frameImage = Assets.character;
		duration = 1250;
		ArrayList<Zone> moveUpCollisionZones = generateCollisionZones(centerX, centerY);
		ArrayList<Zone> moveUpDamageZones = generateDamageZones(centerX, centerY);
	    ArrayList<Zone> moveUpAttackZones = generateAttackZones(centerX, centerY);
		moveUpAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				moveUpAttackZones, moveUpAttackZones, moveUpAttackZones);
	    
	    frameImage = Assets.character2;
		duration = 50;
		moveUpAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				moveUpAttackZones, moveUpAttackZones, moveUpAttackZones);
	    
	    frameImage = Assets.character3;
		duration = 50;
		moveUpAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				moveUpAttackZones, moveUpAttackZones, moveUpAttackZones);
	    
	    frameImage = Assets.character2;
		duration = 1000;
		moveUpAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				moveUpCollisionZones, moveUpDamageZones, moveUpAttackZones);


		// moveLeftAnimation
		ArrayList<Zone> moveLeftCollisionZones = generateCollisionZones(centerX, centerY);
		ArrayList<Zone> moveLeftDamageZones = generateDamageZones(centerX, centerY);
	    ArrayList<Zone> moveLeftAttackZones = generateAttackZones(centerX, centerY);
	    frameImage = Assets.character;
		duration = 1250;
		moveLeftAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				moveLeftCollisionZones, moveLeftDamageZones, moveLeftAttackZones);
	    
	    frameImage = Assets.character2;
		duration = 50;
		moveLeftAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				moveLeftCollisionZones, moveLeftDamageZones, moveLeftAttackZones);
	    
	    frameImage = Assets.character3;
		duration = 50;
		moveLeftAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				moveLeftCollisionZones, moveLeftDamageZones, moveLeftAttackZones);
	    
	    frameImage = Assets.character2;
		duration = 1000;
		moveLeftAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				moveLeftCollisionZones, moveLeftDamageZones, moveLeftAttackZones);


		// moveDownAnimation
		ArrayList<Zone> moveDownCollisionZones = generateCollisionZones(centerX, centerY);
		ArrayList<Zone> moveDownDamageZones = generateDamageZones(centerX, centerY);
	    ArrayList<Zone> moveDownAttackZones = generateAttackZones(centerX, centerY);
	    frameImage = Assets.character;
		duration = 1250;
		moveDownAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				moveDownCollisionZones, moveDownDamageZones, moveDownAttackZones);
	    
	    frameImage = Assets.character2;
		duration = 50;
		moveDownAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				moveDownCollisionZones, moveDownDamageZones, moveDownAttackZones);
	    
	    frameImage = Assets.character3;
		duration = 50;
		moveDownAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				moveDownCollisionZones, moveDownDamageZones, moveDownAttackZones);
	    
	    frameImage = Assets.character2;
		duration = 1000;
		moveDownAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				moveDownCollisionZones, moveDownDamageZones, moveDownAttackZones);

	    
		// moveRightAnimation
		ArrayList<Zone> moveRightCollisionZones = generateCollisionZones(centerX, centerY);
		ArrayList<Zone> moveRightDamageZones = generateDamageZones(centerX, centerY);
	    ArrayList<Zone> moveRightAttackZones = generateAttackZones(centerX, centerY);
	    frameImage = Assets.character;
		duration = 1250;
		moveRightAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				moveRightCollisionZones, moveRightDamageZones, moveRightAttackZones);
	    
	    frameImage = Assets.character2;
		duration = 50;
		moveRightAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				moveRightCollisionZones, moveRightDamageZones, moveRightAttackZones);
	    
	    frameImage = Assets.character3;
		duration = 50;
		moveRightAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				moveRightCollisionZones, moveRightDamageZones, moveRightAttackZones);
	    
	    frameImage = Assets.character2;
		duration = 1000;
		moveRightAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				moveRightCollisionZones, moveRightDamageZones, moveRightAttackZones);

	    
		// faceUpAnimation
		ArrayList<Zone> faceUpCollisionZones = generateCollisionZones(centerX, centerY);
		ArrayList<Zone> faceUpDamageZones = generateDamageZones(centerX, centerY);
	    ArrayList<Zone> faceUpAttackZones = generateAttackZones(centerX, centerY);
	    frameImage = Assets.character;
		duration = 1250;
		faceUpAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				faceUpCollisionZones, faceUpDamageZones, faceUpAttackZones);
	    
	    frameImage = Assets.character2;
		duration = 50;
		faceUpAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				faceUpCollisionZones, faceUpDamageZones, faceUpAttackZones);
	    
	    frameImage = Assets.character3;
		duration = 50;
		faceUpAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				faceUpCollisionZones, faceUpDamageZones, faceUpAttackZones);
	    
	    frameImage = Assets.character2;
		duration = 1000;
		faceUpAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				faceUpCollisionZones, faceUpDamageZones, faceUpAttackZones);


		// faceLeftAnimation
		ArrayList<Zone> faceLeftCollisionZones = generateCollisionZones(centerX, centerY);
		ArrayList<Zone> faceLeftDamageZones = generateDamageZones(centerX, centerY);
	    ArrayList<Zone> faceLeftAttackZones = generateAttackZones(centerX, centerY);
	    frameImage = Assets.character;
		duration = 1250;
		faceLeftAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				faceLeftCollisionZones, faceLeftDamageZones, faceLeftAttackZones);
	    
	    frameImage = Assets.character2;
		duration = 50;
		faceLeftAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				faceLeftCollisionZones, faceLeftDamageZones, faceLeftAttackZones);
	    
	    frameImage = Assets.character3;
		duration = 50;
		faceLeftAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				faceLeftCollisionZones, faceLeftDamageZones, faceLeftAttackZones);
	    
	    frameImage = Assets.character2;
		duration = 1000;
		faceLeftAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				faceLeftCollisionZones, faceLeftDamageZones, faceLeftAttackZones);

	    
		// faceDownAnimation
		ArrayList<Zone> faceDownCollisionZones = generateCollisionZones(centerX, centerY);
		ArrayList<Zone> faceDownDamageZones = generateDamageZones(centerX, centerY);
	    ArrayList<Zone> faceDownAttackZones = generateAttackZones(centerX, centerY);
	    frameImage = Assets.character;
		duration = 1250;
		faceDownAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				faceDownCollisionZones, faceDownDamageZones, faceDownAttackZones);
	    
	    frameImage = Assets.character2;
		duration = 50;
		faceDownAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				faceDownCollisionZones, faceDownDamageZones, faceDownAttackZones);
	    
	    frameImage = Assets.character3;
		duration = 50;
		faceDownAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				faceDownCollisionZones, faceDownDamageZones, faceDownAttackZones);
	    
	    frameImage = Assets.character2;
		duration = 1000;
		faceDownAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				faceDownCollisionZones, faceDownDamageZones, faceDownAttackZones);

	    
		// faceRightAnimation
		ArrayList<Zone> faceRightCollisionZones = generateCollisionZones(centerX, centerY);
		ArrayList<Zone> faceRightDamageZones = generateDamageZones(centerX, centerY);
	    ArrayList<Zone> faceRightAttackZones = generateAttackZones(centerX, centerY);
	    frameImage = Assets.character;
		duration = 1250;
		faceRightAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				faceRightCollisionZones, faceRightDamageZones, faceRightAttackZones);
	    
	    frameImage = Assets.character2;
		duration = 50;
		faceRightAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				faceRightCollisionZones, faceRightDamageZones, faceRightAttackZones);
	    
	    frameImage = Assets.character3;
		duration = 50;
		faceRightAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				faceRightCollisionZones, faceRightDamageZones, faceRightAttackZones);
	    
	    frameImage = Assets.character2;
		duration = 1000;
		faceRightAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				faceRightCollisionZones, faceRightDamageZones, faceRightAttackZones);

		Animation currentAnimation = faceRightAnimation;
		
		PlayerCharacter playerCharacter = 
				new PlayerCharacter(
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
	
	
	private static ArrayList<Zone> generateCollisionZones(int centerX, int centerY) {
		ArrayList<Zone> zones = new ArrayList<Zone>();

		Rect rect = new Rect(centerX - 34, centerY - 63, centerX + 34, centerY);
	    Rect rect2 = new Rect(rect.left, rect.top + 63, rect.left + 68, rect.top + 126);
	    Rect rect3 = new Rect(rect.left - 26, rect.top + 32, rect.left, rect.top + 52);
	    Rect rect4 = new Rect(rect.left + 68, rect.top + 32, rect.left + 94, rect.top + 52);
	    Rect footleft = new Rect(centerX - 50, rect2.bottom - 15, centerX, rect2.bottom);
	    Rect footright = new Rect(centerX, rect2.bottom - 15, centerX + 50, rect2.bottom);

		zones.add(new Zone(rect, rect.centerX() - centerX, rect.centerY() - centerY));
		zones.add(new Zone(rect2, rect2.centerX() - centerX, rect2.centerY() - centerY));
		zones.add(new Zone(rect3, rect3.centerX() - centerX, rect3.centerY() - centerY));
		zones.add(new Zone(rect4, rect4.centerX() - centerX, rect4.centerY() - centerY));
		zones.add(new Zone(footleft, footleft.centerX() - centerX, footleft.centerY() - centerY));
		zones.add(new Zone(footright, footright.centerX() - centerX, footright.centerY() - centerY));
		
		return zones;
	}
	
	private static ArrayList<Zone> generateAttackZones(int centerX, int centerY) {
		ArrayList<Zone> zones = new ArrayList<Zone>();

		Rect rect = new Rect(centerX - 34, centerY - 63, centerX + 34, centerY);
	    Rect rect2 = new Rect(rect.left, rect.top + 63, rect.left + 68, rect.top + 126);
	    Rect rect3 = new Rect(rect.left - 26, rect.top + 32, rect.left, rect.top + 52);
	    Rect rect4 = new Rect(rect.left + 68, rect.top + 32, rect.left + 94, rect.top + 52);
	    Rect footleft = new Rect(centerX - 50, rect2.bottom - 15, centerX, rect2.bottom);
	    Rect footright = new Rect(centerX, rect2.bottom - 15, centerX + 50, rect2.bottom);
	    
	    Rect _rect = new Rect(rect.left - 1, rect.top - 1, rect.right + 1, rect.bottom + 1);
	    Rect _rect2 = new Rect(rect2.left - 1, rect2.top - 1, rect2.right + 1, rect2.bottom + 1);
	    Rect _rect3 = new Rect(rect3.left - 1, rect3.top - 1, rect3.right + 1, rect3.bottom + 1);
	    Rect _rect4 = new Rect(rect4.left - 1, rect4.top - 1, rect4.right + 1, rect4.bottom + 1);
	    Rect _footleft = new Rect(footleft.left - 1, footleft.top - 1, footleft.right + 1, footleft.bottom + 1);
	    Rect _footright = new Rect(footright.left - 1, footright.top - 1, footright.right + 1, footright.bottom + 1);

	    zones.add(new Zone(_rect, rect.centerX() - centerX, rect.centerY() - centerY));
		zones.add(new Zone(_rect2, rect2.centerX() - centerX, rect2.centerY() - centerY));
		zones.add(new Zone(_rect3, rect3.centerX() - centerX, rect3.centerY() - centerY));
		zones.add(new Zone(_rect4, rect4.centerX() - centerX, rect4.centerY() - centerY));
		zones.add(new Zone(_footleft, footleft.centerX() - centerX, footleft.centerY() - centerY));
		zones.add(new Zone(_footright, footright.centerX() - centerX, footright.centerY() - centerY));
		
		return zones;
	}
	
	private static ArrayList<Zone> generateDamageZones(int centerX, int centerY) {
		ArrayList<Zone> zones = new ArrayList<Zone>();

		Rect rect = new Rect(centerX - 34, centerY - 63, centerX + 34, centerY);
	    Rect rect2 = new Rect(rect.left, rect.top + 63, rect.left + 68, rect.top + 126);
	    Rect rect3 = new Rect(rect.left - 26, rect.top + 32, rect.left, rect.top + 52);
	    Rect rect4 = new Rect(rect.left + 68, rect.top + 32, rect.left + 94, rect.top + 52);
	    Rect footleft = new Rect(centerX - 50, rect2.bottom - 15, centerX, rect2.bottom);
	    Rect footright = new Rect(centerX, rect2.bottom - 15, centerX + 50, rect2.bottom);
	    
	    Rect _rect = new Rect(rect.left - 1, rect.top - 1, rect.right + 1, rect.bottom + 1);
	    Rect _rect2 = new Rect(rect2.left - 1, rect2.top - 1, rect2.right + 1, rect2.bottom + 1);
	    Rect _rect3 = new Rect(rect3.left - 1, rect3.top - 1, rect3.right + 1, rect3.bottom + 1);
	    Rect _rect4 = new Rect(rect4.left - 1, rect4.top - 1, rect4.right + 1, rect4.bottom + 1);
	    Rect _footleft = new Rect(footleft.left - 1, footleft.top - 1, footleft.right + 1, footleft.bottom + 1);
	    Rect _footright = new Rect(footright.left - 1, footright.top - 1, footright.right + 1, footright.bottom + 1);

	    zones.add(new Zone(_rect, rect.centerX() - centerX, rect.centerY() - centerY));
		zones.add(new Zone(_rect2, rect2.centerX() - centerX, rect2.centerY() - centerY));
		zones.add(new Zone(_rect3, rect3.centerX() - centerX, rect3.centerY() - centerY));
		zones.add(new Zone(_rect4, rect4.centerX() - centerX, rect4.centerY() - centerY));
		zones.add(new Zone(_footleft, footleft.centerX() - centerX, footleft.centerY() - centerY));
		zones.add(new Zone(_footright, footright.centerX() - centerX, footright.centerY() - centerY));
		
		return zones;
	}

}

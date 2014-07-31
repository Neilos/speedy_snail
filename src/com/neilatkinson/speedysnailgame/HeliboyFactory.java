package com.neilatkinson.speedysnailgame;

import java.util.ArrayList;

import android.graphics.Rect;

import com.neilatkinson.framework.Image;
import com.neilatkinson.gameobject.Animation;
import com.neilatkinson.gameobject.GameObject;
import com.neilatkinson.gameobject.Zone;

public class HeliboyFactory {
	
	public static Heliboy build(GameScreen gameScreen, int centerX, int centerY) {
		GameObject playerCharacter = gameScreen.getPlayerCharacter();
		int moveSpeed = 1;
		int speedX = 0;
		int speedY = 0;
		int health = 1;
		int damage = 1;
		boolean isDead = false;
		boolean isMovingUp = false;
		boolean isMovingLeft = false;
		boolean isMovingDown = false;
		boolean isMovingRight = false;
		Zone area = new Zone(new Rect(centerX - 46, centerY - 48, centerX + 48, centerY + 48), 0, 0);
		int areaWidth = area.width();
		int areaHeight = area.height();
		int passiveDuration = 5000;

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

		Image frameImage;
		int duration;
		ArrayList<Zone> collisionZones = generateCollisionZones(area);
		ArrayList<Zone> damageZones = generateDamageZones(area);
	    ArrayList<Zone> attackZones = generateAttackZones(area);

		// moveUpAnimation
	    frameImage = Assets.heliboy;
		duration = 100;
		moveUpAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration,
				collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.heliboy2;
		duration = 100;
		moveUpAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.heliboy3;
		duration = 100;
		moveUpAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.heliboy4;
		duration = 100;
		moveUpAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
		
		frameImage = Assets.heliboy5;
		duration = 100;
		moveUpAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
		
		frameImage = Assets.heliboy4;
		duration = 100;
		moveUpAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
		
		frameImage = Assets.heliboy3;
		duration = 100;
		moveUpAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.heliboy2;
		duration = 100;
		moveUpAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
		
		
		// moveLeftAnimation
	    frameImage = Assets.heliboy;
		duration = 100;
		moveLeftAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.heliboy2;
		duration = 100;
		moveLeftAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.heliboy3;
		duration = 100;
		moveLeftAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.heliboy4;
		duration = 100;
		moveLeftAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
		
		frameImage = Assets.heliboy5;
		duration = 100;
		moveLeftAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
		
		frameImage = Assets.heliboy4;
		duration = 100;
		moveLeftAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
		
		frameImage = Assets.heliboy3;
		duration = 100;
		moveLeftAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.heliboy2;
		duration = 100;
		moveLeftAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
		
		
		// moveDownAnimation
	    frameImage = Assets.heliboy;
		duration = 100;
		moveDownAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.heliboy2;
		duration = 100;
		moveDownAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.heliboy3;
		duration = 100;
		moveDownAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.heliboy4;
		duration = 100;
		moveDownAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
		
		frameImage = Assets.heliboy5;
		duration = 100;
		moveDownAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
		
		frameImage = Assets.heliboy4;
		duration = 100;
		moveDownAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
		
		frameImage = Assets.heliboy3;
		duration = 100;
		moveDownAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.heliboy2;
		duration = 100;
		moveDownAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
		
		
		// moveRightAnimation
	    frameImage = Assets.heliboy;
		duration = 100;
		moveRightAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.heliboy2;
		duration = 100;
		moveRightAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.heliboy3;
		duration = 100;
		moveRightAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
	    
	    frameImage = Assets.heliboy4;
		duration = 100;
		moveRightAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
		
		frameImage = Assets.heliboy5;
		duration = 100;
		moveRightAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
		
		frameImage = Assets.heliboy4;
		duration = 100;
		moveRightAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
		
		frameImage = Assets.heliboy3;
		duration = 100;
		moveRightAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);

		frameImage = Assets.heliboy2;
		duration = 100;
		moveRightAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);


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

		return heliboy;
	}
	
	private static ArrayList<Zone> generateCollisionZones(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		zones.add(area.deepClone());		
		return zones;
	}
	
	private static ArrayList<Zone> generateAttackZones(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		zones.add(new Zone(new Rect(area.left() - 1, area.top() -1, area.right() + 1, area.bottom() + 1), 0, 0));
		return zones;
	}
	
	private static ArrayList<Zone> generateDamageZones(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		zones.add(new Zone(new Rect(area.left() - 1, area.top() -1, area.right() + 1, area.bottom() + 1), 0, 0));
		return zones;
	}

}

	package com.neilatkinson.speedysnailgame;

import java.util.ArrayList;

import android.graphics.Rect;

import com.neilatkinson.framework.Image;
import com.neilatkinson.gameobject.Animation;
import com.neilatkinson.gameobject.GameObject;
import com.neilatkinson.gameobject.Zone;

public class TileFactory {
	
	public static Tile build(GameScreen gameScreen, int centerX, int centerY, int type) {
		int moveSpeed = 0;
		int speedX = 0;
		int speedY = 0;
		int health = 1;
		int damage = 1;
		boolean isDead = false;
		boolean isMovingUp = false;
		boolean isMovingLeft = false;
		boolean isMovingDown = false;
		boolean isMovingRight = false;
		Zone area = new Zone(new Rect(centerX - 20, centerY - 20, centerX + 20, centerY + 20), 0, 0);
		int areaWidth = area.width();
		int areaHeight = area.height();
		int passiveDuration = 3000;
		
		ArrayList<Class<? extends GameObject>> damageableTypes = new ArrayList<Class<? extends GameObject>>();
		
		ArrayList<Class<? extends GameObject>> collidableTypes = new ArrayList<Class<? extends GameObject>>();
		collidableTypes.add(PlayerCharacter.class);
		
		int duration;
		ArrayList<Zone> collisionZones = generateCollisionZones(area);
		ArrayList<Zone> damageZones = generateDamageZones(area);
	    ArrayList<Zone> attackZones = generateAttackZones(area);

		Animation moveUpAnimation = new Animation();
		Animation moveLeftAnimation = new Animation();
		Animation moveDownAnimation = new Animation();
		Animation moveRightAnimation = new Animation();

		Animation faceUpAnimation = new Animation();
		Animation faceLeftAnimation = new Animation();
		Animation faceDownAnimation = new Animation();
		Animation faceRightAnimation = new Animation();

		Image frameImage = null;
		if (type == 5) {
			frameImage = Assets.tiledirt;
        } else if (type == 8) {
        	frameImage = Assets.tilegrassTop;
        } else if (type == 4) {
        	frameImage = Assets.tilegrassLeft;
        } else if (type == 6) {
        	frameImage = Assets.tilegrassRight;
        } else if (type == 2) {
        	frameImage = Assets.tilegrassBot;
        } else {
            type = 0;
        }

		// moveUpAnimation
		duration = 1000;
		moveUpAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);

		// moveLeftAnimation
		duration = 1000;
		moveLeftAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);

		// moveDownAnimation
		duration = 1000;
		moveDownAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);

		// moveRightAnimation
		duration = 1000;
		moveRightAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);


		// faceUpAnimation
		duration = 1000;
		faceUpAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
	    
		// faceLeftAnimation
		duration = 1000;
		faceLeftAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);
	    
		// faceDownAnimation
		duration = 1000;
		faceDownAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);

		// faceRightAnimation
		duration = 1000;
		faceRightAnimation.addFrame(frameImage, 0, 0, areaWidth, areaHeight, duration, collisionZones, damageZones, attackZones);

		Animation currentAnimation = faceLeftAnimation;

		if (type != 0) {
		
			Tile tile = new Tile(
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
	
			return tile;
		} else {
			return null;
		}
	}
	
	private static ArrayList<Zone> generateCollisionZones(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		zones.add(new Zone(new Rect(area.left() + 1, area.top() + 1, area.right() - 1, area.bottom() - 1), 0, 0));
		return zones;
	}
	
	private static ArrayList<Zone> generateAttackZones(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		zones.add(area.deepClone());
		return zones;
	}
	
	private static ArrayList<Zone> generateDamageZones(Zone area) {
		ArrayList<Zone> zones = new ArrayList<Zone>();
		zones.add(area.deepClone());
		return zones;
	}
}

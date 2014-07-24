package com.neilatkinson.speedysnailgame;

import java.util.ArrayList;

import android.graphics.Rect;

import com.neilatkinson.framework.Image;
import com.neilatkinson.gameobject.Animation;
import com.neilatkinson.gameobject.GameObject;

public class TileFactory {
	
	public static Tile build(GameScreen gameScreen, int centerX, int centerY, int type) {
		GameObject playerCharacter = gameScreen.getPlayerCharacter();
		int moveSpeed = 0;
		int speedX = 0;
		int speedY = 0;
		int health = 1;
		boolean isDead = false;
		boolean isMovingUp = false;
		boolean isMovingLeft = false;
		boolean isMovingDown = false;
		boolean isMovingRight = false;
		Rect vicinity;
		
		int duration;
		ArrayList<Rect> collisionZones = new ArrayList<Rect>();
		ArrayList<Rect> damageZones = new ArrayList<Rect>();
	    ArrayList<Rect> attackZones = new ArrayList<Rect>();

		Animation moveUpAnimation = new Animation();
		Animation moveLeftAnimation = new Animation();
		Animation moveDownAnimation = new Animation();
		Animation moveRightAnimation = new Animation();

		Animation faceUpAnimation = new Animation();
		Animation faceLeftAnimation = new Animation();
		Animation faceDownAnimation = new Animation();
		Animation faceRightAnimation = new Animation();

	    vicinity = new Rect(centerX - 48, centerY - 48, centerX + 48, centerY + 48);

	    collisionZones.add(vicinity);
		damageZones.add(vicinity);
	    attackZones.add(vicinity);

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
		duration = 100;
		moveUpAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
	    
		// moveLeftAnimation
		duration = 100;
		moveLeftAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);
	    
		// moveDownAnimation
		duration = 100;
		moveDownAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);

		// moveRightAnimation
		duration = 100;
		moveRightAnimation.addFrame(frameImage, duration, collisionZones, damageZones, attackZones);


		faceUpAnimation = moveUpAnimation;
		faceLeftAnimation = moveLeftAnimation;
		faceDownAnimation = moveDownAnimation;
		faceRightAnimation = moveRightAnimation;
		
		Animation currentAnimation = faceLeftAnimation;
		
		if (type != 0) {
		
			Tile tile = new Tile(
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
							currentAnimation);
	
			return tile;
		} else {
			return null;
		}
	}
}
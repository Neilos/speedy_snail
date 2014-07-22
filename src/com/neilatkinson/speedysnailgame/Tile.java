package com.neilatkinson.speedysnailgame;

import android.graphics.Rect;

import com.neilatkinson.gameobject.Animation;
import com.neilatkinson.gameobject.Damageable;
import com.neilatkinson.gameobject.GameObject;

public class Tile extends GameObject{

	private PlayerCharacter playerCharacter;

    public Tile(GameScreen gameScreen, GameObject playerCharacter, int centerX,
			int centerY, int moveSpeed, int speedX, int speedY, Rect vicinity,
			int health, boolean isDead, boolean isMovingUp,
			boolean isMovingLeft, boolean isMovingDown, boolean isMovingRight,
			Animation moveUpAnimation, Animation moveLeftAnimation,
			Animation moveDownAnimation, Animation moveRightAnimation,
			Animation faceUpAnimation, Animation faceLeftAnimation,
			Animation faceDownAnimation, Animation faceRightAnimation,
			Animation currentAnimation) {

    	super(gameScreen, centerX, centerY, moveSpeed, speedX, speedY,
				vicinity, health, isDead, isMovingUp, isMovingLeft, isMovingDown,
				isMovingRight, moveUpAnimation, moveLeftAnimation, moveDownAnimation,
				moveRightAnimation, faceUpAnimation, faceLeftAnimation,
				faceDownAnimation, faceRightAnimation, currentAnimation);
    	
    	this.playerCharacter = gameScreen.getPlayerCharacter();

	}


    public void update() {
        move();
//        vicinity.set(centerX(), centerY(), centerX()+40, centerY()+40);

//        if (Rect.intersects(vicinity, playerCharacter.getVicinity()) && type != 0) {
//            checkVerticalCollision(playerCharacter.rect, playerCharacter.rect2);
//            checkSideCollision(playerCharacter.rect3, playerCharacter.rect4, playerCharacter.footleft, playerCharacter.footright);
//        }
    }

//    public void checkVerticalCollision(Rect rtop, Rect rbot) {
//        if (Rect.intersects(rtop, vicinity)) {
//        	playerCharacter.setSpeedY(0);
//        }
//
//        if (Rect.intersects(rbot, vicinity) && type == 8) {
//            playerCharacter.setSpeedY(0);
//            playerCharacter.setCenterY(centerY() - 63);
//        }
//    }

//    public void checkSideCollision(Rect rleft, Rect rright, Rect leftfoot, Rect rightfoot) {
//        if (type != 5 && type != 2 && type != 0){
//            if (Rect.intersects(rleft, vicinity)) {
//                playerCharacter.setCenterX(centerX() + 102);
//    
//                playerCharacter.setSpeedX(0);
//    
//            }else if (Rect.intersects(leftfoot, vicinity)) {
//                
//                playerCharacter.setCenterX(centerX() + 85);
//                playerCharacter.setSpeedX(0);
//            }
//            
//            if (Rect.intersects(rright, vicinity)) {
//                playerCharacter.setCenterX(centerX() - 62);
//    
//                playerCharacter.setSpeedX(0);
//            }
//            
//            else if (Rect.intersects(rightfoot, vicinity)) {
//                playerCharacter.setCenterX(centerX() - 45);
//                playerCharacter.setSpeedX(0);
//            }
//        }
//    }

	@Override
	public void attack(Damageable damageable) {

	}

	@Override
	public void takeDamage(int damage) {

	}

	@Override
	public void heal(int damage) {

	}

	@Override
	public void die() {

	}

}

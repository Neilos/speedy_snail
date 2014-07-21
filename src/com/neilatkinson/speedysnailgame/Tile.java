package com.neilatkinson.speedysnailgame;

import android.graphics.Rect;

import com.neilatkinson.framework.Image;
import com.neilatkinson.gameobject.Animation;
import com.neilatkinson.gameobject.Damageable;
import com.neilatkinson.gameobject.GameObject;

public class Tile extends GameObject{

    public int type;
    public Image tileImage;
    private PlayerCharacter robot;
    private Rect r;
    
    public Tile(
    		GameScreen gameScreen,
	    	int moveSpeed, 
			int startingCenterX, 
			int startingCenterY,
			int typeInt) {

    	super(gameScreen,
			moveSpeed,
			startingCenterX, startingCenterY);
    	robot = gameScreen.getPlayerCharacter();

        type = typeInt;

        r = new Rect();

        if (type == 5) {
            tileImage = Assets.tiledirt;
        } else if (type == 8) {
            tileImage = Assets.tilegrassTop;
        } else if (type == 4) {
            tileImage = Assets.tilegrassLeft;
        } else if (type == 6) {
            tileImage = Assets.tilegrassRight;
        } else if (type == 2) {
            tileImage = Assets.tilegrassBot;
        } else {
            type = 0;
        }

    }
    
    @Override
	public void setUpAnimations() {
		currentAnimation = new Animation();

		moveUpAnimation = new Animation();
		moveLeftAnimation = new Animation();
		moveDownAnimation = new Animation();
		moveRightAnimation = new Animation();

		stationaryFacingUpAnimation = new Animation();
		stationaryFacingLeftAnimation = new Animation();
		stationaryFacingDownAnimation = new Animation();
		stationaryFacingRightAnimation = new Animation();
		
		moveUpAnimation.addFrame(tileImage, 1000, null ,null ,null , null);
		moveLeftAnimation = moveUpAnimation;
		moveDownAnimation = moveUpAnimation;
		moveRightAnimation = moveUpAnimation;

		stationaryFacingUpAnimation = moveUpAnimation;
		stationaryFacingLeftAnimation = moveUpAnimation;
		stationaryFacingDownAnimation = moveUpAnimation;
		stationaryFacingRightAnimation = moveUpAnimation;
		
		currentAnimation = stationaryFacingRightAnimation;
	}

    public void update() {
        move();
        r.set(centerX, centerY, centerX+40, centerY+40);

        if (Rect.intersects(r, robot.yellowRed) && type != 0) {
            checkVerticalCollision(robot.rect, robot.rect2);
            checkSideCollision(robot.rect3, robot.rect4, robot.footleft, robot.footright);
        }
    }

    @Override
    public Image getImage() {
        return tileImage;
    }

    public void setTileImage(Image tileImage) {
        this.tileImage = tileImage;
    }

    public void checkVerticalCollision(Rect rtop, Rect rbot) {
        if (Rect.intersects(rtop, r)) {
        	robot.setSpeedY(0);
        }

        if (Rect.intersects(rbot, r) && type == 8) {
            robot.setSpeedY(0);
            robot.setCenterY(centerY - 63);
        }
    }

    public void checkSideCollision(Rect rleft, Rect rright, Rect leftfoot, Rect rightfoot) {
        if (type != 5 && type != 2 && type != 0){
            if (Rect.intersects(rleft, r)) {
                robot.setCenterX(centerX + 102);
    
                robot.setSpeedX(0);
    
            }else if (Rect.intersects(leftfoot, r)) {
                
                robot.setCenterX(centerX + 85);
                robot.setSpeedX(0);
            }
            
            if (Rect.intersects(rright, r)) {
                robot.setCenterX(centerX - 62);
    
                robot.setSpeedX(0);
            }
            
            else if (Rect.intersects(rightfoot, r)) {
                robot.setCenterX(centerX - 45);
                robot.setSpeedX(0);
            }
        }
    }

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

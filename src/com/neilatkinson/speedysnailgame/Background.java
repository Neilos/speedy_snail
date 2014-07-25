package com.neilatkinson.speedysnailgame;

public class Background {
	
	private int bgX, bgY;
	private int speedX, speedY;
	private int width;
	private int height;

	public Background(int x, int y, int width, int height){
        bgX = x;
        bgY = y;
        this.width = width;
        this.height = height;
        speedX = 0;
        speedY = 0;
    }
	
    public void update() {
        bgX += getSpeedX();
        if (bgX <= -width){
            bgX += 2 * width;
        } else if (bgX >= width) {
        	bgX -= 2 * width;
        }

        bgY += getSpeedY();
        if (bgY <= -height){
            bgY += 2 * height;
        } else if (bgY >= height) {
        	bgY -= 2 * height;
        }
    }
    
    public int getBgX() {
        return bgX;
    }

    
    public int getBgY() {
        return bgY;
    }

    
    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    
    public void setBgX(int bgX) {
        this.bgX = bgX;
    }

    
    public void setBgY(int bgY) {
        this.bgY = bgY;
    }

    
    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }


	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

}

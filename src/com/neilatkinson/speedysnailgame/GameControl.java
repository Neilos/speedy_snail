package com.neilatkinson.speedysnailgame;

import com.neilatkinson.framework.Graphics;
import com.neilatkinson.framework.Image;
import com.neilatkinson.framework.Input.TouchEvent;

public class GameControl {

	protected Image image;
	protected int positionX;
	protected int positionY;
	protected int width;
	protected int height;
	private int sourceX;
	private int sourceY;

	public GameControl(GameScreen gameScreen, Image image, int x, int y, int srcX, int srcY, int width, int height) {
		this.image = image;
		this.positionX = x;
		this.positionY = y;
		this.sourceX = srcX;
		this.sourceY = srcY;
		this.width = width;
		this.height = height;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public Image getImage() {
		return image;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	protected boolean inBounds(TouchEvent event, int x, int y,
			int width, int height) {
				if (event.x > x
					&& event.x < x + width - 1
					&& event.y > y
					&& event.y < y + height - 1)
					return true;
				else
					return false;
			}

	public void draw(Graphics g) {
		g.drawImage(getImage(), 
				positionX, positionY, 		// int x, int y, 
				sourceX, sourceY, 			// int srcX, int srcY,
				width, height); 			// int srcWidth, int srcHeight
	}

}
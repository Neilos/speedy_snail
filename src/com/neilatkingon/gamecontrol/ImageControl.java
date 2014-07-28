package com.neilatkingon.gamecontrol;

import com.neilatkinson.framework.Graphics;
import com.neilatkinson.framework.Image;

public class ImageControl extends GameControl{

	protected Image image;
	private int sourceX;
	private int sourceY;

	public ImageControl(Image image, int x, int y, int srcX, int srcY, int width, int height) {
		super(x,y,width,height);
		this.image = image;
		this.sourceX = srcX;
		this.sourceY = srcY;
	}

	public Image getImage() {
		return image;
	}

	public int sourceX() {
		return sourceX;
	}

	public int sourceY() {
		return sourceY;
	}

	@Override
	public void drawSelf(Graphics g) {
		g.drawImage(getImage(), 
				positionX(), positionY(), 		// int x, int y, 
				sourceX(), sourceY(), 			// int srcX, int srcY,
				width(), height()); 			// int srcWidth, int srcHeight
	}

}
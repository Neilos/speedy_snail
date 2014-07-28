package com.neilatkingon.gamecontrol;

import android.graphics.Rect;

import com.neilatkinson.framework.Graphics;

public class ScreenRegion extends GameControl {
	private Rect rectangle;

	public ScreenRegion(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.rectangle = new Rect(x, y, x + width, y + height);
	}
	
	public Rect rectangle(){
		return rectangle;
	}

	@Override
	public void drawSelf(Graphics g) {
		
	}

}

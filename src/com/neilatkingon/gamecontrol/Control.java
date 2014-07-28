package com.neilatkingon.gamecontrol;

import com.neilatkinson.framework.Graphics;

public interface Control {
	
	public void drawSelf(Graphics g);
	public int width();
	public int height();
	public int positionX();
	public int positionY();

}

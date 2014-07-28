package com.neilatkingon.gamecontrol;

import com.neilatkinson.framework.Graphics;
import com.neilatkinson.framework.Input.TouchEvent;

public abstract class GameControl implements Control{

	protected int positionX;
	protected int positionY;
	protected int width;
	protected int height;

	public GameControl(int x, int y, int width, int height) {
		this.positionX = x;
		this.positionY = y;
		this.width = width;
		this.height = height;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int positionX() {
		return positionX;
	}

	public int positionY() {
		return positionY;
	}

	public int width() {
		return width;
	}

	public int height() {
		return height;
	}
	
	protected boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
		if (event.x > x
			&& event.x < x + width - 1
			&& event.y > y
			&& event.y < y + height - 1)
			return true;
		else
			return false;
	}
	
	public boolean isTouched(TouchEvent event) {
		return inBounds(event, positionX(), positionY(), width(), height());
	}

	public boolean isTouchedUpInside(TouchEvent event) {
		if (event.type == TouchEvent.TOUCH_UP) {
			return isTouched(event);
		} else {
			return false;
		}
	}

	public boolean isTouchedDownInside(TouchEvent event) {
		if (event.type == TouchEvent.TOUCH_DOWN) {
			return isTouched(event);
		} else {
			return false;
		}
	}

	@Override
	public abstract void drawSelf(Graphics g);
}
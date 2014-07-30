package com.neilatkinson.gameobject;

import android.graphics.Rect;

public class Zone {

	private Rect rect;
	private int xOffsetFromObjectCenter;
	private int yOffsetFromObjectCenter;

	public Zone(Rect zoneArea, int xOffsetFromObjectCenter, int yOffsetFromObjectCenter) {
		this.rect = zoneArea;
		this.xOffsetFromObjectCenter = xOffsetFromObjectCenter;
		this.yOffsetFromObjectCenter = yOffsetFromObjectCenter;
	}
	
	public int xOffsetFromObjectCenter() {
		return xOffsetFromObjectCenter;
	}

	public int yOffsetFromObjectCenter() {
		return yOffsetFromObjectCenter;
	}

	public void offsetTo(int newObjectCenterX, int newObjectCenterY) {
		int newLeft = newObjectCenterX + xOffsetFromObjectCenter - width() / 2;
		int newTop = newObjectCenterY + yOffsetFromObjectCenter - height() / 2;
		rect.offsetTo(newLeft, newTop);
	}
	
	public void offset(int offsetX, int offsetY) {
		rect.offset(offsetX, offsetY);
	}
	
	public int left() {
		return rect.left;
	}
	
	public int bottom() {
		return rect.bottom;
	}
	
	public int top() {
		return rect.top;
	}
	
	public int right() {
		return rect.right;
	}

	public Rect rect() {
		return rect;
	}

	public int width() {
		return rect.width();
	}
	
	public int height() {
		return rect.height();
	}

	public int centerX() {
		return rect.centerX();
	}
	
	public int centerY() {
		return rect.centerY();
	}

	public Zone deepClone() {
		return new Zone(new Rect(rect), xOffsetFromObjectCenter, yOffsetFromObjectCenter);
	}

}

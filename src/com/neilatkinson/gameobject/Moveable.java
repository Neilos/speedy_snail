package com.neilatkinson.gameobject;

public interface Moveable {

	public void setMovingUp();
	public void setMovingLeft();
	public void setMovingDown();
	public void setMovingRight();
	public void setStopped();

	public boolean isMovingUp();
	public boolean isMovingLeft();
	public boolean isMovingDown();
	public boolean isMovingRight();

	public void move();

	public int speedX();
	public void setSpeedX(int speedX);
	public int speedY();
	public void setSpeedY(int speedY);
	
	public int centerX();
	public int centerY();
	public void updatePosition(int newCenterX, int newCenterY);

	public boolean nearTopOfScreen();
	public boolean nearLeftOfScreen();
	public boolean nearBottomOfScreen();
	public boolean nearRightOfScreen();

	public void moveUp();
	public void moveLeft();
	public void moveDown();
	public void moveRight();
	public void remainStationary();

}

package com.neilatkinson.gameobject;

public interface Moveable {

	public void setMovingUp();
	public void setMovingLeft();
	public void setMovingDown();
	public void setMovingRight();
	public void stop();

	public boolean isMovingUp();
	public boolean isMovingLeft();
	public boolean isMovingDown();
	public boolean isMovingRight();

	public void move();

	public int getSpeedX();
	public void setSpeedX(int speedX);
	public int getSpeedY();
	public void setSpeedY(int speedY);
	
	public int getCenterX();
	public void setCenterX(int centerX);
	public int getCenterY();
	public void setCenterY(int centerY);

	public boolean nearTopOfScreen();
	public boolean nearLeftOfScreen();
	public boolean nearBottomOfScreen();
	public boolean nearRightOfScreen();

}

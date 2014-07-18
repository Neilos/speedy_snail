package com.neilatkinson.gameobject;

public interface Moveable {

	public void moveUp();
	public void moveLeft();
	public void moveDown();
	public void moveRight();
	public void stop();

	public boolean isMovingUp();
	public boolean isMovingLeft();
	public boolean isMovingDown();
	public boolean isMovingRight();

	public int getSpeedX();
	public void setSpeedX(int speedX);
	public int getSpeedY();
	public void setSpeedY(int speedY);
	
	public int getCenterX();
	public void setCenterX(int centerX);
	public int getCenterY();
	public void setCenterY(int centerY);

}

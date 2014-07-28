package com.neilatkinson.framework;

public abstract class Screen {
	public final Game game;

	public Screen(Game game) {
		this.game = game;
	}

	public abstract void update(int elapsedTime);
	
	public abstract void paint(int elapsedTime);
	
	public abstract void pause();
	
	public abstract void resume();
	
	public abstract void dispose();
	
	public abstract void backButton();

	public int getWidth() {
		return game.getFrameBufferWidth();
	}

	public int getHeight() {
		return game.getFrameBufferHeight();
	}

	public void setBackgroundSpeedX(int xSpeed) {}
	public void setBackgroundSpeedY(int ySpeed) {}

	public int getBackgroundSpeedX() {
		return 0;
	}
	public int getBackgroundSpeedY() {
		return 0;
	}

}

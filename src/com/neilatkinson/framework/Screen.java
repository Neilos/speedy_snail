package com.neilatkinson.framework;

public abstract class Screen {
	protected final Game game;

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
		return game.getFrameBufferWidth();
	}

}

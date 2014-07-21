package com.neilatkinson.speedysnailgame;

import com.neilatkinson.framework.Game;
import com.neilatkinson.framework.Graphics;
import com.neilatkinson.framework.Graphics.ImageFormat;
import com.neilatkinson.framework.Screen;

public class SplashLoadingScreen extends Screen {

	public SplashLoadingScreen(Game game) {
		super(game);
	}

	@Override
	public void update(int elapsedTime) {
		 Graphics g = game.getGraphics();
		 Assets.splash = g.newImage("splash.jpg", ImageFormat.RGB565);

		 game.setScreen(new LoadingScreen(game));
	}

	@Override
	public void paint(int elapsedTime) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

	@Override
	public void backButton() {
	}

}

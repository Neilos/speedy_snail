package com.neilatkinson.speedysnailgame;

import java.util.List;

import com.neilatkingon.gamecontrol.ScreenRegion;
import com.neilatkinson.framework.Game;
import com.neilatkinson.framework.Graphics;
import com.neilatkinson.framework.Input.TouchEvent;
import com.neilatkinson.framework.Screen;

public class MainMenuScreen extends Screen {
	private ScreenRegion startGameButton;

	public MainMenuScreen(Game game) {
		super(game);
		this.startGameButton = new ScreenRegion(50, 350, 250, 450);
	}

	@Override
	public void update(int elapsedTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
                if (startGameButton.isTouchedUpInside(event)) {
                    //START GAME
                	game.setScreen(new GameScreen(game));               
                }
            }
        }
	}

	@Override
	public void paint(int elapsedTime) {
		Graphics g = game.getGraphics();
		g.drawImage(Assets.menu, 0, 0);
		startGameButton.drawSelf(g);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void backButton() {
		 android.os.Process.killProcess(android.os.Process.myPid());
	}

}

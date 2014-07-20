package com.neilatkinson.speedysnailgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import android.graphics.Color;
import android.graphics.Paint;

import com.neilatkinson.framework.Game;
import com.neilatkinson.framework.Graphics;
import com.neilatkinson.framework.Image;
import com.neilatkinson.framework.Input.TouchEvent;
import com.neilatkinson.framework.Screen;
import com.neilatkinson.gameobject.Animation;

public class GameScreen extends Screen {

	enum GameState {
		Ready, Running, Paused, GameOver
	}

	 GameState state = GameState.Ready;

    // Variable Setup
	private static Background bg1, bg2;
	private static DirectionControl directionControl;

	public ArrayList<Tile> tilearray = new ArrayList<Tile>();
	public ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	public PlayerCharacter playerCharacter;

    int livesLeft = 1;
    Paint paint, paint2;

	private PauseButton pauseButton;

    
    public GameScreen(Game game) {
        super(game);

        // Initialize game objects here
        bg1 = new Background(0, 0);
		bg2 = new Background(2160, 0);

		pauseButton = new PauseButton(Assets.directionControl, 0, 0, 0, 195, 35, 35);
		directionControl = new DirectionControl(Assets.directionControl, 10, 350, 0, 0, 120, 120);

		Animation anim = new Animation();
		anim.addFrame(Assets.character, 1250);
		anim.addFrame(Assets.character2, 50);
		anim.addFrame(Assets.character3, 50);
		anim.addFrame(Assets.character2, 50);

		Animation ducked = new Animation();
		ducked.addFrame(Assets.characterDown, 1000);

		Animation jumped = new Animation();
		jumped.addFrame(Assets.characterJump, 1000);

		playerCharacter = new PlayerCharacter(this, 10, 100, 377, jumped, anim, ducked, anim);

		Animation hanim = new Animation();
		hanim.addFrame(Assets.heliboy, 100);
		hanim.addFrame(Assets.heliboy2, 100);
		hanim.addFrame(Assets.heliboy3, 100);
		hanim.addFrame(Assets.heliboy4, 100);
		hanim.addFrame(Assets.heliboy5, 100);
		hanim.addFrame(Assets.heliboy4, 100);
		hanim.addFrame(Assets.heliboy3, 100);
		hanim.addFrame(Assets.heliboy2, 100);

		enemies.add(new Heliboy(this, 1, 340, 360, hanim, hanim, hanim, hanim, 5));
		enemies.add(new Heliboy(this, 1, 700, 360, hanim, hanim, hanim, hanim, 5));

		loadMap();

        // Defining a paint object
		paint = new Paint();
		paint.setTextSize(30);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setAntiAlias(true);
		paint.setColor(Color.WHITE);

		paint2 = new Paint();
		paint2.setTextSize(100);
		paint2.setTextAlign(Paint.Align.CENTER);
		paint2.setAntiAlias(true);
		paint2.setColor(Color.WHITE);
    }
 

	private void loadMap() {
		ArrayList<String> lines = new ArrayList<String>();
		int width = 0;
		int height = 0;

		Scanner scanner = new Scanner(SpeedySnailGame.map);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();

			// no more lines to read
			if (line == null) {
				break;
			}

			if (!line.startsWith("!")) {
				lines.add(line);
				width = Math.max(width, line.length());

			}
		}
		height = lines.size();
		int moveSpeed = 0;
		int startingCenterX;
		int startingCenterY;
		int type;
		Animation tileAnimation = new Animation();
		Image staticFrame;
		for (int j = 0; j < height; j++) {
			String line = (String) lines.get(j);
			for (int i = 0; i < width; i++) {

				if (i < line.length()) {
					startingCenterX = i * 40;
					startingCenterY = j * 40;
					char ch = line.charAt(i);
					
					type = Character.getNumericValue(ch);
					if (type == 5) {
						staticFrame = Assets.tiledirt;
			        } else if (type == 8) {
			        	staticFrame = Assets.tilegrassTop;
			        } else if (type == 4) {
			        	staticFrame = Assets.tilegrassLeft;
			        } else if (type == 6) {
			        	staticFrame = Assets.tilegrassRight;
			        } else if (type == 2) {
			        	staticFrame = Assets.tilegrassBot;
			        } else {
			            type = 0;
			            staticFrame = null;
			        }
					tileAnimation.addFrame(staticFrame, 1000);
					Tile t = new Tile(this, moveSpeed,
							startingCenterX, startingCenterY,
							tileAnimation, type);
					tilearray.add(t);
				}

			}
		}
		scanner.close();
	}

	
	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

        // We have four separate update methods in this example.
        // Depending on the state of the game, we call different update methods.

        if (state == GameState.Ready)
            updateReady(touchEvents);
        if (state == GameState.Running)
            updateRunning(touchEvents, deltaTime);
        if (state == GameState.Paused)
            updatePaused(touchEvents);
        if (state == GameState.GameOver)
            updateGameOver(touchEvents);
	}

	
	private void updateReady(List<TouchEvent> touchEvents) {
		// This example starts with a "Ready" screen.
        // When the user touches the screen, the game begins. 
        // state now becomes GameState.Running.
        // Now the updateRunning() method will be called!
        if (touchEvents.size() > 0)
            state = GameState.Running;
	}

	
	private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {

		// 1. All touch input is handled here:
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_DOWN) {
				
				if (directionControl.upButtonPressed(event)) {
					playerCharacter.setMovingUp();
				} else if (directionControl.leftButtonPressed(event)) {
					playerCharacter.setMovingLeft();
				} else if (directionControl.downButtonPressed(event)) {
					playerCharacter.setMovingDown();
				} else if (directionControl.rightButtonPressed(event)) {
					playerCharacter.setMovingRight();
				} else {  }
			}

			if (event.type == TouchEvent.TOUCH_UP) {
				if (pauseButton.isPressed(event)) {
					pause();
				} else {
					playerCharacter.stop();
				}
			}
		}

		// 2. Check miscellaneous events like death:
		if (livesLeft == 0) {
			state = GameState.GameOver;
		}

		// 3. Call individual update() methods here.
		// This is where all the game updates happen.
		// For example, playerCharacter.update();
		updatePlayerCharacter();
		updateTiles();
		updateEnemies();
		bg1.update();
		bg2.update();
		
		// if player has fallen down a hole game is over
		if (playerCharacter.getCenterY() > 500) {
			state = GameState.GameOver;
		}
	}


	private void updatePlayerCharacter() {
		playerCharacter.update();
		playerCharacter.animate(10);
	}


	private void updateEnemies() {
		for (int i = 0; i < enemies.size(); i++) {
			Enemy enemy = (Enemy) enemies.get(i);
			enemy.update();
			enemy.animate(50);
		}
	}

	
	private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
		if (event.x > x
			&& event.x < x + width - 1
			&& event.y > y
			&& event.y < y + height - 1)
			return true;
		else
			return false;
	}
	
	
	private void updateTiles() {
		for (int i = 0; i < tilearray.size(); i++) {
			Tile t = (Tile) tilearray.get(i);
			t.update();
			t.animate(50);
		}
	}

	
	private void updatePaused(List<TouchEvent> touchEvents) {
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {
				if (inBounds(event, 0, 0, 800, 240)) {

					if (!inBounds(event, 0, 0, 35, 35)) {
						resume();
					}
				}

				if (inBounds(event, 0, 240, 800, 240)) {
					nullify();
					goToMenu();
				}
			}
		}
	}

	
	private void updateGameOver(List<TouchEvent> touchEvents) {
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_DOWN) {
				if (inBounds(event, 0, 0, 800, 480)) {
					nullify();
					game.setScreen(new MainMenuScreen(game));
					return;
				}
			}
		}
	}

	
	private void nullify() {
		// Set all variables to null. We will be recreating them in the
        // constructor.
		paint = null;
		paint2 = null;
		bg1 = null;
		bg2 = null;
		playerCharacter = null;
		enemies = null;

        // Call garbage collector to clean up memory.
        System.gc();
	}

	
	@Override
	public void paint(float deltaTime) {
		Graphics g = game.getGraphics();
		
		// 1. draw the game elements.
        // Example:
        // g.drawImage(Assets.background, 0, 0);
        // g.drawImage(Assets.character, characterX, characterY);

		g.drawImage(Assets.background, bg1.getBgX(), bg1.getBgY());
		g.drawImage(Assets.background, bg2.getBgX(), bg2.getBgY());
		drawTiles(g);

		g.drawImage(playerCharacter.getImage(), playerCharacter.getCenterX() - 61,
				playerCharacter.getCenterY() - 63);
		drawEnemies(g);

        // 2. draw the UI above the game elements.
        if (state == GameState.Ready)
            drawReadyUI();
        if (state == GameState.Running)
            drawRunningUI();
        if (state == GameState.Paused)
            drawPausedUI();
        if (state == GameState.GameOver)
            drawGameOverUI();
	}


	private void drawEnemies(Graphics g) {
		for (int i = 0; i < enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			g.drawImage(enemy.getImage(), enemy.getCenterX() - 48, enemy.getCenterY() - 48);
		}
	}

	
	private void drawTiles(Graphics g) {
		for (int i = 0; i < tilearray.size(); i++) {
			Tile t = (Tile) tilearray.get(i);
			if (t.type != 0) {
				g.drawImage(t.getImage(), t.getCenterX(), t.getCenterY());
			}
		}
	}

	
	private void drawReadyUI() {
		Graphics g = game.getGraphics();
		g.drawARGB(155, 0, 0, 0);
		g.drawString("Tap to Start.", 400, 240, paint);
	}

	
	private void drawRunningUI() {
		Graphics g = game.getGraphics();
		directionControl.draw(g);
		g.drawImage(Assets.button, 0, 0, 0, 195, 35, 35);
	}

	
	private void drawPausedUI() {
		Graphics g = game.getGraphics();
        // Darken the entire screen so you we display the Paused screen.
		g.drawARGB(155, 0, 0, 0);
		g.drawString("Resume", 400, 165, paint2);
		g.drawString("Menu", 400, 360, paint2);
	}

	
	private void drawGameOverUI() {
		Graphics g = game.getGraphics();
        g.drawRect(0, 0, 1281, 801, Color.BLACK);
        g.drawString("GAME OVER.", 400, 240, paint2);
		g.drawString("Tap to return.", 400, 290, paint);
	}

	
	@Override
	public void pause() {
		if (state == GameState.Running)
			 state = GameState.Paused;
	}

	
	@Override
	public void resume() {
		if (state == GameState.Paused)
			state = GameState.Running;
	}

	
	@Override
	public void dispose() {

	}

	
	@Override
	public void backButton() {
		pause();
	}
	
	
	private void goToMenu() {
		game.setScreen(new MainMenuScreen(game));

	}

	
	public static Background getBg1() {
		return bg1;
	}

	
	public static Background getBg2() {
		return bg2;
	}

	
	public PlayerCharacter getPlayerCharacter() {
		return playerCharacter;
	}
}

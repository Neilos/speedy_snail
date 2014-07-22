package com.neilatkinson.speedysnailgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import com.neilatkinson.framework.Game;
import com.neilatkinson.framework.Graphics;
import com.neilatkinson.framework.Input.TouchEvent;
import com.neilatkinson.framework.Screen;
import com.neilatkinson.gameobject.GameObject;

public class GameScreen extends Screen {

	enum GameState {
		Ready, Running, Paused, GameOver
	}

	 GameState state = GameState.Ready;

    // Variable Setup
	private static Background bg1, bg2, bg3, bg4;
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
        bg1 = new Background(0, 0, 2160, 480);
		bg2 = new Background(2160, 0, 2160, 480);
		bg3 = new Background(0, 480, 2160, 480);
		bg4 = new Background(2160, 480, 2160, 480);

		pauseButton = new PauseButton(Assets.directionControl, 0, 0, 0, 195, 35, 35);
		directionControl = new DirectionControl(Assets.directionControl, 10, 350, 0, 0, 120, 120);

		playerCharacter = PlayerCharacterFactory.build(this, 100, 377);
		enemies.add(HeliboyFactory.build(this, 340, 360));
		enemies.add(HeliboyFactory.build(this, 700, 360));


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
		int startingCenterX, startingCenterY, type;
		char ch;
		String line;
		Tile tile;

		ArrayList<String> lines = loadLines();

		int height = lines.size();
		for (int j = 0; j < height; j++) {
			line = (String) lines.get(j);
			int width = line.length();
			for (int i = 0; i < width; i++) {
				if (i < line.length()) {
					startingCenterX = i * 40;
					startingCenterY = j * 40;
					ch = line.charAt(i);
					type = Character.getNumericValue(ch);
					tile = TileFactory.build(this, startingCenterX, startingCenterY, type);
					if (tile != null) {
						tilearray.add(tile);
					}
				}
			}
		}
	}


	private ArrayList<String> loadLines() {
		ArrayList<String> lines = new ArrayList<String>();
		Scanner scanner = new Scanner(SpeedySnailGame.map);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line == null) {
				// no more lines to read
				break;
			} else if (!line.startsWith("!")) {
				lines.add(line);
			}
		}
		scanner.close();
		return lines;
	}

	
	@Override
	public void update(int elapsedTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

        if (state == GameState.Ready)
            updateReady(touchEvents);
        if (state == GameState.Running)
            updateRunning(touchEvents, elapsedTime);
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

	
	private void updateRunning(List<TouchEvent> touchEvents, int elapsedTime) {

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
				playerCharacter.setStopped();
				if (pauseButton.isPressed(event)) {
					pause();
				}
			}
		}

		// 2. Check miscellaneous events like death:
		// Check for game over
		if (playerCharacter.isDead()) {
			state = GameState.GameOver;
		}

		// 3. Call individual update() methods here.
		// This is where all the game updates happen.
		// For example, playerCharacter.update();
		updatePlayerCharacter(elapsedTime);
		updateBackground();
		updateTiles(elapsedTime);
		updateEnemies(elapsedTime);
		
		// 4. Check for and trigger interactions
		for(int i = 0; i < enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			if (enemy.inVicinityOf(playerCharacter)) {
				checkForCollisionsBetween(getPlayerCharacter(), enemy);
				playerCharacter.attack(enemy);
				enemy.attack(playerCharacter);
			}
		}
	}
	
	private void checkForCollisionsBetween(GameObject object1, GameObject object2) {
		ArrayList<Rect> zones1 = object1.collisionZones();
		ArrayList<Rect> zones2 = object2.collisionZones();
		ArrayList<Rect> collisions = new ArrayList<Rect>();
		
		Log.i("zones1", "zones1 = " + object1.collisionZones());
		Log.i("zones2", "zones2 = " + object2.collisionZones());
		
		for (int i = 0; i < zones1.size(); i++) {
			for (int j = 0; j < zones2.size(); j++) {
				Rect zone1 = zones1.get(i);
				Rect zone2 = zones2.get(j);
				Rect collision = new Rect(zone1);
				if (collision.intersect(zone2)) {
					Log.i("collision detected", "collision detected");
					collisions.add(collision);
				}
			}
		}

		Log.i("COLLISIONS", "collisions count = " + collisions.size());

		if (collisions.size() > 0) {
			object1.resolveCollisions(collisions);
			object2.resolveCollisions(collisions);
		}
	}


	private void updateBackground() {
		bg1.update();
		bg2.update();
		bg3.update();
		bg4.update();
	}


	private void updatePlayerCharacter(int elapsedTime) {
		playerCharacter.update();
		playerCharacter.animate(elapsedTime);
	}


	private void updateEnemies(int elapsedTime) {
		for (int i = 0; i < enemies.size(); i++) {
			Enemy enemy = (Enemy) enemies.get(i);
			enemy.update();
			enemy.animate(elapsedTime);
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
	
	
	private void updateTiles(int elapsedTime) {
		for (int i = 0; i < tilearray.size(); i++) {
			Tile t = (Tile) tilearray.get(i);
			t.update();
			t.animate(elapsedTime);
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
		bg3 = null;
		bg4 = null;

		directionControl = null;
		pauseButton = null;

		playerCharacter = null;
		tilearray = null;
		enemies = null;

        // Call garbage collector to clean up memory.
        System.gc();
	}

	
	@Override
	public void paint(int elapsedTime) {
		Graphics g = game.getGraphics();
		
		// 1. draw the game elements.
        // Example:
        // g.drawImage(Assets.background, 0, 0);
        // g.drawImage(Assets.character, characterX, characterY);

		drawBackground(g);
		drawTiles(g);

		g.drawImage(playerCharacter.getImage(), playerCharacter.centerX() - 61,
				playerCharacter.centerY() - 63);
		g.drawRect( playerCharacter.vicinity().left,
					playerCharacter.vicinity().top,
					playerCharacter.vicinity().width(),
					playerCharacter.vicinity().height(),
					Color.argb(50, 255, 0, 0));
		for(int i = 0; i < playerCharacter.collisionZones().size(); i++){
			Rect collisionZone = playerCharacter.collisionZones().get(i);
			g.drawRect( collisionZone.left,
						collisionZone.top,
						collisionZone.width(),
						collisionZone.height(),
						Color.argb(100, 255, 0, 0));
		}
		
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


	private void drawBackground(Graphics g) {
		g.drawImage(Assets.background, bg1.getBgX(), bg1.getBgY());
		g.drawImage(Assets.background, bg2.getBgX(), bg2.getBgY());
		g.drawImage(Assets.background, bg3.getBgX(), bg3.getBgY());
		g.drawImage(Assets.background, bg4.getBgX(), bg4.getBgY());
	}


	private void drawEnemies(Graphics g) {
		for (int i = 0; i < enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			g.drawImage(enemy.getImage(), enemy.centerX() - 48, enemy.centerY() - 48);
			g.drawRect( enemy.vicinity().left,
					enemy.vicinity().top,
					enemy.vicinity().width(),
					enemy.vicinity().height(),
					Color.argb(50, 0, 255, 0));
			for(int j = 0; j < enemy.collisionZones().size(); j++){
				Rect collisionZone = enemy.collisionZones().get(j);
				g.drawRect( collisionZone.left,
							collisionZone.top,
							collisionZone.width(),
							collisionZone.height(),
							Color.argb(100, 0, 255, 0));
			}
		}
	}

	
	private void drawTiles(Graphics g) {
		for (int i = 0; i < tilearray.size(); i++) {
			Tile t = (Tile) tilearray.get(i);
			g.drawImage(t.getImage(), t.centerX(), t.centerY());
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


	public PlayerCharacter getPlayerCharacter() {
		return playerCharacter;
	}

	@Override
	public void setBackgroundSpeedX(int xSpeed) {
		bg1.setSpeedX(xSpeed);
		bg2.setSpeedX(xSpeed);
		bg3.setSpeedX(xSpeed);
		bg4.setSpeedX(xSpeed);
	}

	@Override
	public void setBackgroundSpeedY(int ySpeed) {
		bg1.setSpeedY(ySpeed);
		bg2.setSpeedY(ySpeed);
		bg3.setSpeedY(ySpeed);
		bg4.setSpeedY(ySpeed);
	}
	
	@Override
	public int getBackgroundSpeedX() {
		return bg1.getSpeedX();
	}

	@Override
	public int getBackgroundSpeedY() {
		return bg1.getSpeedY();
	}
}

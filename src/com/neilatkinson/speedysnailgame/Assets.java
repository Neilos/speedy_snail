package com.neilatkinson.speedysnailgame;

import com.neilatkinson.framework.Image;
import com.neilatkinson.framework.Music;
import com.neilatkinson.framework.Sound;

public class Assets {

	public static Image menu, splash, background, character, character2, character3, heliboy, heliboy2, heliboy3, heliboy4, heliboy5;
    public static Image tiledirt, tilegrassTop, tilegrassBot, tilegrassLeft, tilegrassRight, characterJump, characterDown;
    public static Image button;
	public static Sound click;
	public static Music theme;

	public static void load(SpeedySnailGame sampleGame) {
		theme = sampleGame.getAudio().createMusic("menutheme.mp3");
		theme.setLooping(true);
		theme.setVolume(0.85f);
		theme.play();
	}

}

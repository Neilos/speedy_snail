package com.neilatkinson.gameobject;

import java.util.ArrayList;

import com.neilatkinson.framework.Image;

public class Animation {
	
	private ArrayList<AnimFrame> frames;
    private int currentFrame;
    private int animTime;
    private int totalDuration;

	public Animation() {
		frames = new ArrayList<AnimFrame>();
        totalDuration = 0;

        synchronized (this) {
            animTime = 0;
            currentFrame = 0;
        }
	}
	

	public synchronized void addFrame(Image image, int duration) {
        totalDuration += duration;
        frames.add(new AnimFrame(image, totalDuration));
    }
	
	
	public synchronized void update(int elapsedTime) {
        if (frames.size() > 1) {
            animTime += elapsedTime;
            if (animTime >= totalDuration) {
                animTime = animTime % totalDuration;
                currentFrame = 0;

            }

            while (animTime > getFrame(currentFrame).endTime) {
                currentFrame++;

            }
        }
    }
	
	
	public synchronized Image getImage() {
        if (frames.size() == 0) {
            return null;
        } else {
            return getFrame(currentFrame).image;
        }
    }

	
    private AnimFrame getFrame(int i) {
        return (AnimFrame) frames.get(i);
    }

    
    private class AnimFrame {
        Image image;
        long endTime;

        public AnimFrame(Image image, long endTime) {
            this.image = image;
            this.endTime = endTime;
        }
    }

}

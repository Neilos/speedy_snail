package com.neilatkinson.gameobject;

import java.util.ArrayList;

import android.graphics.Rect;

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


	public synchronized void addFrame(Image image, int duration,
								    ArrayList<Rect> collisionZones,
								    ArrayList<Rect> damageZones,
								    ArrayList<Rect> attackZones) {
        totalDuration += duration;
        AnimFrame frame = new AnimFrame(image, totalDuration);
        
        if (collisionZones == null) {
        	frame.setCollisionZones(new ArrayList<Rect>());
        } else {
        	frame.setCollisionZones(collisionZones);
        }
        
        if (damageZones == null) {
        	frame.setDamageZones(new ArrayList<Rect>());
        } else {
        	frame.setDamageZones(damageZones);
        }
        
        if (attackZones == null) {
        	frame.setAttackZones(new ArrayList<Rect>());
        } else {
        	frame.setAttackZones(attackZones);
        }

        frames.add(frame);
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

	public synchronized ArrayList<Rect> getCollisionZones() {
		if (frames.size() == 0) {
            return null;
        } else {
            return getFrame(currentFrame).collisionZones;
        }
	}

	public synchronized ArrayList<Rect> getDamageZones() {
		if (frames.size() == 0) {
            return null;
        } else {
            return getFrame(currentFrame).damageZones;
        }
	}

	public synchronized ArrayList<Rect> getAttackZones() {
		if (frames.size() == 0) {
            return null;
        } else {
            return getFrame(currentFrame).attackZones;
        }
	}

	
    private AnimFrame getFrame(int i) {
        return (AnimFrame) frames.get(i);
    }

    
    private class AnimFrame {
        Image image;
		long endTime;
        ArrayList<Rect> collisionZones;
        ArrayList<Rect> damageZones;
        ArrayList<Rect> attackZones;
        
		public AnimFrame(Image image, long endTime) {
            this.image = image;
            this.endTime = endTime;
        }

		public void setCollisionZones(ArrayList<Rect> collisionZones) {
			this.collisionZones = collisionZones;
		}

		public void setDamageZones(ArrayList<Rect> damageZones) {
			this.damageZones = damageZones;
		}

		public void setAttackZones(ArrayList<Rect> attackZones) {
			this.attackZones = attackZones;
		}

    }

}

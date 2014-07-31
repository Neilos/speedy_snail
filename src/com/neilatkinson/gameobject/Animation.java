package com.neilatkinson.gameobject;

import java.util.ArrayList;

import com.neilatkinson.framework.Graphics;
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


	public synchronized void addFrame(Image image,
									int srcX, int srcY,
									int srcWidth, int srcHeight,
									int duration,
								    ArrayList<Zone> collisionZones,
								    ArrayList<Zone> damageZones,
								    ArrayList<Zone> attackZones) {
        totalDuration += duration;
        AnimFrame frame = new AnimFrame(image, srcX, srcY,
				srcWidth, srcHeight, totalDuration);
        
        if (collisionZones == null) {
        	frame.setCollisionZones(new ArrayList<Zone>());
        } else {
        	frame.setCollisionZones(collisionZones);
        }
        
        if (damageZones == null) {
        	frame.setDamageZones(new ArrayList<Zone>());
        } else {
        	frame.setDamageZones(damageZones);
        }
        
        if (attackZones == null) {
        	frame.setAttackZones(new ArrayList<Zone>());
        } else {
        	frame.setAttackZones(attackZones);
        }

        frames.add(frame);
    }


	public synchronized void update(int elapsedTime, int objectCenterX, int objectCenterY) {
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
        positionZones(objectCenterX, objectCenterY);
    }
	
	public synchronized void positionZones(int objectCenterX, int objectCenterY) {
		AnimFrame frame = getFrame(currentFrame);
		frame.updateCollisionZones(objectCenterX, objectCenterY);
		frame.updateDamageZones(objectCenterX, objectCenterY);
		frame.updateAttackZones(objectCenterX, objectCenterY);
	}

	public synchronized ArrayList<Zone> getCollisionZones() {
		if (frames.size() == 0) {
            return null;
        } else {
            return getFrame(currentFrame).collisionZones;
        }
	}

	public synchronized ArrayList<Zone> getDamageZones() {
		if (frames.size() == 0) {
            return null;
        } else {
            return getFrame(currentFrame).damageZones;
        }
	}

	public synchronized ArrayList<Zone> getAttackZones() {
		if (frames.size() == 0) {
            return null;
        } else {
            return getFrame(currentFrame).attackZones;
        }
	}

    private AnimFrame getFrame(int i) {
        return (AnimFrame) frames.get(i);
    }

	public void drawImage(Graphics graphics, int left, int top) {
		getFrame(currentFrame).drawSelf(graphics, left, top);
	}

    private class AnimFrame {
        Image image;
        int srcX;
        int srcY;
		int srcWidth;
		int srcHeight;
		long endTime;
        ArrayList<Zone> collisionZones;
        ArrayList<Zone> damageZones;
        ArrayList<Zone> attackZones;

		public AnimFrame(Image image, int srcX, int srcY,
				int srcWidth, int srcHeight, long endTime) {
            this.image = image;
            this.srcX = srcX;
            this.srcY = srcY;
            this.srcWidth = srcWidth;
            this.srcHeight = srcHeight;
            this.endTime = endTime;
        }

		public void setCollisionZones(ArrayList<Zone> collisionZones) {
			this.collisionZones = collisionZones;
		}

		public void setDamageZones(ArrayList<Zone> damageZones) {
			this.damageZones = damageZones;
		}

		public void setAttackZones(ArrayList<Zone> attackZones) {
			this.attackZones = attackZones;
		}

		private void updateAttackZones(int newCenterX, int newCenterY) {
			for (Zone zone : attackZones) {
				zone.offsetTo(newCenterX, newCenterY);
			}
		}

		private void updateDamageZones(int newCenterX, int newCenterY) {
			for (Zone zone : damageZones) {
				zone.offsetTo(newCenterX, newCenterY);
			}
		}

		private void updateCollisionZones(int newCenterX, int newCenterY) {
			for (Zone zone : collisionZones) {
				zone.offsetTo(newCenterX, newCenterY);
			}
		}

		public void drawSelf(Graphics graphics, int x, int y) {
			graphics.drawImage(image, x, y, srcX, srcY, srcWidth, srcHeight);
		}
    }

}

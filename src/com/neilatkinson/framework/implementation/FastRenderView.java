package com.neilatkinson.framework.implementation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class FastRenderView extends SurfaceView implements Runnable {
	AndroidGame game;
	Bitmap framebuffer;
	SurfaceHolder holder;
	Thread renderThread;
	volatile boolean running = false;

	public FastRenderView(AndroidGame game, Bitmap framebuffer) {
		super(game);
		this.game = game;
		this.framebuffer = framebuffer;
		this.holder = getHolder();
	}
	
	public void resume() {
		running  = true;
		renderThread = new Thread(this);
		renderThread.start();
	}

	@Override
	public void run() {
		Rect dstRect = new Rect();
        long startTime = System.nanoTime();
        while(running) {  
        	if(!holder.getSurface().isValid())
                continue;           

		    float deltaTime = (System.nanoTime() - startTime) / 10000000.000f;
		    startTime = System.nanoTime();
		    
		    if (deltaTime > 50.0){
		        deltaTime = (int) 50;
		    }
     
            game.getCurrentScreen().update((int) deltaTime);
            game.getCurrentScreen().paint((int) deltaTime);
          
            Canvas canvas = holder.lockCanvas();
            canvas.getClipBounds(dstRect);
            canvas.drawBitmap(framebuffer, null, dstRect, null);                           
            holder.unlockCanvasAndPost(canvas);
            
        }
    }
	
	public void pause() {
	    running = false;                        
	    while(true) {
	        try {
	            renderThread.join();
	            break;
	        } catch (InterruptedException e) {
	            // retry
	        }
	        
	    }
	}
}

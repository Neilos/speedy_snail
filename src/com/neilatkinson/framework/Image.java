package com.neilatkinson.framework;

import com.neilatkinson.framework.Graphics.ImageFormat;

public interface Image {
    public int getWidth();
    public int getHeight();
    public ImageFormat getFormat();
    public void dispose();
}

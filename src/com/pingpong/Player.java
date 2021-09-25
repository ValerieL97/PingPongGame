package com.pingpong;

import java.awt.*;


public interface Player {

    int PADDLE_WIDTH = 25;
    int PADDLE_HEIGHT = 100;

    public void move();
    public void draw(Graphics g);
    public void setUp(boolean b);
    public void setDown(boolean b);
    public double getY();

}

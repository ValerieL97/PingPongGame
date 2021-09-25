package com.pingpong;

import java.awt.*;

public class AI extends Rectangle implements Player{

    Ball b1;
    int speed = 10;
    AI(int x, int y, Ball b1) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.b1 = b1;
    }

   //stops the paddle at the edges
    public void checkCollisionP_W() {
        if(y < 0) {
            y= 0;
        } else if (y > PingPong.GAME_HEIGHT - PADDLE_HEIGHT) {
            y = PingPong.GAME_HEIGHT-PADDLE_HEIGHT;
        }
    }

    //finds out where the ball is heading for and move in that direction
    @Override
    public void move() {
        // AI paddle needs to go up
        int diff = (int) (y + PADDLE_HEIGHT / 2 - b1.getY());
        if (diff > 0) { 

            if (diff <= speed){
                y = (int) (b1.getY() - PADDLE_HEIGHT / 2);
            } else {
                y -= speed;
            }
        }
        // AI paddle needs to go down
        if (diff < 0) { 
            if (-diff <= speed) {
                y = (int) (b1.getY() - PADDLE_HEIGHT / 2);
            } else {
                y += speed;
            }
        }
        if (y < speed) {
            y = speed;
        }

       checkCollisionP_W();


    }


    @Override
    public void draw(Graphics g) {
        g.fillRect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

    @Override
    public void setUp(boolean b) {

    }

    @Override
    public void setDown(boolean b) {

    }

   public double getY() {
      return y;
   }
}

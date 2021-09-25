package com.pingpong;

import java.awt.*;

public class Human extends Rectangle implements Player{

    static int yVelocity;
    boolean up, down;
    int id;
    int speed = 7;

    Human(int x,int y, int id) {
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
        up = false; down = false;
        this.id = id;
    }
    //stops the paddle at the edges
    public void checkCollisionP_W() {
        if(y < 0) {
            y= 0;
        } else if (y > PingPong.GAME_HEIGHT - PADDLE_HEIGHT) {
            y = PingPong.GAME_HEIGHT-PADDLE_HEIGHT;
        }
    }
    
    public void setYVelocity() {
        if(up) {
            yVelocity = -speed; //sets vel. to move up
        } else if(down) {
            yVelocity = +speed;//sets vel. to move down
        } else {
            yVelocity = 0;
        }
    }

    //moves depending on the id
    @Override
    public void move() {
        setYVelocity();
        if(id == 1 ){
            y += yVelocity;
        } else if(id==2) {
            y += yVelocity;
        }
        checkCollisionP_W();
    }

    @Override
    public void draw(Graphics g) {
        g.fillRect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
    }
   
    public void setUp(boolean b) {
       up = b;
    }
    
    public void setDown(boolean b) {
        down = b;
    }
   public double getY() {
        return (int) y;
   }
}


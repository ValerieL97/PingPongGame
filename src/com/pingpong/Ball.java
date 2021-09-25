package com.pingpong;

import java.awt.*;
import java.util.Random;

public class Ball extends Rectangle {

    static final int BALL_DIAMETER = 25;
    Random random = new Random();

    int yVelocity, xVelocity;

    Ball(int x, int y) {
        super(x, y, BALL_DIAMETER, BALL_DIAMETER);
        yVelocity = setSpeed() * setDirection();
        if(yVelocity == 0) {
            yVelocity--;
        }
        xVelocity = setSpeed() * setDirection();
        if(xVelocity == 0) {
            xVelocity--;
        }
    }
    //sets a random direction for ball
    public int setDirection() {
        return random.nextInt(2) == 1 ? 1 : -1;
    }
    //sets a random speed for ball
    public int setSpeed() {
        return random.nextInt(2);
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(x, y, width, height);
    }

    //checks the collision between the ball and paddles
    public void checkBallPlayerCollision(Player p1, Player p2) {
        if (x <= Player.PADDLE_WIDTH) {
            if (y >= p1.getY() && y <= p1.getY() + Player.PADDLE_HEIGHT) {
                xVelocity = -xVelocity + 1;//increases the vel. for more difficulty
            }
        } else if (x >= PingPong.GAME_WIDTH - 2 * Player.PADDLE_WIDTH) {
            if (y >= p2.getY() && y <= p2.getY() + Player.PADDLE_HEIGHT) {
                xVelocity = -xVelocity - 1;     }
        }


    }
    
    public void move() {
        x += xVelocity;
        y += yVelocity;
        
        //ball bounces off the bottom edge and top edge
        if (y <= 0) {
            yVelocity = -yVelocity;
        }
        if (y >= PingPong.GAME_HEIGHT - BALL_DIAMETER) {
            yVelocity = -yVelocity;
        }
    }

    public double getY(){
        return (int) y;
    }
}

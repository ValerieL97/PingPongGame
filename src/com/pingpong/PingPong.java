package com.pingpong;

import javax.swing.*;
import java.awt.*;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class PingPong extends JPanel implements Runnable, KeyListener {

    static final int GAME_HEIGHT = 600;
    static final int GAME_WIDTH = 1000;
    final Dimension GAME_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static boolean game_state = true;
    static boolean ai_play = Menu.getEnemy();

    Random random = new Random();
    Image image;
    Graphics graphics;
    Thread thread;
    UIManager UI;

    Ball ball;
    Player player1;
    Player player2;
    Score score = new Score();


    PingPong()  {

        newBall();
        newPlayers();

        if(!ai_play) {
            UI.put("OptionPane.background",new ColorUIResource(163,45,41));
            UI.put("Panel.background",new ColorUIResource(4,34,58));
            UI.put("OptionPane.messageForeground",new ColorUIResource(255,255,255));
            JOptionPane.showMessageDialog (null, "Welcome to R-PingPong! Player 1 moves with UP and DOWN, player 2 moves with 1 and 2.");
        }

        this.setFocusable(true);
        this.addKeyListener(this);
        this.setPreferredSize(GAME_SIZE);

        thread = new Thread(this::run);
        thread.start();

    }

    public void newBall() {
        ball = new Ball((GAME_WIDTH/2)-(Ball.BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-Ball.BALL_DIAMETER));
    }

    public void newPlayers() {
        player1 = new Human(0,(GAME_HEIGHT/2)-(Player.PADDLE_HEIGHT/2),1);
        if(ai_play) {
            player2 = new AI(GAME_WIDTH-Player.PADDLE_WIDTH,(GAME_HEIGHT/2)-(Player.PADDLE_HEIGHT/2),ball);
        } else {
            player2 = new Human(GAME_WIDTH-Player.PADDLE_WIDTH,(GAME_HEIGHT/2)-(Player.PADDLE_HEIGHT/2),2);
        }
    }
    public void paint(Graphics g) {
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);

    }
    public void draw(Graphics g) {
       if(game_state) {
           ball.draw(g);
           g.setColor(Color.blue);
           player1.draw(g);
           g.setColor(Color.red);
           player2.draw(g);
           g.setColor(Color.WHITE);
           score.draw(g);
           g.drawOval(400, 170, 200, 200);
           g.drawLine(GAME_WIDTH / 2, 0, GAME_WIDTH / 2, GAME_HEIGHT);
           Toolkit.getDefaultToolkit().sync();
       } else {
               g.setColor(Color.white);
               g.setFont(new Font("MV Boli",Font.BOLD,30));
               g.drawString("Press Enter!", GAME_WIDTH/2-100, GAME_HEIGHT/2);
       }



    }

    public void move() {
        ball.move();
        player1.move();
        player2.move();
    }
     
     // gives 1 point to the winner
     // creates new paddles & ball
    public void checkWin() {
        if(ball.x <=0) {
            score.player2++;
            newBall();
            newPlayers();
        }

        if(ball.x >= GAME_WIDTH-Ball.BALL_DIAMETER) {
            score.player1++;
            newBall();
            newPlayers();
        }

    }

    public void run() {
            while (true) {
                move();
                if(game_state) {
                    checkWin();
                }
                ball.checkBallPlayerCollision(player1, player2);
                repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player1.setUp(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player1.setDown(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_1) {
            player2.setUp(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_2) {
            player2.setDown(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            game_state = true; 
        }
    }

        @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player1.setUp(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player1.setDown(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_1) {
            player2.setUp(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_2) {
            player2.setDown(false);
        }
    }
}





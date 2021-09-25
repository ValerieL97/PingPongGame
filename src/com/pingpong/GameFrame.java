package com.pingpong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class GameFrame extends JFrame {

    PingPong game;
    NameFrame nameFrame;
    WindowListener windowListener;

    GameFrame() {
        game = new PingPong();
        this.add(game);
        this.setTitle("R-PingPong Game");
        this.setResizable(false);
        this.setBackground(Color.black);
        windowListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(Score.checkScore()) {
                    nameFrame = new NameFrame();
                } else {
                    System.exit(0);
                }
            }
        };
        this.pack();
        this.addWindowListener(windowListener);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }


}


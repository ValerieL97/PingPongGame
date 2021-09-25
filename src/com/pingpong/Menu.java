package com.pingpong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener {

    private static final int HEIGHT = 450;
    private static final int WIDTH = 500;


    JFrame frame = new JFrame();
    JPanel image_panel = new JPanel();
    JPanel buttonsR_panelT = new JPanel();
    JPanel text1_panel = new JPanel();
    JPanel buttons_panel = new JPanel();

    JRadioButton playerUser = new JRadioButton("HUMAN");
    JRadioButton playerAI = new JRadioButton("AI");
    ButtonGroup group1 = new ButtonGroup();


    JButton start = new JButton("START");
    JButton exit = new JButton("EXIT");
    JButton score = new JButton("SCORE");

    JLabel player_enemy = new JLabel("Choose your enemy:");
    ImageIcon tennis = new ImageIcon("tennis.jpg");
    JLabel image = new JLabel();

    static String enemy = "";

    Menu() {
        group1.add(playerAI);
        group1.add(playerUser);

        frame.setTitle("R-PingPong");
        frame.setSize(WIDTH,HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(0,0,0));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        image_panel.setBounds(0,0,WIDTH,HEIGHT-250);
        image_panel.setBackground(new Color(0,0,0));
        image.setIcon(tennis);
        image.setHorizontalAlignment(JLabel.CENTER);
        image_panel.add(image);

        text1_panel.setBounds(0,205,WIDTH,HEIGHT-415);
        text1_panel.setBackground(new Color(0,0,0));

        buttonsR_panelT.setBackground(new Color(0,0,0));
        buttonsR_panelT.setBounds(0,250,WIDTH,HEIGHT-420);
        buttonsR_panelT.setLayout(null);

        playerUser.setFont(new Font("MV Boli",Font.BOLD,15));
        playerUser.setBackground(new Color(0,0,0));
        playerUser.setForeground(new Color(4,34,58));
        playerUser.setFont(new Font("Ink Free",Font.BOLD,20));
        playerUser.setFocusable(false);
        playerUser.setBounds(140,0,120,30);
        playerUser.addActionListener(this);
        buttonsR_panelT.add(playerUser);

        playerAI.setFont(new Font("MV Boli",Font.BOLD,15));
        playerAI.setBackground(new Color(0,0,0));
        playerAI.setForeground(new Color(163,45,41));
        playerAI.setFocusable(false);
        playerAI.setFont(new Font("Ink Free",Font.BOLD,20));
        playerAI.setBounds(280,0,120,30);
        playerAI.addActionListener(this);
        buttonsR_panelT.add(playerAI);

        player_enemy.setBackground(new Color(0,0,0));
        player_enemy.setForeground(new Color(163,45,41));
        player_enemy.setFont(new Font("Ink Free",Font.BOLD,25));
        player_enemy.setHorizontalAlignment(JLabel.SOUTH_EAST);
        player_enemy.setOpaque(true);
        text1_panel.add(player_enemy);

        buttons_panel.setBackground(new Color(0,0,0));
        buttons_panel.setBounds(0,280,WIDTH,HEIGHT-140);
        buttons_panel.setLayout(null);

        exit.setFont(new Font("MV Boli",Font.BOLD,20));
        exit.setBackground(new Color(0,0,0));
        exit.setForeground(new Color(163,45,41));
        exit.setFont(new Font("Ink Free",Font.BOLD,20));
        exit.setHorizontalAlignment(JButton.CENTER);
        exit.setBounds(180,80,120,25);
        exit.addActionListener(this);

        start.setFont(new Font("MV Boli",Font.BOLD,15));
        start.setBackground(new Color(0,0,0));
        start.setForeground(new Color(163,45,41));
        start.setFont(new Font("MV Boli",Font.BOLD,20));
        start.setHorizontalAlignment(JButton.CENTER);
        start.setBounds(180,20,120,25);
        start.addActionListener(this);

        score.setFont(new Font("MV Boli",Font.BOLD,15));
        score.setBackground(new Color(0,0,0));
        score.setForeground(new Color(4,34,58));
        score.setFont(new Font("MV Boli",Font.BOLD,20));
        score.setHorizontalAlignment(JButton.CENTER);
        score.setBounds(180,50,120,25);
        score.addActionListener(this);

        buttons_panel.add(exit);
        buttons_panel.add(start);
        buttons_panel.add(score);

        frame.add(image_panel);
        frame.add(buttons_panel);
        frame.add(buttonsR_panelT);
        frame.add(text1_panel);
        frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playerUser) {
            enemy = "user";
        } else if(e.getSource() == playerAI) {
            enemy = "ai";
        }

        if (e.getSource() == start) {
            frame.dispose();
            GameFrame game = new GameFrame();
        } else if(e.getSource() == exit) {
            frame.dispose();
        } else if(e.getSource() == score) {
            ScoreFrame frame = new ScoreFrame();
        }
    }

    static boolean getEnemy() {
       return (enemy.equals("ai") || enemy.equals(""));
    }
}

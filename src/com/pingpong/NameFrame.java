package com.pingpong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NameFrame {

    private static final int HEIGHT = 130;
    private static final int WIDTH = 400;

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JPanel text_panel = new JPanel();
    static JTextField name_field = new JTextField(5);
    JButton done = new JButton("DONE");
    JLabel text1 = new JLabel("Write your name (only characters");
    JLabel text2 = new JLabel("Congratulations! You beat the last record!");


    NameFrame() {
        frame.setTitle("Pong GAME");
        frame.setSize(WIDTH,HEIGHT);
        frame.getContentPane().setBackground(new Color(0,0,0));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        text_panel.setBackground(new Color(4,34,58));
        text_panel.setBounds(18,40,WIDTH-40,HEIGHT-80);
        text_panel.setLayout(new FlowLayout());
        panel.setBackground(new Color(163,45,40));
        panel.setBounds(0,0,WIDTH,HEIGHT);

        text2.setBackground(new Color(163,45,41));
        text2.setForeground(new Color(255,255,255));
        text2.setFont(new Font("Ink Free",Font.BOLD,15));
        text2.setLocation(5,5);
        text2.setOpaque(true);
        panel.add(text2);

        text1.setBackground(new Color(4,34,58));
        text1.setForeground(new Color(255,255,255));
        text1.setFont(new Font("Ink Free",Font.BOLD,15));
        text1.setOpaque(true);
        text_panel.add(text1);
        name_field.setFont(new Font("Ink Free",Font.ITALIC,15));
        name_field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        text_panel.add(name_field);

        done.setForeground(Color.white);
        done.setBackground(new Color(163,45,41));
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Score.keepScoreNameArr();
                Score.keepScoreNameFile();
                System.exit(0);
            }
        });
        text_panel.add(done);


        frame.add(text_panel);
        frame.add(panel);
        frame.setVisible(true);

    }

    //returns the introduced name
    public static String getName() {
        return name_field.getText().replaceAll("[0-9]"," ");
    }


}

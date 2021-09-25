package com.pingpong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScoreFrame extends JFrame implements ActionListener {

    static final int WIDTH = 250;
    static final int HEIGHT = 200;

    JPanel panel_columns = new JPanel();
    JLabel name = new JLabel("Highest Scores",SwingConstants.CENTER);
    JPanel panel_text = new JPanel();
    JPanel button_panel = new JPanel();
    String str = "";
    String[] names;
    String[] scores;
    JButton ok = new JButton("OK");
    JLabel[] lines;
    JLabel line1;
    JLabel line2;
    JLabel line3;
    JLabel line4;
    JLabel line5;

    ScoreFrame() {
        this.setTitle("R-PingPong");
        this.setSize(WIDTH, HEIGHT);
        this.getContentPane().setBackground(new Color(0, 0, 0));
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        panel_columns.setBounds(0, 25, WIDTH, HEIGHT-50);
        panel_columns.setBackground(new Color(4, 34, 58));
        panel_columns.setLayout(new BoxLayout(panel_columns,BoxLayout.PAGE_AXIS));

        panel_text.setBounds(0,0,WIDTH,25);
        panel_text.setBackground(new Color(163,45,41));
        panel_text.add(name);

        ok.setBackground(new Color(163,45,41));
        ok.setForeground(new Color(255, 255, 255));
        ok.setFont(new Font("Ink Free", Font.BOLD, 14));
        ok.addActionListener(this);

        button_panel.setBounds(0,125,WIDTH,35);
        button_panel.setBackground(new Color(4, 34, 58));
        button_panel.add(ok);

        name.setBackground(new Color(163,45,41));
        name.setForeground(new Color(255, 255, 255));
        name.setFont(new Font("Ink Free", Font.BOLD, 17));
        name.setOpaque(true);

        //get data from the file
        try {
            str = Files.readString(Path.of("HighScores.txt"), StandardCharsets.US_ASCII);
        } catch (IOException e) {
             e.printStackTrace();
        }

        str = str.replaceAll(" ","");
        str = str.replaceAll("\n"," ");
        String players = str.replaceAll("[0-9]", "-");
        //all names are kept in names[]
        names = players.split("-");

        str = str.replaceAll("[^0-9]", " ");
        str = str.replaceAll("\\s{2,}", "");
        //all scores are kept in scores[]
        scores = str.split("");



        lines = new JLabel[]{line1, line2, line3, line4, line5};

        for(int i = 0; i < 5; i++) {
            lines[i] = new JLabel((i+1) +". " + names[i] + " " + scores[i]);
            System.out.println(scores[i]);
        }

        lines[0].setBackground(new Color(4, 34, 58));
        lines[0].setForeground(new Color(255, 255, 255));
        lines[0].setFont(new Font("Ink Free", Font.BOLD, 15));
        lines[0].setLocation(3, 20);
        lines[0].setOpaque(true);

        lines[1].setBackground(new Color(4, 34, 58));
        lines[1].setForeground(new Color(255, 255, 255));
        lines[1].setFont(new Font("Ink Free", Font.BOLD, 15));
        lines[1].setLocation(3, 20);
        lines[1].setOpaque(true);

        lines[2].setBackground(new Color(4, 34, 58));
        lines[2].setForeground(new Color(255, 255, 255));
        lines[2].setFont(new Font("Ink Free", Font.BOLD, 15));
        lines[2].setLocation(3, 20);
        lines[2].setOpaque(true);

        lines[3].setBackground(new Color(4, 34, 58));
        lines[3].setForeground(new Color(255, 255, 255));
        lines[3].setFont(new Font("Ink Free", Font.BOLD, 15));
        lines[3].setLocation(3, 20);
        lines[3].setOpaque(true);

        lines[4].setBackground(new Color(4, 34, 58));
        lines[4].setForeground(new Color(255, 255, 255));
        lines[4].setFont(new Font("Ink Free", Font.BOLD, 15));
        lines[4].setLocation(3, 20);
        lines[4].setOpaque(true);


        for(int i = 0; i < 5; i++) {
            panel_columns.add(lines[i]);
        }


        this.add(panel_text);
        this.add(button_panel);
        this.add(panel_columns);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ok) {
            this.dispose();
        }

    }

}

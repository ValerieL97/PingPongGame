package com.pingpong;

import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;


public class Score {

    static int player1;
    static int player2;
    static int[] highScores;
    static String[] names;
    String[] highStr;
    String players;
    String str;
    static int num;
    static int numI;

   Score() {
       //reads the previous scores from the file as a string
        try {
            str = Files.readString(Path.of("HighScores.txt"), StandardCharsets.US_ASCII);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //name in name[]
        str = str.replaceAll("\n"," ");
        players = str.replaceAll("[0-9]", "-");
        names = players.split("-");
        //scores in highScores[]
        str = str.replaceAll("[^0-9]", " ");
        str = str.replaceAll("\\s{2,}", " ");
        highStr = str.split(" ");

        if(highStr.length > 0) {
            highScores = new int[highStr.length-1];
            for (int i = 0; i < highStr.length - 1; i++) {
                highScores[i] = Integer.parseInt(highStr[i + 1]);
            }
        }

    }
    //checks if the score is higher than the kept highest scores
    public static boolean checkScore() {
        for(int i = 0; i < highScores.length; i++) {
            if(player1 > highScores[i] && player1 > player2) {
                numI = i;
                num = player1;
                player1 = 0;
                player2 = 0;
                return true;
            } else if(player2 > highScores[i] && !PingPong.ai_play && player2 > player1) {
                numI= i;
                num = player2;
                player1 = 0;
                player2 = 0;
                return true;
            }

        }
        return false;
    }
    public static void keepScoreNameFile() {
       //clears the contents of the file
        try {
            PrintWriter writer = new PrintWriter("HighScores.txt");
            writer.print("");
            writer.close();
        //writes the current list of names and scores in file
            PrintWriter pr = new PrintWriter("HighScores.txt");
            for (int i=0; i < highScores.length; i++) {
                pr.println(names[i] + highScores[i]);
            }
            pr.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }
    }
    //  keeps the winner's name and score in arrays
    public static void keepScoreNameArr() {
       highScores[numI] = num;
       names[numI] = NameFrame.getName();
    }


    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Consolas",Font.PLAIN,60));
        g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), (PingPong.GAME_WIDTH/2)-95, 50);
        g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10), (PingPong.GAME_WIDTH/2)+20, 50);
    }

}

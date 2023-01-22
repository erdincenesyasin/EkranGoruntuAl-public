package org.EeE;

import javax.swing.*;
import java.awt.*;

public class infoFrm {
    public static JFrame frameInfo;
    public static   JLabel labelBilgi;

    public void infoJT() {




            frameInfo = new JFrame();

       frameInfo.setSize(400, 55);


        labelBilgi = new JLabel();
        labelBilgi.setSize(400, 100);

        labelBilgi.setFont(new Font("Arial", Font.PLAIN, 34));


        frameInfo.add(labelBilgi);


        Color green = new Color(211, 12, 20);
        Color lighgreen = green.brighter();
        frameInfo.getContentPane().setBackground(lighgreen);

        labelBilgi.setForeground(Color.WHITE);

        frameInfo.setUndecorated(true);
        frameInfo.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);



    }

    public static void main(String[] args) {

    }
}

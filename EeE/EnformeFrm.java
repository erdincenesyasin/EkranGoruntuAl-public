package org.EeE;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;


public class EnformeFrm {
    public void baloncuk(JFrame acilacakJFrame) {


        JFrame frame = new JFrame("baloncuk");
        frame.setSize(500, 120);


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screenSize.width - frame.getWidth();
        int y = screenSize.height - frame.getHeight();
        frame.setLocation(FrmAna.xxx,FrmAna.yyy);


        frame.getContentPane().setBackground(Color.RED);
        frame.setUndecorated(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel label = new JLabel("<html>RESİM KAYDEDİLDİ  <br> "+ GirisYatay.klasorPath);
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        label.setForeground(Color.white);
        label.setBackground(Color.ORANGE);
        label.setBounds(10, 0, 480, 120);

        frame.add(label);

        frame.setLayout(null);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                frame.dispose();
                acilacakJFrame.setVisible(true);
                acilacakJFrame.setEnabled(true);
            }
        }, 3000);
        frame.setVisible(true);

    }
}

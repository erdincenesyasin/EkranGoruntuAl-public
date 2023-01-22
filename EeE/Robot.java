package org.EeE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Robot {

    public static boolean icAlanda;


    public static Point getMousePosition() {
        try {

            java.awt.Robot robot = new java.awt.Robot();


            Point mousePos = MouseInfo.getPointerInfo().getLocation();
            return mousePos;
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void trackMousePosition() {

        infoFrm infocu = new infoFrm();
        EkranOlculerifinal ekranOlculerifinal1 = new EkranOlculerifinal();
        infocu.infoJT();

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!FrmAna.basla) {
                    ((Timer) e.getSource()).stop();

                }
                Robot.icAlanda=false;
                Point mousePos = getMousePosition();
                int x = (int) mousePos.getX();
                int y = (int) mousePos.getY();
                //ilk tıklama ile şu anki koordinat farkı
                int xp = x - FrmAna.firstxx;
                int yp = y - FrmAna.firstyy;
                FrmAna.frame.setSize(xp, yp);

                if (FrmAna.firstyy > 100) {
                    infoFrm.frameInfo.setLocation(FrmAna.firstxx, FrmAna.firstyy - 55);
                } else if (ekranOlculerifinal1.screenHeight > y + 55) {
                    infoFrm.frameInfo.setLocation(FrmAna.firstxx, y);

                } else if (FrmAna.firstxx > 400) {
                    infoFrm.frameInfo.setLocation(FrmAna.firstxx - 400, FrmAna.frame.getLocation().getLocation().y);

                } else {
                    infoFrm.frameInfo.setLocation(FrmAna.firstxx, FrmAna.frame.getLocation().getLocation().y);//iç alan
                  Robot.icAlanda=true;
                }

                if ( !infoFrm.frameInfo.isVisible()){
                    infoFrm.frameInfo.setVisible(true);
                }

                infoFrm.frameInfo.setTitle("En" + xp + "BOY: " + yp);
                infoFrm.labelBilgi.setText("En :" + xp + "     " + "Boy : " + yp);




            }
        });


        timer.start();



    }

    public static void main(String[] args) {

        trackMousePosition();
    }
}

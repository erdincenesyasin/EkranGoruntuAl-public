package org.EeE;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Robot;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EkranScreenAl {
    public void EkraniAl(int x, int y, int w, int h, String klasorYolu, JFrame tekrarAcilacakEkran) {
        java.awt.Robot robot = null;

        String desktopPath = System.getProperty("user.home") + "/Desktop/";

        File imagesFolder = new File(desktopPath + "Satıs Resimleri");
        if (!imagesFolder.exists()) {

            imagesFolder.mkdir();
        }

        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        BufferedImage screenCapture = robot.createScreenCapture(new Rectangle(x, y, w, h));
        String fileName = "/" + System.currentTimeMillis() + "EN" + w + "BOY" + h + ".jpeg";

        File file = new File(klasorYolu + fileName);
        try {
            boolean jpeg = ImageIO.write(screenCapture, "jpeg", file);
            if (jpeg) {

                EnformeFrm enformeFrm = new EnformeFrm();
                enformeFrm.baloncuk(tekrarAcilacakEkran);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

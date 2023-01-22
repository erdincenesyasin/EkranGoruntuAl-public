package org.EeE;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class KlasoruGoster {
    public boolean klasoruGoster() {


        File file = new File(System.getProperty("user.home") + "/Desktop/Satıs Resimleri");
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(file);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Masaüstünde SAtış Resimleri klasörü bulunamadı..", "HATA", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}

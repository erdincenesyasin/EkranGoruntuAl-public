package org.EeE;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DosyaAdiYoneticisi {
    public String klasorPATHolustur(String dosyaYil, String dosyaNo) {

        Date date = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
        String formattedDate = dateFormat.format(date);
        String desktopPath = System.getProperty("user.home") + "/Desktop/";

        File imagesFolder;

        imagesFolder = new File(desktopPath + "Satıs Resimleri/");


        if (!imagesFolder.exists()) {
            // Klasör yoksa oluştur
            imagesFolder.mkdir();
        }
        if (dosyaYil.isEmpty() || dosyaNo.isEmpty()) {
            imagesFolder = new File(desktopPath + "Satıs Resimleri/DosyaNoYazilmayanlar/");
        } else {
            imagesFolder = new File(desktopPath + "Satıs Resimleri/" + dosyaYil + "-" + dosyaNo + " ESAS " + formattedDate + "/");

        }

        if (!imagesFolder.exists()) {
            // Klasör yoksa oluştur
            imagesFolder.mkdir();
        }
        return imagesFolder.getPath();


    }
}

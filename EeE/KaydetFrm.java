package org.EeE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KaydetFrm {


    public KaydetFrm() {
        JFrame frame = new JFrame();
        JLabel label = new JLabel("KAYDET");
        frame.setLayout(null);

        label.setBounds(0, 0, 80, 40);
        frame.add(label);
        frame.setUndecorated(true);

        frame.setBackground(Color.pink);
        frame.getContentPane().setBackground(Color.BLUE);
        label.setBackground(Color.red);

        label.setFont(new Font("Serif", Font.PLAIN, 12));

        JLabel labelIptal = new JLabel("İPTAL");
        labelIptal.setBounds(85, 0, 80, 40);
        labelIptal.setBackground(Color.yellow);
        frame.add(labelIptal);


        frame.setSize(200, 60);
        int x = FrmAna.frame.getLocation().x;
        int y = FrmAna.frame.getLocation().y;
        int w = FrmAna.frame.getWidth();
        int h = FrmAna.frame.getHeight();

        int konumX = x + w - frame.getWidth();
        int konumY = y + h - frame.getHeight();

        frame.setLocation(konumX, konumY);

        frame.setVisible(true);


        //////listener


        labelIptal.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GirisYatay.klasorPath = "";
                FrmAna.frame.setVisible(false);
                JOptionPane.showMessageDialog(null, "iptal edildi", "İPTAL", JOptionPane.INFORMATION_MESSAGE);


            }
        });


        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                boolean basarili = anaFrmBoyutundaResimAl();
                if (!basarili) {
                    JOptionPane.showMessageDialog(null, "ters giden bir şey var", "HATA", JOptionPane.ERROR_MESSAGE);

                }


            }
        });


    }

    public boolean anaFrmBoyutundaResimAl() {

        FrmAna.basla = false;
        EkranScreenAl ekranScreenAl = new EkranScreenAl();
        int x = FrmAna.frame.getLocation().x;
        int y = FrmAna.frame.getLocation().y;
        int w = FrmAna.frame.getSize().width;
        int h = FrmAna.frame.getSize().height;


        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        if (!(w < 1) || !(h < 1)) {

            FrmAna.frame.setVisible(false);

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);

            }

            FrmAna.frame.setVisible(true);


        } else {
            FrmAna.frame.setVisible(false);
            KlasoruGoster klasoruGoster = new KlasoruGoster();
            klasoruGoster.klasoruGoster();
            GirisYatay.klasorPath = "";
            GirisYatay.frame.setVisible(true);

        }


        return true;
    }

}

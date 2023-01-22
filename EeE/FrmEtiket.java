package org.EeE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrmEtiket {
    EkranScreenAl ekranScreenAl;
    private boolean bitti = false;
    Timer timer;

    public FrmEtiket(JFrame calisilanEkran) {


        JFrame frameparsel = new JFrame("Resmin üzerinde parsel numarası yazmasını ister misiniz=");
        frameparsel.setBounds(10, 10, 400, 45);

        frameparsel.getContentPane().setBackground(new Color(252,76,2));

        frameparsel.setLayout(null);
        JTextField lbparsel = new JTextField();
        frameparsel.add(lbparsel);
        JButton iptal = new JButton("İptal");
        JButton tamam = new JButton("Kaydet");
        JLabel lbKlasorPth= new JLabel("DOSYA KAYIT YERİ:  Masaüstü/Satış Resimleri" );
        frameparsel.add(lbKlasorPth);



        lbparsel.setBounds(0, 0, 150, 20);
        tamam.setBounds(160, 0, 80, 20);
        iptal.setBounds(250, 0, 80, 20);
        lbKlasorPth.setBounds(0,21,400,20);


        lbparsel.setBackground(Color.BLUE);
        lbparsel.setForeground(Color.white);
        lbparsel.setFont(lbparsel.getFont().deriveFont(Font.ITALIC));
        lbparsel.setOpaque(false);

        lbparsel.setBorder(null);
        lbparsel.setBackground(Color.cyan);


        setHint(lbparsel, "etiket yazmak için..");
        lbparsel.setText("etiket yazmak için..");

        JLabel gizliLabel = new JLabel();

        gizliLabel.setBackground(Color.ORANGE);
        gizliLabel.setBounds(0, 60, 100, 20);
        gizliLabel.setVisible(true);

        //enboy jfaremesi iç alanda ise, enboyframesinin altına gelecek şekilde ayar..
        if (Robot.icAlanda){
            frameparsel.setLocation(FrmAna.xxx + 5, FrmAna.yyy + 5+58);
        }else {
            frameparsel.setLocation(FrmAna.xxx + 5, FrmAna.yyy + 5);
        }

        frameparsel.add(tamam);
        frameparsel.add(iptal);

        frameparsel.setUndecorated(true);
        frameparsel.setAlwaysOnTop(true);
        frameparsel.setVisible(true);
      tamam.requestFocusInWindow();



        ekranScreenAl = new EkranScreenAl();
        tamam.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                tamam.setVisible(false);
                iptal.setVisible(false);
                lbparsel.setVisible(false);


                gizliLabel.setLocation(0, 0);

                frameparsel.setSize(100, 20);
                if (!lbparsel.getText().equals("etiket yazmak için..")) {
                    gizliLabel.setText(lbparsel.getText());

                    gizliLabel.revalidate();
                } else {
                    gizliLabel.setVisible(false);
                    frameparsel.setVisible(false);
                }


                bitti = true;
                FrmAna.frame.setVisible(false);
                infoFrm.frameInfo.setVisible(false);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }




                ekranScreenAl.EkraniAl(FrmAna.xxx, FrmAna.yyy, FrmAna.w, FrmAna.h, GirisYatay.klasorPath,calisilanEkran);



                FrmAna.frame.setLocation(0, 0);
                EkranOlculerifinal ekranOlculerifinal = new EkranOlculerifinal();
                FrmAna.frame.setSize(ekranOlculerifinal.screenWidth - 50, ekranOlculerifinal.screenHeight);
                infoFrm.frameInfo.setVisible(false);
                frameparsel.setVisible(false);

            }

            @Override
            public void mousePressed(MouseEvent e) {


            }
        });
        iptal.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                frameparsel.setVisible(false);
                FrmAna.frame.setLocation(0, 0);
                EkranOlculerifinal ekranOlculerifinal = new EkranOlculerifinal();
                FrmAna.frame.setSize(ekranOlculerifinal.screenWidth - 50, ekranOlculerifinal.screenHeight);
                infoFrm.frameInfo.setVisible(false);
                FrmAna.frame.setVisible(true);
                FrmAna.frame.setEnabled(true);
            }
        });


        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (bitti) {


                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }

                    FrmAna.frame.setVisible(false);

                    if (lbparsel.getText().isEmpty()) {
                        frameparsel.setVisible(false);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }

                    ekranScreenAl.EkraniAl(FrmAna.xxx, FrmAna.yyy, FrmAna.w, FrmAna.h, GirisYatay.klasorPath,calisilanEkran);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }


                    FrmAna.frame.setLocation(0, 0);
                    EkranOlculerifinal ekranOlculerifinal = new EkranOlculerifinal();
                    FrmAna.frame.setSize(ekranOlculerifinal.screenWidth - 50, ekranOlculerifinal.screenHeight);
                    infoFrm.frameInfo.setVisible(false);
                    FrmAna.frame.setVisible(true);
                    timer.stop();
                }
            }
        });




    }



    public void setHint(JTextField textField, String hint) {
        textField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(hint)) {
                    textField.setText("");
                    textField.setForeground(Color.white);
                    textField.setFont(textField.getFont().deriveFont(Font.PLAIN));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.LIGHT_GRAY);
                    textField.setFont(textField.getFont().deriveFont(Font.ITALIC));
                    textField.setText(hint);
                }
            }
        });
    }

    public static void main(String[] args) {

    }
}

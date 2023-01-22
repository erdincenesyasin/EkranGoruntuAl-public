package org.EeE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class GirisYatay extends JFrame {


    public static String klasorPath;
    public static JFrame frame;
    private static ImageIcon icon = new ImageIcon();
    public static void main(String[] args) {



        LocalDate bugun= LocalDate.now();
        LocalDate sonGun=LocalDate.parse("2023-02-05");
        long kalanGun = ChronoUnit.DAYS.between(bugun, sonGun);
        JOptionPane.showMessageDialog(null,"<HTML>Kalan süre " + kalanGun + " gün kaldı <br> SINIRLI SAYIDA KİŞİYLE TEST YAPILMAKTADIR.</HTML>","BETA TEST SÜRÜMÜDÜR Telegram:  İCRA YAZILIM ",JOptionPane.INFORMATION_MESSAGE);
        if(bugun.isAfter(sonGun)){
            //frame.setEnabled(true);
            JOptionPane.showMessageDialog(null,"Programın süresi bitti, Version: V.1.0 'i indirin..","Telegram İCRA YAZILIM ",JOptionPane.INFORMATION_MESSAGE);
            return;

        }


        EkranOlculerifinal ekranOlculerifinal = new EkranOlculerifinal();
        int h = ekranOlculerifinal.screenHeight;
        int w = ekranOlculerifinal.screenWidth;
        int gorevCubugununUstu;

        gorevCubugununUstu = ekranOlculerifinal.gorevCubugununUstu();

        JTextField t1 = new JTextField(), t2 = new JTextField();
        JLabel b1 = new JLabel(), b2 = new JLabel(), b3 = new JLabel();
        JLabel b4 = new JLabel();
        JLabel b5 = new JLabel();
        JTree tree = new JTree();

        frame = new JFrame();



        int x = 40;
        int y = 10;

        frame.setSize(1000, 120);
        frame.setLocation(w / 2 - 500, gorevCubugununUstu - 122);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);

        frame.setResizable(false);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);


        int baslangicX = 80;
        int topMarjini = 15;

        b4.setBounds(baslangicX - 60, topMarjini, 100, 30);
        b4.setText("DOSYA NO");

        b4.setForeground(Color.white);



        t1.setBounds(baslangicX + 10, topMarjini, 120, 30);
        t2.setBounds(baslangicX + 10, topMarjini + 50, 120, 30);
        b5.setBounds(baslangicX -60, topMarjini + 10, 100, 100);
        b5.setPreferredSize(new Dimension(40,40));



        frame.add(b4);
        frame.add(b5);

        t1.setFont(new Font("Serif", Font.BOLD, 25));
        t2.setFont(new Font("Serif", Font.BOLD, 25));

        frame.add(t1);
        frame.add(t2);

        JPanel panelOrta = new JPanel();
        panelOrta.setBounds(baslangicX + 600, 0, 400, 120);


        panelOrta.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JLabel labelinfo = new JLabel();
        labelinfo.setText("<html>Eğitim amaçlı kodlanmıştır. Testleri bitmemiştir. Ücretsizdir.<br>Hata ve öneri bildirimi için erdinc_19@hotmail.com</html>");

        labelinfo.setBounds(baslangicX + 550, 0, 360, 120);

        labelinfo.setFont(new Font("Serif", Font.BOLD, 20));
        labelinfo.setForeground(Color.WHITE);

        labelinfo.setFocusable(true);
        frame.add(labelinfo);


        GirisYatay girisYatay = new GirisYatay();

        b1.setIcon(girisYatay.iconYap("beyaz48.png"));
        b2.setIcon(girisYatay.iconYap("beyazok48.png"));
        b5.setIcon(girisYatay.iconYap("folder40.png"));

        b1.setBounds(baslangicX + 160, topMarjini, 100, 100);
        b2.setBounds(baslangicX + 270, topMarjini, 100, 100);

        b1.setHorizontalAlignment(SwingConstants.CENTER);
        b1.setVerticalAlignment(SwingConstants.CENTER);
        b2.setHorizontalAlignment(SwingConstants.CENTER);
        b2.setVerticalAlignment(SwingConstants.CENTER);

        ToolTipManager.sharedInstance().setInitialDelay(0);

        b1.setToolTipText("Çizerek ekran resmi alın");
        b2.setToolTipText("800*600 sabit ölçüde resim alın");

        frame.add(b1);
        frame.add(b2);
        JLabel closeLabel = new JLabel("Kapat");
        closeLabel.setFont(new Font("Serif", Font.BOLD, 30));
        closeLabel.setForeground(Color.WHITE);
        closeLabel.setBounds(baslangicX + 400, topMarjini, 100, 90);
        closeLabel.setHorizontalAlignment(SwingConstants.CENTER);


        frame.add(closeLabel);


        Dimension dimension = new Dimension(20, 10);
        b3.setPreferredSize(dimension);

        Color green = new Color(10, 112, 11, 255);
        Color lighgreen = green.brighter();
        frame.getContentPane().setBackground(lighgreen);

        frame.setLayout(null);
        frame.setIconImage(girisYatay.iconYap("su.png").getImage());
        frame.setVisible(true);



        ///listenerler
        labelinfo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                labelinfo.setText("<html>Eğitim amaçlı kodlanmıştır. Testleri bitmemiştir. Ücretsizdir.<br>Hata ve öneri bildirimi için erdinc_19@hotmail.com</html>");

            }
        });

        t1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                t1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
                labelinfo.setText("<html>Dosya numarasını yaz<br>Boş bırakabilirsiniz. Boş bırakırsanız DOSYANOYAZILMAYANLAR klasörüne kaydedilir.</html>");


            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                t1.setBorder(BorderFactory.createEmptyBorder());
            }
        });


        t2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                t2.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                t2.setBorder(BorderFactory.createEmptyBorder());
            }
        });


        closeLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                System.exit(0);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                closeLabel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                labelinfo.setText("<html>PROGRAMI KAPATIR.</html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {

                closeLabel.setBorder(BorderFactory.createEmptyBorder());
                labelinfo.setText("<html><br></html>");
            }
        });


        t1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {

                if (t1.getText().length() >= 4) {
                    e.consume();
                    t2.requestFocus();
                }
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });

        t1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (t1.getText().length() >= 4) {

                    t2.requestFocus();
                }
            }
        });
        t2.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {


                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });


        b2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                DosyaAdiYoneticisi dosyaAdiYoneticisi = new DosyaAdiYoneticisi();
                klasorPath = dosyaAdiYoneticisi.klasorPATHolustur(t1.getText(), t2.getText());
                SabitEkranAlfrm sabitEkranAlfrm = new SabitEkranAlfrm();
                sabitEkranAlfrm.frameSabit.setVisible(true);
                t1.setText("");
                t2.setText("");
                frame.setVisible(false);


            }

            @Override
            public void mousePressed(MouseEvent e) {
                icon = new ImageIcon(getClass().getResource("/siyahok48.png"));
                b2.setIcon(icon);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                icon = new ImageIcon(getClass().getResource("/beyazok48.png"));
                b2.setIcon(icon);

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                icon = new ImageIcon(getClass().getResource("/siyahok48.png"));
                b2.setIcon(icon);
                b2.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                labelinfo.setText("<html>800*600 ölçülerinde resim alın <br>Açılan pencerenin ortasına fare ile basıp taşıyın..</html>");

            }

            @Override
            public void mouseExited(MouseEvent e) {
                icon = new ImageIcon(getClass().getResource("/beyazok48.png"));
                b2.setIcon(icon);
                b2.setBorder(BorderFactory.createEmptyBorder());
                labelinfo.setText("");

            }
        });

        b1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                DosyaAdiYoneticisi dosyaAdiYoneticisi = new DosyaAdiYoneticisi();
                klasorPath = dosyaAdiYoneticisi.klasorPATHolustur(t1.getText(), t2.getText());
                t1.setText("");
                t2.setText("");
                new FrmAna();
                frame.setVisible(false);

            }

            @Override
            public void mousePressed(MouseEvent e) {

                ImageIcon icon = new ImageIcon(getClass().getResource("/beyaz48.png"));
                b1.setIcon(icon);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

                ImageIcon icon = new ImageIcon(getClass().getResource("/siyah48.png"));
                b1.setIcon(icon);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

                ImageIcon icon = new ImageIcon(getClass().getResource("/siyah48.png"));
                b1.setIcon(icon);
                b1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
                labelinfo.setText("<html>Fare ile çizim yapın<br>Ekranda fare ile çizdiğiniz <br> alanını resmini alır</html>");

            }

            @Override
            public void mouseExited(MouseEvent e) {

                ImageIcon icon = new ImageIcon(getClass().getResource("/beyaz48.png"));
                b1.setIcon(icon);
                b1.setBorder(BorderFactory.createEmptyBorder());
                labelinfo.setText("");

            }
        });

        b5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
              KlasoruGoster klasorGoster=  new KlasoruGoster();
              klasorGoster.klasoruGoster();


            }
        });

    }

    public ImageIcon iconYap(String iconDosyaAdi) {

        ImageIcon icon = new ImageIcon(getClass().getResource("/" + iconDosyaAdi));

        return icon;
    }
}

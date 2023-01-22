package org.EeE;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FrmAna {
    public static JFrame frame;
    public static int firstxx, firstyy;
    public static boolean basla = false;

    public static int xxx, yyy, w, h;
    Timer timer;

    public FrmAna() {


        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        int screenWidth = env.getMaximumWindowBounds().width;
        int screenHeight = env.getMaximumWindowBounds().height;

        int frameWidth = 0;
        int frameHeight = 0;
        int x = screenWidth - frameWidth;
        int y = screenHeight - frameHeight;


        frame = new JFrame();

        frame.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));


        frame.setSize(screenWidth - 50, screenHeight);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.setOpacity(0.5f);

        Color green = new Color(9, 218, 10);
        Color lighgreen = green.brighter();
        frame.getContentPane().setBackground(lighgreen);


        JLabel label = new JLabel();


        ImageIcon icon2 = new ImageIcon(getClass().getResource("/close48.png"));
        label.setIcon(icon2);
        label.setBounds(frame.getWidth() - 200, 90, 90, 90);


        frame.add(label);
        frame.setLayout(null);


        frame.setVisible(true);


        MouseListener listener2 = new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {


                    basla = true;


                    firstxx = Robot.getMousePosition().x;
                    firstyy = Robot.getMousePosition().y;
                    frame.setLocation(firstxx, firstyy);
                    frame.setSize(0, 0);
                    Robot.trackMousePosition();


                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {

                if (e.getButton() == MouseEvent.BUTTON1) {

                    basla = false;
                    EkranScreenAl ekranScreenAl = new EkranScreenAl();
                    xxx = frame.getLocation().x;
                    yyy = frame.getLocation().y;
                    w = frame.getSize().width;
                    h = frame.getSize().height;


                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }

                    if (!(w < 1) && !(h < 1)) {


                        FrmEtiket etiket = new FrmEtiket(FrmAna.frame);

                    } else {


                        JOptionPane.showMessageDialog(null, "Geçersiz boyut girdiniz", "HATALI SEÇİM", JOptionPane.ERROR_MESSAGE);
                        FrmAna.frame.setLocation(0, 0);

                        EkranOlculerifinal ekranOlculerifinal = new EkranOlculerifinal();
                        FrmAna.frame.setSize(ekranOlculerifinal.screenWidth - 50, ekranOlculerifinal.screenHeight);


                        infoFrm.frameInfo.setVisible(false);

                        FrmAna.frame.setEnabled(true);


                    }
                }

            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        };

        frame.addMouseListener(new

                                       MouseAdapter() {
                                           public void mouseEntered(MouseEvent e) {

                                               Insets insets = frame.getInsets();

                                           }
                                       });


        frame.addMouseListener(listener2);


        label.addMouseListener(new

                                       MouseListener() {
                                           @Override
                                           public void mouseClicked(MouseEvent e) {
                                               frame.setVisible(false);
                                               infoFrm.frameInfo.setVisible(false);
                                               GirisYatay.frame.setVisible(true);


                                               new Reset();//sabitleri sıfırlıyor..


                                           }

                                           @Override
                                           public void mousePressed(MouseEvent e) {

                                           }

                                           @Override
                                           public void mouseReleased(MouseEvent e) {

                                           }

                                           @Override
                                           public void mouseEntered(MouseEvent e) {

                                           }

                                           @Override
                                           public void mouseExited(MouseEvent e) {

                                           }
                                       });
    }

    public static void main(String[] args) {
        new FrmAna();
    }
}

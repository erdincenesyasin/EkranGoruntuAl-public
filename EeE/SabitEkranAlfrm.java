package org.EeE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

public class SabitEkranAlfrm {
    public final JFrame frameSabit;
    private final JLabel lb;
    private final JFrame ustKapak;

    private TimerTask task;
    private Timer timer;

    public SabitEkranAlfrm() {


        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        int screenWidth = env.getMaximumWindowBounds().width;
        int screenHeight = env.getMaximumWindowBounds().height;

        int frameWidth = 0;
        int frameHeight = 0;
        int x = screenWidth - frameWidth;
        int y = screenHeight - frameHeight;


        frameSabit = new JFrame();
        frameSabit.setSize(800, 600);


        frameSabit.setUndecorated(true);
        frameSabit.setOpacity(0.5f);


        JLabel l1 = new JLabel();
        l1.setBackground(Color.RED);

        Color green = new Color(9, 218, 10);
        Color lighgreen = green.brighter();
        frameSabit.getContentPane().setBackground(lighgreen);
        frameSabit.setLayout(null);


        ImageIcon icon = new ImageIcon(getClass().getResource("/beyazOk.png"));
        l1.setIcon(icon);

        l1.setBounds(364, 264, 72, 72);
        l1.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setVerticalAlignment(SwingConstants.CENTER);
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setVerticalAlignment(SwingConstants.CENTER);

        frameSabit.add(l1);
        frameSabit.setLocationRelativeTo(null);


        JLabel label = new JLabel();


        ImageIcon icon2 = new ImageIcon(getClass().getResource("/close48.png"));
        label.setIcon(icon2);
        label.setBounds(650, 60, 90, 90);
        frameSabit.add(label);

        ustKapak = new JFrame();
        ustKapak.setSize(550, 55);
        ustKapak.setUndecorated(true);
        ustKapak.getContentPane().setBackground(Color.RED);
        lb = new JLabel("800*600 BOYUTTA RESİM AL. yeşil ekranı resim alınacak alana taşıyın.");
        lb.setFont(new Font("Arial", Font.PLAIN, 20));
        lb.setForeground(Color.WHITE);
        ustKapak.add(lb);
        ustKapak.setLocation(frameSabit.getLocation().x, frameSabit.getLocation().y - 55);
        ustKapak.setVisible(true);

        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                frameSabit.setVisible(false);
                GirisYatay.frame.setVisible(true);
                GirisYatay.klasorPath = "";
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

        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                ustKapak.setVisible(false);
                timer = new Timer();

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        frameSabit.setLocation(MouseInfo.getPointerInfo().getLocation().x - frameSabit.getWidth() / 2, MouseInfo.getPointerInfo().getLocation().y - frameSabit.getHeight() / 2);

                    }
                }, 10, 100);


            }

            @Override
            public void mouseReleased(MouseEvent e) {

                timer.cancel();


                EkranScreenAl ekranScreenAl = new EkranScreenAl();
                int x = frameSabit.getLocation().x;
                int y = frameSabit.getLocation().y;
                int w = 800;
                int h = 600;
                frameSabit.setVisible(false);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                ekranScreenAl.EkraniAl(x, y, w, h, GirisYatay.klasorPath, frameSabit);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                frameSabit.setVisible(true);


            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };


        l1.addMouseListener(mouseListener);
        ustKapak.setVisible(false);
        frameSabit.setVisible(true);
    }

    public static void main(String[] args) {
        new SabitEkranAlfrm();
    }

}

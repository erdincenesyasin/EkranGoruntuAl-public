package org.EeE;

import java.awt.*;

public class EkranOlculerifinal {
    final GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    final public int screenWidth = env.getMaximumWindowBounds().width;

    final public int screenHeight = env.getMaximumWindowBounds().height;

    public int gorevCubugununUstu() {

        Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();

        int taskBarHeight = scrnSize.height - winSize.height;

        return screenHeight;
    }
}


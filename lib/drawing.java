package com.example.lib;

import java.awt.*;
import javax.swing.*;


/**
 * Created by Anna on 4/15/2018.
 */

public class drawing extends JComponent{
    public void draw(){
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // This paints the background

        g.setColor(Color.BLACK);
        g.fillRect(200, 150, 400, 250);
    }


}

package com.example.lib;

import java.awt.*;
import javax.swing.*;

/**
 * Created by Anna on 4/15/2018.
 */

public class testG {
    public static void main(String[] args){
        JFrame frame = new JFrame("teeest");
        JPanel panel = new JPanel();


        frame.setVisible(true);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawing thing = new drawing();

        frame.add(thing);
        thing.draw();




    }
}

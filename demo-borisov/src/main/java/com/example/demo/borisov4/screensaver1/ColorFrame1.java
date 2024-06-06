package com.example.demo.borisov4.screensaver1;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

// TODO: remove this
//@Component
public  class ColorFrame1 extends JFrame {

    public ColorFrame1() {
        setTitle("ColorFrame-1");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void showOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1000), random.nextInt(600));
        getContentPane().setBackground(getColor());
        repaint();
    }

    @Lookup
    public Color getColor() {
        return null;
    };
}

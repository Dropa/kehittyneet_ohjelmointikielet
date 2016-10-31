package com.tasks1;

import javax.swing.*;
import java.awt.*;

public class T2 extends JPanel {

    public static void main(String[] args) {
        JFrame mainWindow = new JFrame("Average calculator");
        mainWindow.setSize(400,200);
        T2 pane = new T2();

        String number;
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            number = JOptionPane.showInputDialog("Insert number: ");
            sum = sum + Integer.parseInt(number);
        }

        JLabel average = new JLabel("Average: " + String.valueOf((float) sum / 5));
        average.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        pane.add(average);
        mainWindow.setContentPane(pane);
        mainWindow.setVisible(true);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.YELLOW);
    }

}

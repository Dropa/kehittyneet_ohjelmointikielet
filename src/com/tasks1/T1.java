package com.tasks1;

import javax.swing.*;

public class T1 {

    public static void main(String[] args) {

        String number;
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            number = JOptionPane.showInputDialog("Insert number: ");
            sum = sum + Integer.parseInt(number);
        }

        JOptionPane.showMessageDialog(null, "Average: " + (float) sum/5, "So fancy average", JOptionPane.PLAIN_MESSAGE);

        System.exit(0);
    }
}

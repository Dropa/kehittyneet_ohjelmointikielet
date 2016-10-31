package com.tasks1;

import javax.swing.*;

public class T4 {
    static public void main(String[] args){
        int operations;
        int i = 1;
        int divider = 1;
        double pii = 0;

        String input = JOptionPane.showInputDialog("Insert number: ");
        operations = Integer.parseInt(input);
        boolean operand = true; //start with + due to 0 + (4/1)
        while(i <= operations){
            if (operand){
                pii = pii + (4.0 / divider);
            }
            else {
                pii = pii - (4.0 / divider);
            }
            operand = !operand;
            divider = divider + 2;
            i++;
        }
        System.out.print("Approximate value of pi with " + operations + " operations: ");
        System.out.print(pii + "\n");

    }
}

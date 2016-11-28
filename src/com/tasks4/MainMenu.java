package com.tasks4;

import javax.swing.*;

public class MainMenu {

    public static void main(String[] args) {

        TimerListener myListener = () -> System.out.println("my listener triggered 10seconds");

        Timer timer = new Timer();
        timer.start();
        timer.setTimerListener(myListener);

        boolean running = true;
        while (running) {
            String options = "1. Start timer\n" +
                    "\n" +
                    "2. Stop timer\n" +
                    "\n" +
                    "3. Set timer interval\n" +
                    "\n" +
                    "4. Set timer priority\n" +
                    "\n" +
                    "5. Exit program"+
                    "\n";
            String selection = JOptionPane.showInputDialog(null, options);
            switch (selection) {
                default:
                    System.out.println("Unsupported input.");
                    break;
                case "1":
                    timer.unpause();
                    System.out.println("Resuming timer.");
                    break;
                case "2":
                    timer.pause();
                    System.out.println("Paused timer.");
                    break;
                case "3":
                    int interval = Integer.parseInt(JOptionPane.showInputDialog(null, "Select interval"));
                    timer.setInterval(interval);
                    System.out.println("Interval updated.");
                    break;
                case "4":
                    int priority = Integer.parseInt(JOptionPane.showInputDialog(null, "Select priority"));
                    timer.setPriority(priority);
                    System.out.println("Priority updated.");
                    break;
                case "5":
                    timer.exit();
                    running = false;
                    System.out.println("Exiting program.");
                    break;
            }
        }

    }

}

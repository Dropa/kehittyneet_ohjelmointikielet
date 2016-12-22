package com.harkka;

import javax.swing.*;

/**
 * Class MainMenu.
 *
 * @see Runner
 */
public class MainMenu {

    /**
     * Main function.
     *
     * Awesome Weather machine. Fetches weather once a minute or when forced.
     *
     * @param args String
     */
    public static void main(String[] args) {

        Runner runner = new Runner();
        runner.start();
        boolean running = true;
        while (running) {
            String options = "1. Force update\n" +
                    "\n" +
                    "2. Print all fetched\n" +
                    "\n" +
                    "3. Pause autorunner\n" +
                    "\n" +
                    "4. Continue autorunner\n" +
                    "\n" +
                    "5. Clear all fetched\n" +
                    "\n" +
                    "0. Exit program" +
                    "\n";
            String selection = JOptionPane.showInputDialog(null, options);
            switch (selection) {
                default:
                    System.out.println("Invalid input.");
                    break;
                case "1":
                    runner.fetchNow();
                    break;
                case "2":
                    runner.print();
                    break;
                case "3":
                    runner.pause();
                    break;
                case "4":
                    runner.unpause();
                    break;
                case "5":
                    runner.clear();
                    break;
                case "0":
                    runner.exit();
                    running = false;
                    break;
            }
        }
    }
}


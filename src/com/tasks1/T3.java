package com.tasks1;

public class T3 {
    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {
            printMarks(i);
        }
        for (int i = 1; i <= 5; i++){
            printMarks(6 - i);
        }
    }

    private static void printMarks(int marks) {
        char mark = '*';
        for (int i = 1; i <= marks; i++) {
            System.out.print(mark);
        }
        System.out.print("\n");
    }
}

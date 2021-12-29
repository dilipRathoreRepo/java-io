package com.diliprathore.java;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DivideExample {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int x = getInt();
        int y = getInt();
        System.out.println("Division is " + (x/y));
    }

    private static int getInt() {
        System.out.println("enter a valid int");
        while (true) {
            try {
                return scanner.nextInt();
            } catch (NoSuchElementException e) {
                scanner.nextLine();
                System.out.println("Enter only digits between 0 and 9");
            }
        }
    }
}

package com.diliprathore.java;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class DivideExampleThrowException {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            System.out.println(division());
        } catch (ArithmeticException | NoSuchElementException e) {
            System.out.println(e.toString());
        }

    }

    private static int division() {
        int x, y;
        try {
            x = getInt();
            y = getInt();
            return x/y;
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Invalid integer entered");
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Attempt to divide by Zero");
        }
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

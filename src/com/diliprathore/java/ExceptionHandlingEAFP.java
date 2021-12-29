package com.diliprathore.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingEAFP {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter int");
        int inputInt;

        try {
            inputInt = s.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException occurred");
            inputInt = 0;
        }

        System.out.println("Entered Number -> " + inputInt);
    }
}

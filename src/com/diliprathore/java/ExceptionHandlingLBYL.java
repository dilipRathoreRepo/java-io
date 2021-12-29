package com.diliprathore.java;

import java.util.Scanner;

public class ExceptionHandlingLBYL {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter int");
        String input = s.nextLine();
        boolean isValid = true;
        for (int i=0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                isValid = false;
                break;
            }
        }
        int result = isValid ? Integer.parseInt(input) : 0;
        System.out.println("Entered Number -> " + result);
    }
}

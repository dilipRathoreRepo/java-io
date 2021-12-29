package com.diliprathore.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReader_ScannerAndBufferedReader {
    public static void main(String[] args) {
//        Scanner scanner = null;
//        try {
//            scanner = new Scanner(new BufferedReader(new FileReader("exits.txt")));
//            scanner.useDelimiter(",");
//            while (scanner.hasNextLine()) {
//                int location = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String direction = scanner.next();
//                scanner.skip(scanner.delimiter());
//                String dest = scanner.nextLine();
//                int destination = Integer.parseInt(dest);
//                System.out.println(location + ":" + direction + ":" + destination);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (scanner != null) {
//                scanner.close();
//            }
//        }
//

        // Using 'try with resources approach
//        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("exits.txt")))){
//            scanner.useDelimiter(",");
//            while (scanner.hasNextLine()) {
//                int location = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String direction = scanner.next();
//                scanner.skip(scanner.delimiter());
//                String dest = scanner.nextLine();
//                int destination = Integer.parseInt(dest);
//                System.out.println(location + ":" + direction + ":" + destination);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        // remove using Scanner approach
        try (BufferedReader br = new BufferedReader(new FileReader("exits.txt"))) {
            String input;
            while ((input = br.readLine()) != null ) {
                String[] data = input.split(",");
                int location = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                System.out.println(location + ":" + direction + ":" + destination);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

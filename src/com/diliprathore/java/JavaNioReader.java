package com.diliprathore.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class JavaNioReader {

    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("nio_out_file.txt");
        try (Scanner scanner = new Scanner(path)) {
            scanner.useDelimiter(":");
            while (scanner.hasNextLine()) {
                int id = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String name = scanner.next();
                scanner.skip(scanner.delimiter());
                String subject = scanner.next();
                scanner.skip(scanner.delimiter());
                int score = Integer.parseInt(scanner.nextLine());
                System.out.println(id + "|" + name + "|" + subject + "|" + score);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

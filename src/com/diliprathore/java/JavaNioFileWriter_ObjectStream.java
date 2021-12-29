package com.diliprathore.java;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class JavaNioFileWriter_ObjectStream {
    public static void main(String[] args) {
        int id = 10;
        String name = "Dilip";

        Path path = FileSystems.getDefault().getPath("nio_out_file_using_objectStream.dat");
        try(ObjectOutputStream outFile = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))){
            outFile.writeObject(new Student(id, name));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Reading .dat file again..");

        try(ObjectInputStream inFile = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(path)))) {
            boolean eof = false;
            Student input;
            while (!eof) {
                try {
                    input = (Student) inFile.readObject();
                    System.out.println("Student -> " + input);
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Student implements Serializable {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.id + ":" + this.name;
    }
}

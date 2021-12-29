package com.diliprathore.java;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ByteStreams {
    // uses InputStream & OutputStream instead of using FileReader and FileWriter.
    // Better use DataInputStream & DataOutputStream classes as they allow us to work directly with Java primitive types (including String) by offering methods such as 'readInt' etc.

    static Map<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        map.put(1, "dilip");
        map.put(2, "rathore");

        try(DataOutputStream os = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("out.dat")))) {
            for (Map.Entry<Integer, String> entry: map.entrySet()) {
                os.writeInt(entry.getKey());
                os.writeUTF(entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Reading out.txt..");
        try(DataInputStream inputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("out.dat")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    int id = inputStream.readInt();
                    String name = inputStream.readUTF();
                    System.out.println(id + ":" + name);
                } catch (EOFException e)  {
                    eof = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

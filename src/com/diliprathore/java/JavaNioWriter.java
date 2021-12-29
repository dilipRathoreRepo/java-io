package com.diliprathore.java;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class JavaNioWriter {
    /**
     * Better performance than IO. Non blocking threads. Works at block level instead of character/byte level.
     */

    private int id;
    private String name;
    private Map<String, Integer> marks;

    public JavaNioWriter(int id, String name, Map<String, Integer> marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Maths", 100);
        map.put("Eng", 98);

        JavaNioWriter javaNioExample = new JavaNioWriter(1, "Chanu", map);

        Path filePath = FileSystems.getDefault().getPath("nio_out_file.txt");
        try(BufferedWriter bf = Files.newBufferedWriter(filePath)) {
            for(Map.Entry<String, Integer> item: map.entrySet()) {
                bf.write(javaNioExample.id + ":" + javaNioExample.name + ":" + item.getKey() + ":" + item.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

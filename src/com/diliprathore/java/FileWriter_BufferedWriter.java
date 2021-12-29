package com.diliprathore.java;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<String, Integer>(exits);
        this.exits.put("Q", 0);
    }

//    public void addExit(String direction, int location) {
//        exits.put(direction, location);
//    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }
}

class FileWriterExample {
    static Map<Integer, Location> locations = new HashMap<>();
    static {
        Map<String, Integer> tempExit = new HashMap<>();
        tempExit.put("A", 0);
        Location location1 = new Location(1, "location1", tempExit);

        tempExit = new HashMap<>();
        tempExit.put("B", 1);
        tempExit.put("C", 2);
        Location location2 = new Location(2, "location2", tempExit);

        locations.put(0, location1);
        locations.put(1, location2);
    }

//    public static void main(String[] args) {
//        try (FileWriter locFile = new FileWriter("locations.txt");
//             FileWriter exitsFile = new FileWriter("exits.txt")) {
//
//            for (Location location : locations.values()) {
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//                for (Map.Entry<String, Integer> entry: location.getExits().entrySet()) {
//                    if (!entry.getKey().equals("Q"))
//                        exitsFile.write(location.getLocationID() + "," + entry.getKey() + "," + entry.getValue() + "\n");
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    public static void main(String[] args) {
        try (BufferedWriter locFile = new BufferedWriter(new FileWriter("locations.txt"));
             BufferedWriter exitsFile = new BufferedWriter(new FileWriter("exits.txt"))) {

            for (Location location : locations.values()) {
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for (Map.Entry<String, Integer> entry: location.getExits().entrySet()) {
                    if (!entry.getKey().equals("Q"))
                        exitsFile.write(location.getLocationID() + "," + entry.getKey() + "," + entry.getValue() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

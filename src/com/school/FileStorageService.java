package com.school;

import java.io.*;
import java.util.List;

public class FileStorageService {
    public void saveData(List<? extends Storable> items, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Storable item : items) {
                writer.println(item.toDataString());
            }
        } catch (IOException e) {
            System.out.println("Error saving data to " + filename + ": " + e.getMessage());
        }
    }
}

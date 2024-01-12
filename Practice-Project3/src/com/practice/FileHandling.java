package com.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling {

    public static void main(String[] args) {
        String fileName = "example.txt";

        // Write to file
        writeToFile(fileName, "This is a program for File Handling.");

        // Read from file
        String text = readFromFile(fileName);
        System.out.println("Reading content from file: " + text);

        // Append to file
        appendToFile(fileName, " Appending text to a file.");

        // Read again after appending
        text = readFromFile(fileName);
        System.out.println("File after appending: " + text);
    }

    private static void writeToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("Content written to file successfully.");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    private static String readFromFile(String fileName) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
            	text.append(line).append("\n");
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    private static void appendToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(content);
            System.out.println("Appended a text to file successfully.");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

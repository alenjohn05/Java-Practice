package org.file_operations;// FileReadWriteExample.java
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class FileReadWriteExample {

    private static void writeToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("This is the initial content.");
            System.out.println("Content written to the file.");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    private static void appendToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write("\nThis is additional content.");
            System.out.println("Content appended to the file.");
        } catch (IOException e) {
            System.err.println("Error appending to the file: " + e.getMessage());
        }
    }

    private static void readFileContent(String filePath) {
        try {
            Path path = Paths.get(filePath);
            List<String> lines = Files.readAllLines(path);

            System.out.println("File content:");
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public void fileReadWrite(){
        String filePath = "users/newfile.txt";
        // Write content to the file
        FileReadWriteExample.writeToFile(filePath);
        // Append content to the file
        FileReadWriteExample.appendToFile(filePath);
        // Read and display the file content
        FileReadWriteExample.readFileContent(filePath);
    }

    public void differentFileReadingExamples(){
        System.out.println("Start reading file with different Reading techniques........");
        String filePathBufferedReader = "users/newfile.txt"; // Replace with your file path
        try (BufferedReader reader = new BufferedReader(new FileReader(filePathBufferedReader))) {
            System.out.println("Reading with BufferedReader:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading with BufferedReader: " + e.getMessage());
        }

        // Using Scanner
        String filePathScanner = "users/newfile.txt"; // Replace with your file path
        try {
            Scanner scanner = new Scanner(new File(filePathScanner));
            System.out.println("\nReading with Scanner:");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found with Scanner: " + e.getMessage());
        }

        // Using Files (Java NIO)
        String filePathFiles = "users/newfile.txt"; // Replace with your file path
        try {
            Path path = Paths.get(filePathFiles);
            List<String> lines = Files.readAllLines(path);

            System.out.println("\nReading with Files (Java NIO):");
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading with Files (Java NIO): " + e.getMessage());
        }
        System.out.println("Finished reading file with different Reading techniques........");
    }

    public void openingAFile(){
        String filePath = "users/file.txt"; // Replace with your file path

        // Reading using BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Reading using BufferedReader:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file with BufferedReader: " + e.getMessage());
        }

        // Writing using BufferedWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            System.out.println("\nWriting using BufferedWriter:");
            writer.write("Hello, writing to file!");
            System.out.println("Content written successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to the file with BufferedWriter: " + e.getMessage());
        }

        // RandomAccessFile for both read and write operations
        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {
            System.out.println("\nRandomAccessFile for both reading and writing:");
            String line;
            while ((line = file.readLine()) != null) {
                System.out.println(line);
            }
            // Seek to a specific position and write content
            file.seek(file.length());
            file.writeBytes("\nAppending with RandomAccessFile!");
            System.out.println("Content appended successfully.");
        } catch (IOException e) {
            System.err.println("Error accessing the file with RandomAccessFile: " + e.getMessage());
        }
    }
}

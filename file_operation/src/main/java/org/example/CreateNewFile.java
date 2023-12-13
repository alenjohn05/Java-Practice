package org.example;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreateNewFile {
    public void createNewFile() {
        try {
            // Creates a File.txt in tmp with Absolute path
            String fileSeparator = FileSystems.getDefault().getSeparator();
            // Absolute path
            String absoluteFilePath = fileSeparator + "Users" + fileSeparator + "pankaj" + fileSeparator + "file.txt";
            // Create directories if they don't exist
            Path filePath = FileSystems.getDefault().getPath(absoluteFilePath);
            System.out.println(filePath);
            Files.createDirectories(filePath.getParent());
            File file = new File(String.valueOf(filePath));
            if (file.createNewFile()) {
                System.out.println(filePath + " File Created");
            } else {
                System.out.println("File " + filePath + " already exists");
            }



            // Creates a File.txt in tmp with relative path
            Path relativePath = FileSystems.getDefault().getPath("tmp", "file.txt");
            // Create directories if they don't exist
            Files.createDirectories(relativePath.getParent());
            // Create the file
            file = new File(String.valueOf(relativePath));
            if (file.createNewFile()) {
                System.out.println(relativePath + " File Created");
            } else {
                System.out.println("File " + relativePath + " already exists");
            }
        } catch (Exception e) {
            System.out.println("Error occurred in file creation: " + e.getMessage());
        }
    }
}

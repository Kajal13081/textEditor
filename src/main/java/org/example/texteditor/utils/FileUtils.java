package org.example.texteditor.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

    // Utility class to read and write files
    public static String readFile(File file) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(file.toURI()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static void writeFile(File file, String content) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file.toURI()))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.softswiss.go.dev;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;

public class FileReader {

    private FileReader() {
    }

    public static String getFileContent(String fileName) {
        ClassLoader classLoader = FileReader.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
        String result = null;
        try {
            List<String> list = Files.readAllLines(file.toPath());
            StringBuilder queryTemplateBuilder = new StringBuilder();
            for (String line : list) {
                queryTemplateBuilder.append(line).append(" ");
            }
            result = queryTemplateBuilder.toString().trim();
        } catch (IOException e) {
            System.out.println("Error occurs while reading file " + Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
        }
        return result;
    }
}
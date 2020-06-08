package com.softswiss.go.dev;

import java.util.stream.Stream;


public class Main {
    private static final String DELIMITER = " ";

    public static void main(String[] args) {
        String fileContent1 = FileReader.getFileContent("array1.txt");
        String fileContent2 = FileReader.getFileContent("array2.txt");
        Integer[] array1 = Stream.of(fileContent1.split(DELIMITER)).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] array2 = Stream.of(fileContent2.split(DELIMITER)).map(Integer::parseInt).toArray(Integer[]::new);
        for(Integer item : ArrayUtils.combine(array1, array2)) {
            System.out.println(item);
        }
    }
}
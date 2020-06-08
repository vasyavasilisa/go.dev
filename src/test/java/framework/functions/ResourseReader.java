package framework.functions;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class ResourseReader {


    public static String getResourceFileContent(String resourceName) {
        File file = new File(resourceName);
        String result;
        try {
            List<String> list = Files.readAllLines(file.toPath());
            StringBuilder queryTemplateBuilder = new StringBuilder();
            for (String line : list) {
                queryTemplateBuilder.append(line).append(" ");
            }
            result = queryTemplateBuilder.toString().trim();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return result;
    }
}
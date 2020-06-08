package framework.functions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class JsonParser {
    private final ObjectMapper mapper = new ObjectMapper();
    private final String content;

    public JsonParser(String resourceName) {
        this.content = ResourseReader.getResourceFileContent(System.getProperty("user.dir") + "//src/test/resources/" +
                resourceName);
    }

    public Object getValue(String jsonPath) {
        return this.getEnvValueOrDefault(jsonPath);
    }

    private Object getEnvValueOrDefault(String jsonPath) {
        JsonNode node = this.getJsonNode(jsonPath);
        if (node.isBoolean()) {
            return node.asBoolean();
        } else if (node.isLong()) {
            return node.asLong();
        } else {
            return node.isInt() ? node.asInt() : node.asText();
        }
    }

    public Map<String, Object> getMap(String jsonPath) {
        Iterator<Map.Entry<String, JsonNode>> iterator = this.getJsonNode(jsonPath).fields();
        Map<String, Object> result = new HashMap<>();
        iterator.forEachRemaining((entry) -> {
            result.put(entry.getKey(), this.getValue(jsonPath + "/" + entry.getKey()));
        });
        return result;
    }

    public List<String> getList(String jsonPath) {
        List<String> list = new ArrayList<>();
        this.getJsonNode(jsonPath).elements().forEachRemaining((node) -> {
            list.add(node.asText());
        });
        return list;
    }

    private JsonNode getJsonNode(String jsonPath) {
        String errorMessage = String.format("Json field by json-path %1$s was not found in the file %2$s", jsonPath, this.content);
        JsonNode nodeAtPath;
        try {
            JsonNode node = this.mapper.readTree(this.content);
            nodeAtPath = node.at(jsonPath);
        } catch (IOException var6) {
            throw new UncheckedIOException(errorMessage, var6);
        }
        return nodeAtPath;
    }

    private String getFileContent(String filename) {
        try {
            return new String(Files.readAllBytes(Paths.get(filename)));
        } catch (IOException var3) {
            throw new UncheckedIOException(String.format("Content of file %1$s can't be read as String", filename), var3);
        }
    }
}
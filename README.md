import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ParseYamlWithoutDto {
    public static void main(String[] args) {
        String yamlFilePath = "path/to/your/input.yml";

        // Create an ObjectMapper for YAML
        ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());

        try {
            // Read YAML file and convert to JsonNode
            JsonNode rootNode = yamlReader.readTree(new File(yamlFilePath));

            // Create a map to store origin values with filenames as keys
            Map<String, String> origins = new HashMap<>();

            // Iterate through the YAML structure
            Iterator<JsonNode> fileDataIterator = rootNode.elements();
            while (fileDataIterator.hasNext()) {
                JsonNode fileDataNode = fileDataIterator.next();
                String fileName = fileDataNode.path("FileName").asText();

                JsonNode detailsNode = fileDataNode.path("details");
                Iterator<JsonNode> detailsIterator = detailsNode.elements();
                while (detailsIterator.hasNext()) {
                    JsonNode detailNode = detailsIterator.next();
                    String origin = detailNode.path("ORIGIN").asText();
                    origins.put(fileName, origin);
                }
            }

            // Print the origin values
            origins.forEach((key, value) -> System.out.println("FileName: " + key + ", Origin: " + value));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonPrettyPrinter<T> {
    private static final Logger logger = LoggerFactory.getLogger(JsonPrettyPrinter.class);
    private final ObjectWriter objectWriter;

    public JsonPrettyPrinter() {
        ObjectMapper objectMapper = new ObjectMapper();
        this.objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
    }

    public String prettyPrint(T object) {
        try {
            return objectWriter.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error("Failed to pretty print JSON", e);
            return object.toString(); // Return the original object's string representation if an error occurs
        }
    }

    public String prettyPrintJsonString(String jsonString) {
        try {
            Object jsonObject = new ObjectMapper().readValue(jsonString, Object.class);
            return objectWriter.writeValueAsString(jsonObject);
        } catch (JsonProcessingException e) {
            logger.error("Failed to pretty print JSON string", e);
            return jsonString; // Return the original JSON string if an error occurs
        }
    }
}

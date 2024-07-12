import java.util.HashMap;
import java.util.Map;

public class MTMessageParser {

    public static void main(String[] args) {
        String message = "{1:F01BANKBEBBAXXX0000000000}{2:O1031255000003BANKDEFFXXXX2222123456000003}{4:" +
                ":20:1234567890123456" +
                ":23B:CRED" +
                ":32A:210112EUR1000," +
                ":50K:/123456789" +
                "JOHN DOE" +
                "123 MAIN ST" +
                "CITY COUNTRY" +
                ":59:/987654321" +
                "JANE DOE" +
                "456 ANOTHER ST" +
                "CITY COUNTRY" +
                "-}";

        Map<String, String> parsedFields = parseMTMessage(message);
        
        parsedFields.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    private static Map<String, String> parseMTMessage(String message) {
        Map<String, String> fields = new HashMap<>();
        String[] parts = message.split("\\{4\\}|-\\}");

        if (parts.length > 1) {
            String[] fieldLines = parts[1].split(":");
            for (int i = 1; i < fieldLines.length; i++) {
                String field = fieldLines[i];
                if (field.length() > 2) {
                    String fieldCode = field.substring(0, 2);
                    String fieldValue = field.substring(2).trim();
                    fields.put(fieldCode, fieldValue);
                }
            }
        }
        return fields;
    }
}

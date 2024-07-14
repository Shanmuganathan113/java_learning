import java.util.HashMap;
import java.util.Map;

public class SwiftMTParser {

    public static void main(String[] args) {
        String mtMessage = "{1:F01BANKBEBBAXXX2222123456}{2:I103BANKDEFFXXXXN}{4:\n" +
                ":20:1234567890\n" +
                ":32A:210312EUR1000,\n" +
                ":50K:/123456789\n" +
                "JOHN DOE\n" +
                ":59:/123456789\n" +
                "JANE DOE\n" +
                ":71A:SHA\n" +
                "-}";

        MTMessage parsedMessage = parseSwiftMT(mtMessage);
        printParsedMessage(parsedMessage);
    }

    public static MTMessage parseSwiftMT(String message) {
        MTMessage mtMessage = new MTMessage();

        String[] blocks = message.split("}");
        for (String block : blocks) {
            if (block.startsWith("{1:")) {
                mtMessage.setBasicHeader(block.substring(3));
            } else if (block.startsWith("{2:")) {
                mtMessage.setApplicationHeader(block.substring(3));
            } else if (block.startsWith("{4:")) {
                String[] lines = block.substring(3).split("\n");
                String currentTag = null;
                StringBuilder currentValue = new StringBuilder();
                for (String line : lines) {
                    if (line.startsWith(":")) {
                        if (currentTag != null) {
                            mtMessage.addField(currentTag, currentValue.toString());
                        }
                        int index = line.indexOf(':', 1);
                        currentTag = line.substring(1, index);
                        currentValue = new StringBuilder(line.substring(index + 1));
                    } else {
                        currentValue.append('\n').append(line);
                    }
                }
                if (currentTag != null) {
                    mtMessage.addField(currentTag, currentValue.toString());
                }
            }
        }

        return mtMessage;
    }

    public static void printParsedMessage(MTMessage message) {
        System.out.println("Basic Header: " + message.getBasicHeader());
        System.out.println("Application Header: " + message.getApplicationHeader());
        message.getFields().forEach((tag, value) -> System.out.println(tag + ": " + value));
    }
}

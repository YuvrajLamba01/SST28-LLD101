import java.util.LinkedHashMap;
import java.util.Map;

public class InputParser {
    public Map<String, String> parse(String rawData) {
        Map<String, String> map = new LinkedHashMap<>();
        String[] parts = rawData.split(";");
        for (String p : parts) {
            String[] t = p.split("=", 2);
            if (t.length == 2) map.put(t[0].trim(), t[1].trim());
        }
        return map;
    }
}
package hexlet.code;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String p1, String p2) throws Exception {
        List<Map<String, Object>> maps = formatFactory.createMaps(p1, p2);
        var map1 = maps.get(0);
        var map2 = maps.get(1);
        var mainMap = maps.get(2);
        String acc = "{\n";
        for (String key : mainMap.keySet()) {
            if (!map1.containsKey(key)) {
                String exitCode1 = String.format("+ %s: %s\n", key, map2.get(key));
                acc += exitCode1;
            } else if (!map2.containsKey(key)) {
                String exitCode2 = String.format("- %s: %s\n", key, map1.get(key));
                acc += exitCode2;
            } else if (map1.get(key).equals(map2.get(key))) {
                String exitCode3 = String.format("  %s: %s\n", key, mainMap.get(key));
                acc += exitCode3;
            } else if (!map1.get(key).equals(map2.get(key))) {
                String prop1 = String.format("- %s: %s\n", key, map1.get(key));
                String prop2 = String.format("+ %s: %s\n", key, map2.get(key));
                acc += prop1;
                acc += prop2;
            }
        }
        acc += "}";
        return acc;
    }
}
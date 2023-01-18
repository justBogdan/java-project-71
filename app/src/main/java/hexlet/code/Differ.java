package hexlet.code;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String p1, String p2) throws Exception {
        List<Map<String, Object>> maps = FormatFactory.createMaps(p1, p2);
        var map1 = maps.get(0);
        var map2 = maps.get(1);
        var mainMap = maps.get(2);
        String acc = "{\n";
        for (String key : mainMap.keySet()) {
            var value = map1.get(key);
            var value2 = map2.get(key);
            if (!map1.containsKey(key)) {
                acc += formatter.formatGenerate(key, value2, "+", App.format);
            } else if (!map2.containsKey(key)) {
                acc += formatter.formatGenerate(key, value, "-", App.format);
            } else if (map1.get(key).equals(map2.get(key))) {
                acc += formatter.formatGenerate(key, value, " ", App.format);
            } else if (!map1.get(key).equals(map2.get(key))) {
                acc += formatter.formatGenerate(key, value, "-", App.format);
                acc += formatter.formatGenerate(key, value2, "+", App.format);
            }
        }
        acc += "}";
        return acc;
    }
}

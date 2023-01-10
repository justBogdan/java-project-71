package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Differ {
    public static String generate(String p1, String p2) throws Exception {

        ObjectMapper objectMap = new ObjectMapper();
        ObjectMapper objectMap2 = new ObjectMapper();

        Path path1 = Paths.get(p1).toAbsolutePath().normalize();
        Path path2 = Paths.get(p2).toAbsolutePath().normalize();

        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);
        Map<String, Object> map1 = objectMap.readValue(content1, new TypeReference<Map<String, Object>>() {});
        Map<String, Object> map2 = objectMap2.readValue(content2, new TypeReference<Map<String, Object>>() {});

        Map<String, Object> merge = new HashMap<>();
        merge.putAll(map1);
        merge.putAll(map2);

        String acc = "{\n";
        try {
            for (String key : merge.keySet()) {
                if (!map1.containsKey(key)) {
                    String exitCode1 = String.format("+ %s: %s\n", key, map2.get(key));
                    acc += exitCode1;
                }
                else if (!map2.containsKey(key)) {
                    String exitCode2 = String.format("- %s: %s\n", key, map1.get(key));
                    acc += exitCode2;
                }
                else if (map1.get(key).equals(map2.get(key))) {
                    String exitCode3 = String.format("  %s: %s\n", key, merge.get(key));
                    acc += exitCode3;
                }
                else if (!map1.get(key).equals(map2.get(key))) {
                    String prop1 = String.format("- %s: %s\n", key, map1.get(key));
                    String prop2 = String.format("+ %s: %s\n", key, map2.get(key));
                    acc += prop1;
                    acc += prop2;
                }
            }
        }
        catch (NullPointerException e) {
            System.out.println("Find Null");
        }
        acc += "}";
        return acc;
    }
}

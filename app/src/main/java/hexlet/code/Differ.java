package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        Map<String, Object> merge = Stream.of(map1, map2)
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        String acc = "{";
        for (String key : merge.keySet()) {
            if (!map1.get(key).equals(map2.get(key))) {
                String exitCode = String.format("  %s: %s\n", key, merge.get(key));
                acc += exitCode;
            }
            else if (!map2.containsKey(key)) {
                String exitCode1 = String.format("- %s: %s\n", key, merge.get(key));
                acc += exitCode1;
            }
            else if (!map1.containsKey(key)) {
                String exitCode2 = String.format("+ %s: %s\n", key, merge.get(key));
                acc += exitCode2;
            }
        }
        acc += "}";
        return acc;
    }
}

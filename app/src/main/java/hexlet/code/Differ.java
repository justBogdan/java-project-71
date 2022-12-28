package hexlet.code;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Differ {
    public static String generate(String path1, String path2) throws Exception {
        ObjectMapper objectMap = new ObjectMapper();
        Map<String, Object> fileValue1 = objectMap.readValue(path1, new TypeReference<Map<String, Object>>() {});
        Map<String, Object> fileValue2 = objectMap.readValue(path2, new TypeReference<Map<String, Object>>() {});

        Map mergedMap = Stream.concat(fileValue1.entrySet().stream(), fileValue2.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        String acc = "{\n";
        for (var key : mergedMap.keySet()) {
            var valueOfMerge = mergedMap.get(key);
            var valueOfFirst = fileValue1.getOrDefault(key, null);
            var valueOfSecond = fileValue2.getOrDefault(key, null);
            if (!fileValue2.containsKey(key)) {
                acc += String.format("- %s: %s\n", key, valueOfMerge);
            }
            else if (!fileValue1.containsKey(key)) {
                acc += String.format("+ %s: %s\n", key, valueOfMerge);
            }
            else if (fileValue1.containsKey(key) && fileValue2.containsKey(key) &&) {
            }
        }
    }
}

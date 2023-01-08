package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
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
        Map<String, Object> fileValue1 = objectMap.readValue(content1, new TypeReference<Map<String, Object>>() {});
        Map<String, Object> fileValue2 = objectMap2.readValue(content2, new TypeReference<Map<String, Object>>() {});

        Map<String, Object> merge = new HashMap();
        merge.putAll(fileValue1);
        merge.putAll(fileValue2); // Вот здесь будет задача - правильно отсортировать пару для этого придется видимо поочерёдно добавлять
        String acc = "{\n";
        for (String key : merge.keySet()) {
            var valueMerge = merge.get(key);
            var value1 = fileValue1.get(key);
            var value2 = fileValue2.get(key);
            if (!fileValue1.containsKey(key)) {
                acc += String.format("+ %s: %s", key, valueMerge);
            }
            else if (!fileValue2.containsKey(key)) {
                acc += String.format("- %s: %s", key, valueMerge);
            }
            else if (!(value1.equals(value2))) {
                acc += String.format("- %s: %s", key, value1);
                acc += String.format("+ %s: %s", key, value2);
            }
        }
        System.out.println("\n}");
        return acc;
    }
}

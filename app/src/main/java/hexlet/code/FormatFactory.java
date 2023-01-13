package hexlet.code;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class FormatFactory {
    private static ObjectMapper mapper1;

    private static ObjectMapper mapper2;
    public static List<Map<String, Object>> createMaps(final String p1, final String p2) throws IOException {
        if (p1.endsWith("yaml") && p2.endsWith("yaml")) {
            mapper1 = new ObjectMapper(new YAMLFactory());
            mapper2 = new ObjectMapper(new YAMLFactory());
            mapper1.findAndRegisterModules();
            mapper2.findAndRegisterModules();
        } else if (p1.endsWith("json") && p2.endsWith("json")) {
            mapper1 = new ObjectMapper();
            mapper2 = new ObjectMapper();
        }
        Map<String, Object> map1 = mapper1.readValue(new File(p1), HashMap.class);
        Map<String, Object> map2 = mapper2.readValue(new File(p2), HashMap.class);
        Map<String, Object> mainMap = new HashMap<>();
        mainMap.putAll(map1);
        mainMap.putAll(map2);
        return List.of(map1, map2, mainMap);
    }
}


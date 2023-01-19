package hexlet.code;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class DifferTest2 {
    @Test
     void testRelativePathYAML() throws Exception {
        var f = "./src/test/resources/YAMLFiles/testFile1.yaml";
        var s = "./src/test/resources/YAMLFiles/testFile2.yaml";
        var answer = Differ.generate(f, s, "stylish");
        var param2 = "  - CustomerName: Joe";
        var param3 = "  + CustomerName: Victoria";
        var param4 = "  + unitPrice: 100";
        var param5 = "  - unitPrice: 12";
        assertEquals(true, answer.contains(param2));
        assertEquals(true, answer.contains(param3));
        assertEquals(true, answer.contains(param4));
        assertEquals(true, answer.contains(param5));
    }
    @Test
    void testIfKeyIsObj() throws Exception {
        var f = "./src/test/resources/YAMLFiles/testFile3.yaml";
        var s = "./src/test/resources/YAMLFiles/testFile4.yaml";
        var answer = Differ.generate(f, s, "stylish");
        var param6 = "  - setting1: Some Value";
        var param7 = "  + setting1: Another Value";
        var param8 = "  - numbers1: [1, 2, 3, 4]";
        var param9 = "  + numbers1: [10, 9, 8]";
        assertEquals(true, answer.contains(param6));
        assertEquals(true, answer.contains(param7));
        assertEquals(true, answer.contains(param8));
        assertEquals(true, answer.contains(param9));
    }
}

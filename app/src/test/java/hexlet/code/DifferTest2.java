package hexlet.code;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class DifferTest2 {
    @Test
    void testRelativePathJSON() throws Exception {
        String subStr1 = "+ age: 40";
        String subStr2 = "- car: BMW";
        String subStr3 = "+ car: Pagani";
        var f = "./src/test/resources/JSONFiles/testFile1.json";
        var s = "./src/test/resources/JSONFiles/testFile2.json";
        String answer = Differ.generate(f, s);
        boolean expected = true;
        boolean actual1 = answer.contains(subStr1);
        boolean actual2 = answer.contains(subStr2);
        boolean actual3 = answer.contains(subStr3);
        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
        assertEquals(expected, actual3);
    }
    @Test
    void testDefunctPath() {
        Throwable thrown = assertThrows(IOException.class, () -> {
            var f = "./src/test/resources/JSONFile/testFile12.json";
            var s = "./src/test/resources/JSONFile/testFile22.json";
            var answer = Differ.generate(f, s);
        });
        assertNotNull(thrown.getMessage());
    }
    @Test
    void testIfFileEmpty() {
        Throwable thrown = assertThrows(IOException.class, () -> {
            var f = "./src/test/resources/JSONFiles/testEmptyFile1.json";
            var s = "./src/test/resources/JSONFiles/testEmptyFile2.json";
            var answer = Differ.generate(f, s);
        });
        assertNotNull(thrown.getMessage());
    }
    @Test
     void testRelativePathYAML() throws Exception {
        var f = "./src/test/resources/YAMLFiles/testFile1.yaml";
        var s = "./src/test/resources/YAMLFiles/testFile2.yaml";
            var answer = Differ.generate(f, s);
            var param2 = "- CustomerName: Joe";
            var param3 = "+ CustomerName: Victoria";
            var param4 = "+ unitPrice: 100";
            var param5 = "- unitPrice: 12";
            assertEquals(true, answer.contains(param2));
            assertEquals(true, answer.contains(param3));
            assertEquals(true, answer.contains(param4));
            assertEquals(true, answer.contains(param5));
    }
}

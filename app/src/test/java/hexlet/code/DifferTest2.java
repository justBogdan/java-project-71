package hexlet.code;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class DifferTest2 {
    @Test
    void testAbsolutePath() throws Exception {
        String subStr1 = "+ age: 40";
        String subStr2 = "- car: BMW";
        String subStr3 = "+ car: Pagani";
        var f = "C:/Users/ggwpd/OneDrive/Documents/GitHub/java-project-71/app/src/test/resources/testFile1.json";
        var s = "C:/Users/ggwpd/OneDrive/Documents/GitHub/java-project-71/app/src/test/resources/testFile2.json";
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
    void testRelativePath() throws Exception {
        String subStr11 = "+ age: 40";
        String subStr21 = "- car: BMW";
        String subStr31 = "+ car: Pagani";
        var f = "./src/test/resources/testFile1.json";
        var s = "./src/test/resources/testFile2.json";
        String answer = Differ.generate(f, s);
        boolean expected = true;
        boolean actual1 = answer.contains(subStr11);
        boolean actual2 = answer.contains(subStr21);
        boolean actual3 = answer.contains(subStr31);
        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
        assertEquals(expected, actual3);
    }
    @Test
    void testDefunctPath() throws Exception {
        Throwable thrown = assertThrows(IOException.class, () -> {
            var f = "./src/test/resources/testFile12.json";
            var s = "./src/test/resources/testFile22.json";
            var answer = Differ.generate(f, s);
        });
        assertNotNull(thrown.getMessage());
    }
    @Test
    void testIfFileEmpty() throws Exception {
        Throwable thrown = assertThrows(IOException.class, () -> {
            var f = "./src/test/resources/testEmptyFile1.json";
            var s = "./src/test/resources/testEmptyFile2.json";
            var answer = Differ.generate(f, s);
        });
        assertNotNull(thrown.getMessage());
    }
}

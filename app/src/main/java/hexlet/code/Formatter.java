package hexlet.code;

public class Formatter {
    public static String output = "";
    public static String formatGenerate(String key, Object value, String inform, String format) {
        if (format.equals("stylish")) {
            output = stylish(key, value, inform);
        }
        return output;
    }
    public static String stylish(String key, Object value, String inform) {
        return String.format("  %s %s: %s\n", inform, key, String.valueOf(value));
    }
}

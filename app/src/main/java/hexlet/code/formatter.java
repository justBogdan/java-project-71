package hexlet.code;

public class formatter {
    public static String output = "";
    public static String exitCode = "";
    public static String formatGenerate(String key, Object value, String inform, String format) {
        if (format.equals("stylish")) {
            exitCode = stylish(key, value, inform);
        }
        return exitCode;
    }
    public static String stylish(String key, Object value, String inform) {
        return output = String.format("  %s %s: %s\n", inform, key, String.valueOf(value));
    }
}

package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;
@Command(
        name = "genDif",
        description = "Compares two configuration files and shows difference.",
        mixinStandardHelpOptions = true,
        version = "0.0.1"
)
public class App implements Callable<Integer> {
    @Parameters(index = "0", description = "path to first file")
    private String filepath1;

    @Parameters(index = "1", description = "path to second file")
    private String filepath2;

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String format;

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }
    @Override
    public Integer call() throws Exception {
        Differ.generate(filepath1, filepath2);
        return 0;
    }
}


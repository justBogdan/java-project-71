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

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }
    @Override
    public Integer call() throws Exception {
        return 0;
    }
}


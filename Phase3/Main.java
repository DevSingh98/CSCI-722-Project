import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        AtomicReference<String> transitionsFile = new AtomicReference<>("");
        AtomicReference<String> tapeInputFile = new AtomicReference<>("");
        AtomicReference<String> outputFile = new AtomicReference<>("");
        AtomicInteger maxSteps = new AtomicInteger(-1);

        HashMap<String, String> inputArgs = new HashMap<>();
        for (String arg : args) {
            String[] split = arg.split("=");
            if (split.length == 2) {
                inputArgs.put(split[0].toLowerCase(), split[1]);
            }
        }
        //Map to consume the command line arguments which may come in any order
        Map<String, Consumer<String>> commands = new HashMap<>();
        commands.put("transitionsfile", transitionsFile::set);
        commands.put("initialtapeinput", tapeInputFile::set);
        commands.put("finaloutput", outputFile::set);
        commands.put("steps", value -> maxSteps.set(Integer.parseInt(value)));

        //Using the map created to consume the command line inputs
        for (Map.Entry<String, String> entry : inputArgs.entrySet()) {
            commands.getOrDefault(entry.getKey().toLowerCase(), v -> {}).accept(entry.getValue());
        }

        //Checks if the required input file and transition file is present
        if (transitionsFile.get().isEmpty() || tapeInputFile.get().isEmpty() || outputFile.get().isEmpty() || maxSteps.get() < 0) {
            System.out.println("missing commandline arguments");
            return;
        }

        //As required steps of 0 will just print out the names of the text files with their corresponding contents into the FinalOutput file
        if (maxSteps.get() == 0) {
            OutputHandler.writeOutput(tapeInputFile.get(), transitionsFile.get(), outputFile.get(), null, false, true);
            return;
        }

        //creates turning machine object and loads in the transition and the tape to the machine
        TuringMachine machine = new TuringMachine();
        machine.loadTransitions(transitionsFile.get());
        machine.loadTape(tapeInputFile.get());
        machine.execute(maxSteps.get(), outputFile.get());
    }
}

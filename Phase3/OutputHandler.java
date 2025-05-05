import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class OutputHandler {

    // Method for printing to the output file, with a debug flag mode as required for when the steps are 0
    public static void writeOutput(String transitionsFile, String tapeFile, String outputFileName, Tape tape, boolean halted, boolean isDebug) {
        try (PrintWriter out = new PrintWriter(outputFileName)) {
            //if debug flag is true, output the names of the text files with their corresponding contents into the FinalOutput file
            if (isDebug) {
                out.println("TransitionsFile: " + transitionsFile);
                out.println("TransitionsFile Contents:");
                Files.lines(Path.of(transitionsFile)).forEach(out::println);

                out.println("\nInitialTapeInput: " + tapeFile);
                out.println("InitialTapeInput Contents:");
                Files.lines(Path.of(tapeFile)).forEach(out::println);
            } else { // else print the turning machines final tape contents and the halting state of the machine
                out.println("Final Tape: " + tape.getTapeContents());
                out.println("Machine Halted: " + halted);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

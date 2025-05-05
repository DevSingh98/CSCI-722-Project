import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

//Class to represent the turing machine
public class TuringMachine {
    private HashMap<String, Transition> transitionTable = new HashMap<>();
    private Tape tape = new Tape();
    private int currentState = 0;
    private boolean halted = false;

    //Load the steps into the turing machine object
    public void loadTransitions(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s*,\\s*");
                if (parts.length != 5) continue;
                String key = parts[0] + parts[1];
                transitionTable.put(key, new Transition(parts[2].charAt(0), parts[3].charAt(0), Integer.parseInt(parts[4])));
            }
        } catch (IOException e) {
            System.out.println("Error reading transitions file: " + e.getMessage());
        }
    }

    //Load the contents of the tape into the turing machine object
    public void loadTape(String filename) {
        tape.loadFromFile(filename);
    }

    public void execute(int maxSteps, String outputFile) {
        int steps = 0;
        while (steps < maxSteps) {
            char currentSymbol = tape.read();
            String key = currentState + String.valueOf(currentSymbol);
            Transition transition = transitionTable.get(key);

            if (transition == null) {
                halted = true;
                break;
            }

            tape.write(transition.writeSymbol);
            tape.move(transition.moveDirection);
            currentState = transition.nextState;
            steps++;
        }
        //Print the outputs of the tape to the otput file with the halting state of the machine
        OutputHandler.writeOutput(null, null, outputFile, tape, halted, false);
    }
}

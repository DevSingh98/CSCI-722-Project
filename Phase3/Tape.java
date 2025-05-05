import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//Class to represent the tape of a turing machine
public class Tape {
    private Map<Integer, Character> tape = new HashMap<>();
    private int head = 0;

    //reading in the input file to the tape
    public void loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine().trim().toLowerCase();
            for (int i = 0; i < line.length(); i++) {
                tape.put(i, line.charAt(i));
            }
        } catch (IOException e) {
            System.out.println("Error while loading tape from file: " + filename);
            System.out.println(e.getMessage());
        }
    }

    public char read() {
        return tape.getOrDefault(head, '_');
    }

    public void write(char c) {
        tape.put(head, c);
    }

    public void move(char dir) {
        if (dir == 'L') head--;
        else if (dir == 'R') head++;
    }

    public String getTapeContents() {
        int min = Collections.min(tape.keySet());
        int max = Collections.max(tape.keySet());
        StringBuilder sb = new StringBuilder();
        for (int i = min; i <= max; i++) {
            sb.append(tape.getOrDefault(i, '_'));
        }
        return sb.toString();
    }
}

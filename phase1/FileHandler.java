import java.io.*;
import java.util.Hashtable;

public class FileHandler {
    static final String header = "First name | Last name | id Number | age | Lives in New York?\n";
    //Method used to read in existing membership and load it into our hashtable
    public static Hashtable<String, Member> readInitialData(String filename) throws IOException {
        Hashtable<String, Member> members = new Hashtable<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        reader.readLine(); // Skipp over required header
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|");
            if (parts.length == 5) {
                members.put(cleanString(parts[2]), new Member(cleanString(parts[0]), cleanString(parts[1]), cleanString(parts[2]), Integer.parseInt(cleanString(parts[3])), Boolean.parseBoolean(cleanString(parts[4]))));
            }
        }
        reader.close();
        return members;
    }

    //Function used to write to the output file, it is set to overwrite the file each time instead of appending to it
    public static void writeToFile(String filename, String content, boolean isError) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        if (isError) {
            writer.write("ERROR Member already exists. Member in question: \n");
        }
        writer.write(header + content + "\n");
        writer.close();
    }

    //Function that I created to have data persistence, but realized it's not required for phase1
    public static void appendToFile(String filename, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
        writer.close();
    }

    private static String cleanString(String str) {
        return str.replace(" ", "");
    }
}

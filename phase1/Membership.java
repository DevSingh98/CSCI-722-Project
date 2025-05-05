import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

public class Membership {
    static HashTableHandler hashtable = new HashTableHandler();
    public static void main(String[] args) throws IOException {
        AtomicReference<String> inputFileName = new AtomicReference<>("");
        AtomicReference<String> outputFileName = new AtomicReference<>("");
        AtomicBoolean printAllMemberships = new AtomicBoolean(true);
        HashMap<String,String> inputArgs = new HashMap<>();
        for (String arg : args) {
            String[] split = arg.split("=");
            if (split.length == 2) {
                inputArgs.put(split[0].substring(1), split[1]);
            }
        }
        Member member = new Member();

        //Map to consume the command line arguments which may come in any order
        Map<String, Consumer<String>> commands = new HashMap<>();
        commands.put("firstname", member::setFirstName);
        commands.put("lastname", member::setLastName);
        commands.put("age", value -> member.setAge(Integer.parseInt(value)));
        commands.put("livesinnewyork", value -> member.setLivesInNewYork(value.equalsIgnoreCase("true")));
        commands.put("id", member::setId);
        commands.put("outputfile", outputFileName::set);
        commands.put("inputfile", inputFileName::set);
        commands.put("printAllMembers", value -> printAllMemberships.set(Boolean.parseBoolean(value)));
        //Using the map created to consume the command line inputs
        for (Map.Entry<String, String> entry : inputArgs.entrySet()) {
            commands.getOrDefault(entry.getKey().toLowerCase(), v -> {}).accept(entry.getValue());
        }
        //Loads our hashtable from the input file
        hashtable.setHashTable(FileHandler.readInitialData(inputFileName.get()));
        if(!hashtable.containsMember(member)) {
            hashtable.addMember(member);
            //Writes the newly added member to output files as specified by the flag
            if(printAllMemberships.get()) {
                FileHandler.writeToFile(outputFileName.get(), hashtable.toString(), false);
            }else {
                FileHandler.writeToFile(outputFileName.get(), member.toString(), false); //Writes all the members to output files as specified by the flag
            }
        }else{
            //Writes the error and the failed member to the output file
            FileHandler.writeToFile(outputFileName.get(), member.toString(), true);
        }
    }
}
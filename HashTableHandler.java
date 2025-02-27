import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

//HashTable Handler class to store membership information
public class HashTableHandler {
    private Hashtable<String, Member> hashTable;

    //Default constructor to initialize the hash table
    public HashTableHandler() {
        this.hashTable = new Hashtable<>();
    }

    public void addMember(Member member) {
        hashTable.put(member.getId(), member);
    }

    public void setHashTable(Hashtable<String, Member> hashTable) {
        this.hashTable = hashTable;
    }

    //Helper method used to quickly determine if a member ID already exist in our hashtable
    public boolean containsMember(Member member) {
        return hashTable.containsKey(member.getId());
    }

    //Returns a list of all existing id's
    public List<String> getAllMemberIds() {
        return new ArrayList<>(hashTable.keySet());
    }

    @Override
    public String toString() {
        String temp = "";
        for (String id : hashTable.keySet()) {
            temp = temp + hashTable.get(id).toString() + "\n";
        }
        return temp;
    }
}

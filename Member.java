//Member class to define what each member object will hold
public class Member {
    private String firstName;
    private String lastName;
    private String id;
    private Integer age;
    private Boolean livesInNewYork;

    //No args constructor
    public Member() {
        firstName = "";
        lastName = "";
        id = "";
        age = 0;
        livesInNewYork = false;
    }

    //All args constructor
    public Member(String firstName, String lastName, String id, Integer age, Boolean livesInNewYork) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.livesInNewYork = livesInNewYork;
        this.age = age;
    }

    //firstNameGetter
    public String getFirstName() {
        return firstName;
    }

    //firstNameSetter
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //lastNameGetter
    public String getLastName() {
        return lastName;
    }

    //lastNameSetter
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //idGetter
    public String getId() {
        return id;
    }

    //idSetter
    public void setId(String id) {
        this.id = id;
    }

    //ageGetter
    public Integer getAge() {
        return age;
    }

    //ageSetter
    public void setAge(Integer age) {
        this.age = age;
    }

    //livesInNewYorkGetter
    public Boolean getLivesInNewYork() {
        return livesInNewYork;
    }

    //livesInNewYorkSetter
    public void setLivesInNewYork(Boolean livesInNewYork) {
        this.livesInNewYork = livesInNewYork;
    }

    //manual toString definition
    @Override
    public String toString() {
        return firstName + " | " + lastName + " | " + id + " | " + age + " | " + livesInNewYork;
    }
}

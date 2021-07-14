public class Person {

    private final String name;
    private final Gender gender;
    private final boolean isAdult;
    private int ID;


    Person(String name, Gender gender, boolean isAdult) {
        this.name = name;
        this.gender = gender;
        this.isAdult = isAdult;

    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        String str = "";
        str += "ID : " + this.ID + "\n" +
                "firstname : " + this.name + "\n" +
                "gender : " + this.gender + "\n" +
                "is adult? : " + this.isAdult;
        return str;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isAdult() {
        return isAdult;
    }
}

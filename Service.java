import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

public class Service {
    public static void create(PersonRequest personRequest) throws SQLException {
        String name = personRequest.getName();
        String strGender = personRequest.getGender().toLowerCase(Locale.ROOT);
        int age = personRequest.getAge();
        Gender gender = null;
        boolean isAdult = false;

        if(!(strGender.equals("male")
                || strGender.equals("female"))) {
            throw new RuntimeException("gender must be male or female");
        } else {
            gender = strGender.charAt(0) == 'm' ? Gender.MALE : Gender.FEMALE;
        }

        if(age < 0 || age > 150) {
            throw new RuntimeException("age must be 0 to 150");
        } else {
           isAdult = age >= 18;
        }

        Person person = new Person(name, gender, isAdult);
        DAO.recordPerson(person);
    }

    public static Person getPersonFromId(int personID) throws SQLException {
        Person person = DAO.getPerson(personID);
        return person;
    }

    public static void deletePerson(int id) throws SQLException {
        DAO.deletePersonFromDB(id);
    }

    public static void updateName(int id, String name) throws SQLException {
        DAO.updateNameInDB(id, name);
    }

    public static void updateGender(int id, String genderStr) throws SQLException {
        if(genderStr.equals("male")) {
            Gender gender = Gender.MALE;
            DAO.updateGenderInDB(id, gender);
            return;
        } else if(genderStr.equals("female")) {
            Gender gender = Gender.FEMALE;
            DAO.updateGenderInDB(id, gender);
            return;
        } else {
            throw new RuntimeException("incorrect input");
        }
    }

    public static void updateAge(int id, int age) throws SQLException {
        if(age < 0 || age > 150) {
            throw new RuntimeException("incorrect input");
        }

        boolean isAdult = age >= 18;
        DAO.updateAgeInDB(id, isAdult);
    }
}

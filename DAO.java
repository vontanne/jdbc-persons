import java.sql.*;

public class DAO {
    static Connection connection;
    static Statement statement;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/gamers",
                    "root", "1234");
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public DAO() throws SQLException {
    }

    public static void recordPerson(Person person) throws SQLException {
        boolean execute = statement.execute("INSERT INTO " +
                "persons (firstname, gender, isAdult) " +
                "VALUES ('"+ person.getName() + "','" +
                person.getGender() + "'," + person.isAdult() + ");");
        statement.close();
    }

    public static Person getPerson(int personID) throws SQLException {
        ResultSet resultSet = statement.executeQuery
                ("SELECT * FROM PERSONS WHERE ID = " + personID);
        resultSet.next();

        int ID = resultSet.getInt("ID");
        String firstname = resultSet.getString("firstname");
        String genderStr = resultSet.getString("gender");
        Gender gender = genderStr.equals("male") ? Gender.MALE : Gender.FEMALE;
        boolean isAdult = resultSet.getBoolean("isAdult");


        Person person = new Person(firstname, gender, isAdult);
        person.setID(ID);
        return person;
    }

    public static void deletePersonFromDB(int id) throws SQLException {
        statement.execute("delete from persons where id = " + id);
    }

    public static void updateNameInDB(int i, String name) throws SQLException {
        statement.execute("UPDATE persons SET firstname = '" + name + "' WHERE ID = "+ i +"" );
    }

    public static void updateGenderInDB(int i, Gender gender) throws SQLException {
        statement.execute("UPDATE persons SET gender = '" + gender + "' WHERE ID = "+ i +"" );
    }

    public static void updateAgeInDB(int i, boolean bool) throws SQLException {
        statement.execute("UPDATE persons SET isAdult = " + bool + " WHERE ID = "+ i +"" );
    }
}

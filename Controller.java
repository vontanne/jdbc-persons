import java.sql.SQLException;
import java.util.Scanner;

public class Controller {

    public static void showMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("choose action");
        System.out.println();
        System.out.println("create person --- press 1");
        System.out.println("get person by ID --- press 2");
        System.out.println("update person by ID --- 3");
        System.out.println("delete person by ID --- press 4");
        int userInput = scanner.nextInt();

        switch (userInput) {
            case 1:
                PersonRequest personRequest = createPersonRequest();
                Service.create(personRequest);
                break;
            case 2:
                int personId = getPersonId();
                Person person = Service.getPersonFromId(personId);
                System.out.println(person.toString());
                break;
            case 3:
                int ident = getPersonId();
                int i = chooseFromUpdateMenu();
                if(i == 1) {
                    String updateName = getUpdateName();
                    Service.updateName(ident, updateName);
                } else if(i == 2) {
                    String updateGender = getUpdateGender();
                    Service.updateGender(ident, updateGender);
                } else if(i == 3) {
                    int updateAge = getUpdateAge();
                    Service.updateAge(ident, updateAge);
                } else {
                    System.out.println("input correct action");
                }
                break;
            case 4:
                int id = getPersonId();
                Service.deletePerson(id);
                break;
            default:
                System.out.println("incorrect action");
        }
    }

    public static PersonRequest createPersonRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("input person name");
        String name = scanner.nextLine();

        System.out.println("input person gender");
        String gender = scanner.nextLine();

        System.out.println("input person age");
        int age = scanner.nextInt();

        PersonRequest personRequest = new PersonRequest(name, gender, age);
        return personRequest;
    }

    public static int getPersonId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input person ID");
        int personID = scanner.nextInt();
        return personID;
    }

    public static int chooseFromUpdateMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("choose action");
        System.out.println("update firstname --- press 1");
        System.out.println("update gender --- press 2");
        System.out.println("update age --- press 3");

        int userInput = scanner.nextInt();
        return userInput;
    }

    public static String  getUpdateName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input person updated name");
        String name = scanner.nextLine();
        return name;
    }

    public static String getUpdateGender() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input person updated gender");
        return scanner.nextLine();
    }

    public static int getUpdateAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input person updated age");
        return scanner.nextInt();
    }
}

import java.util.ArrayList;

public class RegistrationAndUsers {
    private ArrayList<String> users = new ArrayList<>();
    private ArrayList<String> userNamesAndPasswords = new ArrayList<>();
    private ArrayList<String> usernames = new ArrayList<>();

    public void userNameAndPassword(String username, String password) {
        userNamesAndPasswords.add(username + password);
    }

    public void userName(String username) {
        usernames.add(username);
    }

    public boolean usernameCheckForRegistration(String username) {
        boolean userName = true;
        for (String name : usernames) {
            if (name.equals(username)) {
                userName = false;
                break;
            }
        }
        return userName;
    }

    public boolean checkLogin(String userName, String password) {
        boolean check = false;
        for (String user : userNamesAndPasswords) {
            if (user.equals(userName + password)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public void userRegistration(String firstName, String lastName, String email, String username, String password) {
        users.add("firstName: " + firstName + "  lastName: " + lastName + "  email: " + email + "  username: " + username + "  password: " + password);
    }

    public void getUsersInfo() {
        System.out.println("Users list see below");
        System.out.println();
        for (String user : users) {
            System.out.println(user);
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }
}

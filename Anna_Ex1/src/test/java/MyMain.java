import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyMain {
    public static void main(String[] args) {
        RegistrationAndUsers registration = new RegistrationAndUsers();
        ArrayList<String> posts = new ArrayList<>();
        String admin_Password = "123456";
        String first_Name = "^[a-zA-Z]{2,20}$";
        Pattern firstNamePattern = Pattern.compile(first_Name);
        String last_Name = "^[a-zA-Z]{2,20}$";
        Pattern lastNamePattern = Pattern.compile(last_Name);
        String usernameRegex = "^[a-zA-Z]{2,14}$";
        Pattern userNamePattern = Pattern.compile(usernameRegex);
        String passwordRegex = "^\\S{4,12}$";
        Pattern passwordPattern = Pattern.compile(passwordRegex);
        String emailRegex = "^(.+)@(.+)\\.(.+)$";
        Pattern emailPattern = Pattern.compile(emailRegex);

        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.println("For LogIn type 1");
            System.out.println("For Registration type 2");
            System.out.println("For Exit type 3");
            System.out.println("-------------------------------------------------");
            System.out.println("If you are Admin type Admin to see All Users");
            String choice = s.nextLine();

            if (choice.equals("1"))  //LogIn
            {
                System.out.print("Username:  ");
                String userName = s.nextLine();
                System.out.print("Password:  ");
                String password = s.nextLine();

                if (registration.checkLogin(userName, password)) {
                    System.out.println("You are logged In:");
                    System.out.println("---------------------------");
                    while (true) {
                        System.out.println("For writing post enter 1");
                        System.out.println("For looking Users posts enter 2");
                        System.out.println("For log-Out enter 3");
                        String writeOrRead = s.nextLine();
                        if (writeOrRead.equals("1")) {
                            System.out.println();
                            System.out.println("You can write your Posts");
                            String post = s.nextLine();
                            posts.add(userName + ":  " + post);
                        } else if (writeOrRead.equals("2")) {
                            for (String post : posts) {
                                System.out.println(post);
                                System.out.println();
                            }
                        } else if (writeOrRead.equals("3")) {
                            break;
                        } else {
                            System.out.println("Wrong choice");
                        }
                    }
                } else {
                    System.out.println("There is no such user");
                }


            } else if (choice.equals("2")) {       //Registration
                String firstName;
                while (true) {
                    System.out.print("Type firstName: ");
                    firstName = s.nextLine();
                    Matcher firstNameMatcher = firstNamePattern.matcher(firstName);
                    if (firstNameMatcher.find()) {
                        break;
                    } else {
                        System.out.println("Not valid firstName.FirstName should contain only 2-20 letters. Please Try again");
                    }
                }
                String lastName;
                while (true) {
                    System.out.print("Type lastName: ");
                    lastName = s.nextLine();
                    Matcher lastNameMatcher = lastNamePattern.matcher(lastName);
                    if (lastNameMatcher.find()) {
                        break;
                    } else {
                        System.out.println("Not valid lastName. LastName should contain only 2-20 letters. Please Try again");
                    }
                }

                String email;
                while (true) {
                    System.out.print("Type email: ");
                    email = s.nextLine();
                    Matcher emailMatcher = emailPattern.matcher(email);
                    if (emailMatcher.find()) {
                        break;
                    } else {
                        System.out.println("Not valid email. Please Try again with valid one");
                    }
                }

                String userName;
                while (true) {
                    System.out.print("Type userName: ");
                    userName = s.nextLine();
                    Matcher userNameMatcher = userNamePattern.matcher(userName);
                    if (registration.usernameCheckForRegistration(userName)) {
                        if (userNameMatcher.find()) {
                            break;
                        } else {
                            System.out.println("Not valid Username. Username should contain only 2-14 letters. Please try again");
                        }

                    } else {
                        System.out.println("Username: " + userName + " already exists try another one");
                    }
                }

                String password;
                while (true) {
                    System.out.print("Type password: ");
                    password = s.nextLine();
                    Matcher passwordMatcher = passwordPattern.matcher(password);
                    if (passwordMatcher.find()) {
                        break;
                    } else {
                        System.out.println("Not valid Password. Password should contain at least 4-12 numbers. Please try again");
                    }
                }
                registration.userRegistration(firstName, lastName, email, userName, password);
                registration.userNameAndPassword(userName, password);
                registration.userName(userName);
                System.out.println();
                System.out.println("You have successfully registered ");
                System.out.println("------------------------------------");
            } else if (choice.equals("3"))          //Exit App
            {
                System.out.println("Are You sure? Do you want to exit app?");
                System.out.println("If No Type 1");
                System.out.println("If Yes Type Anything else");
                String exitChoice = s.nextLine();
                if (exitChoice.equals("1")) {
                    System.out.println("Good choice");
                } else {
                    break;
                }
            } else if (choice.equals("Admin")) {  //Admins feather
                System.out.println("Type Admin-Password");
                String adminPassword = s.nextLine();
                if (adminPassword.equals(admin_Password)) {
                    registration.getUsersInfo();
                } else {
                    System.out.println("Not valid Password. Please try again");
                }
            } else {
                System.out.println("You choose the wrong way, Please stay focussed");
            }
        }
    }
}

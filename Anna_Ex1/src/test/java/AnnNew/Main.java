package AnnNew;

import Ann.User;
import Ann.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static boolean isLoggedIn = false;
    public static String currentUserName;
    public static Visualisation v = new Visualisation();
    public static String choice;
    public static Scanner scn = new Scanner(System.in);
    public static boolean isFinished = false;
    public static boolean alreadyExecuted = false;


    public static void main(String[] args) throws IOException {

        readAllUsers();
        while (!isFinished) {
            if (isLoggedIn) {
                handleLogedinFlow();
            } else {
                handleLogedoutFlow();
            }
        }
    }

    private static void readAllUsers() {
        ArrayList<String> userStrings = FileService.readFromFile();
        for (String userString : userStrings) {
            User user = new User();
            List<String> split = Arrays.asList(userString.trim().split(" "));
            user.setUsername(split.get(0));
            user.setPassword(split.get(1));

            split.remove(0);
            split.remove(0);

            user.setPosts(split);
            UserService.addUser(user);
        }
    }

    private static void writeAllUsers() {
        List<String> userStrings = new ArrayList<>();
        for (User user : UserService.getAllUsers()) {
            StringBuilder userPost = new StringBuilder();
            for (String userPosts : user.getPosts()) {
                userPost.append(userPosts);
                userPost.append(" ");
            }

            String userString = user.getUsername() + " " + user.getPassword() + " " + userPost;
            userStrings.add(userString);
        }
        FileService.writeToFile(userStrings);
    }


    private static void handleLogedoutFlow() {
        if (!alreadyExecuted) {
            printLogedOutMenu();
            alreadyExecuted = true;
        }
        if (Visualisation.choice != null) {
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException ie) {
//                Thread.currentThread().interrupt();
//            }
                choice = Visualisation.choice;
                Visualisation.textField_1.setText(null);
                alreadyExecuted = false;
                switch (choice) {
                    case "1":
                        registerUser();
                        break;
                    case "2":
                        loginUser();
                        break;
                    case "3":
                        exitProgram();
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }

        }







    private static void exitProgram() {
        writeAllUsers();
        isFinished = true;
    }

    private static void loginUser() {
        System.out.println("Type Username");
        String username = scn.next();
        System.out.println("Type password");
        String password = scn.next();
        boolean isValid = UserService.validateUser(username, password);
        if (isValid) {
            currentUserName = username;
            isLoggedIn = true;
        } else {
            System.out.println("invalid credentials");
        }

    }

    private static User registerUser() {
        v.setLoggedIn();
        System.out.println("Type Username");
        String username = scn.next();
        System.out.println("Type password");
        String password = scn.next();
        User user = new User(username, password);
        boolean isAdded = UserService.addUser(user);
        if (isAdded) {
            System.out.println("you have registered successfully");
            return user;
        } else {
            System.out.println("something went wrong, try again");
            return null;
        }
    }


    private static void handleLogedinFlow() throws IOException {
        printLogedInMenu();
        switch (scn.nextInt()) {
            case 1:
                writePost();
                break;
            case 2:

                //showAllPosts();
//                readFromFile();
                break;

            case 3:

                logout();
                break;
            case 4:

                exitProgram();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static void logout() {
        isLoggedIn = false;
        currentUserName = null;
    }

//    private static void showAllPosts() {
//
//        List<User> allUsers = UserService.getAllUsers();
//        for (User user : allUsers) {
//            if (user != null) {
//                for (String post : user.getPosts()) {
//                    if (post != null) {
//                        System.out.println(user.getUsername() + " : " + post);
//                    }
//                }
//            }
//        }
//    }

    private static void writePost() {
        System.out.println("Write post");
        String post = scn.next();
        boolean isAdded = UserService.addPostToUser(currentUserName, post);
        if (isAdded) System.out.println("Your post have been added successfully");
    }

    private static void printLogedInMenu() {
        //v.setLoggedIn();
        System.out.println("1 for write post");
        System.out.println("2 for read all posts");
        System.out.println("3 for logout");
        System.out.println("4 for exit");
    }

    private static void printLogedOutMenu() {
        v.setLoggedOut();
        System.out.println("1 for reg");
        System.out.println("2 for login");
        System.out.println("3 for exit");
    }
}


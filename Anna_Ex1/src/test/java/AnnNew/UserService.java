package AnnNew;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static List<User> userList = new ArrayList<>();

    public static List<User> getAllUsers() {
        return userList;
    }

    public static boolean addUser(User user) {
        if (user != null && getUserByUsername(user.getUsername()) == null) {
            userList.add(user);
            return true;
        }
        return false;
    }

    public static User getUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }


    public static boolean validateUser(String username, String password) {
        User user = getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }


    public static boolean addPostToUser(String username, String post) {
        List<String> userPosts = getUserByUsername(username).getPosts();
        if (userPosts.size() <= 10) {
            userPosts.add(post);
            return true;
        }
        return false;
    }


}

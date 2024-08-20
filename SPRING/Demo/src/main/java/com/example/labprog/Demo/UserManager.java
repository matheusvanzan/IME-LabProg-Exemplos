package com.example.labprog.Demo;

import java.util.ArrayList;

public class UserManager {

    private ArrayList<User> users;

    public UserManager() {
        users = new ArrayList<>();
        users.add(new User(1, "User 1", "user_1@ime.eb.br"));
        users.add(new User(2, "User 2", "user_2@ime.eb.br"));
        users.add(new User(3, "User 3", "user_3@ime.eb.br"));
        users.add(new User(4, "User 4", "user_4@ime.eb.br"));
        users.add(new User(5, "User 5", "user_5@ime.eb.br"));
    }

    public ArrayList<User> getAll() {
        return users;
    }

    public User getUserById(Integer id) {

        for(User u: users) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

}

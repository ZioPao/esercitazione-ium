//Alessandro Picchetti 65524


package com.example.esercitazioneBonus;

import com.example.esercitazioneBonus.model.User;
import com.example.esercitazioneBonus.BaseHeader.LoginStatus;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SingletonArray extends AppCompatActivity {

    private static SingletonArray instance = null;

    private ArrayList<User> users = new ArrayList<>();
    private User currentUser;

    protected SingletonArray() {
    }

    public static SingletonArray getInstance() {
        if (instance == null) {
            instance = new SingletonArray();
        }
        return instance;
    }


    public void addUser(User user) {
        users.add(user);

    }

    public LoginStatus checkLogin(String username, String password) {

        User user = searchUsername(username);

        if (user != null) {
            if (isPasswordValid(password, user)) {
                setCurrentUser(user);
                return LoginStatus.OK;
            } else
                return LoginStatus.ERR_PASS;
        }
        return LoginStatus.ERR_USERNAME;
    }

    public User searchUsername(String username) {

        for (User u : users) {
            if (u.getUsername().equals(username))
                return u;
        }
        return null;
    }

    public boolean isPasswordValid(String password, User user) {
        return user.getPassword().equals(password);

    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }

    public User getCurrentUser() {
        return currentUser;
    }


    public void findAndUpdateUser(User u, String password) {

        int id = users.indexOf(u);
        users.get(id).setPassword(password);

    }
}

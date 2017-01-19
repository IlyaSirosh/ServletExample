package com.sirosh.servlet;

/**
 * Created by Illya on 19.01.17.
 */
public class UserDB {

    private static final String login = "login";
    private static final String password = "pass";


    private UserDB(){

    }

    private static class pUserDB{

       static UserDB instance = new UserDB();

    }

    public static UserDB getInstance(){
        return pUserDB.instance;
    }

    public boolean isCorrect(String login, String password){
        return UserDB.login.equals(login) && UserDB.password.equals(password);
    }
}

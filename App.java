package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class App 
{
    public static void main( String[] args ){
        String url = "jdbc:mysql://localhost:3306/?user=root";
        String admin = "root";
        String passkey = "6751221T";
        tryToLogin("dani", "6751221T", url, admin, passkey);
    }
    public static void tryToLogin(String username, String password, String url, String admin, String passkey){
        if(userAlreadyExists(username, url, admin, passkey) == true){
            if(checkForPassword(password, url, admin, passkey) == true){
                System.out.println("You entered your account");
                }
                else{
                    System.out.println("Username or password are incorrect");
                }
            }
            else{
                System.out.println("Username or passowrd are incorrect");
            }
            
    }

    public static boolean userAlreadyExists(String username, String url, String admin, String passkey){
        try {
            Connection connection = DriverManager.getConnection(url, admin, passkey);
            PreparedStatement statement = connection.prepareStatement("select * from LoginPassUi.users order by username;");
            ResultSet r1 = statement.executeQuery();
            String usernameCounter;
            if(r1.next()){
                usernameCounter = r1.getString("username");
                if(usernameCounter.equals(username)){
                    return true;
                }
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return false;
        
    }

    public static boolean checkForPassword(String password, String url, String admin, String passkey){
        try {
            Connection connection = DriverManager.getConnection(url, admin, passkey);
            PreparedStatement statement = connection.prepareStatement("select * from LoginPassUi.users order by password;");
            ResultSet r1 = statement.executeQuery();
            String usernameCounter;
            if(r1.next()){
                usernameCounter = r1.getString("password");
                if(usernameCounter.equals(password)){
                    return true;
                }
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return false;
    }
}

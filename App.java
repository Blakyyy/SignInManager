package com.example;

import org.mindrot.jbcrypt.BCrypt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class App{

    private String url = "jdbc:mysql://localhost:3306/?user=root";
    private String admin = "root";
    private String passkey = "6751221T";
    
    public boolean tryToLogin(String username, String password, String url, String admin, String passkey){
        if(userAlreadyExists(username, url, admin, passkey) == true){
            if(checkForPassword(password, url, admin, passkey) == true){
                return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
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
    public static void signUp(String admin, String url, String passkey){
        try {
            Connection connection = DriverManager.getConnection(url, admin, passkey);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void hashPassword(String password){
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hashed);
        if (BCrypt.checkpw(password, hashed))
		System.out.println("It matches");
	else
		System.out.println("It does not match");
    }
    
    
    public String getUrl() {
        return url;
    }
    public String getAdmin() {
        return admin;
    }
    public String getPasskey() {
        return passkey;
    }
}

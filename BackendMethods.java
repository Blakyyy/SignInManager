package com.example;

import org.mindrot.jbcrypt.BCrypt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class BackendMethods{

    private String url = "jdbc:mysql://localhost:3306/?user=root";
    private String admin = "root";
    private String passkey = "6751221T";

    public boolean tryToLogin(String username, String password, String url, String admin, String passkey){
        if(userAlreadyExists(username, url, admin, passkey) == true){
            if(checkForPassword(username, password, url, admin, passkey) == true){
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
            PreparedStatement statement = connection.prepareStatement("select * from LoginPassUi.users order by username; ");
            ResultSet r1 = statement.executeQuery();
            String usernameCounter;
            while(r1.next()){
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

    public static boolean checkForPassword(String username, String password, String url, String admin, String passkey){
        try {
            Connection connection = DriverManager.getConnection(url, admin, passkey);
            PreparedStatement statement = connection.prepareStatement("select password from LoginPassUi.users where username = ?;");
            statement.setString(1, username);
            ResultSet r1 = statement.executeQuery();
            String passwordCounter;
            if(r1.next()){
                passwordCounter = r1.getString("password");
                if(BCrypt.checkpw(password, passwordCounter)){
                    return true;
                }
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return false;
    }
    public int signUp(String admin, String url, String passkey, String username, String password, String email){
        try {
            Connection connection = DriverManager.getConnection(url, admin, passkey);
            if(userAlreadyExists(username, url, admin, passkey) == false){
                if(email.contains("@")){
                    System.out.println("ok");
                    String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
                    String sql = "INSERT INTO LoginPassui.users (username, password, email) VALUES (?, ?, ?);";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setString(1, username);
                    ps.setString(2, hashed);
                    ps.setString(3, email);
                    System.out.println(ps);
                    ps.execute();
                    connection.close();
                    return 1;
                }
                else{
                    return -1;
                }
            }
            else{
                return -2;
            }     
            }
        catch (SQLException e) {
            e.printStackTrace();
            return -3;
        } 
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

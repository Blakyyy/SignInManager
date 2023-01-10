package com.example;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.*;


public class Java_GUI extends App implements ActionListener { 

    private static JLabel userLabel;
    private static JLabel passwordLabel;
    private static JTextField userText;
    private static JPasswordField passwordField;
    private static JButton button;
    private static JLabel success;
    public static String[] userAndPass = new String[2];

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel pannel = new JPanel(); 
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(pannel);

        pannel.setLayout(null);

        userLabel = new JLabel("Username");
        userLabel.setBounds(10, 20, 80, 25);
        pannel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        pannel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        pannel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 165, 25);
        pannel.add(passwordField);

        button = new JButton("Login");
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(new Java_GUI());
        
        pannel.add(button);

        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        pannel.add(success);
        success.setText("");

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        userAndPass[0] = actionPerformedUser(e);
        userAndPass[1] = actionPerformedPassword(e);
        App appMethods = new App();
        if(appMethods.tryToLogin(userAndPass[0], userAndPass[1], appMethods.getUrl(), appMethods.getAdmin(), appMethods.getPasskey()) == true){
            success.setText("You entered your account!");
        }
        else{
            success.setText("Login or password are incorrect");
        }
       
    }
    
    public String actionPerformedUser(ActionEvent e){
        return userText.getText();
    }
    public String actionPerformedPassword(ActionEvent e){
        return passwordField.getText();
    }

    
}

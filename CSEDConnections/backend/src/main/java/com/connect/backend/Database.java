package com.connect.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;  

public class Database {
    public static void main(String[] args) {
        //Device varibles
        String url = "jdbc:mysql://127.0.0.1:3306/csedconnections";
        String username = "root";
        String password = "arduino-010";

        System.out.println("Connecting database...");
        
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement=connection.createStatement();

            int m = statement.executeUpdate("insert into student(email ,name,password) values ('ahmed@gmail.com' , 'ahmed' ,'1234')");
            if (m==1)
                System.out.println("inserted successfully ");
            else
                System.out.println("insertion failed");

            ResultSet result=statement.executeQuery("select * from student");  

            while(result.next())  
                System.out.println(result.getString("email"));  
                
            connection.close();  
            System.out.println("Database connection closed!");
        } 
        catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
    void checkForanexistingmail(){
        
    }

    void checkDataSignin(){

    }

    void getallApearingData(){

    }

}
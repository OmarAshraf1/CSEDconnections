package com.connect.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

 

public class Database {
    private String url = "jdbc:mysql://127.0.0.1:3306/csedconnections";
    private String username = "root";
    private String password = "arduino-010";

    boolean checkUser(String email ,String pass1word){
        
        System.out.println("Connecting database...");
                
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement=connection.createStatement();

            ResultSet result=statement.executeQuery("select email"+
                                                    " from graduate "+ 
                                                    "where email = '" + email +"'"+
                                                    " AND password = '"+pass1word+"'");  

            boolean Exist=result.next();

            connection.close();  
            System.out.println("Database connection closed!");
            return Exist;
        } 
        catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    boolean checkEmail(String email){
        
        System.out.println("Connecting database...");
                
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement=connection.createStatement();

            ResultSet result=statement.executeQuery("select email"+
                                                    " from graduate "+ 
                                                    "where email = '" + email+"'");  

            
            boolean Exist=result.next();
            
            connection.close();  
            System.out.println("Database connection closed!");
            return !Exist;
        } 
        catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    boolean insertGraduate(Graduate G ){
        System.out.println("Connecting database...");
        
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement=connection.createStatement();
            
            Experience E=G.experience.get(0);
            try{
                String query="insert into graduate values ('"+G.mail+"' , '"+G.name+"' , '"+ G.birhtDate +"' , '"+ G.gender +"' , '"+ G.phone +"' , '"+ G.password +"' , '"+ G.img +"' , '"+ G.about+"' , '"+ G.graduationYear + "' )" ;
                System.out.println(query);
                statement.executeUpdate(query);
                statement.executeUpdate("insert into experience values ('"+G.mail+"' , '"+ E.companyName +"' , '"+ E.location +"' , '"+ E.position+"','"+ E.startDate +"','"+ E.endDate+"')" );
            }
            catch(Exception e){
                System.out.println("insertion failed");
                return false;
            }
                
             System.out.println("inserted successfully ");  
            connection.close();  
            System.out.println("Database connection closed!");
            return true;
        } 
        catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    List<DisplayedGrads> getGraduates(){
        List<DisplayedGrads> displayedGrads = new ArrayList<>();

        System.out.println("Connecting database...");
        
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement=connection.createStatement();

            ResultSet tuple=statement.executeQuery("select graduate.name ,graduate.email ,graduate.imageURL,experience.company ,experience.location"+
                                                    " from graduate JOIN experience "+ 
                                                    "on experience.email=graduate.email;");  

            
            
            
            while(tuple.next()){
                DisplayedGrads gradtemp = new DisplayedGrads();
                try {
                    gradtemp.company = tuple.getString("company") ;
                    gradtemp.email = tuple.getString("email") ;
                    gradtemp.img = tuple.getString("imageURL") ;
                    gradtemp.location = tuple.getString("location") ;
                    gradtemp.name = tuple.getString("name") ;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
                //System.out.println(gradtemp.name);
                displayedGrads.add(gradtemp) ;
    
            } 
            
            connection.close();  
            System.out.println("Database connection closed!");
        } 
        catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return displayedGrads;
    }

}

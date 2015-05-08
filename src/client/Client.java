/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Wiliam
 */
public class Client {

    public static void main(String[] args) {
              
        try{
            //create the connection to MySQL server
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wiltech", "wilferraciolli", "160916");
            
            //create the statement
            Statement stmt = (Statement)con.createStatement();
            
            String ID = "1";
            String name = "Wiliam Ferraciolli";            
            String position = "Doctor";
            String phone = "07540595289";
            String eMail = "wiliam334@hotmail.com";
            String preferedcontactmethod = "eMail";
            
            //build the query and run it
            String insert = "INSERT INTO carer(carerID, carerName, carerTitle, carerPhone, carerEmail, carerPreferedContact)" 
                    + "VALUES(?,?,?,?,?,?)";
            
            //build the statement
            PreparedStatement preparedStm = con.prepareStatement(insert);
            preparedStm.setString(1, ID);
            preparedStm.setString(2, name);
            preparedStm.setString(3, position);
            preparedStm.setString(4, phone);
            preparedStm.setString(5, eMail);
            preparedStm.setString(6, preferedcontactmethod);
            
            //execute the query
            preparedStm.execute();
            
           // stmt.executeUpdate(insert);
            System.out.println(insert);
            
        }catch(SQLException e){
             System.out.println(e.getMessage());
        }        
    }
    
}

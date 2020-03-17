package swingdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.cj.xdevapi.Statement;

public class draw{

    draw( String s) {
        String Url = "jdbc:mysql://localhost:3306/soo";
        String user = "root";
        String pass = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Trying to connect");
            Connection connection = DriverManager.getConnection(Url,user,pass);
           
            
            String SQL = "CREATE TABLE "+ s + "(\r\n" + 
            		"    x_axis int,\r\n" + 
            		"    y_axis int\r\n" + 
            		");";
        		
            
             PreparedStatement preparedStmt = connection.prepareStatement(SQL);
            
             preparedStmt.execute();
             
                     
            System.out.println("Connection Established Successfull and the DATABASE NAME IS:"
                    + connection.getMetaData().getDatabaseProductName());
        } catch (Exception e) {
System.out.println("Unable to make connection with DB");
            e.printStackTrace();
        }
    }
}
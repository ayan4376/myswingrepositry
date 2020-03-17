package swingdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class data_insert {
	
	   public data_insert(int s[],int a[],String p,int i)
	   {
		   String Url = "jdbc:mysql://localhost:3306/soo";
	        String user = "root";
	        String pass = "root";
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("Trying to connect");
	            Connection connection = DriverManager.getConnection(Url,user,pass);
	           int j=0;
	            while(j<i)
	            {
	            String SQL = "INSERT INTO "+ p +  
	            		"        ( x_axis,y_axis) VALUE \r\n" + 
	            		"        (?,?)";
	        		
	            
	             PreparedStatement preparedStmt = connection.prepareStatement(SQL);
	             preparedStmt.setInt(1, s[j]);
	             preparedStmt.setInt(2, a[j]);
	             preparedStmt.execute();
	             j=j+1;
	            }
	                     
	            System.out.println("Connection Established Successfull and the DATABASE NAME IS:"
	                    + connection.getMetaData().getDatabaseProductName());
	        } catch (Exception P) {
	System.out.println("Unable to make connection with DB");
	            P.printStackTrace();
	   }


}
}
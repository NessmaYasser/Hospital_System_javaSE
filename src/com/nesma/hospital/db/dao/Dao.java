
package com.nesma.hospital.db.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *class of connection with database
 */

public class Dao {
    /**
     *start connection with database
     * @return 
     * @throws java.lang.Exception 
     */
     public Connection getConnection() throws Exception
     {
         //define sql driver
         Class.forName("com.mysql.jdbc.Driver"); 
         //initialize the connection
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hospital_system","root",null); 
         // if there is a connection
         if(con!=null)                                        
         {
             return con;
         }
         //if there is no connection, get out
         return null;                                        
     }
     /**
      *close the connection with database
      * @param con
      * @throws java.lang.Exception
      */
    public void closeConnection(Connection con) throws Exception
    {
       //if connected, termenate it
       if(con!=null)                                        
       {
           con.close();
       }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author Igor-SSD
 */
public class BD {
    
    private static BD instancia = new BD();
    
    public static BD getInstance(){
       return instancia; 
   }
    private BD(){
        
    }

    public static Connection getConnection() throws SQLException,
            ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn
                = DriverManager.getConnection("jdbc:mysql://localhost/transport", "root", "");
        return conn;
    }

}

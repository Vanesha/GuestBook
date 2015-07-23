/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Vanesh
 */
public class DBWorker {
    private final String URL = "jadbc:mysql://localhost:3306/webapp";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";
    
    private Connection connection;
    public DBWorker(){
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
           e.printStackTrace();
        }
    
    }

    public Connection getConnection() {
        return connection;
    }

    public ResultSet executeResult(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
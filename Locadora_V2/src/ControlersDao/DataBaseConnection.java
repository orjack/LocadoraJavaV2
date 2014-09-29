package ControlersDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String USER = "root";
    private static final String PASSWORD = "";//unopar123
    private static final String DATABASE = "locadora";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/" + DATABASE;
    
    public Connection con = null;
    private static DataBaseConnection instance;
    
    private DataBaseConnection() {}
    
    public static DataBaseConnection getInstance() {
        if (instance == null)
            instance = new DataBaseConnection();
        return instance;
    }

    public Connection getConnection() {
        return con;
    }
    
    public void open() {
        
        try {
            Class.forName(DataBaseConnection.DRIVER);

            con = DriverManager.getConnection(
                    DataBaseConnection.CONNECTION_STRING, 
                    DataBaseConnection.USER, 
                    DataBaseConnection.PASSWORD
            );
        } catch (ClassNotFoundException ex) {

            System.out.println(ex.getStackTrace());

        } catch (SQLException ex) {

            System.out.println(ex.getStackTrace());

        }

    }

    public void close() {
        try {
        
            con.close();
            con = null;
            
        } catch(SQLException ex) {
            
        }
    }
}

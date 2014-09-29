
package ControlersDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionDao {
    private static final String USER = "root";
    private static final String PASSWORD = "";//unopar123
    private static final String DATABASE = "locadora";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/" + DATABASE;
    
    public static Connection con = null;
    public static PreparedStatement prepSt = null;
       
    public static void open() {
        try {
            Class.forName(ConnectionDao.DRIVER);
            con = DriverManager.getConnection(
                    ConnectionDao.CONNECTION_STRING, 
                    ConnectionDao.USER, 
                    ConnectionDao.PASSWORD
            );
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getStackTrace());
            System.out.println("Não foi possivel conectar o driver");

        } catch (SQLException ex) {
            System.out.println(ex.getStackTrace());
            System.out.println("Não foi possivel conectar ao banco de dados");
            
        }
    }
    
    public static void close() {
        try {
            prepSt.close();
            con.close();
            
            prepSt = null;
            con = null;
        }catch (SQLException ex) {
            System.out.println("Erro ao fechar a conexão!");
        }
    }
}

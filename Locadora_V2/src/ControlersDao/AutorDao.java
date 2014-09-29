
package ControlersDao;

import Model.AutorBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class AutorDao {
    private static final String TABLE_NAME = "Autor";
    
    public static void save(AutorBean autor) {  
        try {
            ConnectionDao.open();
            String query;
            if(autor.getId() > 0) {
                query = "UPDATE"+ TABLE_NAME
                        + "SET nome ="
                        + "WHERE id=?";
            } else {
                query = "INSERT INTO "+ TABLE_NAME +"(nome)"
                        + "VALUES(?)";
            }
            ConnectionDao.prepSt = ConnectionDao.con.prepareStatement(query);
            ConnectionDao.prepSt.setString(1, autor.getNome());
            ConnectionDao.prepSt.executeUpdate();
            
            ConnectionDao.close();
            
        } catch(SQLException ex) {
            System.out.println("Erro ao inserir registro no Banco");
        }
        
    }
    
    public static void delete(AutorBean autor) {
        ConnectionDao.open();
        String query = "DELETE FROM "+ TABLE_NAME +" WHERE id = ?";
        try {
            ConnectionDao.prepSt = ConnectionDao.con.prepareStatement(query);
            ConnectionDao.prepSt.setInt(1, autor.getId());
            ConnectionDao.prepSt.executeUpdate();
            ConnectionDao.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static ArrayList<AutorBean> all() {
        ArrayList<AutorBean> instance = new ArrayList();
        try {
            ConnectionDao.open();
            String query = "SELECT * FROM " + TABLE_NAME;
            ConnectionDao.prepSt = ConnectionDao.con.prepareCall(query);

            ResultSet rs = ConnectionDao.prepSt.executeQuery();
            
            while(rs.next()) {
                AutorBean autor = new AutorBean();
                autor.setId(rs.getInt("id"));
                autor.setNome(rs.getString("nome"));
                instance.add(autor);
            }
            rs.close();
            
        }  
        
        catch(SQLException ex) {
            ex.printStackTrace();
            System.out.println("Não existe este registro");
        } finally {
            ConnectionDao.close();
        }
        
        return instance;
    }
    
    public static AutorBean get(int id) {
        System.out.println(id);
        AutorBean autor = new AutorBean();
        try {
            ConnectionDao.open();
            String query = "SELECT * FROM " + TABLE_NAME 
                        + " WHERE `id` = " + id;
            ConnectionDao.prepSt = ConnectionDao.con.prepareCall(query);
            ResultSet rs = ConnectionDao.prepSt.executeQuery();
            
            if(rs.next()) {
                autor.setNome(rs.getString("nome"));
                
            }
            
            ConnectionDao.close();
            
        } catch(SQLException ex) {
            ex.printStackTrace();
            System.out.println("Não existe este registro");
        }
        System.out.println(autor.getNome().toString());
        return autor;
    }
}

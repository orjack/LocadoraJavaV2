
package ControlersDao;

import Model.DiretorBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DiretorDao {
    private static final String TABLE_NAME = "Diretor";
    
    public static void save(DiretorBean diretor) {  
        try {
            ConnectionDao.open();
            String query;
            if(diretor.getId() > 0) {
                query = "UPDATE"+ TABLE_NAME
                        + "SET nome ="
                        + "WHERE id=?";
            } else {
                query = "INSERT INTO "+ TABLE_NAME +"(nome)"
                        + "VALUES(?)";
            }
            ConnectionDao.prepSt = ConnectionDao.con.prepareStatement(query);
            ConnectionDao.prepSt.setString(1, diretor.getNome());
            ConnectionDao.prepSt.executeUpdate();
            
            ConnectionDao.close();
            
        } catch(SQLException ex) {
            System.out.println("Erro ao inserir registro no Banco");
        }
        
    }
    
    public static void delete(DiretorBean diretor) {
        ConnectionDao.open();
        String query = "DELETE FROM "+ TABLE_NAME +" WHERE id = ?";
        try {
            ConnectionDao.prepSt = ConnectionDao.con.prepareStatement(query);
            ConnectionDao.prepSt.setInt(1, diretor.getId());
            ConnectionDao.prepSt.executeUpdate();
            ConnectionDao.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static ArrayList<DiretorBean> all() {
        ArrayList<DiretorBean> instance = new ArrayList();
        try {
            ConnectionDao.open();
            String query = "SELECT * FROM " + TABLE_NAME;
            ConnectionDao.prepSt = ConnectionDao.con.prepareCall(query);

            ResultSet rs = ConnectionDao.prepSt.executeQuery();
            
            while(rs.next()) {
                DiretorBean diretor = new DiretorBean();
                diretor.setId(rs.getInt("id"));
                diretor.setNome(rs.getString("nome"));
                instance.add(diretor);
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
    
    public static DiretorBean get(int id) {
        System.out.println(id);
        DiretorBean diretor = new DiretorBean();
        try {
            ConnectionDao.open();
            String query = "SELECT * FROM " + TABLE_NAME 
                        + " WHERE `id` = " + id;
            ConnectionDao.prepSt = ConnectionDao.con.prepareCall(query);
            ResultSet rs = ConnectionDao.prepSt.executeQuery();
            
            if(rs.next()) {
                diretor.setNome(rs.getString("nome"));
                
            }
            
            ConnectionDao.close();
            
        } catch(SQLException ex) {
            ex.printStackTrace();
            System.out.println("Não existe este registro");
        }
        System.out.println(diretor.getNome().toString());
        return diretor;
    }
}

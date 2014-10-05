
package ControlersDao;

import Model.AutorBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class AutorDao {
    private static final String TABLE_NAME = "Autor";
    
    public void save(AutorBean autor) {
        try {
            ConnectionDao.open();
            
            PreparedStatement prepSt;
            String query;
            
            if (autor.getId() > 0) {
                query = "UPDATE "+ TABLE_NAME
                    + " SET nome= ?, situacao= ? WHERE id= ?";
                prepSt = ConnectionDao.getPreparedStatement(query);
                prepSt.setString(1, autor.getNome());
                prepSt.setInt(2, autor.getSituacao());
                prepSt.setInt(3, autor.getId());
                prepSt.executeUpdate();
            } else {
                query = "INSERT INTO "+ TABLE_NAME +" (nome)"
                    + " VALUES(?);"
                    + "INSERT INTO midias (locacao, midia)"
                    + " VALUES(?, ?)";
                prepSt = ConnectionDao.getPreparedStatement(query);
                prepSt.setString(1, autor.getNome());
                prepSt.executeUpdate();
            }
            
            ConnectionDao.close(prepSt);
            
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
        }
    }
    
    public ArrayList<AutorBean> all() {
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
                autor.setSituacao(rs.getInt("situacao"));
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
        AutorBean autor = new AutorBean();
        try {
            ConnectionDao.open();
            String query = "SELECT * FROM " + TABLE_NAME 
                        + " WHERE `id` = " + id;
            ConnectionDao.prepSt = ConnectionDao.con.prepareCall(query);
            ResultSet rs = ConnectionDao.prepSt.executeQuery();
            
            if(rs.next()) {
                autor.setId(rs.getInt("id"));
                autor.setNome(rs.getString("nome"));
                autor.setSituacao(rs.getInt("situacao"));
            }
            
            ConnectionDao.close();
            
        } catch(SQLException ex) {
            ex.printStackTrace();
            System.out.println("Não existe este registro");
        }
        return autor;
    }
}

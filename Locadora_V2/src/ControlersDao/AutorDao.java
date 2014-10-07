
package ControlersDao;

import Model.AutorBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class AutorDao {
    private static final String TABLE_NAME = "Autor";
    
    public void save(AutorBean autor) {
        PreparedStatement prepSt = null;
        try {
            String query;

            if (autor.getId() > 0) {
                query = "UPDATE "+ TABLE_NAME
                    + " SET nome= ?, situacao= ? WHERE id= ?";
                prepSt = ConnectionDao.getPreparedStatement(query);

                prepSt.setString(1, autor.getNome());
                prepSt.setInt(2, autor.getSituacao());
                prepSt.setInt(3, autor.getId());
                prepSt.executeUpdate();
                System.out.println("Alterado com sucesso!");
            } else {
                query = "INSERT INTO "+ TABLE_NAME +" (nome)"
                    + " VALUES(?);";
                prepSt = ConnectionDao.getPreparedStatement(query);

                prepSt.setString(1, autor.getNome());
                prepSt.executeUpdate();
                System.out.println("Salvo com sucesso!");
            }
        } catch(SQLException ex) {
            System.out.println("Erro ao inserir registro no Banco");
        } finally {
            ConnectionDao.close(prepSt);
        }
    }
    
    public static void delete(AutorBean autor) {
        ConnectionDao.open();
        String query = "DELETE FROM "+ TABLE_NAME +" WHERE id = ?";
        PreparedStatement prepSt = null;
        
        try {
            prepSt = ConnectionDao.getPreparedStatement(query);
            
            prepSt.setInt(1, autor.getId());
            prepSt.executeUpdate();
            System.out.println("Removido com sucesso!");
         
        } catch(SQLException ex) {
            System.out.println("Erro ao remover registro!");
        } finally {
            ConnectionDao.close(prepSt);
        }
    }
    
    public ArrayList<AutorBean> all() {
        ArrayList<AutorBean> instance = new ArrayList();
        PreparedStatement prepSt = null;
        try {
            ConnectionDao.open();
            String query = "SELECT * FROM " + TABLE_NAME;

            prepSt = ConnectionDao.getPreparedStatement(query);
            ResultSet rs = prepSt.executeQuery();

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
            ConnectionDao.close(prepSt);
        }
        return instance;
    }
    
    public static AutorBean get(int id) {
        AutorBean autor = new AutorBean();
        PreparedStatement prepSt = null;
        try {
            ConnectionDao.open();            
            String query = "SELECT * FROM " + TABLE_NAME 
                        + " WHERE `id` = " + id;
            prepSt = ConnectionDao.getPreparedStatement(query);
            ResultSet rs = prepSt.executeQuery();

            if(rs.next()) {
                autor.setId(rs.getInt("id"));
                autor.setNome(rs.getString("nome"));
                autor.setSituacao(rs.getInt("situacao"));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
            System.out.println("Não existe este registro");
        } finally {
            ConnectionDao.close(prepSt);
        }
        return autor;
    }
}

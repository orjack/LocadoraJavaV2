
package ControlersDao;

import Model.DiretorBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DiretorDao {
    private static final String TABLE_NAME = "Diretor";
    
    public void save(DiretorBean diretor) {  
        PreparedStatement prepSt = null;
        String query;
        try {

            if(diretor.getId() > 0) {
                query = "UPDATE "+ TABLE_NAME
                        + " SET nome= ?, situacao= ? WHERE id= ?";
                prepSt = ConnectionDao.getPreparedStatement(query);
                
                prepSt.setString(1, diretor.getNome());
                prepSt.setInt(2, diretor.getSitucacao());
                prepSt.setInt(3, diretor.getId());
                prepSt.executeUpdate();
                System.out.println("Alterado com sucesso!");
            } else {
                query = "INSERT INTO "+ TABLE_NAME +"(nome)"
                        + "VALUES(?)";
                prepSt = ConnectionDao.getPreparedStatement(query);
                
                prepSt.setString(1, diretor.getNome());
                prepSt.executeUpdate();
                System.out.println("Salvo com sucesso!");
            }
        } catch(SQLException ex) {
            System.out.println("Erro ao inserir registro no Banco");
        } finally {
            ConnectionDao.close(prepSt);
        }
    };
    
    public void delete(DiretorBean diretor) {
        PreparedStatement prepSt = null;
        String query = "DELETE FROM "+ TABLE_NAME +" WHERE id = ?";
        try {
            prepSt = ConnectionDao.getPreparedStatement(query);
            prepSt.setInt(1, diretor.getId());
            prepSt.executeUpdate();
            System.out.println("Removido com sucesso");
        } catch(SQLException ex) {
            System.out.println("Erro ao deletar registro");
        } finally {
            ConnectionDao.close(prepSt);
        }
    }
    
    public ArrayList<DiretorBean> all() {
        ArrayList<DiretorBean> instance = new ArrayList();
        PreparedStatement prepSt = null;
        try {
            String query = "SELECT * FROM " + TABLE_NAME;
            prepSt = ConnectionDao.getPreparedStatement(query);

            ResultSet rs = prepSt.executeQuery();

            while(rs.next()) {
                DiretorBean diretor = new DiretorBean();
                diretor.setId(rs.getInt("id"));
                diretor.setNome(rs.getString("nome"));
                diretor.setSituacao(rs.getInt("situacao"));
                instance.add(diretor);
            }
            rs.close();
        }  
        catch(SQLException ex) {
            System.out.println("Não existe este registro");
        } finally {
            ConnectionDao.close(prepSt);
        }
        
        return instance;
    }
    
    public static DiretorBean get(int id) {
        DiretorBean diretor = new DiretorBean();
        PreparedStatement prepSt = null;
        try {
            String query = "SELECT * FROM " + TABLE_NAME 
                        + " WHERE `id` = ?;";
            prepSt = ConnectionDao.getPreparedStatement(query);
            prepSt.setInt(1, id);

            ResultSet rs = prepSt.executeQuery();

            if(rs.next()) {
                diretor.setId(rs.getInt("id"));
                diretor.setNome(rs.getString("nome"));
                diretor.setSituacao(rs.getInt("situacao"));
            }
           
        } catch(SQLException ex) {
            ex.printStackTrace();
            System.out.println("Não existe este registro");
        } finally {
            ConnectionDao.close(prepSt);
        }
        return diretor;
    }
}

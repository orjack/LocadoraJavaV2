package ControlersDao;

import Model.AutorBean;
import Model.DiretorBean;
import Model.FornecedorBean;
import Model.MidiaBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MediaDao {
    private static final String TABLE_NAME = "Media";

    public void save(MidiaBean media) {

        ConnectionDao.open();
        String query = null;

        try {
        if(media.getId() > 0) {

        }
        else {
            query = "INSERT INTO "+ TABLE_NAME + "("
                    + "`fornecedor`, `grupo`, `genero`, `censura`, `titulo`,"
                    + "`autor`, `diretor`, `categoria`, `lancamento`, `sinopse`,"
                    + "`valor_compra`, `quantidade`, `valor_locacao`)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
        ConnectionDao.prepSt = ConnectionDao.con.prepareStatement(query);
        ConnectionDao.prepSt.setInt(1, media.getFornecedor().getId());
        ConnectionDao.prepSt.setString(2, media.getGrupo());
        ConnectionDao.prepSt.setString(3, media.getGenero());
        ConnectionDao.prepSt.setString(4, media.getCensura());
        ConnectionDao.prepSt.setString(5, media.getTitulo());
        ConnectionDao.prepSt.setInt(6, media.getAutor().getId());
        ConnectionDao.prepSt.setInt(7, media.getDiretor().getId());
        ConnectionDao.prepSt.setString(8, media.getCategoria());
        ConnectionDao.prepSt.setString(9, media.getData_lancamento());
        ConnectionDao.prepSt.setString(10, media.getSinopse());
        ConnectionDao.prepSt.setString(11, media.getValor_custo());
        ConnectionDao.prepSt.setString(12, media.getQuantidade());
        ConnectionDao.prepSt.setString(13, media.getValor_locacao());
        ConnectionDao.prepSt.executeUpdate();
        
        System.out.println("ADICIONADO");
        ConnectionDao.close();

        } catch(SQLException ex) {
            System.out.println("REJEITADO");
        }
        
    }
    
    public static ArrayList<MidiaBean> all() {
        ArrayList<MidiaBean> medias = new ArrayList();
        String query = "SELECT * FROM " + TABLE_NAME;
        
        try {
            ConnectionDao.open();
            ConnectionDao.prepSt = ConnectionDao.con.prepareStatement(query);
            ResultSet rs = ConnectionDao.prepSt.executeQuery();
            
            while (rs.next()) {
                MidiaBean media = new MidiaBean();
                media.setId(rs.getInt("id"));
                
                media.setGrupo(rs.getString("grupo"));
                media.setGenero(rs.getString("genero"));
                media.setCensura(rs.getString("censura"));
                media.setTitulo(rs.getString("titulo"));
                media.setCategoria(rs.getString("categoria"));
                media.setData_lancamento(rs.getString("lancamento"));
                media.setSinopse(rs.getString("sinopse"));
                media.setValor_custo(rs.getString("valor_compra"));
                media.setQuantidade(rs.getString("quantidade"));
                media.setValor_locacao(rs.getString("valor_locacao"));
                
                medias.add(media);
            }
            rs.close();
            
            
        } catch(SQLException ex) {}
        
        return medias;
    }
    
    public static void delete(MidiaBean media) {
        ConnectionDao.open();
        String query = "DELETE FROM "+ TABLE_NAME +" WHERE id = ?";
        try {
            
            ConnectionDao.prepSt = ConnectionDao.con.prepareStatement(query);
            ConnectionDao.prepSt.setInt(1, media.getId());
            ConnectionDao.prepSt.executeUpdate();
            ConnectionDao.close();
            System.out.println("DELETADO COMS SUCESSO!");
        } catch(SQLException ex) {
            System.out.println("ERRO AO DELETAR");
        }
    }
}

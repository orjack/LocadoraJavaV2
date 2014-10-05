package ControlersDao;

import Model.MidiaBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MediaDao {
    private static final String TABLE_NAME = "Media";
    private static final SimpleDateFormat SHORT_DATE_FORMAT = new SimpleDateFormat("yyyy");
    
    public void save(MidiaBean media) {
        PreparedStatement prepSt;
        String query;

        try {
            if(media.getId() > 0) {
                query = "UPDATE "+ TABLE_NAME
                        + " SET fornecedor= ?, grupo= ?, genero= ?, censura= ?, titulo= ?,"
                        + "autor= ?, diretor= ?, categoria= ?, data_lancamento= ?, sinopse= ?,"
                        + "valor_compra= ?, quantidade= ?, valor_locacao= ?, situacao= ?"
                        + " WHERE id= ?";
                prepSt = ConnectionDao.getPreparedStatement(query);
                prepSt.setInt(1, media.getFornecedor().getId());
                prepSt.setInt(2, media.getGrupo());
                prepSt.setInt(3, media.getGenero());
                prepSt.setInt(4, media.getCensura());
                prepSt.setString(5, media.getTitulo());
                prepSt.setInt(6, media.getAutor().getId());
                prepSt.setInt(7, media.getDiretor().getId());
                prepSt.setInt(8, media.getCategoria());
                prepSt.setString(9, String.valueOf(media.getDataLancamento()));
                prepSt.setString(10, media.getSinopse());
                prepSt.setDouble(11, media.getValorCusto());
                prepSt.setInt(12, media.getQuantidade());
                prepSt.setDouble(13, media.getValorLocacao());
                prepSt.setInt(14, media.getSituacao());
                prepSt.setInt(15, media.getId());
                prepSt.executeUpdate();
                System.out.println("ALTERADO COM SUCESSO");
            }
            else {
                query = "INSERT INTO "+ TABLE_NAME + "("
                        + "fornecedor, grupo, genero, censura, titulo,"
                        + "autor, diretor, categoria, data_lancamento, sinopse,"
                        + "valor_compra, quantidade, valor_locacao)"
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                prepSt = ConnectionDao.getPreparedStatement(query);
                prepSt.setInt(1, media.getFornecedor().getId());
                prepSt.setInt(2, media.getGrupo());
                prepSt.setInt(3, media.getGenero());
                prepSt.setInt(4, media.getCensura());
                prepSt.setString(5, media.getTitulo());
                prepSt.setInt(6, media.getAutor().getId());
                prepSt.setInt(7, media.getDiretor().getId());
                prepSt.setInt(8, media.getCategoria());
                prepSt.setString(9, String.valueOf(media.getDataLancamento()));
                prepSt.setString(10, media.getSinopse());
                prepSt.setDouble(11, media.getValorCusto());
                prepSt.setInt(12, media.getQuantidade());
                prepSt.setDouble(13, media.getValorLocacao());
                prepSt.executeUpdate();
                System.out.println("ADICIONADO");
            }
        ConnectionDao.close(prepSt);

        } catch(SQLException ex) {
            System.out.println("REJEITADO");
        }
    }
    
    public ArrayList<MidiaBean> all() {
        ArrayList<MidiaBean> medias = new ArrayList();
        PreparedStatement prepSt;
        String query = "SELECT * FROM " + TABLE_NAME;

        try {
            prepSt = ConnectionDao.getPreparedStatement(query);
            ResultSet rs = prepSt.executeQuery();
            while (rs.next()) {
                MidiaBean media = new MidiaBean();
                media.setId(rs.getInt("id"));
                media.setFornecedor(FornecedorDao.get(rs.getInt("id")));
                media.setGrupo(rs.getInt("grupo"));
                media.setGenero(rs.getInt("genero"));
                media.setCensura(rs.getInt("censura"));
                media.setTitulo(rs.getString("titulo"));
                media.setAutor(AutorDao.get(rs.getInt("id")));
                media.setDiretor(DiretorDao.get(rs.getInt("id")));
                media.setCategoria(rs.getInt("categoria"));
                media.setDataLancamento(rs.getString("data_lancamento"));
                media.setSinopse(rs.getString("sinopse"));
                media.setValorCusto(rs.getDouble("valor_compra"));
                media.setQuantidade(rs.getInt("quantidade"));
                media.setValorLocacao(rs.getDouble("valor_locacao"));
                media.setSituacao(rs.getInt("situacao"));
                medias.add(media);
            }
            rs.close();

        } catch(SQLException ex) {
        }
        return medias;
    }
    
    public void delete(MidiaBean media) {
        String query = "DELETE FROM "+ TABLE_NAME +" WHERE id = ?";
        PreparedStatement prepSt;
        try {
            
            prepSt = ConnectionDao.getPreparedStatement(query);
            prepSt.setInt(1, media.getId());
            prepSt.executeUpdate();
            ConnectionDao.close(prepSt);
            System.out.println("DELETADO COMS SUCESSO!");
        } catch(SQLException ex) {
            System.out.println("ERRO AO DELETAR");
        }
    }
    
    public MidiaBean get(int id) {
        MidiaBean media = new MidiaBean();
        PreparedStatement prepSt;
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";

        try {
            prepSt = ConnectionDao.getPreparedStatement(query);
            prepSt.setInt(1, id);
            ResultSet rs = prepSt.executeQuery();
            if (rs.next()) {
                media.setId(rs.getInt("id"));
                media.setFornecedor(FornecedorDao.get(rs.getInt("id")));
                media.setGrupo(rs.getInt("grupo"));
                media.setGenero(rs.getInt("genero"));
                media.setCensura(rs.getInt("censura"));
                media.setTitulo(rs.getString("titulo"));
                media.setAutor(AutorDao.get(rs.getInt("id")));
                media.setDiretor(DiretorDao.get(rs.getInt("id")));
                media.setCategoria(rs.getInt("categoria"));
                media.setDataLancamento(rs.getString("data_lancamento"));
                media.setSinopse(rs.getString("sinopse"));
                media.setValorCusto(rs.getDouble("valor_compra"));
                media.setQuantidade(rs.getInt("quantidade"));
                media.setValorLocacao(rs.getDouble("valor_locacao"));
                media.setSituacao(rs.getInt("situacao"));
            }
            rs.close();

        } catch(SQLException ex) {
        }
        return media;
    
    }
}

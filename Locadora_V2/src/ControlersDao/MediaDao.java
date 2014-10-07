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
    
    public void save(MidiaBean media) {
        PreparedStatement prepSt = null;
        String query;

        try {
            if(media.getId() > 0) {
                query = "UPDATE "+ TABLE_NAME
                        + " SET fornecedor= ?, grupo= ?, genero= ?, censura= ?, titulo= ?,"
                        + "autor= ?, diretor= ?, categoria= ?, ano_lancamento= ?, sinopse= ?,"
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
                prepSt.setInt(9, media.getAnoLancamento());
                prepSt.setString(10, media.getSinopse());
                prepSt.setDouble(11, media.getValorCusto());
                prepSt.setInt(12, media.getQuantidade());
                prepSt.setDouble(13, media.getValorLocacao());
                prepSt.setInt(14, media.getSituacao());
                prepSt.setInt(15, media.getId());
                prepSt.executeUpdate();
                System.out.println("Alterado com sucesso!");
            }
            else {
                query = "INSERT INTO "+ TABLE_NAME + "("
                        + "fornecedor, grupo, genero, censura, titulo,"
                        + "autor, diretor, categoria, ano_lancamento, sinopse,"
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
                prepSt.setInt(9, media.getAnoLancamento());
                prepSt.setString(10, media.getSinopse());
                prepSt.setDouble(11, media.getValorCusto());
                prepSt.setInt(12, media.getQuantidade());
                prepSt.setDouble(13, media.getValorLocacao());
                System.out.println(prepSt.toString());
                prepSt.executeUpdate();
                System.out.println("Salvo com sucesso!");
            }

        } catch(SQLException ex) {
            System.out.println("REJEITADO");
        } finally {
            ConnectionDao.close(prepSt);
        }
    }
    
    public ArrayList<MidiaBean> all() {
        ArrayList<MidiaBean> medias = new ArrayList();
        PreparedStatement prepSt = null;
        String query = "SELECT * FROM " + TABLE_NAME;

        try {
            prepSt = ConnectionDao.getPreparedStatement(query);
            ResultSet rs = prepSt.executeQuery();
            while (rs.next()) {
                MidiaBean media = new MidiaBean();
                media.setId(rs.getInt("id"));
                media.setFornecedor(FornecedorDao.get(rs.getInt("fornecedor")));
                media.setGrupo(rs.getInt("grupo"));
                media.setGenero(rs.getInt("genero"));
                media.setCensura(rs.getInt("censura"));
                media.setTitulo(rs.getString("titulo"));
                media.setAutor(AutorDao.get(rs.getInt("autor")));
                media.setDiretor(DiretorDao.get(rs.getInt("diretor")));
                media.setCategoria(rs.getInt("categoria"));
                media.setAnoLancamento(rs.getInt("ano_lancamento"));
                media.setSinopse(rs.getString("sinopse"));
                media.setValorCusto(rs.getDouble("valor_compra"));
                media.setQuantidade(rs.getInt("quantidade"));
                media.setValorLocacao(rs.getDouble("valor_locacao"));
                media.setSituacao(rs.getInt("situacao"));
                medias.add(media);
            }
            rs.close();

        } catch(SQLException ex) {
            
        } finally {
            ConnectionDao.close(prepSt);
        }
        return medias;
    }
    
    public void delete(MidiaBean media) {
        String query = "DELETE FROM "+ TABLE_NAME +" WHERE id = ?";
        PreparedStatement prepSt = null;
        try {
            
            prepSt = ConnectionDao.getPreparedStatement(query);
            prepSt.setInt(1, media.getId());
            
            prepSt.executeUpdate();
            System.out.println("Removido com sucesso!");
        } catch(SQLException ex) {
            System.out.println("Erro ao deletar registro!");
        } finally {
            ConnectionDao.close(prepSt);
        }
    }
    
    public MidiaBean get(int id) {
        MidiaBean media = new MidiaBean();
        PreparedStatement prepSt = null;
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";

        try {
            
            prepSt = ConnectionDao.getPreparedStatement(query);
            prepSt.setInt(1, id);
            
            ResultSet rs = prepSt.executeQuery();
            
            while (rs.next()) {
                media.setId(rs.getInt("id"));
                media.setFornecedor(FornecedorDao.get(rs.getInt("id")));
                media.setGrupo(rs.getInt("grupo"));
                media.setGenero(rs.getInt("genero"));
                media.setCensura(rs.getInt("censura"));
                media.setTitulo(rs.getString("titulo"));
                media.setAutor(AutorDao.get(rs.getInt("id")));
                media.setDiretor(DiretorDao.get(rs.getInt("id")));
                media.setCategoria(rs.getInt("categoria"));
                media.setAnoLancamento(rs.getInt("ano_lancamento"));
                media.setSinopse(rs.getString("sinopse"));
                media.setValorCusto(rs.getDouble("valor_compra"));
                media.setQuantidade(rs.getInt("quantidade"));
                media.setValorLocacao(rs.getDouble("valor_locacao"));
                media.setSituacao(rs.getInt("situacao"));
            }
            rs.close();

        } catch(SQLException ex) { 
        
        } finally {
            ConnectionDao.close(prepSt);
        }
        return media;
    }

    public ArrayList<MidiaBean> filter(int id_locacao) {
        ArrayList<MidiaBean> midias = new ArrayList();
        String query = "SELECT * FROM Media " +
                        "INNER JOIN MediaLocacao ON MediaLocacao.id_media = Media.id " +
                        "WHERE id_locacao = ?;";
        PreparedStatement prepSt;
        ResultSet rs;
        try {
            prepSt = ConnectionDao.getPreparedStatement(query);
            prepSt.setInt(1, id_locacao);
            
            rs = prepSt.executeQuery();
            while(rs.next()) {
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
                media.setAnoLancamento(rs.getInt("ano_lancamento"));
                media.setSinopse(rs.getString("sinopse"));
                media.setValorCusto(rs.getDouble("valor_compra"));
                media.setQuantidade(rs.getInt("quantidade"));
                media.setValorLocacao(rs.getDouble("valor_locacao"));
                media.setSituacao(rs.getInt("situacao"));
                midias.add(media);
            }
            ConnectionDao.close(prepSt);
            
        } catch(SQLException ex) {}
    
        return midias;
    }
}

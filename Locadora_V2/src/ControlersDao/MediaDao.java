package ControlersDao;

import Model.AutorBean;
import Model.MidiaBean;
import java.sql.SQLException;

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
}

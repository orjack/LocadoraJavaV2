
package ControlersDao;

import Model.LocacaoBean;
import Model.MidiaBean;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocacaoDao {
    
    private static final String TABLE_NAME = "Locacao";
    
    public void save(LocacaoBean locacao) {
        PreparedStatement prepSt;
        MidiaBean media = new MidiaBean();
        
        String query = "INSERT INTO " + TABLE_NAME +
                " (id_cliente, valor_pago, data_locacao)" + "VALUES (?,?,?) ;";
                
        String query2 = " INSERT INTO MediaLocacao " + "(id_locacao, id_media)" +
                " VALUES (?, ?);"; 
        try {
            ConnectionDao.open();
            prepSt = ConnectionDao.getPreparedStatement(query);
            prepSt.setInt(1, locacao.getCliente().getId());
            prepSt.setDouble(2, locacao.getValor_pago());
            prepSt.setString(3, locacao.getData_locacao());
            prepSt.executeUpdate();
            
            System.out.println("CRIOU A LOCACAO");
            prepSt = ConnectionDao.getPreparedStatement(query2);

            prepSt.setInt(1, locacao.getId());
            
            MediaDao dao = new MediaDao();
            ArrayList<MidiaBean> midias = dao.all();
            
            for (MidiaBean m : midias) {
                System.out.println("ID LOCACAO: " + locacao.getId() + "ID_MEDIAS: " + m.getId());
                prepSt.setObject(2, m.getId());
            }
            System.out.println(prepSt.toString());
            prepSt.executeUpdate();
            
            System.out.println("SALVO COM SUCESSO");
            ConnectionDao.close(prepSt);
        }catch (SQLException ex) {
            System.out.println("Erro a inserir dados");
        }
    }
}

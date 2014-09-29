
package ControlersDao;

import Model.LocacaoBean;
import Model.MidiaBean;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovimentoDao {
    
    private static final String TABLE_NAME = "Locacao";
    
    public void save() {
        String query = "INSERT INTO" + TABLE_NAME +
                "(cliente, valor_pago)" +
                "VALUES (?,?) ;";
        
        String query2 = "INSERT INTO MediaLocacao" + "(id_locacao, id_media)" +
                "VALUES (?, ?)"; 
        try {
            ConnectionDao.open();
            LocacaoBean locacao = new LocacaoBean();
            ConnectionDao.prepSt = ConnectionDao.con.prepareStatement(query);
            ConnectionDao.prepSt.setInt(1, locacao.getCliente().getId());
            ConnectionDao.prepSt.setString(2, locacao.getData_locacao());
            
            ConnectionDao.prepSt = ConnectionDao.con.prepareStatement(query2);
            ConnectionDao.prepSt.setInt(1, locacao.getId());
            ArrayList<MidiaBean> midias = locacao.getMidias();
            for (MidiaBean list : midias) {
                ConnectionDao.prepSt.setInt(2, list.getId());
            }
            
            ConnectionDao.prepSt.executeUpdate();
            
        }catch (SQLException ex) {
        
        }
    
    }
    
}

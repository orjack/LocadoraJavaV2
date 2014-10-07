
package ControlersDao;

import Model.LocacaoBean;
import Model.MidiaBean;
import com.mysql.jdbc.StringUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class LocacaoDao {
    
    private static final String TABLE_NAME = "Locacao";
    private static final SimpleDateFormat SHORT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    
    public String join(ArrayList<String> data, String delimiter)
    {
            if (data.size() == 0) return "";
            StringBuilder sb = new StringBuilder();
            int i;
            
            for(i=0;i<data.size()-1;i++) {
                sb.append(data.get(i) + delimiter);
            }
            
            return sb.toString() + data.get(i);
    }
    
    public void save(LocacaoBean locacao) {
        PreparedStatement prepSt;
        MidiaBean media = new MidiaBean();
        
        String query;

        try {
           if(locacao.getId() > 0) {
               query = "UPDATE " + TABLE_NAME + " " + 
                       "SET data_devolucao = ?, valor_pago = ?, situacao = ? " + 
                       "WHERE id = ? ;";
                prepSt = ConnectionDao.getPreparedStatement(query);
                prepSt.setString(1, SHORT_DATE_FORMAT.format(locacao.getDataDevolucao()));
                prepSt.setDouble(2, locacao.getValorPago());
                prepSt.setInt(3, locacao.getSituacao());
                prepSt.setInt(4, locacao.getId());                
                prepSt.executeUpdate();
                ConnectionDao.close(prepSt);
           }
           else {
                query = "INSERT INTO " + TABLE_NAME + " (id_cliente, data_locacao)" + "VALUES (?,?) ;";
                prepSt = ConnectionDao.getPreparedStatement(query, Statement.RETURN_GENERATED_KEYS);
                prepSt.setInt(1, locacao.getCliente().getId());
                prepSt.setString(2, SHORT_DATE_FORMAT.format(locacao.getDataLocacao()));
                
                prepSt.executeUpdate();
            
                // get id from locacao
                ResultSet rs = prepSt.getGeneratedKeys();
                rs.next();
                locacao.setId(rs.getInt(1));

                ConnectionDao.close(prepSt);

                query = "INSERT INTO MediaLocacao (id_locacao, id_media) VALUES " ;

                ArrayList<String> partialQueryMedia = new ArrayList<String>();

                for (MidiaBean midia: locacao.getMidias()) {
                    partialQueryMedia.add("(" + locacao.getId() + ", " + midia.getId() + ")");
                }

                query += join(partialQueryMedia, ",") + " ;";

                Statement st = ConnectionDao.getStatement();

                st.executeUpdate(query);
                ConnectionDao.close(st);
           }          
            System.out.println("SALVO COM SUCESSO");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Erro a inserir dados");
        }
    }

    public ArrayList<LocacaoBean> all() {
        PreparedStatement prepSt;
        ArrayList<LocacaoBean> locacoes = new ArrayList();
        String query = " SELECT * FROM " + TABLE_NAME;
                
        try {
            prepSt = ConnectionDao.getPreparedStatement(query);
            
            ResultSet rs = prepSt.executeQuery();
            while(rs.next()) {
                LocacaoBean locacao = new LocacaoBean();
                locacao.setId(rs.getInt("id"));
                ClienteDao clienteDao = new ClienteDao();
                locacao.setCliente(clienteDao.get(rs.getInt("id_cliente")));
                locacao.setDataLocacao(SHORT_DATE_FORMAT.parse(rs.getString("data_locacao")));
                locacao.setSituacao(rs.getInt("situacao"));
                locacoes.add(locacao);
            }
            rs.close();
            ConnectionDao.close(prepSt);
        } catch(SQLException ex) { 
        
        } catch(ParseException ex) {}

        return locacoes;
    }
    
    public ArrayList<LocacaoBean> filter(int id_cliente, int situacao) {
        PreparedStatement prepSt;
        ArrayList<LocacaoBean> locacoes = new ArrayList();
        String query = "SELECT * FROM " + TABLE_NAME + " " +
                       "WHERE id_cliente = ? AND situacao = ? ;";
                
        try {
            prepSt = ConnectionDao.getPreparedStatement(query);
            
            prepSt.setInt(1, id_cliente);
            prepSt.setInt(2, situacao);
            
            ResultSet rs = prepSt.executeQuery();
            while(rs.next()) {
                LocacaoBean locacao = new LocacaoBean();
                locacao.setId(rs.getInt("id"));
                ClienteDao clienteDao = new ClienteDao();
                locacao.setCliente(clienteDao.get(rs.getInt("id_cliente")));
                locacao.setDataLocacao(SHORT_DATE_FORMAT.parse(rs.getString("data_locacao")));
                locacao.setSituacao(rs.getInt("situacao"));
                locacoes.add(locacao);
            }
            rs.close();
            ConnectionDao.close(prepSt);
        } catch(SQLException ex) { 
            ex.getMessage();
        }catch(ParseException ex) {}

        return locacoes;
    }
         
    public LocacaoBean get(int id) {
        ArrayList<MidiaBean> midias = new ArrayList();
        ClienteDao clienteDao = new ClienteDao();
        MediaDao mediaDao = new MediaDao();
        LocacaoBean locacao = new LocacaoBean();
        ResultSet rs;
        PreparedStatement prepSt;
        String query = "SELECT * FROM Locacao WHERE id= ?;";

        try {
            prepSt = ConnectionDao.getPreparedStatement(query);
            prepSt.setInt(1, id);
            rs = prepSt.executeQuery();
            
            if(rs.next()) {
                locacao.setId(id);
                locacao.setCliente(clienteDao.get(rs.getInt("id_cliente")));
                locacao.setDataLocacao(SHORT_DATE_FORMAT.parse(rs.getString("data_locacao")));
                locacao.setSituacao(rs.getInt("situacao"));
                locacao.setMidias(mediaDao.filter(id));
            }
            ConnectionDao.close(prepSt);
            
        } catch(SQLException ex) { 
            ex.getMessage();
        
        } catch (ParseException ex) {}

        return locacao;
    }

}

package ControlersDao;

import Model.ClienteBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ClienteDao {
        private static final String TABLE_NAME = "Cliente";
        private static final SimpleDateFormat SHORT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        private static PreparedStatement prepSt;
    
    public void update(ClienteBean cliente){
        String query;
          
        query = "UPDATE " + TABLE_NAME + 
                    " SET nome = ?, cpf = ?, rg = ?, data_nascimento = ?, sexo = ?,"
                    + "cep = ?, logradouro = ?, numero_logradouro = ?, bairro = ?, municipio = ?, uf = ?,"
                    + " telefone = ?, celular = ?, email = ?, situacao = ? WHERE id= ?";
        try {
            ConnectionDao.open();
            prepSt = ConnectionDao.getPreparedStatement(query);
            prepSt.setString(1, cliente.getNome());
            prepSt.setString(2, cliente.getCpf());
            prepSt.setString(3, cliente.getRg());
            prepSt.setString(4, SHORT_DATE_FORMAT.format(cliente.getDataNascimento()));
            prepSt.setInt(5, cliente.getSexo());
            prepSt.setString(6, cliente.getCep());
            prepSt.setString(7, cliente.getLogradouro());
            prepSt.setInt(8, cliente.getNumeroLogradouro());
            prepSt.setString(9, cliente.getBairro());
            prepSt.setInt(10, cliente.getMunicipio());
            prepSt.setString(11, cliente.getUf());
            prepSt.setString(12, cliente.getNumeroTelefone());
            prepSt.setString(13, cliente.getNumeroCelular());
            prepSt.setString(14, cliente.getEmail());
            prepSt.setInt(15, cliente.getSituacao());
            prepSt.setInt(16, cliente.getId());
            System.out.println(prepSt.toString());
            prepSt.executeUpdate();
            
            System.out.println("Alterado com sucesso");
            ConnectionDao.close(prepSt);
        
        }catch(SQLException ex) {
             System.out.println("ERRO AO Alterar "); 
        }
    }    
    
    public void save(ClienteBean cliente) { 
        try {
            ConnectionDao.open();
            String query;

            query = "INSERT INTO " + TABLE_NAME 
                    + "(nome, cpf, rg, data_nascimento, sexo,"
                    + "cep, logradouro, numero_logradouro, bairro, "
                    + "municipio, uf, telefone, celular,email)" +
                    " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
           
            prepSt = ConnectionDao.getPreparedStatement(query);
            prepSt.setString(1, cliente.getNome());
            prepSt.setString(2, cliente.getCpf());
            prepSt.setString(3, cliente.getRg());
            prepSt.setString(4, SHORT_DATE_FORMAT.format(cliente.getDataNascimento()));
            prepSt.setInt(5, cliente.getSexo());
            prepSt.setString(6, cliente.getCep());
            prepSt.setString(7, cliente.getLogradouro());
            prepSt.setInt(8, cliente.getNumeroLogradouro());
            prepSt.setString(9, cliente.getBairro());
            prepSt.setInt(10, cliente.getMunicipio());
            prepSt.setString(11, cliente.getUf());
            prepSt.setString(12, cliente.getNumeroTelefone());
            prepSt.setString(13, cliente.getNumeroCelular());
            prepSt.setString(14, cliente.getEmail());
            
            System.out.println(prepSt.toString());
            
            prepSt.executeUpdate();
            System.out.println("ADICIONADO");
            ConnectionDao.close(prepSt);

        } catch(SQLException ex) {
             System.out.println("ERRO AO ADICIONAR");

        }
    }
    
    public void delete(ClienteBean cliente) {
        ConnectionDao.open();
        String query = "DELETE FROM "+ TABLE_NAME +" WHERE id = ?";
        try {
            PreparedStatement prepSt = ConnectionDao.getPreparedStatement(query);
            prepSt.setInt(1, cliente.getId());
            prepSt.executeUpdate();
            System.out.println("Removido com sucesso!");
        } catch(SQLException ex) {
            System.out.println("ERRO AO DELETAR");
        }
    }
    
    public ArrayList<ClienteBean> all() {
        ArrayList<ClienteBean> clientes = new ArrayList();
        String query = "SELECT * FROM " + TABLE_NAME;
        try {
            
            PreparedStatement prepSt = ConnectionDao.getPreparedStatement(query);
            ResultSet rs = prepSt.executeQuery();
            
            while(rs.next()) {
                ClienteBean cliente = new ClienteBean();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setDataNascimento(SHORT_DATE_FORMAT.parse(rs.getString("data_nascimento")));
                cliente.setSexo(rs.getInt("sexo"));
                cliente.setCep(rs.getString("cep"));
                cliente.setLogradouro(rs.getString("logradouro"));
                cliente.setNumeroLogradouro(rs.getInt("numero_logradouro"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setMunicipio(rs.getInt("municipio"));
                cliente.setUf(rs.getString("uf"));
                cliente.setNumeroTelefone(rs.getString("telefone"));
                cliente.setNumeroCelular(rs.getString("celular"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSituacao(rs.getInt("situacao"));                
                clientes.add(cliente);
            }
        
        } catch(SQLException ex) {
            System.out.println("Erro ao listar os clientes");
        } catch(ParseException ex) {
            System.out.println("Erro na data");
        }
        
        return clientes;
    
    }
    
    public ClienteBean get(int id) {
        ClienteBean cliente = new ClienteBean();
        String query = "SELECT * FROM " + TABLE_NAME + "WHERE id = " + id;
        System.out.println(id);
        try {
            PreparedStatement prepSt = ConnectionDao.getPreparedStatement(query);
            ResultSet rs = prepSt.executeQuery();
            
            if(rs.next()) {
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setDataNascimento(SHORT_DATE_FORMAT.parse(rs.getString("data_nascimento")));
                cliente.setSexo(rs.getInt("sexo"));
                cliente.setCep(rs.getString("cep"));
                cliente.setLogradouro(rs.getString("logradouro"));
                cliente.setNumeroLogradouro(rs.getInt("numeroLogradouro"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setMunicipio(rs.getInt("municipio"));
                cliente.setUf(rs.getString("uf"));
                cliente.setNumeroTelefone(rs.getString("telefone"));
                cliente.setNumeroCelular(rs.getString("celular"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSituacao(rs.getInt("situacao"));               
            }
        }catch (SQLException ex) {

        }catch (ParseException ex) {}
           
        return cliente;
    }
}

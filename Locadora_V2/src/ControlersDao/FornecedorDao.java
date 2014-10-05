package ControlersDao;

import Model.FornecedorBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FornecedorDao {
    private static final String TABLE_NAME = "Fornecedor";
    
    public void save(FornecedorBean fornecedor) {
        
        try {
            ConnectionDao.open();
            
            PreparedStatement prepSt;
            String query;
            
            if (fornecedor.getId() > 0) { // update
                query = "UPDATE " + TABLE_NAME + " SET " 
                        + "razao_social= ?, cnpj= ?, ie= ?,"
                        + "cep= ?, logradouro= ?, numero_logradouro= ?, bairro= ?, "
                        + "municipio= ?, uf= ?, telefone= ?, celular= ?,email= ?, situacao=?"
                        + " WHERE id= ?";
                prepSt = ConnectionDao.getPreparedStatement(query);
                prepSt.setString(1, fornecedor.getRazaoSocial());
                prepSt.setString(2, fornecedor.getCnpj());
                prepSt.setString(3, fornecedor.getInscricaoEstadual());
                prepSt.setString(4, fornecedor.getCep());
                prepSt.setString(5, fornecedor.getLogradouro());
                prepSt.setInt(6, fornecedor.getNumeroLogradouro());
                prepSt.setString(7, fornecedor.getBairro());
                prepSt.setInt(8, fornecedor.getMunicipio());
                prepSt.setString(9, fornecedor.getUf());
                prepSt.setString(10, fornecedor.getNumeroTelefone());
                prepSt.setString(11, fornecedor.getNumeroCelular());
                prepSt.setString(12, fornecedor.getEmail());
                prepSt.setInt(13, fornecedor.getSituacao());
                prepSt.setInt(14, fornecedor.getId());
                System.out.println(prepSt.toString());
                prepSt.executeUpdate();
                
            }
            else { // insert
                query = "INSERT INTO " + TABLE_NAME 
                        + "(razao_social, cnpj, ie,"
                        + "cep, logradouro, numero_logradouro, bairro, "
                        + "municipio, uf, telefone, celular,email)" +
                        " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
                prepSt = ConnectionDao.getPreparedStatement(query);
                prepSt.setString(1, fornecedor.getRazaoSocial());
                prepSt.setString(2, fornecedor.getCnpj());
                prepSt.setString(3, fornecedor.getInscricaoEstadual());
                prepSt.setString(4, fornecedor.getCep());
                prepSt.setString(5, fornecedor.getLogradouro());
                prepSt.setInt(6, fornecedor.getNumeroLogradouro());
                prepSt.setString(7, fornecedor.getBairro());
                prepSt.setInt(8, fornecedor.getMunicipio());
                prepSt.setString(9, fornecedor.getUf());
                prepSt.setString(10, fornecedor.getNumeroTelefone());
                prepSt.setString(11, fornecedor.getNumeroCelular());
                prepSt.setString(12, fornecedor.getEmail());
                System.out.println(prepSt.toString());
                prepSt.executeUpdate();
                }
               
        } catch(SQLException ex){
            System.out.println("ERROROROROR");
        }
    }
    
    public static ArrayList<FornecedorBean> all() {
        ArrayList<FornecedorBean> fornecedores = new ArrayList();
        String query = "SELECT * FROM " + TABLE_NAME;
        
        try {
            ConnectionDao.open();
            ConnectionDao.prepSt = ConnectionDao.con.prepareStatement(query);
            ResultSet rs = ConnectionDao.prepSt.executeQuery();
            
            while (rs.next()) {
                FornecedorBean fornecedor = new FornecedorBean();
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setRazaoSocial(rs.getString("razao_social"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setInscricaoEstadual(rs.getString("ie"));
                
                fornecedor.setCep(rs.getString("cep"));
                fornecedor.setLogradouro(rs.getString("logradouro"));
                fornecedor.setNumeroLogradouro(rs.getInt("numero_logradouro"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setMunicipio(rs.getInt("municipio"));
                fornecedor.setUf(rs.getString("uf"));
                
                fornecedor.setNumeroTelefone(rs.getString("telefone"));
                fornecedor.setNumeroCelular(rs.getString("celular"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setSituacao(rs.getInt("situacao"));
                
                fornecedores.add(fornecedor);
            }
            rs.close();
            
            
        } catch(SQLException ex) {}
        
        return fornecedores;
    }
    
    public static void delete(FornecedorBean fornecedor) {
        ConnectionDao.open();
        String query = "DELETE FROM "+ TABLE_NAME +" WHERE id = ?";
        try {
            
            ConnectionDao.prepSt = ConnectionDao.con.prepareStatement(query);
            ConnectionDao.prepSt.setInt(1, fornecedor.getId());
            ConnectionDao.prepSt.executeUpdate();
            ConnectionDao.close();
            System.out.println("DELETADO COMS SUCESSO!");
        } catch(SQLException ex) {
            System.out.println("ERRO AO DELETAR");
        }
    }

    public static FornecedorBean get(int id) {
        System.out.println(id);
        FornecedorBean fornecedor = new FornecedorBean();
        try {
            ConnectionDao.open();
            String query = "SELECT * FROM " + TABLE_NAME 
                        + " WHERE `id` = " + id;
            ConnectionDao.prepSt = ConnectionDao.con.prepareCall(query);
            ResultSet rs = ConnectionDao.prepSt.executeQuery();
            
            if(rs.next()) {
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setRazaoSocial(rs.getString("razao_social"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setInscricaoEstadual(rs.getString("ie"));
                fornecedor.setCep(rs.getString("cep"));
                fornecedor.setLogradouro(rs.getString("logradouro"));
                fornecedor.setNumeroLogradouro(rs.getInt("numero_logradouro"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setMunicipio(rs.getInt("municipio"));
                fornecedor.setUf(rs.getString("uf"));
                
                fornecedor.setNumeroTelefone(rs.getString("telefone"));
                fornecedor.setNumeroCelular(rs.getString("celular"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setSituacao(rs.getInt("situacao"));
            }
            
            ConnectionDao.close();
            
        } catch(SQLException ex) {
            ex.printStackTrace();
            System.out.println("Não existe este registro");
        }
        return fornecedor;
    }

}

package ControlersDao;

import Model.FornecedorBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FornecedorDao {
    private static final String TABLE_NAME = "Fornecedor";
    
    public void save(FornecedorBean fornecedor) {
        
        try {
            ConnectionDao.open();
            String query = null;
            
            if (fornecedor.getId() > 0) { // update
                System.out.println("HAHAHAH");
            }
            else { // insert
                query = "INSERT INTO " + TABLE_NAME 
                        + "(razao_social, cnpj, ie,"
                        + "cep, logradouro, numero_logradouro, bairro, "
                        + "municipio, uf, telefone, celular,email)" +
                        " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
                }
            ConnectionDao.prepSt = ConnectionDao.con.prepareStatement(query);
            ConnectionDao.prepSt.setString(1, fornecedor.getRazao_social());
            ConnectionDao.prepSt.setString(2, fornecedor.getCnpj());
            ConnectionDao.prepSt.setString(3, fornecedor.getInscricao_estadual());
            ConnectionDao.prepSt.setString(4, fornecedor.getCep());
            ConnectionDao.prepSt.setString(5, fornecedor.getLogradouro());
            ConnectionDao.prepSt.setString(6, fornecedor.getNumero_logradouro());
            ConnectionDao.prepSt.setString(7, fornecedor.getBairro());
            ConnectionDao.prepSt.setString(8, fornecedor.getMunicipio());
            ConnectionDao.prepSt.setString(9, fornecedor.getUf());
            ConnectionDao.prepSt.setString(10, fornecedor.getNumero_residencial());
            ConnectionDao.prepSt.setString(11, fornecedor.getNumero_celular());
            ConnectionDao.prepSt.setString(12, fornecedor.getEmail());
            ConnectionDao.prepSt.executeUpdate();
                
        } catch(SQLException ex){
            System.out.println("ERROROROROR");
            ex.printStackTrace();
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
                fornecedor.setRazao_social(rs.getString("razao_social"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setInscricao_estadual(rs.getString("ie"));
                
                fornecedor.setCep(rs.getString("cep"));
                fornecedor.setLogradouro(rs.getString("logradouro"));
                fornecedor.setNumero_logradouro(rs.getString("numero_logradouro"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setMunicipio(rs.getString("municipio"));
                fornecedor.setUf(rs.getString("uf"));
                
                fornecedor.setNumero_residencial(rs.getString("telefone"));
                fornecedor.setNumero_celular(rs.getString("celular"));
                fornecedor.setEmail(rs.getString("email"));
                
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
                fornecedor.setRazao_social(rs.getString("razao_social"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setInscricao_estadual(rs.getString("ie"));
                fornecedor.setCep(rs.getString("cep"));
                fornecedor.setLogradouro(rs.getString("logradouro"));
                fornecedor.setNumero_logradouro(rs.getString("numero_logradouro"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setMunicipio(rs.getString("municipio"));
                fornecedor.setUf(rs.getString("uf"));
                
                fornecedor.setNumero_residencial(rs.getString("telefone"));
                fornecedor.setNumero_celular(rs.getString("celular"));
                fornecedor.setEmail(rs.getString("email"));
            }
            
            ConnectionDao.close();
            
        } catch(SQLException ex) {
            ex.printStackTrace();
            System.out.println("Não existe este registro");
        }
        return fornecedor;
    }

}

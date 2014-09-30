package ControlersDao;

import Model.ClienteBean;
import java.sql.SQLException;

public class ClienteDao {
        private static final String TABLE_NAME = "Cliente";
    
    public void save(ClienteBean cliente) { 
        try {
            ConnectionDao.open();
            String query = null;
            
            if (cliente.getId() > 0) { // update
                System.out.println("HAHAHAH");
            }
            else { // insert
                query = "INSERT INTO " + TABLE_NAME 
                        + "(nome, cpf, rg, data_nascimento, sexo,"
                        + "cep, logradouro, numero_logradouro, bairro, "
                        + "municipio, uf, telefone, celular,email)" +
                        " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
                }
            ConnectionDao.prepSt = ConnectionDao.con.prepareStatement(query);
            ConnectionDao.prepSt.setString(1, cliente.getNome());
            ConnectionDao.prepSt.setString(2, cliente.getCpf());
            ConnectionDao.prepSt.setString(3, cliente.getRg());
            ConnectionDao.prepSt.setString(4, cliente.getData_aniversario());
            ConnectionDao.prepSt.setString(5, cliente.getSexo());
            ConnectionDao.prepSt.setString(6, cliente.getCep());
            ConnectionDao.prepSt.setString(7, cliente.getLogradouro());
            ConnectionDao.prepSt.setString(8, cliente.getNumero_logradouro());
            ConnectionDao.prepSt.setString(9, cliente.getBairro());
            ConnectionDao.prepSt.setString(10, cliente.getMunicipio());
            ConnectionDao.prepSt.setString(11, cliente.getUf());
            ConnectionDao.prepSt.setString(12, cliente.getNumero_residencial());
            ConnectionDao.prepSt.setString(13, cliente.getNumero_celular());
            ConnectionDao.prepSt.setString(14, cliente.getEmail());
            
            ConnectionDao.prepSt.executeUpdate();
            System.out.println("ADICIONADO");

        } catch(SQLException ex) {
             System.out.println("ERRO AO ADICIONAR");

        }
    }
    
    public static void delete(ClienteBean cliente) {
        ConnectionDao.open();
        String query = "DELETE FROM "+ TABLE_NAME +" WHERE id = ?";
        try {
            
            ConnectionDao.prepSt = ConnectionDao.con.prepareStatement(query);
            ConnectionDao.prepSt.setInt(1, cliente.getId());
            ConnectionDao.prepSt.executeUpdate();
            ConnectionDao.close();
            System.out.println("DELETADO COMS SUCESSO!");
        } catch(SQLException ex) {
            System.out.println("ERRO AO DELETAR");
        }
    }
}

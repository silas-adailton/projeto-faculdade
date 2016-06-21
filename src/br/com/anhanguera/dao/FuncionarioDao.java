
package br.com.anhanguera.dao;

import br.com.anhanguera.model.Funcionario;
import br.com.anhanguera.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Silas
 */
public class FuncionarioDao {
    
    public void salvarFuncionario(Funcionario f){
        Connection con = Conexao.getConnection();
            
            PreparedStatement psm = null;
        try {
            
            
            String sql = "insert into funcionario (cod_func,nome,idade,cargo,rua,bairro,cidade,uf,tel,cel,rg,cpf,Data_Nascimento) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            psm = con.prepareStatement(sql);
            
            //Contato
            int index = 1;
            psm.setInt(index++,f.getCodFunc());
            psm.setString(index++,f.getNome());
            psm.setInt(index++,f.getIdade());
            psm.setString(index++,f.getCargo());
            psm.setString(index++,f.getRua());
            psm.setString(index++,f.getBairro());
            psm.setString(index++, f.getCidade());
            psm.setString(index++,f.getUf());
            psm.setString(index++,f.getTel());
            psm.setString(index++,f.getCel());
            psm.setString(index++, f.getRg());
            psm.setString(index++,f.getCpf());
           // java.sql.Date sqlDate = new java.sql.Date(f.getDataNasc().getTime());  
            psm.setDate(index++,java.sql.Date.valueOf(f.getDataNasc()));
            //psm.setDate(index++, sqlDate);
              
           
            //Endereço
           
           
            //Tel
           
            
            psm.execute();
           
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();
                psm.close();
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    PreparedStatement stm;
    ResultSet rs;
    public List<Funcionario> buscaFuncionario(){
        List<Funcionario> listaDeFuncionario = new ArrayList<>();
        Conexao.getConnection();
        
        try {
            
            String sql = "select * from funcionario";
            
            stm = Conexao.getConnection().prepareStatement(sql);
                       
            rs = stm.executeQuery();
            
            while(rs.next()){
                Funcionario f = new Funcionario();
                f.setCodFunc(rs.getInt("cod_func"));
                f.setNome(rs.getString("nome"));
                f.setIdade(rs.getInt("idade"));
                f.setCargo(rs.getString("cargo"));
                f.setRua(rs.getString("rua"));
                f.setBairro(rs.getString("bairro"));
                f.setCidade(rs.getString("cidade"));
                f.setUf(rs.getString("uf"));
                f.setTel(rs.getString("tel"));
                f.setCel(rs.getString("cel"));
                f.setRg(rs.getString("rg"));
                f.setCpf(rs.getString("cpf"));
                
                listaDeFuncionario.add(f);
                
            }
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao efetuar a pesquisa!");            
        }
        
        finally{
            
            try {
                Conexao.getConnection().close();
                stm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return listaDeFuncionario;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anhanguera.dao;

import br.com.anhanguera.model.Aluno;
import br.com.anhanguera.model.Presenca;
import br.com.anhanguera.util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class PresencaDao {
    PreparedStatement stm;
    ResultSet rs;
    public void inserirPresenca(Presenca p,Aluno a){
        
        //Connection con = Conexao.getConnection();
        stm = null;
      
        try {
            String sql = "insert into presenca (cod_aluno,data) values (?,?)";
            
            stm = Conexao.getConnection().prepareStatement(sql);
                        
            stm.setInt(1,a.getCodAluno());             
            stm.setDate(2,java.sql.Date.valueOf(p.getData()));
            
            stm.execute();            
            
            JOptionPane.showMessageDialog(null,"Castrado com sucesso!!!");
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar "+ e.getMessage());
            
            
        }finally{            
            
            try {
                Conexao.getConnection().close();
                stm.close();                
            } catch (SQLException ex) {
                Logger.getLogger(PresencaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }

    public boolean verificaAluno(){
        Aluno a = new Aluno();
        try {
            String sql = "select cod_aluno from aluno where cod_aluno = "+ a.getCodAluno();
            stm = Conexao.getConnection().prepareStatement(sql);            
            rs = stm.executeQuery();            
            while(rs.next()){                
                int cod = rs.getInt("cod_aluno");                
                if(cod == a.getCodAluno()){
                    return true;
                }               
            }            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao efetuar a consulta!");
        }
        finally{
            try {
                Conexao.getConnection().close();
                stm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(PresencaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return false;
    }
}


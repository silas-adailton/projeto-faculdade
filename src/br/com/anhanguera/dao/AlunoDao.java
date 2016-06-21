/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anhanguera.dao;

import br.com.anhanguera.model.Aluno;
import br.com.anhanguera.util.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Silas
 */
public class AlunoDao {
    PreparedStatement psm = null;
    Connection con = null;
    ResultSet rs = null;
    public void cadastrarAluno(Aluno a){                   
            
        try {
            con = Conexao.getConnection();
            
            String sql = "insert into aluno (cod_aluno,cod_atividade,nome,data_nascimento,idade,rua,bairro,cidade,uf,tel,cel,rg,cpf) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            psm = con.prepareStatement(sql);
            
            //Contato
            int index = 1;
            psm.setInt(index++, a.getCodAluno());
            psm.setInt(index++, a.getCodAtividade());
            psm.setString(index++, a.getNome());
            psm.setDate(index++,java.sql.Date.valueOf(a.getDataNasc()));
            psm.setInt(index++, a.getIdade());            
            psm.setString(index++,a.getRua());
            psm.setString(index++,a.getBairro());
            psm.setString(index++, a.getCidade());
            psm.setString(index++, a.getUf());
            psm.setString(index++,  a.getTel());
            psm.setString(index++,a.getCel());
            psm.setString(index++, a.getRg());
            psm.setString(index++, a.getCpf());
           // java.sql.Date sqlDate = new java.sql.Date(f.getDataNasc().getTime());                         
                     
            if(psm.execute()){
                JOptionPane.showMessageDialog(null,"Cadastro efetuado com sucesso!");
            }
           
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null,"Erro ao efetuar o cadastro!" +ex);
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
    
    public List<Aluno> selectAluno(Aluno a, String filtro){
        Aluno a1 = new Aluno();
        List<Aluno>listaDeAlunos = new ArrayList<>();
        String sql = null;
        
        try {
            
            switch(filtro){
            
                case "Código":
                    sql = "select * from aluno where cod_aluno = "+a1.getCodAluno();
                break; 
                    
                case "Nome":
                    sql = "select * from aluno where cod_aluno = "+a1.getNome();
                break;    
                
                default:
                    sql = "select * from aluno";
                break;    
        }
            
            psm = Conexao.getConnection().prepareStatement(sql);
            
            rs = psm.executeQuery();
            
            while(rs.next()){
                
                a.setCodAluno(rs.getInt("cod_aluno"));
                a.setCodAtividade(rs.getInt("cod_atividade"));
                a.setNome(rs.getString("nome"));
                Date dt = rs.getDate("data");//Converte a data que vem do banco em formato Date
                String dataString = String.valueOf(dt);// Converte a data para String
                a.setDataNasc(LocalDate.parse(dataString));//Converte a data de String para LocalDate e seta na model.
                a.setIdade(rs.getInt("idade"));
                a.setRua(rs.getString("rua"));
                a.setBairro(rs.getString("bairro"));
                a.setCidade(rs.getString("cidade"));
                a.setUf(rs.getString("uf"));
                a.setTel(rs.getString("tel"));
                a.setCel(rs.getString("cel"));
                a.setRg(rs.getString("rg"));
                a.setCpf(rs.getString("cpf"));
                
                listaDeAlunos.add(a);
                
            }
            
            if(listaDeAlunos.isEmpty()){
                JOptionPane.showMessageDialog(null, "A pesquisa não retornou nenhum registro!");
            }
            
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao efetuar a consulta!");
        }finally{
            try {
                Conexao.getConnection().close();
                psm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return listaDeAlunos;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anhanguera.dao;

import br.com.anhanguera.model.Atividade;
import br.com.anhanguera.util.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Silas
 */
public class AtividadeDao {

    Connection con;
    ResultSet rs;
    PreparedStatement stm;

    public void CadastrarAtividade(ArrayList Atividade) {
        ArrayList<Atividade> listaAtividade = Atividade;

        con = Conexao.getConnection();

        try {
            //string sql
            String sql = "insert into atividade(cod_atividade,cod_func,nome_atividade,data,dia_semana,hora_inicio,hora_fim)"
                    + "values(?,?,?,?,?,?,?)";
            int index = 1;
            //Preparação para o comando sql
            stm = con.prepareStatement(sql);

            //Percorre a lista e prepara os dados para serem inseridos no banco.
            for (Atividade a : listaAtividade) {
                stm.setInt(index++, a.getCodAtividade());
                stm.setInt(index++, a.getCodProf());
                stm.setString(index++, a.getNome());
                stm.setDate(index++, java.sql.Date.valueOf(a.getData()));//Converte a data para o formato sql date
                stm.setString(index++, a.getDiaSemana());
                stm.setString(index++, a.getHoraInicio());
                stm.setString(index++, a.getHoraFim());
            }

            stm.execute();

            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!\n " + e.getMessage());

        } finally {
            try {
                con.close();
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AtividadeDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public ArrayList selectAtividades(String filtro,Atividade a) {
        
        ArrayList<Atividade> listaAtividade = new ArrayList<>();
       
        con = Conexao.getConnection();        
         String sql;
        switch (filtro) {
                         
            case "Nome":
                sql = "select * from atividade where nome_atividade like '%"
                        + a.getNome() + "%'";
                break;
            case "Código":
                sql = "select * from atividade where cod_atividade= "+ a.getCodAtividade();
                break; 
            default:
                 sql = "select * from atividade";
                break;
                
        }

        try {

            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                Atividade a1 = new Atividade();
                a1.setCodAtividade(rs.getInt("cod_atividade"));
                a1.setCodProf(rs.getInt("cod_func"));
                a1.setNome(rs.getString("nome_atividade"));
                Date dt = rs.getDate("data");//Converte a data que vem do banco para o tipo Date                
                String d = String.valueOf(dt);//Converte a data para String                
                a1.setData(LocalDate.parse(d));//Converte a data que esta em formato String para LocalDate                
                a1.setDiaSemana(rs.getString("dia_semana"));
                a1.setHoraInicio(rs.getString("hora_inicio"));
                a1.setHoraFim(rs.getString("hora_fim"));

                listaAtividade.add(a1);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar consulta!\n " + e.getMessage());

        } finally {
            try {
                con.close();
                stm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AtividadeDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return listaAtividade;

    }

    public ArrayList consultarAgendaAluno() {
        String sql;
        ArrayList<Atividade> listaAtividade = new ArrayList<>();

        //con = Conexao.getConnection();
        //string sql para busca no banco passando por parametro a data atual do sistema.

        sql = "select * from atividade where data = '" + LocalDate.now() + "'";

        try {

            stm = Conexao.getConnection().prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                Atividade a = new Atividade();
                a.setCodAtividade(rs.getInt("cod_atividade"));
                a.setCodProf(rs.getInt("cod_func"));
                a.setNome(rs.getString("nome_atividade"));
                Date dt = rs.getDate("data");//Converte a data que vem do banco para o tipo Date                
                String d = String.valueOf(dt);//Converte a data para String                
                a.setData(LocalDate.parse(d));//Converte a data que esta em formato String para LocalDate                
                a.setDiaSemana(rs.getString("dia_semana"));
                a.setHoraInicio(rs.getString("hora_inicio"));
                a.setHoraFim(rs.getString("hora_fim"));

                listaAtividade.add(a);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar consulta!\n " + e.getMessage());

        } finally {
            try {
                Conexao.getConnection().close();
                stm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AtividadeDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return listaAtividade;

    }
    
    public int contarAgenda(String data){
       Integer cont = 0;
        
        con = Conexao.getConnection();
        String sql = "select count(*) from atividade where data = '"+data+"'";
        
        try {
                stm = con.prepareStatement(sql);
                
                ResultSet rs1 = stm.executeQuery();
                
                
                while(rs1.next()){
                    
                   cont = rs1.getInt(1);
                    
                }
                
                
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"Erro ao consultar " +e.getMessage());
        }
        return cont;
       
        
        
    }

}

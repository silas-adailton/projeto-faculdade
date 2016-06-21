package br.com.anhanguera.dao;

import br.com.anhanguera.model.Usuario;
import br.com.anhanguera.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuarioDao {
        Connection con;
        ResultSet rs;
        PreparedStatement stm;
    public UsuarioDao() {
        
    }
    
    
    
    public void inserir(Usuario u){
         Connection con = Conexao.getConnection();
            
            PreparedStatement stm = null;
        try {
           
            
            String sql = "insert into usuario (login,senha,cod_func)"+
                    ""+" values (?,?,?)";
            
            stm = con.prepareStatement(sql);
            //stm.setInt(1,u.getCodUsuario());
            stm.setString(1,u.getLogin());
            stm.setString(2,u.getSenha());
            stm.setInt(3,u.getCodFunc());
            
            stm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
             try {
                 stm.close();
                 con.close();                 
             } catch (SQLException ex) {
                 Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
             }
            
        }
        
    }
    
    public ArrayList<Usuario> select(){
        ArrayList<Usuario> listUsuario = new ArrayList<>();
        try {
            
            Connection con = Conexao.getConnection();
            
            String sql = "select * from usuario";
            
            PreparedStatement stm = con.prepareStatement(sql);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                Usuario u = new Usuario();
                u.setCodUsuario(rs.getInt("cod_usuario"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setCodFunc(rs.getInt("cod_func"));
                listUsuario.add(u);
                
            }
            rs.close();
            stm.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUsuario;
              
    } 
    
    public boolean update(Usuario u){
        
        con = Conexao.getConnection();
        
        String sql = "update usuario set login = ?,senha = ?";
        
        try {
            
            stm = con.prepareStatement(sql);
            
            stm.setString(1, u.getLogin());
            stm.setString(2, u.getSenha());
            
            if(stm.executeUpdate() == 1){
                
                JOptionPane.showMessageDialog(null,"Usuario atualizado com sucesso ");
                return true;
                
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao atualizar o usuario!");
        }finally{
            try{
                stm.close();
                con.close();
            }catch(Exception e){
                
            }
            
        }
        
        return false;
    }

    
    public ArrayList<Usuario> ultimoId(){
        ArrayList<Usuario> listUsuario = new ArrayList<>();
        try {
            
            Connection con = Conexao.getConnection();
            
            String sql = "select cod_usuario from usuario order by cod_usuario desc limit 1";
            
            PreparedStatement stm = con.prepareStatement(sql);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                Usuario u = new Usuario();
                u.setCodUsuario(rs.getInt("cod_usuario"));
                listUsuario.add(u);
                
            }
            rs.close();
            stm.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUsuario;
              
    }
    
    public boolean selectLogin(String login,String senha){
      
        try {
            
            Connection con = Conexao.getConnection();
            
            String sql = "select * from usuario where login = '"+login+"' and senha = '"+senha+"'" ;
            
            PreparedStatement stm = con.prepareStatement(sql);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                
               if(rs.getString("login").equals(login)&& rs.getString("senha").equals(senha)){
                   return true;
               }
      
            }
            rs.close();
            stm.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
        return false;
              
    }
    
}

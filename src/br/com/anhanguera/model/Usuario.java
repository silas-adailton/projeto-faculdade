package br.com.anhanguera.model;

import br.com.anhanguera.dao.UsuarioDao;
import br.com.anhanguera.view.PrincipalGUI;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Usuario extends Funcionario {

    private int codUsuario;

    private String login;

    private String senha;

        //Construtores 
    public Usuario() {
        
    }

    public Usuario(int codUsuario, String login, String senha) {
        this.codUsuario = codUsuario;
        this.login = login;
        this.senha = senha;
    }

	//getters e setters
    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    //faz um select no banco e pega o ultimo id cadastrado na tabela usuario
    public int maxId(int cod) {
        UsuarioDao udao = new UsuarioDao();
        ArrayList<Usuario> list = udao.ultimoId();
        for (Usuario maxId : list) {
            cod = maxId.getCodUsuario() + 1;
        }

        return cod;

    }
    
    

}

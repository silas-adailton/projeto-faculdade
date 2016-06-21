package br.com.anhanguera.util;

import java.sql.*;


/**
 *
 * @author Silas
 */
public class ConexaoSql {

    private static final String URL = "jdbc:sqlserver//localhost:1433"+"databaseName = power_gym";//se não for acessar localmente mude localhost pelo nome do servidor  
    private static final String usuario = "silas";//esse usuário é um sysadmin ele tem todos os poderes, é bom que se crie um login e usuário a parte  
    private static final String password = "";
    private static Connection con = null;
    

    public static Connection abreConexao() throws ClassNotFoundException{
        try {
                 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// Carregando o driver
             con = DriverManager.getConnection(URL, usuario, password);
        } catch (SQLException e) {
            
        }
        
        return con;
    }
}

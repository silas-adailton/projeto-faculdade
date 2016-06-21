package br.com.anhanguera.util;

import java.sql.*;

public class Conexao implements Servidor{
    
    public static Connection getConnection(){
	        
	        try{
                    //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	            return DriverManager.getConnection(STRCON,USER,PWD);
	        }catch(SQLException e){
	            
	            throw new RuntimeException(e);
	        }
	        
	        
	    }

}

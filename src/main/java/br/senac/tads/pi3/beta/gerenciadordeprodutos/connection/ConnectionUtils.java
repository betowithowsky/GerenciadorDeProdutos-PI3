/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.beta.gerenciadordeprodutos.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Beto
 */
public class ConnectionUtils {
    private static Connection conn = null;
    
    public static Connection obterConexao() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");        
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/produtobd",
                "root",
                "");
                
    return conn;
    }
}

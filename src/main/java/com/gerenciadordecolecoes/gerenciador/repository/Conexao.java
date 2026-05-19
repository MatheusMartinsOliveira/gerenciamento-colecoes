/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gerenciadordecolecoes.gerenciador.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author farma
 */
@Repository
public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
    private static final String user = "seu_user";
    private static final String senha = "sua_senha";
    
    public static Connection conn = null;
    
    public static synchronized Connection conectar() {
        try{
            if(conn == null|| conn.isClosed()  ) {
                conn = DriverManager.getConnection(url, user, senha);
            } else{
                
            }
        } catch(SQLException e){
            e.printStackTrace();
        } return conn;
    } 
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gerenciadordecolecoes.gerenciador.repository;

import com.gerenciadordecolecoes.gerenciador.model.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author farma
 */
@Repository
public class UsuarioDAO {
    
    public void adicionarUsuario(UsuarioDTO usuario) {
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("insert into usuario(nome, email, senha) values (?,?,?)");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            
            stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public UsuarioDTO logar(String email, String senha) {
        UsuarioDTO user = new UsuarioDTO();
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("select * from usuario where usuario.email = ? and usuario.senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();
            if(rs.next()) {
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    return user;
    }
    
}


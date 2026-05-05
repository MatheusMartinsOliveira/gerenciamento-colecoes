/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gerenciadordecolecoes.gerenciador.repository;

import com.gerenciadordecolecoes.gerenciador.model.LivroDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author farma
 */
@Repository
public class LivroDAO {
    public void adicionarLivro(LivroDTO livro) {
         try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT INTO livros (nome, categoria, preco, autor, id_prateleira) values (?, ?, ?, ?, ?)");
            stmt.setString(1, livro.getNome());
            stmt.setString(2, livro.getCategoria());
            stmt.setDouble(3, livro.getPreco());
            stmt.setString(4, livro.getAutor());
            stmt.setInt(5, livro.getIdPrateleira());
            
            stmt.executeUpdate();
            
        } catch(SQLException e) {
            e.printStackTrace();
    }
}
    
    public List<LivroDTO> lerTodos() {
        List<LivroDTO> livros = new ArrayList();
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM livros");
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                LivroDTO livro = new LivroDTO();
                livro.setIdLivro(rs.getInt("id_livro"));
                livro.setNome(rs.getString("nome"));
                livro.setCategoria(rs.getString("categoria"));
                livro.setPreco(rs.getDouble("preco"));
                livro.setAutor(rs.getString("autor"));
                livros.add(livro);
            }
        } catch(SQLException e ) {
            e.printStackTrace();
        }
        return livros;
    }
    
    public void deletarLivro(int idLivro) {
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM livros WHERE id_livro = ?");
            stmt.setInt(1, idLivro);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int contarLivros(int idPrateleira) {
        int total = 0;
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT COUNT(*) as total FROM livros WHERE id_prateleira = ?");
            stmt.setInt(1, idPrateleira);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
            total = rs.getInt("total");
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
    public boolean existeLivro(String nome, int idPrateleira) {
    boolean existe = false;

    try {
        Connection conn = Conexao.conectar();

        PreparedStatement stmt = conn.prepareStatement(
            "SELECT COUNT(*) AS total FROM livros WHERE nome = ? AND id_prateleira = ?"
        );

        stmt.setString(1, nome);
        stmt.setInt(2, idPrateleira);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            existe = rs.getInt("total") > 0;
        }

        rs.close();
        stmt.close();
        conn.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return existe;
}
}

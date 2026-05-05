/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gerenciadordecolecoes.gerenciador.repository;

import com.gerenciadordecolecoes.gerenciador.model.LocalDTO;
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
public class LocaisDAO {
    public List<LocalDTO> listarLocal() {
        List<LocalDTO> lista = new ArrayList();
        
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT armarios.id_armario, prateleira.id_prateleira, prateleira.capacidade FROM armarios inner join prateleira on armarios.id_armario = prateleira.id_armario");
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                LocalDTO local = new LocalDTO();
                local.setIdArmario(rs.getInt("id_armario"));
                local.setIdPrateleira(rs.getInt("id_prateleira"));
                local.setCapacidade(rs.getInt("capacidade"));
                lista.add(local);
            }
        } catch(SQLException e){
            e.printStackTrace();
        } return lista; 
    }
    
}

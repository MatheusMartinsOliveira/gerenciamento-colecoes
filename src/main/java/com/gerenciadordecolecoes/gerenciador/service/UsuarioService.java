/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gerenciadordecolecoes.gerenciador.service;

import com.gerenciadordecolecoes.gerenciador.model.UsuarioDTO;
import com.gerenciadordecolecoes.gerenciador.repository.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author farma
 */
@Service
public class UsuarioService {
    @Autowired
    private UsuarioDAO repository;
    
    public UsuarioDTO logar(String email, String senha) {
        return repository.logar(email, senha);
    }
    
    public void cadastrar(UsuarioDTO usuario) {
        repository.adicionarUsuario(usuario);
    }
}

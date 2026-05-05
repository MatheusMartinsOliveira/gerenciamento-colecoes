/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gerenciadordecolecoes.gerenciador.service;

import com.gerenciadordecolecoes.gerenciador.model.LivroDTO;
import com.gerenciadordecolecoes.gerenciador.repository.LivroDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author farma
 */
@Service
public class LivroService {
    @Autowired
    public LivroDAO repository;
    
    public void adicionarLivros(LivroDTO livro){
    int quantidade = repository.contarLivros(livro.getIdPrateleira());
    if (quantidade >= 10) {
        throw new RuntimeException("Prateleira lotada!");
    }
    if (repository.existeLivro(livro.getNome(), livro.getIdPrateleira())) {
        throw new RuntimeException("Esse livro já existe nessa prateleira!");
    }
    repository.adicionarLivro(livro);
}
    
    public List<LivroDTO> lerTodos() {
        return repository.lerTodos();
    }
    
    public void deletarLivro(int idLivro) {
        repository.deletarLivro(idLivro);
    }
}

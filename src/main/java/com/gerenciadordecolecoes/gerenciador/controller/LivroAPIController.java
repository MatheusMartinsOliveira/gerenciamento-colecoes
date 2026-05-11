/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gerenciadordecolecoes.gerenciador.controller;

import com.gerenciadordecolecoes.gerenciador.model.LivroDTO;
import com.gerenciadordecolecoes.gerenciador.service.LivroService;
import com.gerenciadordecolecoes.gerenciador.service.TokenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author farma
 */
@RestController
@RequestMapping("/api/livros")
public class LivroAPIController {
    @Autowired
    private LivroService livroService;
    
    @Autowired
    private TokenService tokenService;
    
    @PostMapping
    public String adicionar(@RequestBody LivroDTO livro, @RequestHeader("Authorization") String auth) {
        String token = auth.replace("Bearer ", "");
            tokenService.validarToken(token);
            livroService.adicionarLivros(livro);
            return "livro adicionado com sucesso!";

    }
    
    @GetMapping("/listar")
    public List<LivroDTO> listarTodos(@RequestHeader("Authorization") String auth) {
        String token = auth.replace("Bearer ", "");
        tokenService.validarToken(token);
        return livroService.lerTodos();
           
    }
    
    @DeleteMapping("/deletar/{idLivro}")
    public String deletar(@PathVariable int idLivro, @RequestHeader("Authorization") String auth){
        String token = auth.replace("Bearer ", "");
            tokenService.validarToken(token);
            livroService.deletarLivro(idLivro);
            return "Livro deletado com sucesso!";
    }
}

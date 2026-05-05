/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gerenciadordecolecoes.gerenciador.model;

/**
 *
 * @author farma
 */
public class LivroDTO {
    private Integer idLivro;
    private String nome;
    private String categoria;
    private Double preco;
    private String autor;
    private int idPrateleira;

    public LivroDTO() {
    }

    public LivroDTO(Integer idLivro, String nome, String categoria, Double preco, String autor, int idPrateleira) {
        this.idLivro = idLivro;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.autor = autor;
        this.idPrateleira = idPrateleira;
    }

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIdPrateleira() {
        return idPrateleira;
    }

    public void setIdPrateleira(int idPrateleira) {
        this.idPrateleira = idPrateleira;
    }

    
}
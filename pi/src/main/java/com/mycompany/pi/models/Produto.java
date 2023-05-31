/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pi.models;

import javax.swing.JOptionPane;

import com.mycompany.pi.database.ProdutosDAO;
import com.mycompany.pi.utils.Categoria;

/**
 * A classe Produto representa um produto, incluindo informações como ID, estoque, nome, categoria, valor unitário e descrição.
 */
public class Produto {
    private int id_brinquedo;
    private int estoque;
    private String nome;
    private Categoria categoria;
    private double valor_unitario;
    private String descricao;

    /**
     * Cria um objeto Produto vazio.
     */
    public Produto(){}

    /**
     * Cria um objeto Produto com as informações especificadas.
     * @param id_brinquedo o ID do brinquedo
     * @param estoque a quantidade em estoque do produto
     * @param nome o nome do produto
     * @param categoria a categoria do produto
     * @param valor_unitario o valor unitário do produto
     * @param descricao a descrição do produto
     */
    public Produto(int id_brinquedo, int estoque, String nome, Categoria categoria, double valor_unitario, String descricao) {
        this.id_brinquedo = id_brinquedo;
        this.estoque = estoque;
        this.nome = nome;
        this.categoria = categoria;
        this.valor_unitario = valor_unitario;
        this.descricao = descricao;
    }

    public int getId_brinquedo() {
        return id_brinquedo;
    }

    public void setId_brinquedo(int id_brinquedo) {
        this.id_brinquedo = id_brinquedo;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

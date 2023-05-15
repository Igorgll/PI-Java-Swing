/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pi.models;

import com.mycompany.pi.utils.Categoria;

/**
 *
 * @author igor
 */
public class Produto {
    
    private int id_brinquedo;
    private int estoque;
    private String nome;
    private Categoria categoria;
    private double valor_unitario;
    private String descricao;

    public Produto(){}

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

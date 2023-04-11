/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pi;

/**
 *
 * @author igor
 */
public class Produto {
    
    private int id_produto;
    private int estoque;
    private String nome;
    private Enum categoria;
    private double valor_unitario;

    public Produto(int id_produto, String nome, Enum categoria, double valor_unitario) {
        this.id_produto = id_produto;
        this.nome = nome;
        this.categoria = categoria;
        this.valor_unitario = valor_unitario;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Enum getCategoria() {
        return categoria;
    }

    public void setCategoria(Enum categoria) {
        this.categoria = categoria;
    }

    public int getEstoque() {
        return estoque;
    }
    
    public void setEstoque() {
        this.estoque = estoque;
    }
    
    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }
}

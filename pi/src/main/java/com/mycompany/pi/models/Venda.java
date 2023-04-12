/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pi.models;

import java.util.Date;

/**
 *
 * @author igor
 */
public class Venda {
    private int id_venda;
    private double valor;
    private Date data;
    private int quantidade;

    public Venda(int id_venda, double valor, Date data, int quantidade) {
        this.id_venda = id_venda;
        this.valor = valor;
        this.data = data;
        this.quantidade = quantidade;
    }
    
    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setDate(Date data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

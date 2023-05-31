/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pi.models;

/**
 * A classe Endereco representa um endereço, incluindo informações como rua, número, cidade e estado.
 */
public class Endereco {

    private int id_endereco;
    private String rua;
    private int numero;
    private String cidade;
    private String estado;

    /**
     * Cria um objeto Endereco vazio.
     */
    public Endereco() {
    }

    /**
     * Cria um objeto Endereco com as informações especificadas.
     * @param id_endereco o ID do endereço
     * @param rua a rua
     * @param numero o número
     * @param cidade a cidade
     * @param estado o estado
     */
    public Endereco(int id_endereco, String rua, int numero, String cidade, String estado) {
        this.id_endereco = id_endereco;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
    }

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

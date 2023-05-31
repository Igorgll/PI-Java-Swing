package com.mycompany.pi.models;

import java.util.ArrayList;

/**
 * A classe Cliente representa um cliente com informações pessoais e endereços associados.
 */
public class Cliente {

    private int id_cliente;
    private String CPF;
    private String nome;    
    private String email;
    private String telefone;
    private ArrayList<Endereco> enderecos;

    /**
     * Cria um objeto Cliente vazio.
     */
    public Cliente() {
    }

    /**
     * Cria um objeto Cliente com as informações especificadas.
     * @param id_cliente o ID do cliente
     * @param CPF o CPF do cliente
     * @param nome o nome do cliente
     * @param email o email do cliente
     * @param telefone o telefone do cliente
     * @param enderecos os endereços do cliente
     */
    public Cliente(int id_cliente, String cPF, String nome, String email, String telefone,
            ArrayList<Endereco> enderecos) {
        this.id_cliente = id_cliente;
        CPF = cPF;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.enderecos = enderecos;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> arrayList) {
        this.enderecos = arrayList;
    }

    public void addEndereco(Endereco endereco) {
        enderecos.add(endereco);
    }
}


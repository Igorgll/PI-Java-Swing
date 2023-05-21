package com.mycompany.pi.models;

import java.util.ArrayList;

public class Cliente {

    private int id_cliente;
    private String CPF;
    private String nome;    
    private String email;
    private String telefone;
    private ArrayList<Endereco> enderecos;

    public Cliente() {
    }

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


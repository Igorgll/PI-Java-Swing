/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pi.models;

/**
 *
 * @author igor
 */
public class Funcionario {

    private int id_funcionario;
    private String nome;
    private String usuario;
    private String senha;

    public Funcionario(){}

    public Funcionario(int id_funcionario, String nome, String usuario, String senha) {
        this.id_funcionario = id_funcionario;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

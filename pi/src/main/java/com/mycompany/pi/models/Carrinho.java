package com.mycompany.pi.models;

public class Carrinho {
    private String cpfCliente;
    private String produto;
    private double preco;
    private int quantidade;
    private double precoTotal;
    private int idBrinquedo;
    
    public Carrinho(){}

    public Carrinho(String cpfCliente, String produto, double preco, int quantidade, double precoTotal,
            int idBrinquedo) {
        this.cpfCliente = cpfCliente;
        this.produto = produto;
        this.preco = preco;
        this.quantidade = quantidade;
        this.precoTotal = precoTotal;
        this.idBrinquedo = idBrinquedo;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public int getIdBrinquedo() {
        return idBrinquedo;
    }

    public void setIdBrinquedo(int idBrinquedo) {
        this.idBrinquedo = idBrinquedo;
    }
    
    
}

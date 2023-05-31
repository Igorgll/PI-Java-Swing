package com.mycompany.pi.models;

/**
 * A classe Carrinho representa um carrinho de compras contendo informações sobre os produtos adicionados.
 */
public class Carrinho {
    private String cpfCliente;
    private String produto;
    private double preco;
    private int quantidade;
    private double precoTotal;
    private int idBrinquedo;
    
    /**
     * Cria um objeto Carrinho vazio.
     */
    public Carrinho(){}

    /**
     * Cria um objeto Carrinho com as informações especificadas.
     * @param cpfCliente o CPF do cliente
     * @param produto o nome do produto
     * @param preco o preço unitário do produto
     * @param quantidade a quantidade do produto
     * @param precoTotal o preço total do produto no carrinho
     * @param idBrinquedo o ID do brinquedo
     */
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

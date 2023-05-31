package com.mycompany.pi.models;

/**
 * A classe DetalhesVendas representa os detalhes de uma venda, incluindo o ID do brinquedo vendido e a quantidade vendida.
 */
public class DetalhesVendas {
    private int idBrinquedo;
    private int quantidade;

    /**
     * Cria um objeto DetalhesVendas vazio.
     */
    public DetalhesVendas() {
    }

    /**
     * Cria um objeto DetalhesVendas com as informações especificadas.
     * @param idBrinquedo o ID do brinquedo vendido
     * @param quantidade a quantidade vendida
     */
    public DetalhesVendas(int idBrinquedo, int quantidade) {
        this.idBrinquedo = idBrinquedo;
        this.quantidade = quantidade;
    }

    public int getIdBrinquedo() {
        return idBrinquedo;
    }

    public void setIdBrinquedo(int idBrinquedo) {
        this.idBrinquedo = idBrinquedo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

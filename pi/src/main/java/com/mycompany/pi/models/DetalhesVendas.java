package com.mycompany.pi.models;

public class DetalhesVendas {
    private int idBrinquedo;
    private int quantidade;

    public DetalhesVendas(){}

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

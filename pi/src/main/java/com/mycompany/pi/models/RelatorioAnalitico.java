package com.mycompany.pi.models;

public class RelatorioAnalitico {
    private int idVenda;
    private String nomeFuncionario;
    private String nomeBrinquedo;
    private int quantidade;

    public RelatorioAnalitico() {
    }

    public RelatorioAnalitico(int idVenda, String nomeFuncionario, String nomeBrinquedo, int quantidade) {
        this.idVenda = idVenda;
        this.nomeFuncionario = nomeFuncionario;
        this.nomeBrinquedo = nomeBrinquedo;
        this.quantidade = quantidade;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getNomeBrinquedo() {
        return nomeBrinquedo;
    }

    public void setNomeBrinquedo(String nomeBrinquedo) {
        this.nomeBrinquedo = nomeBrinquedo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    
}

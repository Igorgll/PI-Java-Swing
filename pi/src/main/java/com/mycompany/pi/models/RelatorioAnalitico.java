package com.mycompany.pi.models;

/**
 * A classe RelatorioAnalitico representa um relatório analítico contendo informações sobre uma venda, como ID da venda, nome do funcionário, nome do brinquedo e quantidade.
 */
public class RelatorioAnalitico {
    private int idVenda;
    private String nomeFuncionario;
    private String nomeBrinquedo;
    private int quantidade;

    /**
     * Cria um objeto RelatorioAnalitico vazio.
     */
    public RelatorioAnalitico() {
    }

    /**
     * Cria um objeto RelatorioAnalitico com as informações especificadas.
     * @param idVenda o ID da venda
     * @param nomeFuncionario o nome do funcionário
     * @param nomeBrinquedo o nome do brinquedo
     * @param quantidade a quantidade de brinquedos vendidos
     */
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

package com.mycompany.pi.models;

import java.time.LocalDate;

/**
 * A classe RelatorioSintetico representa um relatório sintético contendo informações resumidas sobre uma venda, como ID da venda, data da venda, valor total e CPF do cliente.
 */
public class RelatorioSintetico {
    private int idVenda;
    private LocalDate dataVenda;
    private double valorTotal;
    private String cpfCliente;

    /**
     * Cria um objeto RelatorioSintetico vazio.
     */
    public RelatorioSintetico() {
    }

    /**
     * Cria um objeto RelatorioSintetico com as informações especificadas.
     * @param idVenda o ID da venda
     * @param dataVenda a data da venda
     * @param valorTotal o valor total da venda
     * @param cpfCliente o CPF do cliente
     */
    public RelatorioSintetico(int idVenda, LocalDate dataVenda, double valorTotal, String cpfCliente) {
        this.idVenda = idVenda;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
        this.cpfCliente = cpfCliente;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
}

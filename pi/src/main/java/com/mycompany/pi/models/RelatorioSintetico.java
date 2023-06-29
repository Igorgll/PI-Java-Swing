package com.mycompany.pi.models;

import java.time.LocalDate;

public class RelatorioSintetico {
    private LocalDate dataVenda;
    private double valorTotal;
    private String nomeCliente;
    private String cpfCliente;

    public RelatorioSintetico() {
    }

    public RelatorioSintetico(LocalDate dataVenda, double valorTotal, String nomeCliente, String cpfCliente) {
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
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

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    

}

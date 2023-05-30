package com.mycompany.pi.models;

import java.time.LocalDate;

public class RelatorioSintetico {
    private int idVenda;
    private LocalDate dataVenda;
    private double valorTotal;
    private String cpfCliente;

    public RelatorioSintetico() {
    }

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

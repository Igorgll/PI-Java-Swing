/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.pi.utils;

/**
 * A enumeração Categoria representa as categorias possíveis para os brinquedos, com base na faixa de idade.
 */
public enum Categoria {
    DE_1_A_2_ANOS("1-2 anos"),
    DE_3_A_4_ANOS("3-4 anos"),
    DE_5_A_7_ANOS("5-7 anos"),
    DE_8_A_10_ANOS("8-10 anos"),
    DE_11_A_12_ANOS("11-12 anos");
    
    private final String faixaIdade;
    
    /**
     * Cria uma categoria com a faixa de idade especificada.
     * @param faixaIdade a faixa de idade da categoria
     */
    Categoria(String faixaIdade) {
        this.faixaIdade = faixaIdade;
    }
    
    /**
     * Obtém a faixa de idade da categoria.
     * @return a faixa de idade da categoria
     */
    public String getFaixaIdade() {
        return faixaIdade;
    }
}

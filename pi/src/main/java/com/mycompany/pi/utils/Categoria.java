/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.pi.utils;

/**
 *
 * @author igor
 */
public enum Categoria {
    DE_1_A_2_ANOS("1-2 anos"),
    DE_3_A_4_ANOS("3-4 anos"),
    DE_5_A_7_ANOS("5-7 anos"),
    DE_8_A_10_ANOS("8-10 anos"),
    DE_11_A_12_ANOS("11-12 anos");
    
    private final String faixaIdade;
    
    Categoria(String faixaIdade) {
        this.faixaIdade = faixaIdade;
    }
    
    public String getFaixaIdade() {
        return faixaIdade;
    }
}

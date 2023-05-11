/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pi.themes;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;

/**
 *
 * @author igor
 */
public class tema extends FlatMacDarkLaf{
    public static boolean setup() {
        return setup( new tema());
    }

    @Override
    public String getName() {
        return "tema";
    }
}

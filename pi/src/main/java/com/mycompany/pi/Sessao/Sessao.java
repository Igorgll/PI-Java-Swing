package com.mycompany.pi.Sessao;

/**
 * A classe Sessao representa uma sessão de trabalho com um funcionário.
 */
public class Sessao {
    private static String nomeFuncionario;
    
    /**
     * Obtém o nome do funcionário associado à sessão.
     *
     * @return O nome do funcionário.
     */
    public static String getNomeFuncionario() {
        return nomeFuncionario;
    }

    /**
     * Define o nome do funcionário associado à sessão.
     *
     * @param nome O nome do funcionário.
    */
    public static void setNomeFuncionario(String nome) {
        nomeFuncionario = nome;
    }
}


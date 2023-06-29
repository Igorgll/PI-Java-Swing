package com.mycompany.pi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JOptionPane;

import com.mycompany.pi.database.sqlQueries.Queries;

public class VendasDAO {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String LOGIN = "root";
    private static final String SENHA = "";
    private static final String url = "jdbc:mysql://localhost:3307/lojabrinquedos";
    private static Connection conexao;

    static {
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(url, LOGIN, SENHA);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void criaTabelaVendas() {
        try {
            Statement statement = conexao.createStatement();

            String sql = Queries.CRIA_TABELA_VENDAS_SQL;

            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean efetuarVenda(String nomeFuncionario, String cpfCliente, double valorVenda, LocalDate dataVenda) {
        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }

            String sql = Queries.INSERE_VENDA;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nomeFuncionario);
            preparedStatement.setString(2, cpfCliente);
            preparedStatement.setDouble(3, valorVenda);
            java.sql.Date sqlDate = java.sql.Date.valueOf(dataVenda);
            preparedStatement.setDate(4, sqlDate);
            int linhasAfetadas = preparedStatement.executeUpdate();

            preparedStatement.close();
            return true; // retorna true para venda bem sucedida
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // retorna false para venda mal sucedida
         }
    }
}

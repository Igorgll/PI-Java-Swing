package com.mycompany.pi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mycompany.pi.database.sqlQueries.Queries;

public class ProdutosDAO {
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

    public static void criaTabelaBrinquedos() {
        try {
            Statement statement = conexao.createStatement();

            String sql = Queries.CRIA_TABELA_BRINQUEDOS_SQL;

            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void criaTabelaCategorias() {
        try {
            Statement statement = conexao.createStatement();

            String sql = Queries.CRIA_TABELA_CATEGORIAS_SQL;

            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void criaTabelaClientes() {
        try {
            Statement statement = conexao.createStatement();

            String sql = Queries.CRIA_TABELA_CLIENTES_SQL;

            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void criaTabelaFuncionarios() {
        try {
            Statement statement = conexao.createStatement();

            String sql = Queries.CRIA_TABELA_FUNCIONARIOS_SQL;

            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void criaTabelaEnderecos() {
        try {
            Statement statement = conexao.createStatement();

            String sql = Queries.CRIA_TABELA_ENDERECOS_SQL;

            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
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

    public static void populaTabelaBrinquedos() {
        try {
            Statement statement = conexao.createStatement();

            String sql = Queries.POPULA_TABELA_BRINQUEDOS_SQL;

            statement.executeUpdate(sql);
            statement.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

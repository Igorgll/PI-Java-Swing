package com.mycompany.pi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mycompany.pi.database.sqlQueries.Queries;

/**
 * Classe responsável por lidar com a persistência de dados dos endereços.
 */
public class EnderecosDAO {
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

    /**
     * Cria a tabela de endereços no banco de dados.
     */
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
}

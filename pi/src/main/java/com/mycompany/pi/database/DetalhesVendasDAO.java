package com.mycompany.pi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import com.mycompany.pi.database.sqlQueries.Queries;
import com.mycompany.pi.models.DetalhesVendas;

public class DetalhesVendasDAO {
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

    public static void criaTabelaDetalhesVendas() {
        try {
            Statement statement = conexao.createStatement();

            String sql = Queries.CRIA_TABELA_DETALHES_VENDA;

            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<DetalhesVendas> consultarDetalhesVenda(LocalDate dataVenda, double valorVenda,String cpfCliente) {
        List<DetalhesVendas> detalhesVendaList = new ArrayList<>();
    
        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
    
            String sql = Queries.CONSULTA_DETALHES_VENDA;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setDate(1, java.sql.Date.valueOf(dataVenda));
            preparedStatement.setDouble(2, valorVenda);
            preparedStatement.setString(3, cpfCliente);
    
            ResultSet resultSet = preparedStatement.executeQuery();
    
            while (resultSet.next()) {
                int idBrinquedo = resultSet.getInt("id_brinquedo");
                int quantidade = resultSet.getInt("quantidade");
    
                DetalhesVendas detalhesVenda = new DetalhesVendas(idBrinquedo, quantidade);
                detalhesVendaList.add(detalhesVenda);
            }
    
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return detalhesVendaList;
    }
}

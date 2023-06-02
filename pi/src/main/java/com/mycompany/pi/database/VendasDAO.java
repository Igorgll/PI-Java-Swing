package com.mycompany.pi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import com.mycompany.pi.database.sqlQueries.Queries;
import com.mycompany.pi.models.DetalhesVendas;

/**
 * Esta classe é responsável pela comunicação com o banco de dados para realizar operações relacionadas a vendas na loja de brinquedos.
 */
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

    /**
     * Efetua uma venda na loja de brinquedos, registrando as informações no banco de dados.
     *
     * @param nomeFuncionario O nome do funcionário responsável pela venda.
     * @param cpfCliente O CPF do cliente que realizou a compra.
     * @param valorVenda O valor total da venda.
     * @param dataVenda A data da venda.
     * @param detalhesVenda Uma lista de objetos DetalhesVendas contendo os detalhes dos itens vendidos.
     * @return True se a venda for efetuada com sucesso, False caso contrário.
     */
    public static boolean efetuarVenda(String nomeFuncionario, String cpfCliente, double valorVenda, LocalDate dataVenda, List<DetalhesVendas> detalhesVenda) {
        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
    
            String sqlVenda = Queries.INSERE_VENDA;
            PreparedStatement preparedStatement = conexao.prepareStatement(sqlVenda, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, nomeFuncionario);
            preparedStatement.setString(2, cpfCliente);
            preparedStatement.setDouble(3, valorVenda);
            java.sql.Date sqlDate = java.sql.Date.valueOf(dataVenda);
            preparedStatement.setDate(4, sqlDate);
            int linhasAfetadas = preparedStatement.executeUpdate();
    
            // pega o id da venda inserida
            int idVenda = -1;
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                idVenda = generatedKeys.getInt(1);
            }
    
            preparedStatement.close();
    
            // Inserir os detalhes da venda na tabela detalhes_vendas
            String sqlDetalhes = Queries.INSERE_DETALHES_VENDA;
            PreparedStatement detalhesStatement = conexao.prepareStatement(sqlDetalhes);
    
            for (DetalhesVendas detalhes : detalhesVenda) {
                detalhesStatement.setInt(1, idVenda);
                detalhesStatement.setInt(2, detalhes.getIdBrinquedo());
                detalhesStatement.setInt(3, detalhes.getQuantidade());
                detalhesStatement.executeUpdate();
            }
    
            detalhesStatement.close();
    
            return true; // retorna true para venda bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // retorna false para venda mal-sucedida
        }
    }

    /**
     * Consulta o nome do funcionário responsável por uma venda específica.
     *
     * @param idVenda O ID da venda.
     * @return O nome do funcionário responsável pela venda.
     */
    public static String consultarNomeFuncionario(int idVenda) {
        String nomeFuncionario = "";
    
        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
    
            String sql = Queries.CONSULTA_NOME_FUNCIONARIO;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, idVenda);
    
            ResultSet resultSet = preparedStatement.executeQuery();
    
            if (resultSet.next()) {
                nomeFuncionario = resultSet.getString("nome");
            }
    
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return nomeFuncionario;
    }
}

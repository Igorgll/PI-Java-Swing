package com.mycompany.pi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

    public static void criaTabelaBrinquedos(){
        try {
            Statement statement = conexao.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS brinquedos (" // cria a tabela somente se não existir na base
            + "id_brinquedo INT NOT NULL AUTO_INCREMENT,"
            + "estoque INT NOT NULL,"
            + "nome VARCHAR(50) NOT NULL," 
            + "categoria VARCHAR(50) NOT NULL,"
            + "valor_unitario DECIMAL(10, 2) NOT NULL,"
            + "descricao VARCHAR(200) NOT NULL,"
            + "PRIMARY KEY (id_brinquedo));";

            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void criaTabelaClientes(){
        try {
            Statement statement = conexao.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS clientes (" // cria a tabela somente se não existir na base
            + "id_cliente INT NOT NULL AUTO_INCREMENT,"
            + "nome VARCHAR(50) NOT NULL," 
            + "email VARCHAR(50) NOT NULL,"
            + "telefone VARCHAR(50) NOT NULL,"
            + "PRIMARY KEY (id_cliente));";

            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void criaTabelaFuncionarios(){
        try {
            Statement statement = conexao.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS funcionarios (" // cria a tabela somente se não existir na base
            + "id_funcionario INT NOT NULL AUTO_INCREMENT,"
            + "nome VARCHAR(50) NOT NULL," 
            + "usuario VARCHAR(50) NOT NULL,"
            + "senha VARCHAR(50) NOT NULL,"
            + "PRIMARY KEY (id_funcionario));";

            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void criaTabelaEnderecos(){
        try {
            Statement statement = conexao.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS enderecos (" // cria a tabela somente se não existir na base
            + "id_endereco INT NOT NULL AUTO_INCREMENT,"
            + "rua VARCHAR(50) NOT NULL," 
            + "numero VARCHAR(50) NOT NULL,"
            + "cidade VARCHAR(50) NOT NULL,"
            + "estado VARCHAR(50) NOT NULL,"
            + "PRIMARY KEY (id_endereco));";

            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void criaTabelaVendas(){
        try {
            Statement statement = conexao.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS vendas (" // cria a tabela somente se não existir na base
            + "id_venda INT NOT NULL AUTO_INCREMENT,"
            + "valor DECIMAL(10, 2) NOT NULL," 
            + "data DATE NOT NULL,"
            + "quantidade INT NOT NULL,"
            + "PRIMARY KEY (id_venda));";

            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

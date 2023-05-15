package com.mycompany.pi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mycompany.pi.database.sqlQueries.Queries;
import com.mycompany.pi.models.Funcionario;
import com.mycompany.pi.models.Produto;
import com.mycompany.pi.utils.Categoria;
import com.mysql.cj.protocol.Resultset;

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

    // public static void criaTabelaCategorias() {
    //     try {
    //         Statement statement = conexao.createStatement();

    //         String sql = Queries.CRIA_TABELA_CATEGORIAS_SQL;

    //         statement.executeUpdate(sql);
    //         statement.close();
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    // }

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void criaFuncionarioAdmin(){
        try {
            Statement statement = conexao.createStatement();

            String sql = Queries.CRIA_FUNCIONARIO_ADMIN;

            statement.executeUpdate(sql);
            statement.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Funcionario> consultaFuncionarioNoBanco(String usuario, String senha) {
        ArrayList<Funcionario> retornoFuncionarios = new ArrayList<Funcionario>();
        try  {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
            PreparedStatement preparedStatement = conexao.prepareStatement(Queries.CONSULTA_FUNCIONARIOS);
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id_funcionario = resultSet.getInt("id_funcionario");
                String usuarioBD = resultSet.getString("usuario");
                String senhaBD = resultSet.getString("senha");
                Funcionario funcionario = new Funcionario();
                funcionario.setId_funcionario(id_funcionario);
                funcionario.setUsuario(usuarioBD);
                funcionario.setSenha(senhaBD);
                retornoFuncionarios.add(funcionario);
            }
            resultSet.close();
            preparedStatement.close();
        }catch (SQLException e) {
            retornoFuncionarios.add(new Funcionario());
        }
        return retornoFuncionarios;
    }

    public static ArrayList<Produto> consultaListaBrinquedos() {
        ArrayList<Produto> retornoBrinquedos = new ArrayList<Produto>();
        try  {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(Queries.CONSULTA_BRINQUEDOS);
            while(resultSet.next()) {
                int id_brinquedo = resultSet.getInt("id_brinquedo");
                int estoque = resultSet.getInt("estoque");
                String nome = resultSet.getString("nome");
                String categoriaString = resultSet.getString("categoria");
                Categoria categoria = Categoria.valueOf(categoriaString);
                Double valor_unitario = resultSet.getDouble("valor_unitario");
                String descricao = resultSet.getString("descricao");
                Produto brinquedo = new Produto();
                brinquedo.setId_brinquedo(id_brinquedo);
                brinquedo.setEstoque(estoque);
                brinquedo.setNome(nome);
                brinquedo.setCategoria(categoria);
                brinquedo.setValor_unitario(valor_unitario);
                brinquedo.setDescricao(descricao);
                retornoBrinquedos.add(brinquedo);
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e) {
            retornoBrinquedos.add(new Produto());
        }
        return retornoBrinquedos;
    }
}

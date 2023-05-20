package com.mycompany.pi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    // try {
    // Statement statement = conexao.createStatement();

    // String sql = Queries.CRIA_TABELA_CATEGORIAS_SQL;

    // statement.executeUpdate(sql);
    // statement.close();
    // } catch (SQLException e) {
    // e.printStackTrace();
    // }
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

    public static void criaFuncionarioAdmin() {
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
        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
            PreparedStatement preparedStatement = conexao.prepareStatement(Queries.CONSULTA_FUNCIONARIOS);
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
        } catch (SQLException e) {
            retornoFuncionarios.add(new Funcionario());
        }
        return retornoFuncionarios;
    }

    public static ArrayList<Produto> consultaListaBrinquedos() {
        ArrayList<Produto> retornoBrinquedos = new ArrayList<Produto>();
        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(Queries.CONSULTA_BRINQUEDOS);
            while (resultSet.next()) {
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
        } catch (SQLException e) {
            retornoBrinquedos.add(new Produto());
        }
        return retornoBrinquedos;
    }

    public static ArrayList<Produto> consultaListaBrinquedosPorCategoria(String categoriaSelecionada) {
        ArrayList<Produto> retornoBrinquedos = new ArrayList<Produto>();
        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
            String sql = Queries.CONSULTA_BRINQUEDOS_POR_CATEGORIA;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, categoriaSelecionada);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
            preparedStatement.close();
        } catch (SQLException e) {
            retornoBrinquedos.add(new Produto());
        }
        return retornoBrinquedos;
    }

    public static ArrayList<Produto> consultaListaBrinquedosPorNome(String nomeConsulta) {
        ArrayList<Produto> retornoBrinquedosPorNome = new ArrayList<Produto>();
        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
            String sql = Queries.CONSULTA_BRINQUEDOS_POR_NOME;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, "%" + nomeConsulta + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
                retornoBrinquedosPorNome.add(brinquedo);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            retornoBrinquedosPorNome.add(new Produto());
        }
        return retornoBrinquedosPorNome;
    }

    public static void criaBrinquedo(Produto brinquedo) {
        try {
            if(conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
            String sql = Queries.CRIA_BRINQUEDO;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, brinquedo.getEstoque());
            preparedStatement.setString(2, brinquedo.getNome());
            preparedStatement.setString(3, brinquedo.getCategoria().toString());
            preparedStatement.setDouble(4, brinquedo.getValor_unitario());
            preparedStatement.setString(5, brinquedo.getDescricao());
            preparedStatement.setString(6, brinquedo.getNome()); // adicional para verificar duplicidade de nome no banco de dados
            int linhasAfetadas = preparedStatement.executeUpdate();
            preparedStatement.close();

            if(linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Brinquedo criado com sucesso!");
            }else {
                JOptionPane.showMessageDialog(null, "Já existe um brinquedo com o mesmo nome no banco de dados!");
            }
        } catch(SQLException e) { 
            e.printStackTrace();
        }
    }

    public void deletaBrinquedoLinha(JTable table) {
        int linhaSelecionada = table.getSelectedRow();
            if(linhaSelecionada != -1) {
                DefaultTableModel modelo = (DefaultTableModel) table.getModel();
                modelo.removeRow(linhaSelecionada); // deleta a row com a linha selecionada

                int id = (int) modelo.getValueAt(linhaSelecionada, 0); // pega o id do brinquedo
                deletarBrinquedo(id);
            }
    }

    public void deletarBrinquedo(int id) {
        try {
            if(conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
            String sql = Queries.DELETA_BRINQUEDO;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, id); // define o valor do parametro

            int linhasAfetadas = preparedStatement.executeUpdate();
            if(linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Brinquedo deletado com sucesso!");
            }
            preparedStatement.close();
            conexao.close();
         } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar deletar brinquedo. " + e.getMessage());
         }
    }

    public void alteraBrinquedo(int id, int estoque, String nome, String categoria, double valor_unitario, String descricao) {
        try {
            if(conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }

            String sql = Queries.ALTERA_BRINQUEDO;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, estoque);
            preparedStatement.setString(2, nome);
            preparedStatement.setString(3, categoria);
            preparedStatement.setDouble(4, valor_unitario);
            preparedStatement.setString(5, descricao);
            preparedStatement.setInt(6, id);
            
            int linhasAfetadas = preparedStatement.executeUpdate();
            if(linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Brinquedo alterado com sucesso!");
            }
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar brinquedo. " + e.getMessage());
        }
    }
}

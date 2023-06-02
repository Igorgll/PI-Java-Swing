package com.mycompany.pi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mycompany.pi.database.sqlQueries.Queries;
import com.mycompany.pi.models.Produto;
import com.mycompany.pi.utils.Categoria;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;

/**
 * Esta classe fornece métodos para acessar e manipular dados relacionados a produtos na base de dados.
 */
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

    /**
     * Consulta a lista de todos os brinquedos cadastrados.
     * 
     * @return Uma lista de objetos do tipo Produto contendo os dados dos brinquedos encontrados.
     */
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

    /**
     * Consulta a lista de brinquedos filtrada por categoria.
     * 
     * @param categoriaSelecionada A categoria dos brinquedos a serem filtrados.
     * @return Uma lista de objetos do tipo Produto contendo os dados dos brinquedos encontrados.
     */
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

    /**
     * Consulta a lista de brinquedos filtrada por nome.
     * 
     * @param nomeConsulta O nome dos brinquedos a serem filtrados.
     * @return Uma lista de objetos do tipo Produto contendo os dados dos brinquedos encontrados.
     */
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

    /**
     * Cria um novo brinquedo no banco de dados com base nas informações fornecidas.
     *
     * @param brinquedo O objeto Produto que representa o brinquedo a ser criado.
     */
    public static void criaBrinquedo(Produto brinquedo) {
        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
            String sql = Queries.CRIA_BRINQUEDO;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, brinquedo.getEstoque());
            preparedStatement.setString(2, brinquedo.getNome());
            preparedStatement.setString(3, brinquedo.getCategoria().toString());
            preparedStatement.setDouble(4, brinquedo.getValor_unitario());
            preparedStatement.setString(5, brinquedo.getDescricao());
            preparedStatement.setString(6, brinquedo.getNome()); // adicional para verificar duplicidade de nome no
                                                                 // banco de dados
            int linhasAfetadas = preparedStatement.executeUpdate();
            preparedStatement.close();

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Brinquedo criado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Já existe um brinquedo com o mesmo nome no banco de dados!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deleta um brinquedo do banco de dados com base no ID fornecido.
     *
     * @param id O ID do brinquedo a ser deletado.
     */
    public void deletarBrinquedo(int id) {
        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
            String sql = Queries.DELETA_BRINQUEDO;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, id); // define o valor do parametro

            int linhasAfetadas = preparedStatement.executeUpdate();
            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Brinquedo deletado com sucesso!");
            }
            preparedStatement.close();
            conexao.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar deletar brinquedo. " + e.getMessage());
        }
    }

    /**
     * Altera as informações de um brinquedo no banco de dados com base no ID fornecido.
     *
     * @param id O ID do brinquedo a ser alterado.
     * @param estoque O novo valor do estoque do brinquedo.
     * @param nome O novo nome do brinquedo.
     * @param categoria A nova categoria do brinquedo.
     * @param valor_unitario O novo valor unitário do brinquedo.
     * @param descricao A nova descrição do brinquedo.
     * @param evt O evento relacionado à alteração do brinquedo.
     */
    public void alteraBrinquedo(int id, int estoque, String nome, String categoria, double valor_unitario,
            String descricao, ActionEvent evt) {
        try {
            if (conexao.isClosed()) {
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
            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Brinquedo alterado com sucesso!");
                Window window = SwingUtilities.getWindowAncestor((Component) evt.getSource());
                window.dispose();
            }
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar brinquedo. " + e.getMessage());
        }
    }

    /**
     * Obtém o preço de um brinquedo com base no seu nome.
     *
     * @param produto O nome do brinquedo.
     * @return O preço do brinquedo.
     */
    public static double obterPrecoBrinquedo(String produto) {
        double precoProduto = 0.0;

        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
            String sql = Queries.OBTEM_PRECO_PRODUTO;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, produto);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                precoProduto = resultSet.getDouble("valor_unitario");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return precoProduto;
    }

    /**
     * Consulta o estoque de um brinquedo com base no seu nome.
     *
     * @param produto O nome do brinquedo.
     * @return O estoque do brinquedo.
     */
    public static int consultaEstoqueBrinquedo(String produto) {
        int estoque = 0;

        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
            String sql = Queries.CONSULTA_ESTOQUE_PRODUTO;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, produto);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                estoque = resultSet.getInt("estoque");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estoque;
    }

    /**
     * Atualiza o estoque de um brinquedo com base no seu nome.
     *
     * @param produto O nome do brinquedo.
     * @param novoEstoque O novo valor do estoque do brinquedo.
     */
    public static void atualizaEstoqueBrinquedo(String produto, int novoEstoque) {
        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
            String sql = Queries.ATUALIZA_ESTOQUE_PRODUTO;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, novoEstoque);
            preparedStatement.setString(2, produto);

            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtém o ID de um brinquedo com base no seu nome.
     *
     * @param nomeProduto O nome do brinquedo.
     * @return O ID do brinquedo.
     */
    public static int obterIdBrinquedo(String nomeProduto) {
        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
    
            String sql = Queries.OBTEM_ID_BRINQUEDO;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nomeProduto);
    
            ResultSet resultSet = preparedStatement.executeQuery();
    
            int idBrinquedo = -1; // valor inicial inválido
    
            if (resultSet.next()) {
                idBrinquedo = resultSet.getInt("id_brinquedo");
            }
    
            preparedStatement.close();
            return idBrinquedo;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; // retorna valor inválido em caso de erro
        }
    }

    /**
     * Consulta o nome de um brinquedo com base no seu ID.
     *
     * @param idBrinquedo O ID do brinquedo.
     * @return O nome do brinquedo.
     */
    public static String consultarNomeBrinquedo(int idBrinquedo) {
        String nomeBrinquedo = "";
    
        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
    
            String sql = Queries.CONSULTA_NOME_BRINQUEDO_POR_ID;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, idBrinquedo);
    
            ResultSet resultSet = preparedStatement.executeQuery();
    
            if (resultSet.next()) {
                nomeBrinquedo = resultSet.getString("nome");
            }
    
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return nomeBrinquedo;
    }
}

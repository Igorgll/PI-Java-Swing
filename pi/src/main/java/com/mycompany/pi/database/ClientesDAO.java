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
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;

import com.mycompany.pi.database.sqlQueries.Queries;
import com.mycompany.pi.models.Cliente;
import com.mycompany.pi.models.Endereco;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

/**
 * Classe que representa o DAO (Data Access Object) para a entidade Clientes.
 */
public class ClientesDAO {
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
     * Cria a tabela de clientes no banco de dados.
     */
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

    /**
     * Cria um novo cliente no banco de dados.
     *
     * @param cliente O objeto Cliente a ser criado.
     */
    public static void criaCliente(Cliente cliente) {
        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
            String sql = Queries.CRIA_CLIENTE;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCPF());
            preparedStatement.setString(3, cliente.getEmail());
            preparedStatement.setString(4, cliente.getTelefone());
            preparedStatement.setString(5, cliente.getCPF()); // adicional para verificar duplicidade de CPF
            int linhasAfetadas = preparedStatement.executeUpdate();

            if (linhasAfetadas > 0) {
                // pega o id gerado para o cliente
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id_cliente = generatedKeys.getInt(1);
                    cliente.setId_cliente(id_cliente); // define o id gerado para o cliente

                    // insere o endereços do cliente
                    for (Endereco endereco : cliente.getEnderecos()) {
                        criaEndereco(id_cliente, endereco);
                    }
                }
                JOptionPane.showMessageDialog(null, "Cliente criado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente já existe!");
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cria um novo endereço associado a um cliente no banco de dados.
     *
     * @param idCliente O ID do cliente.
     * @param endereco O objeto Endereco a ser criado.
     */
    public static void criaEndereco(int idCliente, Endereco endereco) {
        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
            String sql = Queries.CRIA_ENDERECO;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, idCliente);
            preparedStatement.setString(2, endereco.getRua());
            preparedStatement.setInt(3, endereco.getNumero());
            preparedStatement.setString(4, endereco.getCidade());
            preparedStatement.setString(5, endereco.getEstado());

            int linhasAfetadas = preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Consulta a lista de todos os clientes no banco de dados.
     *
     * @return A lista de clientes consultada.
     */
    public static ArrayList<Cliente> consultaListaClientes() {
        ArrayList<Cliente> retornoClientes = new ArrayList<Cliente>();
        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
            String sql = Queries.CONSULTA_CLIENTES;
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id_cliente = resultSet.getInt("id_cliente");
                String CPF = resultSet.getString("CPF");
                String email = resultSet.getString("email");
                String rua = resultSet.getString("rua");
                int numero = resultSet.getInt("numero");
                String cidade = resultSet.getString("cidade");
                String estado = resultSet.getString("estado");

                // verifica se o cliente já existe na lista
                Cliente cliente = null;
                for (Cliente c : retornoClientes) {
                    if (c.getId_cliente() == id_cliente) {
                        cliente = c;
                        break;
                    }
                }

                // se o cliente não existe na lista, cria um novo objeto Cliente e adiciona à
                // lista
                if (cliente == null) {
                    cliente = new Cliente();
                    cliente.setId_cliente(id_cliente);
                    cliente.setCPF(CPF);
                    cliente.setEmail(email);
                    cliente.setEnderecos(new ArrayList<Endereco>());
                    retornoClientes.add(cliente);
                }

                // cria um novo objeto Endereco e configura seus atributos
                Endereco endereco = new Endereco();
                endereco.setRua(rua);
                endereco.setNumero(numero);
                endereco.setCidade(cidade);
                endereco.setEstado(estado);

                // adiciona o objeto Endereco ao cliente
                cliente.getEnderecos().add(endereco);

                // configura nome e telefone do cliente
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                cliente.setNome(nome);
                cliente.setTelefone(telefone);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retornoClientes;
    }

    /**
     * Consulta a lista de clientes por nome no banco de dados.
     *
     * @param nomeConsulta O nome a ser consultado.
     * @return A lista de clientes encontrados.
     */
    public static ArrayList<Cliente> consultaListaClientesPorNome(String nomeConsulta) {
        ArrayList<Cliente> retornoClientesPorNome = new ArrayList<>();
        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
            String sql = Queries.CONSULTA_CLIENTE_POR_NOME;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, "%" + nomeConsulta + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_cliente = resultSet.getInt("id_cliente");
                String CPF = resultSet.getString("CPF");
                String email = resultSet.getString("email");
                String rua = resultSet.getString("rua");
                int numero = resultSet.getInt("numero");
                String cidade = resultSet.getString("cidade");
                String estado = resultSet.getString("estado");

                // verifica se o cliente já existe na lista
                Cliente cliente = null;
                for (Cliente c : retornoClientesPorNome) {
                    if (c.getNome().equals(nomeConsulta)) {
                        cliente = c;
                        break;
                    }
                }

                // se o cliente não existe na lista, cria um novo objeto Cliente e adiciona à
                // lista
                if (cliente == null) {
                    cliente = new Cliente();
                    cliente.setId_cliente(id_cliente);
                    cliente.setCPF(CPF);
                    cliente.setEmail(email);
                    cliente.setEnderecos(new ArrayList<Endereco>());
                    retornoClientesPorNome.add(cliente);
                }

                // cria um novo objeto Endereco e configura seus atributos
                Endereco endereco = new Endereco();
                endereco.setRua(rua);
                endereco.setNumero(numero);
                endereco.setCidade(cidade);
                endereco.setEstado(estado);

                // adiciona o objeto Endereco ao cliente
                cliente.getEnderecos().add(endereco);

                // configura nome e telefone do cliente
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                cliente.setNome(nome);
                cliente.setTelefone(telefone);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retornoClientesPorNome;
    }

    /**
     * Consulta a lista de clientes por CPF no banco de dados.
     *
     * @param CPF O CPF a ser consultado.
     * @return A lista de clientes encontrados.
     */
    public static ArrayList<Cliente> consultaListaClientesPorCPF(String CPF) {
        ArrayList<Cliente> retornoClientesPorCPF = new ArrayList<>();
        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
            String sql = Queries.CONSULTA_CLIENTE_POR_CPF;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, "%" + CPF + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_cliente = resultSet.getInt("id_cliente");
                String CPFString = resultSet.getString("CPF");
                String email = resultSet.getString("email");
                String rua = resultSet.getString("rua");
                int numero = resultSet.getInt("numero");
                String cidade = resultSet.getString("cidade");
                String estado = resultSet.getString("estado");

                // verifica se o cliente já existe na lista
                Cliente cliente = null;
                for (Cliente c : retornoClientesPorCPF) {
                    if (c.getCPF().equals(CPF)) {
                        cliente = c;
                        break;
                    }
                }

                // se o cliente não existe na lista, cria um novo objeto Cliente e adiciona à
                // lista
                if (cliente == null) {
                    cliente = new Cliente();
                    cliente.setId_cliente(id_cliente);
                    cliente.setCPF(CPF);
                    cliente.setEmail(email);
                    cliente.setEnderecos(new ArrayList<Endereco>());
                    retornoClientesPorCPF.add(cliente);
                }

                // cria um novo objeto Endereco e configura seus atributos
                Endereco endereco = new Endereco();
                endereco.setRua(rua);
                endereco.setNumero(numero);
                endereco.setCidade(cidade);
                endereco.setEstado(estado);

                // adiciona o objeto Endereco ao cliente
                cliente.getEnderecos().add(endereco);

                // configura nome e telefone do cliente
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                cliente.setNome(nome);
                cliente.setTelefone(telefone);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retornoClientesPorCPF;
    }

    /**
     * Deleta um cliente do banco de dados.
     *
     * @param id_cliente O ID do cliente a ser deletado.
     */
    public void deletarCliente(int id_cliente) {
        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
            // apaga o endereço atrelado ao cliente
            String sqlDeletaEndereco = Queries.DELETA_ENDERECO_CLIENTE;
            PreparedStatement prepareStatementDeletaEndereco = conexao.prepareStatement(sqlDeletaEndereco);
            prepareStatementDeletaEndereco.setInt(1, id_cliente);
            int linhasAfetadasEndereco = prepareStatementDeletaEndereco.executeUpdate();

            // apaga o cliente
            String sqlDeletaCliente = Queries.DELETA_CLIENTE;
            PreparedStatement preparedStatementDeletaCliente = conexao.prepareStatement(sqlDeletaCliente);
            preparedStatementDeletaCliente.setInt(1, id_cliente);
            int linhasAfetadasCliente = preparedStatementDeletaCliente.executeUpdate();

            if (linhasAfetadasEndereco > 0 && linhasAfetadasCliente > 0) {
                JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso!");

            } else {
                JOptionPane.showMessageDialog(null, "Falha ao deletar cliente!");
            }

            prepareStatementDeletaEndereco.close();
            preparedStatementDeletaCliente.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Altera os dados de um cliente no banco de dados.
     *
     * @param id_cliente O ID do cliente a ser alterado.
     * @param nome O novo nome do cliente.
     * @param CPF O novo CPF do cliente.
     * @param email O novo email do cliente.
     * @param rua O novo nome da rua do endereço do cliente.
     * @param numero O novo número do endereço do cliente.
     * @param cidade A nova cidade do endereço do cliente.
     * @param estado O novo estado do endereço do cliente.
     * @param telefone O novo telefone do cliente.
     * @param evt O evento que acionou a alteração.
     */
    public void alterarCliente(int id_cliente, String nome, String CPF, String email, String rua, int numero,
            String cidade, String estado, String telefone, ActionEvent evt) {
        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
            String sql = Queries.ALTERA_CLIENTE;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, CPF);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, rua);
            preparedStatement.setInt(5, numero);
            preparedStatement.setString(6, cidade);
            preparedStatement.setString(7, estado);
            preparedStatement.setString(8, telefone);
            preparedStatement.setInt(9, id_cliente);

            int linhasAfetadas = preparedStatement.executeUpdate();
            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
                Window window = SwingUtilities.getWindowAncestor((Component) evt.getSource());
                window.dispose();
            }
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar cliente. " + e.getMessage());
        }
    }
}

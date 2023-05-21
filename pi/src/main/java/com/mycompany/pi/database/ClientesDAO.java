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
import com.mycompany.pi.models.Cliente;
import com.mycompany.pi.models.Endereco;

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

}

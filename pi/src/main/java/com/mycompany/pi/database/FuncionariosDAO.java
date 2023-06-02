package com.mycompany.pi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.mindrot.jbcrypt.BCrypt;

import com.mycompany.pi.Sessao.Sessao;
import com.mycompany.pi.database.sqlQueries.Queries;
import com.mycompany.pi.models.Funcionario;

/**
 * Classe responsável por lidar com a persistência de dados dos funcionários.
 */
public class FuncionariosDAO {
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
     * Cria um funcionário administrador se ainda não existir.
     */
    public static void criaFuncionarioAdmin() {
        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }

            String nome = "admin";
            String usuario = "admin";
            String senha = "admin";

            // Verifica se o funcionário admin já existe
            if (verificarFuncionarioExistente(usuario)) {
                // System.out.println("Já existe um funcionário admin no banco de dados!");
            } else {
                // criptografa a senha
                String senhaCriptografada = BCrypt.hashpw(senha, BCrypt.gensalt());

                String sql = Queries.CRIA_FUNCIONARIO;
                PreparedStatement preparedStatement = conexao.prepareStatement(sql);
                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, usuario);
                preparedStatement.setString(3, senhaCriptografada);
                preparedStatement.setString(4, usuario);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }

            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cria um novo funcionário no banco de dados.
     * 
     * @param funcionario O objeto Funcionario contendo as informações do novo funcionário.
     */
    public static void criaFuncionario(Funcionario funcionario) {
        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
            String sql = Queries.CRIA_FUNCIONARIO;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setString(2, funcionario.getUsuario());
            preparedStatement.setString(3, funcionario.getSenha());
            preparedStatement.setString(4, funcionario.getUsuario()); // verificar duplicidade
            int linhasAfetadas = preparedStatement.executeUpdate();
            preparedStatement.close();

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Funcionário criado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Verifica se um funcionário com o usuário fornecido já existe no banco de dados.
     * 
     * @param usuario O usuário do funcionário a ser verificado.
     * @return true se o funcionário existe, false caso contrário.
     */
    public static boolean verificarFuncionarioExistente(String usuario) {
        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }

            String sql = Queries.VERIFICA_FUNCIONARIO;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, usuario);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            int count = resultSet.getInt(1);

            resultSet.close();
            preparedStatement.close();

            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Efetua o login de um funcionário com o usuário e senha fornecidos.
     * 
     * @param usuario O usuário do funcionário.
     * @param senha A senha do funcionário.
     */
    public static boolean efetuarLogin(String usuario, String senha) {
        String nomeFuncionario = null;
        try {
            if (conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            }
    
            String sql = Queries.VERIFICA_SENHA_FUNCIONARIO;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, usuario);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                String senhaArmazenada = resultSet.getString("senha");
                nomeFuncionario = resultSet.getString("nome");
    
                // Verificação da senha fornecida criptografada
                if (BCrypt.checkpw(senha, senhaArmazenada)) {
                    resultSet.close();
                    preparedStatement.close();
                    Sessao.setNomeFuncionario(nomeFuncionario);
                    return true;
                } else {
                    resultSet.close();
                    preparedStatement.close();
                    return false;
                }

            } else {
                resultSet.close();
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

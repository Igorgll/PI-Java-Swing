package com.mycompany.pi.database.sqlQueries;

/**
 * Descrição da classe ou do método.
 */
public class Queries {
        public static final String CRIA_FUNCIONARIO_ADMIN = "INSERT INTO funcionarios(nome, usuario, senha) VALUES (?, ?, ?) WHERE NOT EXISTS (SELECT 1 FROM funcionarios WHERE nome = 'admin' AND usuario = 'admin' AND senha = 'admin')";

        public static final String CONSULTA_FUNCIONARIOS = "SELECT id_funcionario, usuario, senha FROM funcionarios WHERE usuario = ? AND senha = ?;";

        public static final String CONSULTA_BRINQUEDOS = "SELECT * FROM brinquedos;";

        public static final String CONSULTA_BRINQUEDOS_POR_CATEGORIA = "SELECT * FROM brinquedos WHERE categoria = ?;";

        public static final String CONSULTA_BRINQUEDOS_POR_NOME = "SELECT * FROM brinquedos WHERE nome LIKE ?;";

        public static final String CRIA_BRINQUEDO = "INSERT INTO brinquedos (estoque, nome, categoria, valor_unitario, descricao) SELECT ?, ?, ?, ?, ? FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM brinquedos WHERE nome = ?)";

        public static final String DELETA_BRINQUEDO = "DELETE FROM brinquedos WHERE id_brinquedo = ?;";

        public static final String ALTERA_BRINQUEDO = "UPDATE brinquedos SET estoque = ?, nome = ?, categoria = ?, valor_unitario = ?, descricao = ? WHERE id_brinquedo = ?;";

        public static final String CRIA_CLIENTE = "INSERT INTO clientes (nome, CPF, email, telefone) SELECT ?, ?, ?, ? FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM clientes WHERE CPF = ?)";

        public static final String CRIA_ENDERECO = "INSERT INTO enderecos (id_cliente, rua, numero, cidade, estado) VALUES(?, ?, ?, ?, ?)";

        public static final String CONSULTA_CLIENTES = "SELECT c.id_cliente, c.nome, c.CPF, c.email, c.telefone, e.rua, e.numero, e.cidade, e.estado FROM clientes c JOIN enderecos e ON c.id_cliente = e.id_cliente";

        public static final String CONSULTA_CLIENTE_POR_NOME = "SELECT c.id_cliente, c.nome, c.CPF, c.email, c.telefone, e.rua, e.numero, e.cidade, e.estado FROM clientes c JOIN enderecos e ON c.id_cliente = e.id_cliente WHERE c.nome LIKE ?";

        public static final String CONSULTA_CLIENTE_POR_CPF = "SELECT c.id_cliente, c.nome, c.CPF, c.email, c.telefone, e.rua, e.numero, e.cidade, e.estado FROM clientes c JOIN enderecos e ON c.id_cliente = e.id_cliente WHERE c.CPF LIKE ?";

        public static final String DELETA_CLIENTE = "DELETE FROM clientes WHERE id_cliente = ?";

        public static final String DELETA_ENDERECO_CLIENTE = "DELETE FROM enderecos WHERE id_cliente = ?";

        public static final String ALTERA_CLIENTE = "UPDATE clientes c "
                        + "INNER JOIN enderecos e ON c.id_cliente = e.id_cliente "
                        + "SET c.nome = ?, c.CPF = ?, c.email = ?, e.rua = ?, e.numero = ?, e.cidade = ?, e.estado = ?, c.telefone = ? "
                        + "WHERE c.id_cliente = ?";

        public static final String CRIA_FUNCIONARIO = "INSERT INTO funcionarios (nome, usuario, senha) SELECT ?, ?, ? FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM funcionarios WHERE usuario = ?)";

        public static final String VERIFICA_FUNCIONARIO = "SELECT COUNT(*) FROM funcionarios WHERE usuario = ?;";

        public static final String VERIFICA_SENHA_FUNCIONARIO = "SELECT senha, nome FROM funcionarios WHERE usuario = ?;";

        public static final String OBTEM_PRECO_PRODUTO = "SELECT valor_unitario FROM brinquedos WHERE nome = ?";

        public static final String INSERE_VENDA = "INSERT INTO vendas (nome_funcionario, cpf_cliente, valor_venda, data_venda) VALUES (?, ?, ?, ?)";

        public static final String CONSULTA_ESTOQUE_PRODUTO = "SELECT estoque FROM brinquedos WHERE nome = ?";

        public static final String ATUALIZA_ESTOQUE_PRODUTO = "UPDATE brinquedos SET estoque = ? WHERE nome = ?";

        public static final String CONSULTA_RELATORIO_SINTETICO = "SELECT V.id_venda, V.data_venda, V.valor_venda, V.cpf_cliente, F.nome "
                        + "FROM vendas V "
                        + "INNER JOIN funcionarios F ON V.nome_funcionario = F.nome "
                        + "WHERE V.data_venda BETWEEN ? AND ?";

        public static final String INSERE_DETALHES_VENDA = "INSERT INTO detalhes_vendas (id_venda, id_brinquedo, quantidade) VALUES (?, ?, ?)";

        public static final String OBTEM_ID_BRINQUEDO = "SELECT * FROM brinquedos WHERE nome = ?";
        
        public static final String CONSULTA_DETALHES_VENDA = "SELECT id_brinquedo, quantidade FROM detalhes_vendas "
        + "INNER JOIN vendas ON detalhes_vendas.id_venda = vendas.id_venda "
        + "WHERE vendas.data_venda = ? AND vendas.valor_venda = ? "
        + "AND vendas.cpf_cliente = ?";

        public static final String CONSULTA_NOME_BRINQUEDO_POR_ID = "SELECT nome FROM brinquedos WHERE id_brinquedo = ?";

        public static final String CONSULTA_NOME_FUNCIONARIO = "SELECT F.nome FROM vendas V INNER JOIN funcionarios F ON V.nome_funcionario = F.nome WHERE V.id_venda = ?";
}

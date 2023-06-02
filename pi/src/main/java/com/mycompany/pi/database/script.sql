create database lojabrinquedos;

use lojabrinquedos;
 CREATE TABLE IF NOT EXISTS brinquedos (
    id_brinquedo INT NOT NULL AUTO_INCREMENT,
    estoque INT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    valor_unitario DECIMAL(10, 2) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    PRIMARY KEY (id_brinquedo)
);

CREATE TABLE IF NOT EXISTS clientes (
    id_cliente INT NOT NULL AUTO_INCREMENT,
    CPF VARCHAR(50) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_cliente)
);

CREATE TABLE IF NOT EXISTS funcionarios (
    id_funcionario INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    usuario VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    PRIMARY KEY (id_funcionario)
);

CREATE TABLE IF NOT EXISTS enderecos (
    id_endereco INT NOT NULL AUTO_INCREMENT,
    id_cliente INT NOT NULL,
    rua VARCHAR(255) NOT NULL,
    numero INT NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_endereco),
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS vendas (
    id_venda INT NOT NULL AUTO_INCREMENT,
    nome_funcionario VARCHAR(255) NOT NULL,
    cpf_cliente VARCHAR(50) NOT NULL,
    valor_venda DECIMAL(10, 2) NOT NULL,
    data_venda DATE NOT NULL,
    PRIMARY KEY (id_venda)
);

CREATE TABLE IF NOT EXISTS detalhes_vendas (
    id_detalhe_venda INT NOT NULL AUTO_INCREMENT,
    id_venda INT NOT NULL,
    id_brinquedo INT NOT NULL,
    quantidade INT NOT NULL,
    PRIMARY KEY (id_detalhe_venda),
    FOREIGN KEY (id_venda) REFERENCES vendas(id_venda),
    FOREIGN KEY (id_brinquedo) REFERENCES brinquedos(id_brinquedo)
);

INSERT INTO brinquedos (estoque, nome, categoria, valor_unitario, descricao) VALUES
    (10, 'Bola de Futebol', 'DE_5_A_7_ANOS', 29.90, 'Bola de futebol com design moderno'),
    (15, 'Boneca de Pano', 'DE_1_A_2_ANOS', 49.99, 'Boneca de pano com vestido colorido'),
    (8, 'Carrinho de Controle Remoto', 'DE_8_A_10_ANOS', 199.99, 'Carrinho de controle remoto com velocidade máxima de 20 km/h'),
    (20, 'Jogo de Tabuleiro', 'DE_5_A_7_ANOS', 39.90, 'Jogo de tabuleiro com temática de aventura'),
    (5, 'Quebra-Cabeça', 'DE_3_A_4_ANOS', 14.99, 'Quebra-cabeça com 100 peças'),
    (12, 'Kit de Ferramentas de Brinquedo', 'DE_11_A_12_ANOS', 69.90, 'Kit de ferramentas de brinquedo com 10 peças'),
    (7, 'Bicicleta', 'DE_8_A_10_ANOS', 399.99, 'Bicicleta infantil com rodinhas laterais'),
    (3, 'Mesa de Pebolim', 'DE_11_A_12_ANOS', 899.90, 'Mesa de pebolim com 4 jogadores por equipe'),
    (18, 'Cubo Mágico', 'DE_5_A_7_ANOS', 9.99, 'Cubo mágico com 3x3x3 peças'),
    (22, 'Pista de Carrinhos', 'DE_3_A_4_ANOS', 149.99, 'Pista de carrinhos com loopings e curvas radicais'),
    (9, 'Instrumento Musical', 'DE_1_A_2_ANOS', 29.90, 'Instrumento musical com teclas coloridas'),
    (13, 'Trenzinho de Madeira', 'DE_3_A_4_ANOS', 59.90, 'Trenzinho de madeira com 3 vagões'),
    (6, 'Lego', 'DE_5_A_7_ANOS', 49.99, 'Conjunto de Lego com 500 peças'),
    (11, 'Patins', 'DE_8_A_10_ANOS', 149.90, 'Patins ajustáveis para pés do tamanho 34 ao 37'),
    (4, 'Kit de Artesanato', 'DE_11_A_12_ANOS', 79.99, 'Kit de artesanato com materiais para criar pulseiras e colares'),
    (16, 'Jogo de Xadrez', 'DE_8_A_10_ANOS', 29.90, 'Jogo de xadrez com peças em formato de animais'),
    (14, 'Carro de Controle Remoto', 'DE_3_A_4_ANOS', 79.90, 'Carro de controle remoto com controle fácil de usar'),
    (9, 'Jogo de Memória', 'DE_1_A_2_ANOS', 19.99, 'Jogo de memória com animais para estimular a mente dos pequenos'),
    (11, 'Jogo de Dardos', 'DE_8_A_10_ANOS', 59.90, 'Jogo de dardos magnéticos para crianças com 6 dardos'),
    (20, 'Playmobil', 'DE_5_A_7_ANOS', 29.99, 'Conjunto de Playmobil com 3 figuras e acessórios'),
    (13, 'Mesa de Air Hockey', 'DE_11_A_12_ANOS', 699.90, 'Mesa de air hockey com ventilador para manter o jogo emocionante'),
    (8, 'Piano Eletrônico', 'DE_3_A_4_ANOS', 89.90, 'Piano eletrônico com teclas coloridas para aprendizagem divertida'),
    (12, 'Patins Azul', 'DE_8_A_10_ANOS', 139.90, 'Patins azul com ajuste para tamanhos 37 a 40'),
    (15, 'Lego Technic', 'DE_11_A_12_ANOS', 99.99, 'Conjunto de Lego Technic com 200 peças para construir máquinas e mecanismos'),
    (17, 'Mini Game', 'DE_5_A_7_ANOS', 49.90, 'Mini game portátil com tela colorida e 100 jogos diferentes');

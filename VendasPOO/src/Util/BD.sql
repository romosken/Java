drop database Vendas;

create database Vendas;

create table Vendas.Clientes (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(40),
  endereco VARCHAR(45),
  bairro VARCHAR(20),
  cidade VARCHAR(20),
  cep VARCHAR(9),
  uf VARCHAR(2),
  email VARCHAR(30),
  telefone VARCHAR(10),
  celular VARCHAR(10),
  primary key (id));

create table Vendas.Produtos (
  id INT NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(30),
  preco double,
  unidade varchar(2),
  qtdInicial double,
  data date,
  qtdAtual double,
  primary key (id));

create table Vendas.Pedidos (
  id INT NOT NULL AUTO_INCREMENT,
  idCliente INT, 
  data datetime,
  primary key (id));
  
  create table Vendas.Itens (
  idPedido INT, 
  idProduto INT,
  qtd double
 );


ALTER TABLE Vendas.Pedidos ADD CONSTRAINT FK_CLIENTE_PEDIDOS FOREIGN KEY (idCliente) REFERENCES Vendas.Clientes (id) ON UPDATE cascade;

ALTER TABLE Vendas.Itens ADD CONSTRAINT FK_PEDIDO_ITENS FOREIGN KEY (idPedido) REFERENCES Vendas.Pedidos (id) ON UPDATE cascade on delete cascade;
ALTER TABLE Vendas.Itens ADD CONSTRAINT FK_PRODUTO_ITENS FOREIGN KEY (idProduto) REFERENCES Vendas.Produtos (id) ON UPDATE cascade;  

INSERT INTO `Vendas`.`Clientes` (`id`, `nome`, `endereco`, `bairro`, `cidade`, `cep`, `uf`, `email`, `telefone`,`celular` ) VALUES ('1', 'Rodrigo', 'Alameda Comendador Santana', 'Capão Redondo', 'São Paulo', '05855020','SP','rodrigo@email.com','55113435','949445996');
INSERT INTO `Vendas`.`Clientes` (`id`, `nome`, `endereco`, `bairro`, `cidade`, `cep`, `uf`, `email`,  `telefone`,`celular` ) VALUES ('2', 'Matheus', 'Estrada de itapecerica', 'Vila das Belezas', 'São Paulo', '05835015','SP','matheus@email.com','55115566','996336336');

INSERT INTO `Vendas`.`Produtos` (`id`, `descricao`, `preco`, `unidade`, `qtdInicial`,`data`,`qtdAtual`) VALUES ('1', 'chocolate', '3', 'UN', '100','2020-11-15','68');
INSERT INTO `Vendas`.`Produtos` (`id`, `descricao`, `preco`, `unidade`, `qtdInicial`,`data`,`qtdAtual`) VALUES ('2', 'bolinho', '2', 'UN', '50','2020-11-13','10');

INSERT INTO `Vendas`.`Pedidos` (`id`, `idCliente`, `data`) VALUES ('1', '1', '2020-11-15');
INSERT INTO `Vendas`.`Pedidos` (`id`, `idCliente`, `data`) VALUES ('2', '2', '2020-11-14');

INSERT INTO `Vendas`.`Itens` (`idPedido`, `idProduto`, `qtd`) VALUES ('1', '1', '10');
INSERT INTO `Vendas`.`Itens` (`idPedido`, `idProduto`, `qtd`) VALUES ('2', '2', '20');




CREATE TABLE produto (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
	descricao VARCHAR(50)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO produto(nome) VALUES
    ("Computador"),
    ("Mouse"),
    ("Teclado")
CREATE TABLE contatos (
    id_contato INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome       VARCHAR(20) NOT NULL,
    sobrenome  VARCHAR(50)     NULL,
    telefone   VARCHAR(20)     NULL,
    email      VARCHAR(80)     NULL
);

INSERT INTO contatos (nome, sobrenome, telefone, email)
VALUES ('Bruno', 'Lima', '32345566', 'bruno.lima@furg.br');

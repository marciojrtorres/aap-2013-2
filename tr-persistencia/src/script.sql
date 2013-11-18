-- MYSQL

CREATE DATABASE tr;

USE tr;

CREATE TABLE produtos (
    id_produto INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT,
    descricao  VARCHAR(50) NOT NULL
);

INSERT INTO produtos (descricao) VALUES ('Cafeteira'), ('Liquidificador');
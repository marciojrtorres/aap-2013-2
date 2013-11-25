-- MYSQL
CREATE DATABASE redesocial;
USE redesocial;

CREATE TABLE usuarios (
    id_usuario      INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT,
    email           VARCHAR(50) NOT NULL UNIQUE,
    senha           VARCHAR(10) NOT NULL,
    nome            VARCHAR(20)     NULL,
    sobrenome       VARCHAR(30)     NULL,
    data_nascimento DATE            NULL,
    genero          TINYINT         NULL
);

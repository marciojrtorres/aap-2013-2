-- jdbc:postgresql://localhost/petshop
-- jdbc:mysql://localhost/petshop

-- CREATE DATABASE PETSHOP;

--DROP SEQUENCE id_animal;
 DROP TABLE animais;

--CREATE SEQUENCE id_animal START WITH 1; -- POSTGRESQL
CREATE TABLE animais (
    id_animal   SERIAL      NOT NULL PRIMARY KEY,
    nome        VARCHAR(50) NOT NULL,
    tipo        VARCHAR(20)     NULL,
    raca        VARCHAR(20)     NULL,
    data_nasc   DATE            NULL,
    dono        VARCHAR(50) NOT NULL
);

-- MYSQL
CREATE TABLE animais (
    id_animal   INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome        VARCHAR(50) NOT NULL,
    tipo        VARCHAR(20)     NULL,
    raca        VARCHAR(20)     NULL,
    data_nasc   DATE            NULL,
    dono        VARCHAR(50) NOT NULL
);
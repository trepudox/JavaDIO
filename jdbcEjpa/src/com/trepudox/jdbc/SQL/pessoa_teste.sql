DROP DATABASE IF EXISTS dio_teste;
CREATE DATABASE dio_teste;
 
 USE dio_teste;
 
 CREATE TABLE pessoa(
	id INTEGER NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    dataNasc DATE NOT NULL,
    cidade VARCHAR(255) NOT NULL,
	PRIMARY KEY(id)
 );
 
 INSERT INTO pessoa(nome, dataNasc, cidade)
 VALUES ("Marco", "2002-07-01", "São Paulo"), ("Alex", "1995-11-25", "São Paulo"),
 ("Jorge", "1998-02-13", "Rio de Janeiro"), ("Beatriz", "2000-08-04", "São Paulo"),
 ("Maria", "1999-09-20", "Rio de Janeiro"), ("Carol", "2001-03-06", "Florianópolis");
 
 SELECT * FROM pessoa;
 
 SELECT * FROM pessoa WHERE id < 3;
 
 SELECT * FROM pessoa WHERE LENGTH(nome) > 5;
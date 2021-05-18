DROP DATABASE IF EXISTS dio_teste;
CREATE DATABASE dio_teste;
 
 USE dio_teste;
 
 CREATE TABLE pessoa(
	id INTEGER NOT NULL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    dataNasc DATE NOT NULL,
    cidade VARCHAR(255) NOT NULL
 );
 
 INSERT INTO pessoa(id, nome, dataNasc, cidade)
 VALUES (1, "Marco", "2002-07-01", "São Paulo"), (2, "Alex", "1995-11-25", "São Paulo"),
 (3, "Jorge", "1998-02-13", "Rio de Janeiro"), (4, "Beatriz", "2000-08-04", "São Paulo"),
 (5, "Maria", "1999-09-20", "Rio de Janeiro"), (6, "Carol", "2001-03-06", "Florianópolis");
 
 SELECT * FROM pessoa;
 
 SELECT * FROM pessoa WHERE id < 3;
 
 SELECT * FROM pessoa WHERE LENGTH(nome) > 5;
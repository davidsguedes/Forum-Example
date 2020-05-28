CREATE SCHEMA `gameforum` DEFAULT CHARACTER SET utf8mb4 ;

use gameforum;

CREATE TABLE usuario
(
  login varchar(30) NOT NULL,
  email varchar(30),
  nome varchar(30),
  senha varchar(30),
  pontos integer,
  PRIMARY KEY usuario_pkey (login)
)ENGINE=innodb;

CREATE TABLE topico
(
  id_topico integer NOT NULL AUTO_INCREMENT,
  titulo varchar(100),
  conteudo varchar(1000),
  login varchar(30),
  PRIMARY KEY topico_pkey (id_topico)
)ENGINE=innodb;


CREATE TABLE comentario
(
  id_comentario integer NOT NULL AUTO_INCREMENT,
  comentario varchar(100),
  login varchar(30),
  id_topico integer,
  PRIMARY KEY comentario_pkey (id_comentario)
)ENGINE=innodb;

ALTER TABLE `topico`
ADD CONSTRAINT `topico_login_fkey` FOREIGN KEY (`login`) REFERENCES `usuario`(`login`);

ALTER TABLE `comentario`
ADD CONSTRAINT `comentario_id_topico_fkey` FOREIGN KEY (`id_topico`) REFERENCES `topico` (`id_topico`) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
ADD CONSTRAINT `comentario_login_fkey` FOREIGN KEY (`login`) REFERENCES usuario (`login`) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION;



INSERT INTO usuario(login, email, nome, senha, pontos) VALUES ("david", "david@email.com", "David Guedes", "davidsenha", 30);
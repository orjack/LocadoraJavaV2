BEGIN;

CREATE DATABASE IF NOT EXISTS `locadora` ;
use locadora;

CREATE TABLE IF NOT EXISTS `Autor` (
	  `id`          INT                     NOT NULL AUTO_INCREMENT,
	  `nome`        VARCHAR(80)             NOT NULL,
	  `situacao`	INT 					NOT NULL DEFAULT=1,
  PRIMARY KEY (id)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `Diretor` (
	  `id`          INT                     NOT NULL AUTO_INCREMENT,
	  `nome`        VARCHAR(80)             NOT NULL,
	  `situacao`	INT 					NOT NULL DEFAULT=1,
  PRIMARY KEY (id)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `Cliente` (
	`id`                   INT              NOT NULL AUTO_INCREMENT,
	`nome`                 VARCHAR(80)      NOT NULL,
	`cpf`                  VARCHAR(12)      NOT NULL,
	`rg`                   VARCHAR(11)      NULL,
	`data_nascimento`      DATE             NOT NULL,
	`sexo`                 VARCHAR(1)       NOT NULL,
	`cep`                  VARCHAR(10)      NULL,
	`logradouro`           VARCHAR(80)      NULL,
	`numero_logradouro`    INT              NULL,
	`bairro`               VARCHAR(80)      NULL,
	`municipio`            INT              NULL,
	`uf`                   VARCHAR(2)       NULL,
	`telefone`             VARCHAR(14)      NULL,
	`celular`              VARCHAR(14)      NULL,
	`email`                VARCHAR(30)      NULL,
	`situacao`             INT		NOT NULL DEFAULT=1,

  PRIMARY KEY (id)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `Fornecedor` (
	`id`                  INT              NOT NULL AUTO_INCREMENT,
	`razao_social`        VARCHAR(80)      NOT NULL,
	`cnpj`                VARCHAR(19)      NOT NULL,
	`ie`                  VARCHAR(15)      NULL,
	`cep`                 VARCHAR(11)      NULL,
	`logradouro`          VARCHAR(80)      NULL,
	`numero_logradouro`   INT              NULL,
	`bairro`              VARCHAR(50)      NULL,
	`municipio`           INT 	       	   NULL,
	`uf`                  VARCHAR(2)       NULL,
	`telefone`            VARCHAR(15)      NULL,
	`celular`             VARCHAR(15)      NULL,
	`email`               VARCHAR(30)      NULL,
	`situacao`            INT              NOT NULL DEFAULT=1,

PRIMARY KEY (id)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `Media` (
	`id`                INT              NULL AUTO_INCREMENT,
	`fornecedor`       	INT 		     NOT NULL,
	`grupo`             INT 		     NOT NULL,
	`genero`            INT 		     NOT NULL,
	`censura`           INT 		     NOT NULL,
	`titulo`            VARCHAR(80)      NULL,
	`autor`   			INT      		 NULL,
	`diretor`           INT 		     NULL,
	`categoria`         INT 		     NULL,
	`lancamento`        DATE 		     NOT NULL,
	`sinopse`       	VARCHAR(1024)    NULL,
	`valor_compra`      DECIMAL(10,2)    NULL,
	`quantidade`        INT 		     NULL,
	`valor_locacao`     DECIMAL(10,2)    NULL,
	`situacao`	INT 					 NOT NULL DEFAULT=1,

PRIMARY KEY (id),
CONSTRAINT `FK_FORNECEDOR` FOREIGN KEY ( `fornecedor` ) REFERENCES `Fornecedor` ( `id` ) ,
CONSTRAINT `FK_DIRETOR` FOREIGN KEY ( `diretor` ) REFERENCES `Diretor` ( `id` ) ,
CONSTRAINT `FK_AUTOR` FOREIGN KEY ( `autor` ) REFERENCES `Autor` ( `id` ) 
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `Locacao` (
	`id`              INT          	NOT NULL AUTO_INCREMENT,
	`cliente`         INT          	NOT NULL,
	`valor_pago`      DECIMAL(10,2) NULL,
	`data_locacao`    DATETIME() 	NOT NULL,
	`data_devolucao`  DATETIME() 	NULL,
	`situacao`        INT          	NOT NULL DEFAULT=1,

PRIMARY KEY (id),
CONSTRAINT `FK_CLIENTE` FOREIGN KEY ( `cliente` ) REFERENCES `Cliente` ( `id` ) ,
CONSTRAINT `FK_MEDIAS_CLIENTE` FOREIGN KEY ( `medias` ) REFERENCES `Medias` ( `id` ) 
 ) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `MediaLocacao` (
	`id_locacao`        INT          NULL,
	`id_media`          INT          NULL,

PRIMARY KEY (id),
CONSTRAINT `FK_LOCACAO` FOREIGN KEY ( `id_locacao` ) REFERENCES `Locacao` ( `id` ) ,
CONSTRAINT `FK_MEDIA` FOREIGN KEY ( `media` ) REFERENCES `Media` ( `id` ) 
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

COMMIT;


/*------------------------------------INSERT-----------------------------------------------------*/
BEGIN;

INSERT INTO `Cliente` 
	(`nome`, `cpf`, `rg`, `data_nascimento`, `sexo`, `cep`, `logradouro`, `numero_logradouro`, `bairro`, `municipio`, `uf`, `telefone`, `celular`, `email`)
VALUES ("Thiago", "11111111111", "1111111", 2000-01-01, "M", "10000750", "R. Luiza", 100, "Jardim 01", 1, "PR", "4333333333", "439999999", "email@email.com")

INSERT INTO `Autor`
	(`nome`)
VALUES ("Jorge Luiz")

INSERT INTO `Diretor`
(`nome`)
VALUES ("Jorge Luiz")

INSERT INTO `Fornecedor`
(`razao_social`, `cnpj`, `ie`, `cep`, `logradouro`, `numero_logradouro`, `bairro`, `municipio`, `uf`, `telefone`, `celular`, `email`)
VALUES ("System One", "111111111111111", "11111111", "Rua One", 1000, "Jardim London", 1, "PR", "4333111111","4399111111", "one@email.com")

INSERT INTO `Media`
(`fornecedor`, `grupo`, `genero`, `censura`, `titulo`, `autor`, `diretor`, `categoria`, `lancamento`, `sinopse`, `valor_compra`, `quantidade`, `valor_locacao`)
VALUES (1, 1, 1, 1, "Panico 01", 1, 1, 1, 2014, "Era uma vez...", 2.00, 5, 5.00)

INSERT INTO  `Locacao`
(`cliente`, `valor_pago`, `data_locacao`, `data_devolucao`)
VALUES (1, 2.00, 2014-09-30)

INSERT INTO `MediaLocacao`
(`id_locacao`, `id_media`)
VALUES (1, 1)

COMMIT;
/*----------------------------------------------------------------------------------------------*/

BEGIN;

SELECT * FROM Autor ORDER by id;
SELECT * FROM Diretor ORDER by id;
SELECT * FROM Fornecedor ORDER by id;
SELECT * FROM Cliente ORDER by id;
SELECT * FROM Media ORDER by id;
SELECT * FROM Locacao ORDER by id;
SELECT * FROM MediaLocacao ORDER by id;

COMMIT;
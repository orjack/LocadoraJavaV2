  BEGIN;

CREATE DATABASE IF NOT EXISTS `LocadoraJava` ;
use AulaJava;


CREATE TABLE IF NOT EXISTS `Cliente` (
 `id`                    INT              NOT NULL AUTO_INCREMENT,
  `nome`                 VARCHAR(80)      NOT NULL,
  `cpf`                  VARCHAR(20)      NOT NULL,
  `rg`                   VARCHAR(20)      NOT NULL,
  `data_nascimento`      DATETIME         NOT NULL,
  `sexo`                 INT              NOT NULL,
  `cep`                  VARCHAR(11)      NOT NULL,
  `logradouro`           VARCHAR(50)      NOT NULL,
  `numero_logradouro`    INT              NOT NULL,
  `bairro`               VARCHAR(20)      NOT NULL,
  `municipio`            VARCHAR(20)      NOT NULL,
  `uf`                   VARCHAR(20)      NOT NULL,
  `telefone`               VARCHAR(20)      NOT NULL,
  `celular`            VARCHAR(20)      NOT NULL,
  `email`                   VARCHAR(20)      NOT NULL,

  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `Autor` (
  `id`          INT                     NOT NULL AUTO_INCREMENT,
  `nome`        VARCHAR(80)             NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `Diretor` (
  `id`          INT                     NOT NULL AUTO_INCREMENT,
  `nome`        VARCHAR(80)             NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;


CREATE TABLE IF NOT EXISTS `Fornecedor` (
  `id`                INT               NOT NULL AUTO_INCREMENT,
  `razao_social`      VARCHAR(80)       NOT NULL,
  `cnpj`              VARCHAR(20)       NOT NULL,
  `ie`                VARCHAR(20)       NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `Media` (
    `id`                 INT            NOT NULL AUTO_INCREMENT,
    `fornecedor`         VARCHAR(40)    NOT NULL,
    `diretor`            INT            NOT NULL,
    `autor`              INT            NOT NULL,
    `grupo`              INT            NOT NULL,
    `genero`             INT            NOT NULL,
    `censura`            INT            NOT NULL,
    
    `produtora`          VARCHAR(50)    NOT NULL,
    `titulo`             VARCHAR(50)    NOT NULL,
    `categoria`          INT            NOT NULL,
    `data_lancamento`    DATETIME       NOT NULL,
    `valor_compra`       DOUBLE(10,2)   NOT NULL,
    `valor_emprestimo`   DOUBLE(10,2)   NOT NULL,
    `quantidade`         INT            NOT NULL,
    `sinopse`            VARCHAR(1024)  NOT NULL,

  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

COMMIT;



BEGIN;

CREATE DATABASE IF NOT EXISTS `locadora` ;
use locadora;

CREATE TABLE IF NOT EXISTS `Autor` (
  `id`          INT                     NOT NULL AUTO_INCREMENT,
  `nome`        VARCHAR(80)             NOT NULL,
  PRIMARY KEY (id)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `Diretor` (
  `id`          INT                     NOT NULL AUTO_INCREMENT,
  `nome`        VARCHAR(80)             NOT NULL,
  PRIMARY KEY (id)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `Cliente` (
`id`                    INT              NOT NULL AUTO_INCREMENT,
`nome`                 VARCHAR(80)      NULL,
`cpf`                  VARCHAR(20)      NULL,
`rg`                   VARCHAR(20)      NULL,
`data_nascimento`      VARCHAR(20)      NULL,
`sexo`                 VARCHAR(10)      NULL,
`cep`                  VARCHAR(11)      NULL,
`logradouro`           VARCHAR(50)      NULL,
`numero_logradouro`    VARCHAR(10)      NULL,
`bairro`               VARCHAR(20)      NULL,
`municipio`            VARCHAR(20)      NULL,
`uf`                   VARCHAR(20)      NULL,
`telefone`             VARCHAR(20)      NULL,
`celular`              VARCHAR(20)      NULL,
`email`                VARCHAR(20)      NULL,

  PRIMARY KEY (id)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `Fornecedor` (
`id`                    INT               NULL AUTO_INCREMENT,
`razao_social`        VARCHAR(80)      NULL,
`cnpj`                VARCHAR(20)      NULL,
`ie`                  VARCHAR(20)      NULL,
`cep`                 VARCHAR(11)      NULL,
`logradouro`          VARCHAR(50)      NULL,
`numero_logradouro`   VARCHAR(10)      NULL,
`bairro`              VARCHAR(20)      NULL,
`municipio`           VARCHAR(20)      NULL,
`uf`                  VARCHAR(20)      NULL,
`telefone`            VARCHAR(20)      NULL,
`celular`             VARCHAR(20)      NULL,
`email`               VARCHAR(20)      NULL,

PRIMARY KEY (id)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

COMMIT;
SELECT * FROM Fornecedor ORDER by id;

CREATE TABLE IF NOT EXISTS `Media` (
`id`                INT              NULL AUTO_INCREMENT,
`fornecedor`       	INT 		     NULL,
`grupo`             VARCHAR(20)      NULL,
`genero`            VARCHAR(20)      NULL,
`censura`           VARCHAR(11)      NULL,
`titulo`            VARCHAR(50)      NULL,
`autor`   			INT      		 NULL,
`diretor`           INT 		     NULL,
`categoria`         VARCHAR(20)      NULL,
`lancamento`        VARCHAR(20)      NULL,
`sinopse`       	VARCHAR(20)      NULL,
`valor_compra`      VARCHAR(20)      NULL,
`quantidade`        VARCHAR(20)      NULL,
`valor_locacao`     VARCHAR(20)      NULL,

PRIMARY KEY (id),
CONSTRAINT `FK_FORNECEDOR` FOREIGN KEY ( `fornecedor` ) REFERENCES `Fornecedor` ( `id` ) ,
CONSTRAINT `FK_DIRETOR` FOREIGN KEY ( `diretor` ) REFERENCES `Diretor` ( `id` ) ,
CONSTRAINT `FK_AUTOR` FOREIGN KEY ( `autor` ) REFERENCES `Autor` ( `id` ) 
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `Locacao` (
`id`              INT          NOT NULL AUTO_INCREMENT,
`cliente`         INT          NULL,
`valor_pago`      VARCHAR(20)  NULL,
`data_locacao`    VARCHAR(11)  NULL,
`data_devolucao`  VARCHAR(50)  NULL,
`situacao`        INT          NULL,

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
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ecotrash
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ecotrash
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ecotrash` DEFAULT CHARACTER SET utf8 ;
USE `ecotrash` ;

-- -----------------------------------------------------
-- Table `ecotrash`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecotrash`.`usuarios` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `tx_cnpj_cpf` VARCHAR(45) NULL,
  `tx_nome` VARCHAR(250) NOT NULL,
  `tx_email` VARCHAR(100) NOT NULL,
  `tx_senha` NVARCHAR(255) NOT NULL,
  `tx_telefone` VARCHAR(45) NOT NULL,
  `dt_nascimento` varchar(45) NOT NULL,
  `tx_endereco` VARCHAR(150) NOT NULL,
  `tx_endNumero` VARCHAR(45) NOT NULL,
  `tx_bairro` VARCHAR(50) NOT NULL,
  `tx_cidade` VARCHAR(50) NOT NULL,
  `tx_uf` CHAR(2) NULL,
  `tx_cep` VARCHAR(10) NULL,
  tipoUsuario VARCHAR(10),
  isPago boolean,
  idServico int(10),
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ecotrash`.`colaborador`
-- -----------------------------------------------------



-- -----------------------------------------------------
-- Table `ecotrash`.`planos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecotrash`.`planos` (
  `id_plano` INT NOT NULL AUTO_INCREMENT,
  `tx_nome` VARCHAR(45) NULL,
  `nu_preco` int(18) NULL,
  PRIMARY KEY (`id_plano`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ecotrash`.`servico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecotrash`.`servico` (
  `id_servico` INT NOT NULL,
  `id_usuario` INT NOT NULL,
  `dt_contratacao` DATETIME NOT NULL,
  `dt_pagamento` DATETIME NOT NULL,
  `id_plano` INT NOT NULL,
  PRIMARY KEY (`id_servico`)

  );

-- -----------------------------------------------------
-- Table `ecotrash`.`agendamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecotrash`.`agendamento` (
  `id_agendamento` INT NOT NULL AUTO_INCREMENT,
  `id_usuario` INT NOT NULL,
  `dt_agendada` varchar(45) NOT NULL ,
  `tx_comentarios` VARCHAR(45) NULL,
  nome varchar(45),
    idColetador int(10),
  descricao text,

  PRIMARY KEY (`id_agendamento`)
    );
-- -----------------------------------------------------
-- Table `ecotrash`.`pagamentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecotrash`.`pagamentos` (
  `id_pagamento` INT NOT NULL AUTO_INCREMENT,
  `dt_pagamento` varchar(45) NULL,
  `id_servico` INT NULL,
  nome varchar(45),
  idColetador int(10),
  descricao varchar(45),
  PRIMARY KEY (`id_pagamento`),
    FOREIGN KEY (`id_servico`)
    REFERENCES `ecotrash`.`servico` (`id_servico`)
);
SELECT * from agendamento;
SELECT * from usuarios ;
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
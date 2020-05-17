CREATE SCHEMA IF NOT EXISTS `ecotrash2020` DEFAULT CHARACTER SET utf8 ;
USE `ecotrash2020` ;
-- -----------------------------------------------------
-- Table Usuário
-- -----------------------------------------------------
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `tipo_perfil` int NOT NULL,
  `tx_nome` varchar(250) NULL,
  `tx_documento` varchar(40) DEFAULT NULL,
  `tx_email` varchar(100) NOT NULL,
  `tx_senha` varchar(255) DEFAULT NULL,
  `tx_telefone` varchar(45) DEFAULT NULL,
  `dt_nascimento` date DEFAULT NULL,
  `tx_endereco` varchar(150) DEFAULT NULL,
  `tx_endNumero` varchar(45) DEFAULT NULL,
  `tx_bairro` varchar(50) DEFAULT NULL,
  `tx_cidade` varchar(50) DEFAULT NULL,
  `tx_uf` char(2) DEFAULT NULL,
  `tx_cep` varchar(10) DEFAULT NULL,
  UNIQUE(id_usuario, tx_documento, tx_email)
) ENGINE=InnoDB;
-- -----------------------------------------------------
-- Table Agendamento
-- -----------------------------------------------------

CREATE TABLE `agendamento` (
  `id_agendamento` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `id_colaborador` int DEFAULT NULL,
  `dt_agendada` datetime NOT NULL,
  `tx_titulo` varchar(100) NOT NULL,
  `tx_descricao` varchar(250) DEFAULT NULL,
   CONSTRAINT fk_cliente FOREIGN KEY (id_cliente) REFERENCES usuario (id_usuario),
    CONSTRAINT fk_colaborador FOREIGN KEY (id_colaborador) REFERENCES usuario (id_usuario)
) ENGINE=InnoDB;

-- -----------------------------------------------------
-- Table Plano
-- -----------------------------------------------------

CREATE TABLE `plano` (
  `id_plano` INT NOT NULL AUTO_INCREMENT,
  `tx_nome` VARCHAR(45) NULL,
  `nu_preco` DECIMAL(18,2) NULL,
  PRIMARY KEY (`id_plano`))
ENGINE = InnoDB; 
-- -----------------------------------------------------
-- Table Serviço
-- -----------------------------------------------------
CREATE TABLE `servico` (
  `id_servico` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `id_cliente` INT NOT NULL,
  `dt_contratacao` DATETIME NOT NULL,
  `dt_pagamento` DATETIME NOT NULL,
  `id_plano` INT NOT NULL,
  CONSTRAINT fk_plano FOREIGN KEY (id_plano)
    REFERENCES plano (id_plano)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_cliente_servico FOREIGN KEY (id_cliente)
    REFERENCES usuario (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `ecotrash`.`pagamento`
-- -----------------------------------------------------

CREATE TABLE  `pagamento` (
  `id_pagamento` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `dt_pagamento` DATETIME NULL,
  `id_servico` INT NULL,
  CONSTRAINT fk_servico FOREIGN KEY (id_servico)
  REFERENCES servico (id_servico)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table Pagamento 2 Para usuários que não tem cadastro
-- -----------------------------------------------------
CREATE TABLE  `pagamento2` (
  `id_pagamento` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `id_cliente` INT NOT NULL,
  `dt_pagamento` DATETIME NOT NULL,
  `nome_cartao` VARCHAR(100) NOT NULL,
  `nu_cartao` INT NOT NULL,
  `nu_cvv` INT NOT NULL,
  `plano` INT NULL,
  CONSTRAINT fk_pagamento2_cliente FOREIGN KEY (id_cliente)
  REFERENCES usuario (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



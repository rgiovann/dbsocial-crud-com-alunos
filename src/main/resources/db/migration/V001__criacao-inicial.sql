-- -----------------------------------------------------
-- Schema dbsocial
-- -----------------------------------------------------


-- -----------------------------------------------------
-- Table `categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `categoria` (
  `categoria_id` INT NOT NULL AUTO_INCREMENT,
  `categoria_nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`categoria_id`))
ENGINE = InnoDB charset=UTF8MB4;

-- -----------------------------------------------------
-- Table `curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `curso` 
 (
  `curso_id` INT NOT NULL AUTO_INCREMENT,
  `curso_descricao` VARCHAR(500) NOT NULL,
  `curso_fornecedor` VARCHAR(45) NOT NULL,
  `curso_nome` VARCHAR(45) NOT NULL,
  `curso_url` VARCHAR(90) NOT NULL,
  `curso_regime` CHAR(15) NULL,
  `curso_visualizacao` INT NULL,
  `curso_gostei` INT NULL,
  `curso_qtd_hrs` INT NULL,
  `categoria_idcategoria` INT NOT NULL,
  CONSTRAINT `fk_curso_categoria`
    FOREIGN KEY (`categoria_idcategoria`)
    REFERENCES `categoria` (`categoria_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,  
  PRIMARY KEY (`curso_id`)
  )
ENGINE = InnoDB default charset=UTF8MB4;

-- -----------------------------------------------------
-- Table `aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aluno` 
  (
  `aluno_id` INT NOT NULL AUTO_INCREMENT,
  `aluno_cpf` VARCHAR(25) NOT NULL,
  `aluno_nome` VARCHAR(45) NOT NULL,
  `aluno_contato` VARCHAR(45) NULL,
  `aluno_email` VARCHAR(45) NULL,
  `aluno_genero` VARCHAR(45) NOT NULL,
  `aluno_data_nascimento` DATE NOT NULL,
  `aluno_cep` VARCHAR(15) NULL,
  `aluno_logradouro` VARCHAR(45) NULL,
  `aluno_bairro` VARCHAR(45) NULL,
  `aluno_cidade` VARCHAR(45) NULL,
  `aluno_estado` VARCHAR(45) NULL,
  `aluno_nr_residencia` VARCHAR(45) NULL,
  `aluno_endereco_complemento` VARCHAR(25) NULL,
  `aluno_senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`aluno_id`)
  )
ENGINE = InnoDB charset=UTF8MB4;

-- -----------------------------------------------------
-- Table `aluno_curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aluno_curso` 
  (
  `aluno_idaluno` INT NOT NULL,
  `curso_idcurso` INT NOT NULL,
  PRIMARY KEY uk_aluno_curso (`aluno_idaluno`, `curso_idcurso`),
  CONSTRAINT `fk_aluno_curso_aluno`
    FOREIGN KEY (`aluno_idaluno`)
    REFERENCES `aluno` (`aluno_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluno_curso_curso`
    FOREIGN KEY (`curso_idcurso`)
    REFERENCES `curso` (`curso_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    )
ENGINE = InnoDB charset=UTF8MB4;

-- -----------------------------------------------------
-- Table `disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `disciplina` 
  (
  `disciplina_id` INT NOT NULL AUTO_INCREMENT,
  `disciplina_nome` VARCHAR(45) NULL,
  PRIMARY KEY (`disciplina_id`)
  )
ENGINE = InnoDB charset=UTF8MB4;
 

-- -----------------------------------------------------
-- Table `curso_disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `curso_disciplina` 
  (
  `curso_idcurso` INT NOT NULL,
  `disciplina_iddisciplina` INT NOT NULL,  
  PRIMARY KEY pk_aluno_curso (`curso_idcurso`, `disciplina_iddisciplina`),
  CONSTRAINT `curso_disciplina_curso`
    FOREIGN KEY (`curso_idcurso`)
    REFERENCES `curso` (`curso_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `curso_disciplina_disciplina`
    FOREIGN KEY (`disciplina_iddisciplina`)
    REFERENCES `disciplina` (`disciplina_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    ) 
ENGINE = InnoDB charset=UTF8MB4;

-- -----------------------------------------------------
-- Table `professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `professor` (
  `professor_id` INT NOT NULL AUTO_INCREMENT,
  `professor_nome` VARCHAR(45) NULL,
  `professor_curriculo` VARCHAR(45) NULL,
  PRIMARY KEY (`professor_id`))
ENGINE = InnoDB charset=UTF8MB4;

-- -----------------------------------------------------
-- Table `aula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aula` (
  `aula_id` INT NOT NULL AUTO_INCREMENT,
  `professor_idprofessor` INT NOT NULL,
  `disciplina_iddisciplina` INT NOT NULL,
  `curso_idcurso` INT NOT NULL,
  `aula_material` VARCHAR(45) NULL,
  `aula_video` VARCHAR(45) NULL,
  PRIMARY KEY (`aula_id`),
  CONSTRAINT unique_combination_constraint
  UNIQUE (disciplina_iddisciplina, curso_idcurso, professor_idprofessor),
  CONSTRAINT `fk_aula_professor`
    FOREIGN KEY (`professor_idprofessor`)
    REFERENCES `professor` (`professor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aula_disciplina`
    FOREIGN KEY (`disciplina_iddisciplina` )
    REFERENCES `disciplina` (`disciplina_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aula_curso`
    FOREIGN KEY (`curso_idcurso` )
    REFERENCES `curso` (`curso_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)    
ENGINE = InnoDB charset=UTF8MB4;

-- -----------------------------------------------------
-- Table `empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa` (
  `empresa_id` INT NOT NULL AUTO_INCREMENT,
  `empresa_cnpj` VARCHAR(25) NOT NULL,
  `empresa_nome` VARCHAR(45) NOT NULL,
  `empresa_cep` VARCHAR(15) NOT NULL,
  `empresa_logradouro` VARCHAR(45) NULL,
  `empresa_bairro` VARCHAR(45) NULL,
  `empresa_cidade` VARCHAR(45) NULL,
  `empresa_estado` VARCHAR(45) NULL,
  `empresa_email` VARCHAR(45) NULL,
  `empresa_contato` VARCHAR(45) NULL,
  PRIMARY KEY (`empresa_id`))
ENGINE = InnoDB charset=UTF8MB4;
 
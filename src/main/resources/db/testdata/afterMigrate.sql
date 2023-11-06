-- -----------------------------------------------------
-- Desabilita checks de foreign key
-- -----------------------------------------------------

set foreign_key_checks = 0;

-- -----------------------------------------------------
-- Limpa todas as tabelas
-- -----------------------------------------------------
delete from curso;
delete from aluno;
delete from disciplina;
delete from curso_disciplina;
delete from aluno_curso;
delete from professor;
delete from aula;
delete from empresa;
delete from categoria;
delete from foto_curso;

-- -----------------------------------------------------
-- Habilita checks de foreign key
-- -----------------------------------------------------

set foreign_key_checks = 1;

-- -----------------------------------------------------
-- Tabelas com auto-incremento começam com 1
-- -----------------------------------------------------

alter table curso auto_increment = 1;
alter table aluno auto_increment = 1;
alter table disciplina auto_increment = 1;
alter table professor auto_increment = 1;
alter table aula auto_increment = 1;
alter table empresa auto_increment = 1;
alter table categoria auto_increment = 1;

-- -----------------------------------------------------
-- Popula a tabela com a massa de dados de teste
-- -----------------------------------------------------

insert into categoria (categoria_id,categoria_nome)
values (1,'Curso Técnico Padrão'),(2,'Projeto 1o Emprego'), 
       (3,'Projeto Trilhas do Futuro'),(4,'Projeto Apoio a indústria textil');

insert into curso (id, curso_descricao,curso_fornecedor,curso_nome,curso_url,
curso_regime,curso_visualizacao,curso_gostei,curso_qtd_hrs,categoria_idcategoria) 
values 
      (1, 'Auxiliar de Cozinha em restaurantes de pequeno médio porte',
      'SENAC/Blumenau','Auxiliar de Cozinha','http://www.senac-blu.org.br/cursos/aux-cozinha','PRESENCIAL',
      12000,456,80,1),
      (2, 'Auxiliar administrativo para pequenas e médias empresas',
      'SENAC/Blumenau','Auxiliar administrativo','http://www.senac-blu.org.br/cursos/aux-admin','HIBRIDO',
      2000,36,80,1),
      (3, 'Costureira autônoma ou para pequenas malharias',
      'SENAC/Blumenau','Costureira','http://www.escolapopular.com.br/cursos/costureira','PRESENCIAL',
      3040,236,120,2),
      (4, 'Mecanico de automóveis e camionetes',
      'SENAC/Blumenau','Mecânico','http://www.senai.edu.br/cursos/mecanico','EAD',
      3240,232,212,1);


insert into aluno (aluno_id, aluno_cpf,aluno_nome,aluno_contato,aluno_email,aluno_genero,
        aluno_data_nascimento,aluno_cep,aluno_logradouro,aluno_bairro,aluno_cidade,
        aluno_estado,aluno_nr_residencia,aluno_endereco_complemento,aluno_senha) 
values(1,'653.601.985-72','Geraldo Magalhães','4798334533','geraldo.magalhaes@gmail.com','MASCULINO','1932-02-20','89020-100',
         'Rua Solimões','Garcia','Blumenau','SC','210','apto 231','123456'),
      (2,'353.621.984-21','Sofia de Andrade','4788334333','sofia.aa@gmail.com','FEMININO','1978-09-28','87120-200',
         'Rua XV de novembro','Alto Tribess','Timbó','SC','1233','apto 45 bloco A','654321'),
      (3,'678.231.185-34','Antonio A. de Souza','4298234559','antonioas@yahoo.com.br','MASCULINO','1989-06-14','83020-200',
         'Rua Mario de Andrade','Nova Brasília','Gaspar','SC','1210',null,'123456'),
      (4,'456.789.323-31','Monica dos Santos Avilla','4798564433','monica.sa@gmail.com','FEMININO','1987-08-14','86220-350',
         'Rua Marechal Candido Rondon','Bairro Champagnat','Indaial','SC','56','apto 18 bloco C','654321');
         
         
insert into disciplina( disciplina_id, disciplina_nome) 
values(1,'Antropologia da Alimentação'),
      (2,'Higiene e Segurança dos Alimentos'),
      (3,'Nutrição Básica e Cozinha Profissional'),
      (4,'Elaboração de Cardápios'),
      (5,'Noções de Administração'),
      (6,'Noções de Controle de Estoque'),
      (7,'Tecnologia de Escritório'),
      (8,'Atendimento ao Cliente'),
      (9,'Introdução ao Código do Consumidor'),
      (10,'Moldes e Modelagem'),
      (11,'Noções de Costura Industria'),
      (12,'Segurança e Ergonomia');
      

insert into curso_disciplina( curso_idcurso, disciplina_iddisciplina) 
values(1,1),
      (1,2),
      (1,3),
      (1,4),
      (1,5),
      (2,5),
      (3,5),      
      (1,6),
      (2,6),     
      (2,7),
      (1,8),
      (2,8),
      (3,8),
      (1,9),
      (2,9),
      (3,9), 
      (3,10),  
      (3,11),
      (1,12),
      (2,12),
      (3,12);
      
insert into aluno_curso( aluno_idaluno, curso_idcurso)
values(1,1),
      (1,2),
      (2,1),
      (2,3),
      (3,1),
      (3,3),
      (4,1),
      (4,2),
      (4,4);
  
insert into professor( professor_id, professor_nome,professor_curriculo)
values(1,'Anselmo Chaves Neto','http://lattes.cnpq.br/3768815744441785'),     
      (2,'Pedro Ribeiro','http://lattes.cnpq.br/3339395919699309'),     
      (3,'Antonio Giordani','http://lattes.cnpq.br/7333528719671860'),
      (4,'Giovanni Leopoldo Rozza','http://lattes.cnpq.br/8181964281402000');
 
 
insert into aula( aula_id, professor_idprofessor,disciplina_iddisciplina,curso_idcurso,aula_material,aula_video)
values(1,1,1,1,'http://link-aula/aula1','http://link-videoaula/videoaula1'),     
      (2,1,2,1,'http://link-aula/aula2','http://link-videoaula/videoaula2'),     
      (3,2,5,2,'http://link-aula/aula3','http://link-videoaula/videoaula3'),     
      (4,3,10,3,'http://link-aula/aula4','http://link-videoaula/videoaula4');    
      
      
      
insert into empresa( empresa_id, empresa_cnpj,empresa_nome,empresa_logradouro,empresa_cep,
                     empresa_bairro,empresa_cidade,empresa_estado,empresa_email,empresa_contato)
values( 1,'33.592.510/0001-54','Vale do Rio Doce','Rua São Paulo','89030-230','Vila Nova',
       'Blumenau','Santa Catarina','faleVale@valeriodoce.com.br','7833232335'),  
      ( 2,'38.456.510/0001-34','Companhia Eletrica 3 Rios','Avenida João 23','87030-230','Saco Grande',
       'Itajubá','Minas Gerais','sac@c3rios.com.br','3433226334'),   
      ( 3,'18.321.910/0001-28','Tecelaria Santo Antonio','Rua Amazonas','34030-700','Alto São Franciso',
       'São Martinho','Pernambuco','joa.tecelaria@gmail.com.br','6744226334');                
 
 
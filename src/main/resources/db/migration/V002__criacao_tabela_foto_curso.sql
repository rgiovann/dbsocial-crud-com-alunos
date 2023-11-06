create table foto_curso (
  curso_id  int not null,
  nome_arquivo varchar(150) not null,
  descricao varchar(150),
  content_type varchar(80) not null,
  tamanho int not null,

  primary key (curso_id),
  constraint fk_foto_curso_curso foreign key (curso_id) references curso (id)
) engine=InnoDB default charset=utf8;
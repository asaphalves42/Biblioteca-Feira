

CREATE TABLE pessoa (
    id integer,
    nome varchar(50),
    morada varchar(50),
    data_nascimento datetime,
    CONSTRAINT pessoa_pk PRIMARY KEY (id)
);

CREATE TABLE autor (
  id integer,
  id_pessoa integer,
  CONSTRAINT autor_pk PRIMARY KEY (id),
  FOREIGN KEY (id_pessoa) REFERENCES pessoa(id)
);

CREATE TABLE socio (
	id integer,
	id_pessoa integer,
	telefone integer,
	CONSTRAINT socio_pk PRIMARY KEY (id),
	FOREIGN KEY (id_pessoa) REFERENCES pessoa(id)
);

CREATE TABLE categoria(
	id integer,
	nome varchar(100),
	CONSTRAINT categoria_pk PRIMARY KEY (id),
);

CREATE TABLE categoria(
	id integer,
	nome varchar(100),
	CONSTRAINT categoria_pk PRIMARY KEY (id),
);

CREATE TABLE produto (
	id integer,
	titulo varchar(100),
	quantidade integer,
	id_autor integer,
	id_categoria integer,
	data_publicacao datetime,
	faixa_etaria varchar(20),
	editora varchar(100),
	CONSTRAINT produto_pk PRIMARY KEY (id),
	FOREIGN KEY (id_autor) REFERENCES autor(id),
	FOREIGN KEY (id_categoria) REFERENCES categoria(id),
);

CREATE TABLE livro (
	id integer,
	id_produto integer,
	subtitulo varchar(100),
	isbn varchar(50),
	paginas integer,
	CONSTRAINT livro_pk PRIMARY KEY (id),
	FOREIGN KEY (id_produto) REFERENCES produto(id),
);

CREATE TABLE cd (
	id integer,
	id_produto integer,
	capitulos integer,
	CONSTRAINT cd_pk PRIMARY KEY (id),
	FOREIGN KEY (id_produto) REFERENCES produto(id),
);

CREATE TABLE reserva (
	id integer,
	id_socio integer,
	data_inicio datetime,
	data_fim datetime,
	CONSTRAINT reserva_pk PRIMARY KEY (id),
	FOREIGN KEY (id_socio) REFERENCES socio (id)
);

CREATE TABLE reserva_produtos (
  id_reserva integer,
  id_produto integer,
  FOREIGN KEY (id_reserva) REFERENCES reserva (id),
  FOREIGN KEY (id_produto) REFERENCES produto (id)
);
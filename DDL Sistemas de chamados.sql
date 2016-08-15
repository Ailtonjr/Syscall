/*	*
	*	UNIVALI - Universidade do Vale do Itajaí
	*	Curso bacharelado em Ciência da Computação
	*	Disciplina de Banco de dados I
	*	Acadêmicos:	-	Ailton Cardoso Júnior
	*				-	João Felipe Gonçalves
	*
	*	Projeto final da disciplina: Sistema de chamados
	*
	*/


 -- DDL		Data Definition Language
--	db_chamados

CREATE TABLE usuario (
	id SERIAL,
	nome VARCHAR(255)	NOT NULL,
	login VARCHAR(255)	NOT NULL UNIQUE,
	senha VARCHAR(255)	NOT NULL
);

CREATE TABLE cliente (
	id SERIAL,
	nome VARCHAR(255)	NOT NULL UNIQUE,
	email VARCHAR(255)	NOT NULL
);

CREATE TABLE programador (
	id SERIAL,
	nome VARCHAR(255)	NOT NULL UNIQUE,
	valorHora REAL		NOT NULL
);

CREATE TABLE categoria (
	id SERIAL,
	nome VARCHAR(255)	NOT NULL UNIQUE
);

CREATE TABLE chamado (
	id SERIAL,
	status BOOLEAN	NOT NULL,
	descricao VARCHAR(255)	NOT NULL,
	id_categoria INTEGER	NOT NULL,
	id_cliente INTEGER	NOT NULL,
	id_usuario INTEGER	NOT NULL,
	data date		NOT NULL,
	hora time		NOT NULL
);

CREATE TABLE topico (
	id SERIAL,
	id_chamado INTEGER,
	descricao VARCHAR(255)		NOT NULL,
	id_programador INTEGER,
	tempo_trabalhado TIME	NOT NULL
);


ALTER TABLE usuario ADD PRIMARY KEY (id);
ALTER TABLE cliente ADD PRIMARY KEY (id);
ALTER TABLE programador ADD PRIMARY KEY (id);
ALTER TABLE categoria ADD PRIMARY KEY (id);
ALTER TABLE chamado ADD PRIMARY KEY (id);
ALTER TABLE topico ADD PRIMARY KEY (id);

ALTER TABLE chamado ADD FOREIGN KEY (id_categoria) REFERENCES categoria(id) ON DELETE SET NULL;
ALTER TABLE chamado ADD FOREIGN KEY (id_cliente) REFERENCES cliente(id) ON DELETE CASCADE;
ALTER TABLE chamado ADD FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE SET NULL;
ALTER TABLE topico ADD FOREIGN KEY (id_chamado) REFERENCES chamado(id) ON DELETE SET NULL;
ALTER TABLE topico ADD FOREIGN KEY (id_programador) REFERENCES programador(id) ON DELETE SET NULL;


-- VIEWS

CREATE VIEW gasto_problema AS
SELECT c.descricao, cast(sum(((extract (minute from t.tempo_trabalhado)/60) + (extract (hour from t.tempo_trabalhado)))* p.valorHora) AS NUMERIC(15, 2)) AS Valor, c.status FROM chamado c
LEFT JOIN topico t ON (c.id = t.id_chamado)
LEFT JOIN programador p ON (p.id = t.id_programador)
GROUP BY c.descricao, c.status;

CREATE VIEW gasto_cliente AS
SELECT c.nome, cast(sum(((extract (minute from ct.tempo_trabalhado)/60) + (extract (hour from ct.tempo_trabalhado)))* p.valorHora) AS NUMERIC(15, 2)) AS Valor FROM cliente c
LEFT JOIN chamado ch ON (c.id = ch.id_cliente) LEFT JOIN topico ct ON (ch.id = ct.id_chamado) LEFT JOIN programador p ON (p.id = ct.id_programador) GROUP BY c.nome;

INSERT INTO usuario (nome, login, senha) VALUES ('Juca', 'abc', '123');

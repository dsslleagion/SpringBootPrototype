drop schema if exists spring;

drop user if exists 'user'@'localhost';

create schema spring;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on spring.* to user@'localhost';

use spring;

create table tra_trabalho (
tra_id bigint primary key auto_increment,
tra_titulo varchar(100) not null unique,
tra_data_hora_entrega datetime not null,
tra_descricao varchar(200),
tra_grupo varchar(20) not null,
tra_nota int,
tra_justificativa varchar(100)
);

create table cor_corpo(
    cor_id bigint primary key auto_increment,
    cor_nome varchar(100) not null unique,
    cor_descricao varchar(200) not null,
    cor_raio int,
    cor_distancia_estrela float not null
);

INSERT INTO cor_corpo (cor_nome, cor_descricao, cor_raio, cor_distancia_estrela) 
VALUES 
('Terra', 'Terceiro planeta', 6371, 1),
('Marte', 'Quarto planeta', null, 1.5);


insert into tra_trabalho (tra_titulo, tra_data_hora_entrega, tra_grupo, tra_nota, tra_justificativa)
values ('Teste 1', current_timestamp(), 'Alpha', 6, 'Bom, mas falta conteúdo'),
('Teste 2', current_timestamp(), 'Beta', 3, 'Incompleto');
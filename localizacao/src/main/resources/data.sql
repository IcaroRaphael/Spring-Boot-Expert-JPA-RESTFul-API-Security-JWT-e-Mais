create table tb_cidade (
    id_cidade bigint not null primary key,
    nome varchar(50) not null,
    qtd_habitantes bigint
);

insert into tb_cidade
    (id_cidade, nome, qtd_habitantes)
values
    (1, 'São Paulo', 11450000),
    (2, 'Rio de Janeiro', 6210000),
    (3, 'Fortaleza', 2430000),
    (4, 'Salvador', 2420000),
    (5, 'Belo Horizonte', 2320000),
    (6, 'Porto Alegre', 1330000),
    (7, 'Porto Velho', 460000),
    (8, 'Palmas', 302690),
    (9, 'Recife', 1490000),
    (10, 'Natal', 751300),
    (11, 'Brasilia', 2820000);

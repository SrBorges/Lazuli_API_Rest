create table produto(

id bigint not null auto_increment,
nome varchar(60) not null,
tipo varchar(60) not null,
fornecedor varchar(100) not null,
quantidade varchar(20) not null,
lote varchar(10) not null,
custo varchar(50) not null,

primary key(id)

)
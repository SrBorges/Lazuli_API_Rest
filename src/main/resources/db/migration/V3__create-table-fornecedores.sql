create table fornecedores(

id bigint not null auto_increment,
nome varchar(60) not null,
cnpj varchar(50) not null,
cidade varchar(60) not null,
estado varchar(2) not null,
email varchar(50) not null,

primary key(id)

)
create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensagem varchar(100) not null,
    datacriacao varchar(15) not null,
    estadotopico varchar(20) not null,
    autor varchar(100) not null,
    curso varchar(40) not null,

    primary key(id)

);

create table topico(

    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(100) not null unique,
    curso varchar(100) not null,
    autor varchar(100) not null,


    primary key(id)
)
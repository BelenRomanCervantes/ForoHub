create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(100) not null unique,
    fechaCreacion datetime not null,
    status varchar(100) not null,
    usuario_id bigint not null,
    curso varchar(100) not null,

    CONSTRAINT fk_topico_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE

    primary key(id)
);
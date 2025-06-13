CREATE EXTENSION IF NOT EXISTS pgcrypto;


CREATE TABLE tb_usuarios (

    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    criado_em DATE NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE tb_habitos (

    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    titulo VARCHAR(50) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    data_ultimo_streak DATE,
    contagem_streak INT DEFAULT 0,
    criado_em DATE NOT NULL DEFAULT CURRENT_DATE,
    usuario_id UUID NOT NULL,
    CONSTRAINT fk_habito_usuario FOREIGN KEY(usuario_id) references tb_usuarios(id)
);
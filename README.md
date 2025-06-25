# API de Gerenciamento de Hábitos
Esta é uma API REST desenvolvida em Java com Spring Boot para o gerenciamento de hábitos diários, com autenticação JWT e boas práticas de produção.

## Funcionalidades
Cadastro e login de usuários com autenticação via JWT

Registro de hábitos vinculados ao usuário autenticado

Validações e tratamento centralizado de exceções

Documentação automática com Swagger

Tecnologias Utilizadas
Java 17

Spring Boot

Spring Security + JWT

PostgreSQL

Docker (para banco de dados em container)

Swagger (springdoc-openapi)

AWS EC2 (deploy em produção)

## Requisitos
Java 17+

Maven

Docker (para rodar o banco de dados local)

PostgreSQL (ou use via container Docker)

## Configuração do Ambiente
1. Crie o arquivo .env na raiz do projeto com as variáveis sensíveis:

```bash
DB_URL=jdbc:postgresql://localhost:5432/nome_do_banco
DB_USERNAME=seu_usuario
DB_PASSWORD=sua_senha
JWT_SECRET=sua_chave_secreta
```

2. Crie o arquivo application.properties em src/main/resources:

```bash
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=false

springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
```

## Como rodar a aplicação

1. Suba a aplicação com Docker Compose:

```bash
docker-compose up --build
```

2. Acesse a documentação Swagger:

```bash
http://localhost:8080/swagger-ui.html
```
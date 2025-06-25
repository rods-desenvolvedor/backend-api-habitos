# Imagem base com Java 21
FROM eclipse-temurin:21-jdk-alpine

# Diretório de trabalho dentro do container
WORKDIR /app

# Copia o .jar gerado pelo Maven para o container
COPY target/todo-0.0.1-SNAPSHOT.jar app.jar

# Executa a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]

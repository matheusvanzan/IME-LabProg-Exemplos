# Usa a imagem do Java
FROM eclipse-temurin:21-jdk-alpine

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos do projeto para dentro do container
COPY code/app1 .

# Compila o arquivo do projeto
# RUN javac Hello.java

RUN chmod +x gradlew && chmod -R 755 gradle/wrapper
RUN gradlew build

EXPOSE 8080

# Comando padrão ao executar o container
CMD ["./gradlew", "bootRun"]
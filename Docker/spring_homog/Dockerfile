# Usa a imagem oficial do OpenJDK 21
FROM openjdk:21-jdk-slim

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o restante do código do projeto
COPY code/ .

# Dá permissão de execução ao Gradle Wrapper
RUN chmod +x gradlew && chmod -R 755 gradle/wrapper

# Constrói o .war
RUN ./gradlew build

# Expõe a porta 8083
EXPOSE 8083

# Comando para iniciar a aplicação
# CMD ["tail", "-f", "/dev/null"]
CMD ["./gradlew", "bootRun"]
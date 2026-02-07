# Usa a imagem do Java
FROM eclipse-temurin:21-jdk-alpine

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos do projeto para dentro do container
COPY code/Hello.java .

# Compila o arquivo do projeto
RUN javac Hello.java

# Comando padrão ao executar o container
CMD ["java", "Hello"]


# Build e execução
# docker build -t meu-java-app .
# docker run --rm meu-java-app
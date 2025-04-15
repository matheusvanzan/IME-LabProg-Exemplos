# Usa a imagem oficial do OpenJDK 21
FROM openjdk:21-jdk-slim

# RUN apt-get update && \
#     apt-get install dos2unix && \
#     apt-get clean

# Cria um usuário não-root chamado "user"
# RUN useradd -m user

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o restante do código do projeto
COPY code/ .

# Dá permissão de execução ao Gradle Wrapper
RUN chmod +x gradlew && chmod -R 755 gradle/wrapper

# Muda o dono de todos os arquivos para o usuário "user"
# RUN chown -R user:user /app

# Alterna para o usuário "user"
# USER user

# Converte todos os arquivos do projeto para formato Unix (evita erro ^M)
# RUN find . -type f -exec sed -i 's/\r$//' {} +

# Constrói o projeto para garantir que as dependências do Gradle estejam instaladas
# RUN ./gradlew build

# Expõe a porta 8081
EXPOSE 8081

# Comando para iniciar a aplicação
# CMD ["./gradlew", "bootRun"]
CMD ["tail", "-f", "/dev/null"]
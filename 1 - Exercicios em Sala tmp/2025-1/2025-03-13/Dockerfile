FROM openjdk:21-jdk-slim

WORKDIR /app
COPY code/ .

RUN chmod +x gradlew && chmod -R 755 gradle/wrapper
RUN ./gradlew build

EXPOSE 8081
CMD ["./gradlew", "bootRun"]
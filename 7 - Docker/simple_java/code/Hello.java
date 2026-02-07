public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello!");
    }
}

// docker run --rm -it -v ${pwd}/code:/app -w /app eclipse-temurin:21-jdk-alpine sh
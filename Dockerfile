FROM openjdk:17
WORKDIR /app
COPY . .
RUN sh mvnw clean package -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "target/Minishop_Backend-0.0.1-SNAPSHOT.jar"]

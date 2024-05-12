FROM openjdk:17
WORKDIR /app
COPY /target/Minishop_Backend-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "Minishop_Backend-0.0.1-SNAPSHOT.jar"]

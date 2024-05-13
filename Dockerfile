FROM openjdk:17
RUN microdnf install --assumeyes maven
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "target/Minishop_Backend-0.0.1-SNAPSHOT.jar"]

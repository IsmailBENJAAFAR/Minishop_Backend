# Use an official OpenJDK runtime as a parent image
FROM openjdk:17

# set shell to bash
RUN apk update && apk add bash

# Set the working directory to /app
WORKDIR /app

# Copy the fat jar into the container at /app
COPY /target/Minishop_Backend-0.0.1-SNAPSHOT.jar /app

# Make port 8081 available to the world outside this container
EXPOSE 8081

# Run jar file when the container launches
CMD ["java", "-jar", "Minishop_Backend-0.0.1-SNAPSHOT.jar"]

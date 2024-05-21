#!/usr/bin/env sh
sh /app/mvnw clean install -DskipTests
java -jar /app/target/Minishop_Backend-0.0.1-SNAPSHOT.jar
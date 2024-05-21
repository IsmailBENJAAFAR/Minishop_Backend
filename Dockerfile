FROM openjdk:17
EXPOSE 8080
WORKDIR /app
CMD ["sh", "/app/script.sh"]

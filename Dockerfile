# Use Java 21 instead of Java 17
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy the compiled JAR file into the container
COPY target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "app.jar"]

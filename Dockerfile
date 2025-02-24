# Use Java 21 instead of Java 17
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper and dependencies
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Grant execution permissions to the Maven wrapper
RUN chmod +x mvnw

# Build the application
RUN ./mvnw dependency:resolve
RUN ./mvnw package -DskipTests

# Copy the generated JAR file
COPY target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
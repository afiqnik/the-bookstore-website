# Use Java 21 instead of Java 17
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper and dependencies
COPY .mvn/ .mvn
COPY mvnw ./
COPY pom.xml ./

# Fix line endings for UNIX systems
RUN apt-get update && apt-get install -y dos2unix && dos2unix mvnw

# Grant execution permissions to the Maven wrapper
RUN chmod +x mvnw

# Install Maven dependencies and build the application
RUN ./mvnw clean package -DskipTests

# Copy the generated JAR file explicitly
COPY target/bookstore-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]

# Use an official Maven image with JDK 21
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copy project files
COPY . .

# Build the application
RUN mvn clean package -DskipTests

# Use JDK 21 runtime for the final application
FROM eclipse-temurin:21-jdk AS runtime

WORKDIR /app

# Copy the exact JAR file (use the name from your target directory)
COPY --from=build /app/target/bookstore-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 (or the port your app uses)
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]


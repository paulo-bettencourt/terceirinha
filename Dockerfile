# Use an official Maven image to build the project
FROM maven:3.9.8-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies (for faster rebuilds)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build
COPY src ./src
RUN mvn clean package -DskipTests

# ----------- RUNTIME IMAGE -----------
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/terceirinha-0.0.1-SNAPSHOT.jar app.jar

# Expose port (default Spring Boot)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

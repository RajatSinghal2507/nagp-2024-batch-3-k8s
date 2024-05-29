# Use an official Maven image as the build environment
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory in the container
WORKDIR /app

# Clone the Git repository
RUN git clone https://github.com/RajatSinghal2507/nagp-2024-batch-3-k8s.git .

# Copy the Maven project files to the container
#COPY pom.xml .
#COPY src ./src
RUN CD nagp-2024-batch-3-k8s

# Build the Maven project
RUN mvn clean package -DskipTests

# Use an official OpenJDK image as the base image for running the application
FROM openjdk:17-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the previous stage to the container
COPY --from=build /app/target/*.jar app.jar

# Command to run the application
CMD ["java", "-jar", "app.jar"]

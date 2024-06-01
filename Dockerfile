FROM openjdk:8-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the application's JAR file to the container
COPY target/nagp-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the application runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java","-jar","app.jar"]

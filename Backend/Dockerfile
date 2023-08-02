# Dockerfile

# Use the appropriate base image
FROM openjdk:17-jdk
  
  # Set the working directory
WORKDIR /app
  
  # Copy the JAR file to the container
COPY target/TaskManager-0.0.1-SNAPSHOT.jar .
  
  # Set the command to run the JAR file
CMD ["java", "-jar", "TaskManager-0.0.1-SNAPSHOT.jar"]

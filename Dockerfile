

# ---------- Runtime Stage ----------
#Using JAVA 17 to run
FROM eclipse-temurin:17-jre

#working directory inside the container
WORKDIR /app

# Copy the Spring Boot JAR
COPY target/*.jar app.jar

# Expose the Spring Boot port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java","-jar","app.jar"]
# Use Maven to build the app
FROM maven:3.9.4-amazoncorretto-17 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# Use a lightweight JRE image
FROM amazoncorretto:17-alpine
WORKDIR /app

COPY --from=build /app/target/StudentInfoSystem-1.0.0.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

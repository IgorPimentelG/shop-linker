FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

FROM openjdk:17-jre-slim
COPY --from=build /app/target/*.jar /app/application.jar
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "application.jar"]
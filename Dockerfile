FROM gradle:8-jdk21 AS build
WORKDIR /home/gradle/project
COPY . .
RUN gradle clean build --no-daemon -x test

FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
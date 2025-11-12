
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package -DskipTests -B


FROM eclipse-temurin:21-jre-alpine
WORKDIR /app


RUN apk add --no-cache ca-certificates && \
    rm -rf /var/cache/apk/*

EXPOSE 8082


COPY --from=build /app/target/purchases-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
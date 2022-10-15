FROM alpine:3.14
WORKDIR /app
COPY . .
RUN ./mvnw install

FROM openjdk:17.0.2-slim-buster
VOLUME /tmp
COPY target/*.jar app.jar
COPY .env .env
CMD ["java","-jar","/app.jar"]
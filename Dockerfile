FROM alpine:3.14
WORKDIR /app
COPY . .
RUN ./mvnw install

FROM openjdk:17.0.2-slim-buster
COPY target/*.jar app.jar
COPY .env .env
EXPOSE 8020
CMD ["java","-jar","/app.jar"]
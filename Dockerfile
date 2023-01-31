FROM openjdk:17.0.2-slim-buster
WORKDIR /app
COPY . .

RUN ./mvnw package
ENTRYPOINT ["java","-jar","./target/messaging-0.0.1-SNAPSHOT.jar"]
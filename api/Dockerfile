FROM maven:3.8.1-jdk-11
WORKDIR /api
COPY java/ /api

RUN mvn package
CMD java -jar target/api-1.0-SNAPSHOT.jar

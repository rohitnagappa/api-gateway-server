FROM openjdk:11-slim as build

MAINTAINER "ROHIT NAGAPPA"

COPY build/libs/api-gateway-server-0.0.1-SNAPSHOT.jar api-gateway-server.jar

EXPOSE 9095

ENTRYPOINT ["java", "-jar", "/api-gateway-server.jar"]
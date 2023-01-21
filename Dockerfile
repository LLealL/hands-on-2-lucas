FROM amazoncorretto:19.0.2-alpine3.17
LABEL maintainer = "Lucas Goes"
WORKDIR /opt/app
COPY target/*.jar app.jar

ENTRYPOINT ["java", "-Dspring.profiles.activate=dev", "-jar", "app.jar"]
EXPOSE 8080
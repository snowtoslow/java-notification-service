FROM openjdk:8-jdk-alpine

VOLUME /tmp

COPY target/app app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
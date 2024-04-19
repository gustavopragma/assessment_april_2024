FROM openjdk:17-jdk-alpine
RUN addgroup -S app && adduser app -S -G app
USER app
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
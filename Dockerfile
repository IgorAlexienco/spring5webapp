FROM openjdk:11-jdk-slim
VOLUME /tmp
ADD ./target/sb-app-1.jar sb-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "sb-app.jar"]
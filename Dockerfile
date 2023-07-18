FROM eclipse-temurin:8-jdk-focal
ENV TZ=Europe/Madrid
ADD target/test-postgres-1.0.jar test-postgres-1.0.jar
ENTRYPOINT ["java", "-jar", "test-postgres-1.0.jar"]
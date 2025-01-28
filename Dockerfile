FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/category-service-0.0.1.jar
COPY ${JAR_FILE} category-service.jar
ENTRYPOINT ["java","-jar","category-service.jar"]
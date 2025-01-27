FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/category-service-0.0.1.jar
COPY ${JAR_FILE} app_eureka.jar
ENTRYPOINT ["java","-jar","category-service.jar"]
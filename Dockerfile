FROM maven:3.5.3-jdk-11-slim as maven
WORKDIR /orderItemApi
RUN mkdir deploy
COPY src src
COPY pom.xml pom.xml
RUN mvn install
FROM openjdk:11-jdk
RUN rm -rf deploy/*
COPY --from=maven /orderItemApi/target/orderitem-0.0.1-SNAPSHOT.jar deploy/
EXPOSE 8080
ENTRYPOINT ["java", "-Xmx1g", "-Xms1g", "-jar", "deploy/orderitem-0.0.1-SNAPSHOT.jar", "-Dspring.profiles.active=dev"]

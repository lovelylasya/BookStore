# Pull base image
FROM openjdk:11
# copy war file on to container
COPY ./spring-boot-web-0.0.1-SNAPSHOT.jar /
WORKDIR /
CMD ["java", "-jar", "spring-boot-web-0.0.1-SNAPSHOT.jar"]

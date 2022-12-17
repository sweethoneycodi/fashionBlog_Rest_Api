FROM openjdk:18
EXPOSE 8080
LABEL MAINTAINER = "Aniezue nonso "fabinonso@gmail.com""
ADD target/Spring-boot-docker.jar Spring-boot-docker.jar
ENTRYPOINT ["java","-jar","/Spring-boot-docker.jar"]
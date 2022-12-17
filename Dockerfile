FROM openjdk:18
EXPOSE 8080
LABEL MAINTAINER = "Aniezue nonso "fabinonso@gmail.com""
ADD target/springboot-image-new.jar springboot-image-new.jar
ENTRYPOINT ["java","-jar","/springboot-image-new.jar"]
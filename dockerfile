FROM openjdk:17-oracle
MAINTAINER baeldung.com
COPY build/libs/student-server.jar student-server.jar
ENTRYPOINT ["java","-jar","/student-server.jar"]
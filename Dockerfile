FROM openjdk:11-jre

COPY target/mongodb-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "mongodb-0.0.1-SNAPSHOT.jar"]
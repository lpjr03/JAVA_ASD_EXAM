FROM ubuntu:latest

RUN apt-get update
RUN apt-get install maven
RUN apt-get install git

RUN git clone https://github.com/lpjr03/JAVA_ASD_EXAM

WORKDIR /JAVA_ASD_EXAM

RUN mvn package

CMD [ "java", "-jar", "target/JAVA_ASD-1.0-SNAPSHOT.jar" ]
FROM maven:3.9-amazoncorretto-17-alpine AS build

WORKDIR /app

RUN apk update && apk add --no-cache git
RUN git clone https://github.com/lpjr03/JAVA_ASD_EXAM.git progetto && cd progetto && mvn clean install

FROM amazoncorretto:17-alpine

WORKDIR /app

COPY --from=build /app/progetto/target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
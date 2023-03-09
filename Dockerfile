FROM azul/zulu-openjdk-alpine:17-jre as build

RUN java --version

WORKDIR /app

COPY target/spring-boot-kafka-0.0.1-SNAPSHOT.jar /app/spring-boot-kafka-0.0.1-SNAPSHOT.jar

EXPOSE 8010

RUN printenv

CMD ["java", "-jar", "spring-boot-kafka-0.0.1-SNAPSHOT.jar"]


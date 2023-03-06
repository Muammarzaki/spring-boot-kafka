FROM azul/zulu-openjdk-alpine:17-jre as build

# RUN jlink \
#     --add-modules java.base \
#     --verbose \
#     --strip-debug \
#     --compress 2 \
#     --no-header-files \
#     --no-man-pages \
#     --output /opt/java/jdk-17

RUN java --version
# FROM  alpine:latest 

# COPY --from=build /opt/java/jdk-17  /opt/java/jdk-17

WORKDIR /app

COPY target/spring-boot-kafka-0.0.1-SNAPSHOT.jar /app/spring-boot-kafka.jar

EXPOSE 8080
# ENV PORT=""
# ENV BOOTSTRAP_SERVER=""

CMD [ "java","-jar", "spring-boot-kafka.jar"]
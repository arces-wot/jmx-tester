#How to publish on Docker HUB
# 1) docker build -t vaimeedock/sepa:latest -f Dockerfile .
# 2) docker login -u YOUR-USER-NAME.
# Build command on Apple M1: docker buildx build --platform linux/amd64 --push -t vaimeedock/jmx-test .

#FROM openjdk:20-jdk-oraclelinux7
#FROM openjdk:17
FROM openjdk:8

COPY ./target/jmx-test-0.0.1-SNAPSHOT.jar /jmx.jar
COPY ./src/main/resources/jmxremote.password /jmxremote.password
COPY ./src/main/resources/jmxremote.access /jmxremote.access
COPY ./src/main/resources/jmx.properties /jmx.properties

RUN chmod 600 /jmxremote.password

EXPOSE 7091

ENTRYPOINT ["java","-Dcom.sun.management.jmxremote.rmi.port=7091","-Dcom.sun.management.jmxremote.port=7091","-Djava.rmi.server.hostname=dld.arces.unibo.it","-Dcom.sun.management.jmxremote.host=dld.arces.unibo.it","-Dcom.sun.management.config.file=jmx.properties","-jar","jmx.jar"]
#ENTRYPOINT ["java","-Dcom.sun.management.jmxremote.rmi.port=7091","-Dcom.sun.management.jmxremote.port=7091","-Djava.rmi.server.hostname=0.0.0.0","-Dcom.sun.management.jmxremote.host=0.0.0.0","-jar","jmx.jar"]

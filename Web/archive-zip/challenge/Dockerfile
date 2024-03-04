FROM maven:3.8.4-openjdk-11 AS build

RUN apt-get update && apt-get install -y netcat

WORKDIR /app

RUN mkdir /tmp/unzip

COPY uploadZipRCE .

RUN mvn package

FROM tomcat:9.0-jdk11-openjdk-slim

COPY --from=build /app/target/UploadRCE-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

COPY ./run.sh /

RUN chmod +x /run.sh

CMD ["/run.sh"]

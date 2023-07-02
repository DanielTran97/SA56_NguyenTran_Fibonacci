FROM maven:3.6-openjdk-17

COPY src home/app/src
COPY pom.xml home/app
COPY dropwizard.yml home/app

RUN mvn -f home/app/pom.xml clean package

EXPOSE 8000

CMD ["java", "-jar", "app-1.0-SNAPSHOT.jar", "server", "dropwizard.yml"]
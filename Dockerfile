FROM eclipse-temurin:21-jdk-noble
EXPOSE 8080

WORKDIR /root

COPY ./*.gradle.kts /root
COPY ./gradle/ /root/gradle/
COPY ./gradlew /root
COPY ./src /root/src

RUN ./gradlew build

ENTRYPOINT ["java", "-jar", "/root/build/libs/inventory-0.0.1-SNAPSHOT.jar"]
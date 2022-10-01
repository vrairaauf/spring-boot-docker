FROM openjdk:8
COPY . /src/java
WORKDIR /src/java
RUN mvn install clean
RUN java -jar demo-0.0.1-SNAPSHOT.jar

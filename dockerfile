FROM openjdk:17
EXPOSE 9090
ADD target/shopping-0.0.1-SNAPSHOT.jar shopping-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/shopping-0.0.1-SNAPSHOT.jar"]
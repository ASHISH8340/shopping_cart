FROM openjdk:17
EXPOSE 9090
ADD target/shopping_shop.jar shopping_shop.jar
ENTRYPOINT ["java","-jar","/shopping_shop.jar"]
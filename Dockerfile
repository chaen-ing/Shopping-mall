FROM amazoncorretto:17.0.7-alpine
COPY build/libs/*.jar shoppingmall.jar
ENV TZ Asia/Seoul
ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=prod", "shoppingmall.jar"]
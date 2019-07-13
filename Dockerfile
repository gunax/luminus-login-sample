FROM openjdk:8-alpine

COPY target/uberjar/login-sample.jar /login-sample/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/login-sample/app.jar"]

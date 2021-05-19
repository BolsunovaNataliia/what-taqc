FROM openjdk:8-alpine
ADD target/what-taqc-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar
COPY src/main/java/mySuite.xml test.xml
#CMD ["mkdir", "-p", "test-output"]
ENTRYPOINT ["java", "-jar", "app.jar", "test.xml"]
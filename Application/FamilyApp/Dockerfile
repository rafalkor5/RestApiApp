FROM maven:3.8.5-amazoncorretto-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip=true

#
# Package stage
#
FROM amazoncorretto:17-alpine3.15
COPY --from=build /home/app/target/*.jar /usr/local/lib/demo.jar
EXPOSE 9020
CMD java -jar -Dspring.profiles.active=prod /usr/local/lib/demo.jar

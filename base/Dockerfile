#Build stage

FROM gradle:jdk19 AS BUILD
WORKDIR /usr/app/
COPY . .
RUN gradle clean bootJar -x test

# Package stage

FROM openjdk:19-jdk
ENV JAR_NAME=base-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app
WORKDIR $APP_HOME
COPY --from=BUILD $APP_HOME .
EXPOSE 8181
ENTRYPOINT exec java -jar $APP_HOME/build/libs/$JAR_NAME

# run jar

#FROM openjdk:21-jdk
#ARG JAR_FILE=build/libs/base-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} app.jar
#EXPOSE 8181
#ENTRYPOINT ["java","-jar","/app.jar"]

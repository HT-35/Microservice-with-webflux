FROM eclipse-temurin:21-jdk-alpine as build
WORKDIR /workspace/app

#COPY . /workspace/app
#COPY ../gradlew .
#COPY ../gradle gradle

COPY . .

RUN chmod +x gradlew
RUN ./gradlew build -x test --no-daemon

FROM eclipse-temurin:21-jre-alpine
VOLUME /tmp
COPY --from=build /workspace/app/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8081
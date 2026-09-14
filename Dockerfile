    # Primera parte de construccion de la imagen, compilacion del proyecto y ejecucion de test
FROM gradle:9.2.0-jdk21-alpine AS build

WORKDIR /workspace

COPY gradlew settings.gradle gradle.properties ./
COPY gradle ./gradle
COPY app/build.gradle app/build.gradle


RUN --mount=type=cache,target=/home/gradle/.gradle \
    ./gradlew --no-daemon dependencies

COPY app/src app/src

RUN --mount=type=cache,target=/home/gradle/.gradle \
    ./gradlew --no-daemon clean test jar

    # Desde aqui comienza la ejecucion del jar generado anteriormente
FROM eclipse-temurin:21-jre-alpine AS runtime

WORKDIR /app

VOLUME ["/app/storage"]

COPY --from=build /workspace/app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

CMD ["echo", "Contenedor iniciado, wasaaaa"]

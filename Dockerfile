# Build the application
FROM gradle:8.8.0-jdk21 AS build-image

ARG BUILD_HOME=/app
ENV APP_HOME=$BUILD_HOME
WORKDIR $APP_HOME

# Copy Gradle configuration files and source code
COPY --chown=gradle:gradle build.gradle.kts settings.gradle.kts ${APP_HOME}/
COPY --chown=gradle:gradle src ${APP_HOME}/src

# Build the application
RUN gradle --no-daemon build

# Debugging step: List files in the build directory
RUN ls -la ${APP_HOME}/build/libs

# Run the application with Distroless Java
FROM gcr.io/distroless/java21-debian12:nonroot

EXPOSE 8080
WORKDIR /app

# Copy the built application from the build phase to the run container
COPY --from=build-image ${APP_HOME}/build/libs/shared-mobility-0.0.1-SNAPSHOT.jar application.jar

# Run the JAR file when the container starts
CMD ["application.jar"]

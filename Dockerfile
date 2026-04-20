# Run with Distroless Java
FROM gcr.io/distroless/java21-debian12:nonroot
WORKDIR /app

ARG APP_VERSION
# Copy the built application from the build phase to the run phase
COPY build/libs/shared-mobility-router-$APP_VERSION.jar /app/application.jar

# Metadata and maintenance information
LABEL maintainer="Team Delingsmobilitet"

# Specify which port the application listens on
EXPOSE 8080

# Run the JAR file when the container starts
CMD ["application.jar"]

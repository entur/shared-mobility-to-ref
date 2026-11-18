# Run with Distroless Java
FROM gcr.io/distroless/java25-debian13:nonroot
WORKDIR /app

ARG APP_VERSION
# Copy the built application from the build phase to the run phase
COPY build/libs/shared-mobility-to-ref-$APP_VERSION.jar /app/application.jar

# Metadata and maintenance information
LABEL maintainer="Team Delingsmobilitet"

# Specify which port the application listens on
EXPOSE 8080

# Mitigation for CVE-2026-114938 (Java4Shell): disable the vulnerable Base64 AVX-512 intrinsic.
# Remove once the base image ships a patched OpenJDK 25 (fixed line 25.0.5.1).
ENV JAVA_TOOL_OPTIONS="-XX:-UseBASE64Intrinsics"

# Run the JAR file when the container starts
CMD ["application.jar"]

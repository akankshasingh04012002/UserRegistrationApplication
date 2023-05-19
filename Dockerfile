# Use a base image with a Java runtime environment
FROM sbtscala/scala-sbt:eclipse-temurin-17.0.4_1.7.1_3.2.0
# Set the working directory inside the container
WORKDIR /app

# Copy the SBT build files to the container
COPY build.sbt .
COPY project project

# Download and cache the project dependencies
RUN sbt update

# Copy the source code to the container
COPY . .

# Build the Scala application
RUN sbt compile

# Specify the command to run the application
CMD ["sbt", "run"]

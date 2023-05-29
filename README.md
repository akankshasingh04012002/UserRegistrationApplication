# User Registration Application

This is a user registration application that allows users to register and persist their information in a MySQL database. The application is built using Scala and follows a structured project layout.

User Registration Application with database connection and Integrated Opentelemetry for distributed tracing,configured application to send traces to Jaeger UI.

## The project consists of the following components:

Main.scala: The entry point of the application that initializes the necessary components and executes the application logic.

User.scala: Defines the User model representing a user's information.

Database.scala: Handles the connection and operations with the MySQL database.

UsersTable.scala: Provides functions to create and interact with the users table in the database.

UserService.scala: Contains the UserService class responsible for user registration logic.

## Dependencies
The project relies on the following dependencies:

Scala: The programming language used to write the application.

MySQL Connector/J: A JDBC driver for MySQL database connectivity.

OpenTelemetry API and SDK: Enables tracing and observability in the application.

Jaeger Exporter: Exports traces to the Jaeger UI.

## Prerequisites

Before running the application, ensure you have the following prerequisites:

Scala and SBT installed on your machine.
A MySQL database configured with the necessary credentials.

## Getting Started

To run the user registration application, follow these steps:

Clone the repository: git clone https://github.com/akankshasingh04012002/UserRegistrationApplication

Navigate to the project directory: cd user-registration-app

Update the MySQL database configuration in application.conf located in the resources directory.

Build the project: sbt compile

Run the application: sbt run

## Tracing Configuration

Tracing is enabled in the application using the OpenTelemetry API and SDK. The traces are exported to the Jaeger UI through the Jaeger Exporter. The tracing configuration is set up in the Main.scala file.

The following steps are involved in the tracing configuration:

Import the necessary OpenTelemetry and Jaeger classes.

Configure the Jaeger exporter with the appropriate endpoint.

Create the OpenTelemetry SDK and set the global instance.

Wrap the application logic with a span, add attributes and events, and activate the span.

End the span and close the scope after the application logic completes.

Make sure to replace "your-service-name" with the actual name of your service and update the Jaeger collector endpoint as per your setup.

## Conclusion

The user registration application provides a structured approach to register users and persist their information in a MySQL database. Tracing is enabled using the OpenTelemetry API and SDK, allowing you to monitor and analyze the application's behavior. Traces are exported to the Jaeger UI through the Jaeger exporter, providing observability into the application's performance and behavior.






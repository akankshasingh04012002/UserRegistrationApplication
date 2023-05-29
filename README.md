# User Registration Application

This is a user registration application that allows users to register and persist their information in a MySQL database. The application is built using Scala and follows a structured project layout.

User Registration Application with database connection and Integrated Opentelemetry for distributed tracing,configured application to send traces to Jaeger UI.

## The project consists of the following components:

Main.scala: The entry point of the application that initializes the necessary components and executes the application logic.

ExampleConfiguration.scala: Contains the configurations and implementation for Jaeger tracing.

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

Jaeger tracing system installed and running.


## Jaeger Tracing Configuration

Tracing is enabled in the application using the OpenTelemetry API and SDK. The traces are exported to the Jaeger UI through the Jaeger Exporter. To enable tracing, you need to configure the Jaeger exporter and initialize the tracer in the ExampleConfiguration.scala file. The configuration code is provided as an example, and you may need to customize it based on your specific Jaeger setup.

The following steps are involved in the tracing configuration:

Open the ExampleConfiguration.scala file located in the same package as the Main.scala file.

Import the necessary OpenTelemetry and Jaeger classes.

Ensure that the Jaeger tracing system is running and accessible.

Configure the Jaeger exporter with the appropriate endpoint.

Create the OpenTelemetry SDK and set the global instance.

Wrap the application logic with a span, add attributes and events, and activate the span.

End the span and close the scope after the application logic completes.

Make sure to replace "your-service-name" with the actual name of your service and update the Jaeger collector endpoint as per your setup.

Once the configuration is updated, the application will automatically start generating traces and exporting them to the Jaeger tracing system.

## Application Workflow

The user registration application follows the following workflow:

The application starts by executing the Main.scala file.

The Main.scala file initializes the necessary components, such as the database connection and tracing setup.

The UserService is responsible for handling user registration.

When a new user is registered, the UserService creates a new table in the database if it doesn't exist.

The user information is inserted into the database.

Tracing spans are generated to track the execution flow and record events related to the registration process.


## Getting Started

To run the user registration application, follow these steps:

Clone the repository: git clone https://github.com/akankshasingh04012002/UserRegistrationApplication

Navigate to the project directory: cd user-registration-app

Update the MySQL database configuration in application.conf located in the resources directory.

Build the project: sbt compile

Run the application: sbt run

## Conclusion

The user registration application provides a structured approach to register users and persist their information in a MySQL database. Tracing is enabled using the OpenTelemetry API and SDK, allowing you to monitor and analyze the application's behavior. Traces are exported to the Jaeger UI through the Jaeger exporter, providing observability into the application's performance and behavior.






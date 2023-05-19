ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "DemoRegistration"
  )
libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "8.0.27",
  "com.typesafe" % "config" % "1.4.1"
)

libraryDependencies ++= Seq(
  // OpenTelemetry dependencies
  "io.opentelemetry" % "opentelemetry-api" % "1.7.0",
  "io.opentelemetry" % "opentelemetry-sdk" % "1.7.0",
  "io.opentelemetry" % "opentelemetry-exporter-otlp-trace" % "1.7.0",
  "io.opentelemetry" % "opentelemetry-exporter-jaeger" % "1.7.0",

  // Jaeger dependencies
  "io.jaegertracing" % "jaeger-thrift" % "1.7.0",
  "io.grpc" % "grpc-netty" % "1.40.0",
  "io.grpc" % "grpc-protobuf" % "1.40.0",
  "io.grpc" % "grpc-stub" % "1.40.0"
)

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.6"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % "test"
libraryDependencies += "org.mockito" % "mockito-core" % "3.12.4" % Test

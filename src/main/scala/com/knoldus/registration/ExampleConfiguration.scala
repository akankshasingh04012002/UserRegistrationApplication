package com.knoldus.registration

import io.opentelemetry.api.OpenTelemetry
import io.opentelemetry.api.common.Attributes
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter
import io.opentelemetry.sdk.OpenTelemetrySdk
import io.opentelemetry.sdk.resources.Resource
import io.opentelemetry.sdk.trace.SdkTracerProvider
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes

import java.util.concurrent.TimeUnit

object ExampleConfiguration {

  def initOpenTelemetry(jaegerEndpoint: String): OpenTelemetry = {
    // Export traces to Jaeger over OTLP
    val jaegerOtlpExporter = OtlpGrpcSpanExporter.builder()
      .setEndpoint(jaegerEndpoint)
      .setTimeout(30, TimeUnit.SECONDS)
      .build()

    val serviceNameResource = Resource.create(Attributes.of(ResourceAttributes.SERVICE_NAME, "user-registration-app"))

    // Set to process the spans by the Jaeger Exporter
    val tracerProvider = SdkTracerProvider.builder()
      .addSpanProcessor(BatchSpanProcessor.builder(jaegerOtlpExporter).build())
      .setResource(Resource.getDefault.merge(serviceNameResource))
      .build()

    val openTelemetry = OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).build()

    // It's always a good idea to shut down the SDK cleanly at JVM exit.
    Runtime.getRuntime.addShutdownHook(new Thread(() => openTelemetry.getSdkTracerProvider.shutdown()))

    openTelemetry
  }
}

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: opentelemetry/proto/collector/metrics/v1/metrics_service.proto

package io.opentelemetry.proto.collector.metrics.v1;

public final class MetricsServiceProto {
  private MetricsServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_opentelemetry_proto_collector_metrics_v1_ExportMetricsServiceRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_opentelemetry_proto_collector_metrics_v1_ExportMetricsServiceRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_opentelemetry_proto_collector_metrics_v1_ExportMetricsServiceResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_opentelemetry_proto_collector_metrics_v1_ExportMetricsServiceResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n>opentelemetry/proto/collector/metrics/" +
      "v1/metrics_service.proto\022(opentelemetry." +
      "proto.collector.metrics.v1\032,opentelemetr" +
      "y/proto/metrics/v1/metrics.proto\"h\n\033Expo" +
      "rtMetricsServiceRequest\022I\n\020resource_metr" +
      "ics\030\001 \003(\0132/.opentelemetry.proto.metrics." +
      "v1.ResourceMetrics\"\036\n\034ExportMetricsServi" +
      "ceResponse2\254\001\n\016MetricsService\022\231\001\n\006Export" +
      "\022E.opentelemetry.proto.collector.metrics" +
      ".v1.ExportMetricsServiceRequest\032F.opente" +
      "lemetry.proto.collector.metrics.v1.Expor" +
      "tMetricsServiceResponse\"\000B\217\001\n+io.opentel" +
      "emetry.proto.collector.metrics.v1B\023Metri" +
      "csServiceProtoP\001ZIgithub.com/open-teleme" +
      "try/opentelemetry-proto/gen/go/collector" +
      "/metrics/v1b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          io.opentelemetry.proto.metrics.v1.MetricsProto.getDescriptor(),
        });
    internal_static_opentelemetry_proto_collector_metrics_v1_ExportMetricsServiceRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_opentelemetry_proto_collector_metrics_v1_ExportMetricsServiceRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_opentelemetry_proto_collector_metrics_v1_ExportMetricsServiceRequest_descriptor,
        new java.lang.String[] { "ResourceMetrics", });
    internal_static_opentelemetry_proto_collector_metrics_v1_ExportMetricsServiceResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_opentelemetry_proto_collector_metrics_v1_ExportMetricsServiceResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_opentelemetry_proto_collector_metrics_v1_ExportMetricsServiceResponse_descriptor,
        new java.lang.String[] { });
    io.opentelemetry.proto.metrics.v1.MetricsProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}

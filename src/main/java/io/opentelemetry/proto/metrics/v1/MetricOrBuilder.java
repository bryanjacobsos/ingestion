// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: opentelemetry/proto/metrics/v1/metrics.proto

package io.opentelemetry.proto.metrics.v1;

public interface MetricOrBuilder extends
    // @@protoc_insertion_point(interface_extends:opentelemetry.proto.metrics.v1.Metric)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * name of the metric, including its DNS name prefix. It must be unique.
   * </pre>
   *
   * <code>string name = 1;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <pre>
   * name of the metric, including its DNS name prefix. It must be unique.
   * </pre>
   *
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <pre>
   * description of the metric, which can be used in documentation.
   * </pre>
   *
   * <code>string description = 2;</code>
   * @return The description.
   */
  java.lang.String getDescription();
  /**
   * <pre>
   * description of the metric, which can be used in documentation.
   * </pre>
   *
   * <code>string description = 2;</code>
   * @return The bytes for description.
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <pre>
   * unit in which the metric value is reported. Follows the format
   * described by http://unitsofmeasure.org/ucum.html.
   * </pre>
   *
   * <code>string unit = 3;</code>
   * @return The unit.
   */
  java.lang.String getUnit();
  /**
   * <pre>
   * unit in which the metric value is reported. Follows the format
   * described by http://unitsofmeasure.org/ucum.html.
   * </pre>
   *
   * <code>string unit = 3;</code>
   * @return The bytes for unit.
   */
  com.google.protobuf.ByteString
      getUnitBytes();

  /**
   * <pre>
   * IntGauge and IntSum are deprecated and will be removed soon.
   * 1. Old senders and receivers that are not aware of this change will
   * continue using the `int_gauge` and `int_sum` fields.
   * 2. New senders, which are aware of this change MUST send only `gauge`
   * and `sum` fields.
   * 3. New receivers, which are aware of this change MUST convert these into
   * `gauge` and `sum` by using the provided as_int field in the oneof values.
   * This field will be removed in ~3 months, on July 1, 2021.
   * </pre>
   *
   * <code>.opentelemetry.proto.metrics.v1.IntGauge int_gauge = 4 [deprecated = true];</code>
   * @return Whether the intGauge field is set.
   */
  @java.lang.Deprecated boolean hasIntGauge();
  /**
   * <pre>
   * IntGauge and IntSum are deprecated and will be removed soon.
   * 1. Old senders and receivers that are not aware of this change will
   * continue using the `int_gauge` and `int_sum` fields.
   * 2. New senders, which are aware of this change MUST send only `gauge`
   * and `sum` fields.
   * 3. New receivers, which are aware of this change MUST convert these into
   * `gauge` and `sum` by using the provided as_int field in the oneof values.
   * This field will be removed in ~3 months, on July 1, 2021.
   * </pre>
   *
   * <code>.opentelemetry.proto.metrics.v1.IntGauge int_gauge = 4 [deprecated = true];</code>
   * @return The intGauge.
   */
  @java.lang.Deprecated io.opentelemetry.proto.metrics.v1.IntGauge getIntGauge();
  /**
   * <pre>
   * IntGauge and IntSum are deprecated and will be removed soon.
   * 1. Old senders and receivers that are not aware of this change will
   * continue using the `int_gauge` and `int_sum` fields.
   * 2. New senders, which are aware of this change MUST send only `gauge`
   * and `sum` fields.
   * 3. New receivers, which are aware of this change MUST convert these into
   * `gauge` and `sum` by using the provided as_int field in the oneof values.
   * This field will be removed in ~3 months, on July 1, 2021.
   * </pre>
   *
   * <code>.opentelemetry.proto.metrics.v1.IntGauge int_gauge = 4 [deprecated = true];</code>
   */
  @java.lang.Deprecated io.opentelemetry.proto.metrics.v1.IntGaugeOrBuilder getIntGaugeOrBuilder();

  /**
   * <code>.opentelemetry.proto.metrics.v1.Gauge gauge = 5;</code>
   * @return Whether the gauge field is set.
   */
  boolean hasGauge();
  /**
   * <code>.opentelemetry.proto.metrics.v1.Gauge gauge = 5;</code>
   * @return The gauge.
   */
  io.opentelemetry.proto.metrics.v1.Gauge getGauge();
  /**
   * <code>.opentelemetry.proto.metrics.v1.Gauge gauge = 5;</code>
   */
  io.opentelemetry.proto.metrics.v1.GaugeOrBuilder getGaugeOrBuilder();

  /**
   * <pre>
   * This field will be removed in ~3 months, on July 1, 2021.
   * </pre>
   *
   * <code>.opentelemetry.proto.metrics.v1.IntSum int_sum = 6 [deprecated = true];</code>
   * @return Whether the intSum field is set.
   */
  @java.lang.Deprecated boolean hasIntSum();
  /**
   * <pre>
   * This field will be removed in ~3 months, on July 1, 2021.
   * </pre>
   *
   * <code>.opentelemetry.proto.metrics.v1.IntSum int_sum = 6 [deprecated = true];</code>
   * @return The intSum.
   */
  @java.lang.Deprecated io.opentelemetry.proto.metrics.v1.IntSum getIntSum();
  /**
   * <pre>
   * This field will be removed in ~3 months, on July 1, 2021.
   * </pre>
   *
   * <code>.opentelemetry.proto.metrics.v1.IntSum int_sum = 6 [deprecated = true];</code>
   */
  @java.lang.Deprecated io.opentelemetry.proto.metrics.v1.IntSumOrBuilder getIntSumOrBuilder();

  /**
   * <code>.opentelemetry.proto.metrics.v1.Sum sum = 7;</code>
   * @return Whether the sum field is set.
   */
  boolean hasSum();
  /**
   * <code>.opentelemetry.proto.metrics.v1.Sum sum = 7;</code>
   * @return The sum.
   */
  io.opentelemetry.proto.metrics.v1.Sum getSum();
  /**
   * <code>.opentelemetry.proto.metrics.v1.Sum sum = 7;</code>
   */
  io.opentelemetry.proto.metrics.v1.SumOrBuilder getSumOrBuilder();

  /**
   * <pre>
   * IntHistogram is deprecated and will be removed soon.
   * 1. Old senders and receivers that are not aware of this change will
   * continue using the `int_histogram` field.
   * 2. New senders, which are aware of this change MUST send only `histogram`.
   * 3. New receivers, which are aware of this change MUST convert this into
   * `histogram` by simply converting all int64 values into float.
   * This field will be removed in ~3 months, on July 1, 2021.
   * </pre>
   *
   * <code>.opentelemetry.proto.metrics.v1.IntHistogram int_histogram = 8 [deprecated = true];</code>
   * @return Whether the intHistogram field is set.
   */
  @java.lang.Deprecated boolean hasIntHistogram();
  /**
   * <pre>
   * IntHistogram is deprecated and will be removed soon.
   * 1. Old senders and receivers that are not aware of this change will
   * continue using the `int_histogram` field.
   * 2. New senders, which are aware of this change MUST send only `histogram`.
   * 3. New receivers, which are aware of this change MUST convert this into
   * `histogram` by simply converting all int64 values into float.
   * This field will be removed in ~3 months, on July 1, 2021.
   * </pre>
   *
   * <code>.opentelemetry.proto.metrics.v1.IntHistogram int_histogram = 8 [deprecated = true];</code>
   * @return The intHistogram.
   */
  @java.lang.Deprecated io.opentelemetry.proto.metrics.v1.IntHistogram getIntHistogram();
  /**
   * <pre>
   * IntHistogram is deprecated and will be removed soon.
   * 1. Old senders and receivers that are not aware of this change will
   * continue using the `int_histogram` field.
   * 2. New senders, which are aware of this change MUST send only `histogram`.
   * 3. New receivers, which are aware of this change MUST convert this into
   * `histogram` by simply converting all int64 values into float.
   * This field will be removed in ~3 months, on July 1, 2021.
   * </pre>
   *
   * <code>.opentelemetry.proto.metrics.v1.IntHistogram int_histogram = 8 [deprecated = true];</code>
   */
  @java.lang.Deprecated io.opentelemetry.proto.metrics.v1.IntHistogramOrBuilder getIntHistogramOrBuilder();

  /**
   * <code>.opentelemetry.proto.metrics.v1.Histogram histogram = 9;</code>
   * @return Whether the histogram field is set.
   */
  boolean hasHistogram();
  /**
   * <code>.opentelemetry.proto.metrics.v1.Histogram histogram = 9;</code>
   * @return The histogram.
   */
  io.opentelemetry.proto.metrics.v1.Histogram getHistogram();
  /**
   * <code>.opentelemetry.proto.metrics.v1.Histogram histogram = 9;</code>
   */
  io.opentelemetry.proto.metrics.v1.HistogramOrBuilder getHistogramOrBuilder();

  /**
   * <code>.opentelemetry.proto.metrics.v1.ExponentialHistogram exponential_histogram = 10;</code>
   * @return Whether the exponentialHistogram field is set.
   */
  boolean hasExponentialHistogram();
  /**
   * <code>.opentelemetry.proto.metrics.v1.ExponentialHistogram exponential_histogram = 10;</code>
   * @return The exponentialHistogram.
   */
  io.opentelemetry.proto.metrics.v1.ExponentialHistogram getExponentialHistogram();
  /**
   * <code>.opentelemetry.proto.metrics.v1.ExponentialHistogram exponential_histogram = 10;</code>
   */
  io.opentelemetry.proto.metrics.v1.ExponentialHistogramOrBuilder getExponentialHistogramOrBuilder();

  /**
   * <code>.opentelemetry.proto.metrics.v1.Summary summary = 11;</code>
   * @return Whether the summary field is set.
   */
  boolean hasSummary();
  /**
   * <code>.opentelemetry.proto.metrics.v1.Summary summary = 11;</code>
   * @return The summary.
   */
  io.opentelemetry.proto.metrics.v1.Summary getSummary();
  /**
   * <code>.opentelemetry.proto.metrics.v1.Summary summary = 11;</code>
   */
  io.opentelemetry.proto.metrics.v1.SummaryOrBuilder getSummaryOrBuilder();

  public io.opentelemetry.proto.metrics.v1.Metric.DataCase getDataCase();
}
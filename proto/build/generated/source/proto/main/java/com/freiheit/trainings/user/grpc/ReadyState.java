// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service_state.proto

package com.freiheit.trainings.user.grpc;

/**
 * Protobuf enum {@code tracking.ReadyState}
 */
public enum ReadyState
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>READY = 0;</code>
   */
  READY(0),
  /**
   * <code>STARTING = 1;</code>
   */
  STARTING(1),
  /**
   * <code>FAILURE = 2;</code>
   */
  FAILURE(2),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>READY = 0;</code>
   */
  public static final int READY_VALUE = 0;
  /**
   * <code>STARTING = 1;</code>
   */
  public static final int STARTING_VALUE = 1;
  /**
   * <code>FAILURE = 2;</code>
   */
  public static final int FAILURE_VALUE = 2;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static ReadyState valueOf(int value) {
    return forNumber(value);
  }

  public static ReadyState forNumber(int value) {
    switch (value) {
      case 0: return READY;
      case 1: return STARTING;
      case 2: return FAILURE;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<ReadyState>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      ReadyState> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<ReadyState>() {
          public ReadyState findValueByNumber(int number) {
            return ReadyState.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return com.freiheit.trainings.user.grpc.ServiceStateProto.getDescriptor().getEnumTypes().get(1);
  }

  private static final ReadyState[] VALUES = values();

  public static ReadyState valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private ReadyState(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:tracking.ReadyState)
}


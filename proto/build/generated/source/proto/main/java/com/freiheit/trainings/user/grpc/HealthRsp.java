// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service_state.proto

package com.freiheit.trainings.user.grpc;

/**
 * Protobuf type {@code tracking.HealthRsp}
 */
public  final class HealthRsp extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:tracking.HealthRsp)
    HealthRspOrBuilder {
  // Use HealthRsp.newBuilder() to construct.
  private HealthRsp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private HealthRsp() {
    state_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private HealthRsp(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 8: {
            int rawValue = input.readEnum();

            state_ = rawValue;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.freiheit.trainings.user.grpc.ServiceStateProto.internal_static_tracking_HealthRsp_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.freiheit.trainings.user.grpc.ServiceStateProto.internal_static_tracking_HealthRsp_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.freiheit.trainings.user.grpc.HealthRsp.class, com.freiheit.trainings.user.grpc.HealthRsp.Builder.class);
  }

  public static final int STATE_FIELD_NUMBER = 1;
  private int state_;
  /**
   * <code>.tracking.HealthState state = 1;</code>
   */
  public int getStateValue() {
    return state_;
  }
  /**
   * <code>.tracking.HealthState state = 1;</code>
   */
  public com.freiheit.trainings.user.grpc.HealthState getState() {
    com.freiheit.trainings.user.grpc.HealthState result = com.freiheit.trainings.user.grpc.HealthState.valueOf(state_);
    return result == null ? com.freiheit.trainings.user.grpc.HealthState.UNRECOGNIZED : result;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (state_ != com.freiheit.trainings.user.grpc.HealthState.HEALTHY.getNumber()) {
      output.writeEnum(1, state_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (state_ != com.freiheit.trainings.user.grpc.HealthState.HEALTHY.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, state_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.freiheit.trainings.user.grpc.HealthRsp)) {
      return super.equals(obj);
    }
    com.freiheit.trainings.user.grpc.HealthRsp other = (com.freiheit.trainings.user.grpc.HealthRsp) obj;

    boolean result = true;
    result = result && state_ == other.state_;
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + STATE_FIELD_NUMBER;
    hash = (53 * hash) + state_;
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.freiheit.trainings.user.grpc.HealthRsp parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.freiheit.trainings.user.grpc.HealthRsp parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.freiheit.trainings.user.grpc.HealthRsp parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.freiheit.trainings.user.grpc.HealthRsp parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.freiheit.trainings.user.grpc.HealthRsp parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.freiheit.trainings.user.grpc.HealthRsp parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.freiheit.trainings.user.grpc.HealthRsp parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.freiheit.trainings.user.grpc.HealthRsp parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.freiheit.trainings.user.grpc.HealthRsp parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.freiheit.trainings.user.grpc.HealthRsp parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.freiheit.trainings.user.grpc.HealthRsp prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code tracking.HealthRsp}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:tracking.HealthRsp)
      com.freiheit.trainings.user.grpc.HealthRspOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.freiheit.trainings.user.grpc.ServiceStateProto.internal_static_tracking_HealthRsp_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.freiheit.trainings.user.grpc.ServiceStateProto.internal_static_tracking_HealthRsp_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.freiheit.trainings.user.grpc.HealthRsp.class, com.freiheit.trainings.user.grpc.HealthRsp.Builder.class);
    }

    // Construct using com.freiheit.trainings.user.grpc.HealthRsp.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      state_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.freiheit.trainings.user.grpc.ServiceStateProto.internal_static_tracking_HealthRsp_descriptor;
    }

    public com.freiheit.trainings.user.grpc.HealthRsp getDefaultInstanceForType() {
      return com.freiheit.trainings.user.grpc.HealthRsp.getDefaultInstance();
    }

    public com.freiheit.trainings.user.grpc.HealthRsp build() {
      com.freiheit.trainings.user.grpc.HealthRsp result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.freiheit.trainings.user.grpc.HealthRsp buildPartial() {
      com.freiheit.trainings.user.grpc.HealthRsp result = new com.freiheit.trainings.user.grpc.HealthRsp(this);
      result.state_ = state_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.freiheit.trainings.user.grpc.HealthRsp) {
        return mergeFrom((com.freiheit.trainings.user.grpc.HealthRsp)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.freiheit.trainings.user.grpc.HealthRsp other) {
      if (other == com.freiheit.trainings.user.grpc.HealthRsp.getDefaultInstance()) return this;
      if (other.state_ != 0) {
        setStateValue(other.getStateValue());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.freiheit.trainings.user.grpc.HealthRsp parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.freiheit.trainings.user.grpc.HealthRsp) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int state_ = 0;
    /**
     * <code>.tracking.HealthState state = 1;</code>
     */
    public int getStateValue() {
      return state_;
    }
    /**
     * <code>.tracking.HealthState state = 1;</code>
     */
    public Builder setStateValue(int value) {
      state_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.tracking.HealthState state = 1;</code>
     */
    public com.freiheit.trainings.user.grpc.HealthState getState() {
      com.freiheit.trainings.user.grpc.HealthState result = com.freiheit.trainings.user.grpc.HealthState.valueOf(state_);
      return result == null ? com.freiheit.trainings.user.grpc.HealthState.UNRECOGNIZED : result;
    }
    /**
     * <code>.tracking.HealthState state = 1;</code>
     */
    public Builder setState(com.freiheit.trainings.user.grpc.HealthState value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      state_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.tracking.HealthState state = 1;</code>
     */
    public Builder clearState() {
      
      state_ = 0;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:tracking.HealthRsp)
  }

  // @@protoc_insertion_point(class_scope:tracking.HealthRsp)
  private static final com.freiheit.trainings.user.grpc.HealthRsp DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.freiheit.trainings.user.grpc.HealthRsp();
  }

  public static com.freiheit.trainings.user.grpc.HealthRsp getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<HealthRsp>
      PARSER = new com.google.protobuf.AbstractParser<HealthRsp>() {
    public HealthRsp parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new HealthRsp(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<HealthRsp> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<HealthRsp> getParserForType() {
    return PARSER;
  }

  public com.freiheit.trainings.user.grpc.HealthRsp getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

package com.freiheit.trainings.user.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * We call this API instead of service in order to be able to differentiate between API and service logic.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.16.1)",
    comments = "Source: service_state.proto")
public final class ServiceStateApiGrpc {

  private ServiceStateApiGrpc() {}

  public static final String SERVICE_NAME = "tracking.ServiceStateApi";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.freiheit.trainings.user.grpc.HealthReq,
      com.freiheit.trainings.user.grpc.HealthRsp> getHealthMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Health",
      requestType = com.freiheit.trainings.user.grpc.HealthReq.class,
      responseType = com.freiheit.trainings.user.grpc.HealthRsp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.freiheit.trainings.user.grpc.HealthReq,
      com.freiheit.trainings.user.grpc.HealthRsp> getHealthMethod() {
    io.grpc.MethodDescriptor<com.freiheit.trainings.user.grpc.HealthReq, com.freiheit.trainings.user.grpc.HealthRsp> getHealthMethod;
    if ((getHealthMethod = ServiceStateApiGrpc.getHealthMethod) == null) {
      synchronized (ServiceStateApiGrpc.class) {
        if ((getHealthMethod = ServiceStateApiGrpc.getHealthMethod) == null) {
          ServiceStateApiGrpc.getHealthMethod = getHealthMethod = 
              io.grpc.MethodDescriptor.<com.freiheit.trainings.user.grpc.HealthReq, com.freiheit.trainings.user.grpc.HealthRsp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "tracking.ServiceStateApi", "Health"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.freiheit.trainings.user.grpc.HealthReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.freiheit.trainings.user.grpc.HealthRsp.getDefaultInstance()))
                  .setSchemaDescriptor(new ServiceStateApiMethodDescriptorSupplier("Health"))
                  .build();
          }
        }
     }
     return getHealthMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.freiheit.trainings.user.grpc.ReadyReq,
      com.freiheit.trainings.user.grpc.ReadyRsp> getReadyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Ready",
      requestType = com.freiheit.trainings.user.grpc.ReadyReq.class,
      responseType = com.freiheit.trainings.user.grpc.ReadyRsp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.freiheit.trainings.user.grpc.ReadyReq,
      com.freiheit.trainings.user.grpc.ReadyRsp> getReadyMethod() {
    io.grpc.MethodDescriptor<com.freiheit.trainings.user.grpc.ReadyReq, com.freiheit.trainings.user.grpc.ReadyRsp> getReadyMethod;
    if ((getReadyMethod = ServiceStateApiGrpc.getReadyMethod) == null) {
      synchronized (ServiceStateApiGrpc.class) {
        if ((getReadyMethod = ServiceStateApiGrpc.getReadyMethod) == null) {
          ServiceStateApiGrpc.getReadyMethod = getReadyMethod = 
              io.grpc.MethodDescriptor.<com.freiheit.trainings.user.grpc.ReadyReq, com.freiheit.trainings.user.grpc.ReadyRsp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "tracking.ServiceStateApi", "Ready"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.freiheit.trainings.user.grpc.ReadyReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.freiheit.trainings.user.grpc.ReadyRsp.getDefaultInstance()))
                  .setSchemaDescriptor(new ServiceStateApiMethodDescriptorSupplier("Ready"))
                  .build();
          }
        }
     }
     return getReadyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServiceStateApiStub newStub(io.grpc.Channel channel) {
    return new ServiceStateApiStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServiceStateApiBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ServiceStateApiBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServiceStateApiFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ServiceStateApiFutureStub(channel);
  }

  /**
   * <pre>
   * We call this API instead of service in order to be able to differentiate between API and service logic.
   * </pre>
   */
  public static abstract class ServiceStateApiImplBase implements io.grpc.BindableService {

    /**
     */
    public void health(com.freiheit.trainings.user.grpc.HealthReq request,
        io.grpc.stub.StreamObserver<com.freiheit.trainings.user.grpc.HealthRsp> responseObserver) {
      asyncUnimplementedUnaryCall(getHealthMethod(), responseObserver);
    }

    /**
     */
    public void ready(com.freiheit.trainings.user.grpc.ReadyReq request,
        io.grpc.stub.StreamObserver<com.freiheit.trainings.user.grpc.ReadyRsp> responseObserver) {
      asyncUnimplementedUnaryCall(getReadyMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHealthMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.freiheit.trainings.user.grpc.HealthReq,
                com.freiheit.trainings.user.grpc.HealthRsp>(
                  this, METHODID_HEALTH)))
          .addMethod(
            getReadyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.freiheit.trainings.user.grpc.ReadyReq,
                com.freiheit.trainings.user.grpc.ReadyRsp>(
                  this, METHODID_READY)))
          .build();
    }
  }

  /**
   * <pre>
   * We call this API instead of service in order to be able to differentiate between API and service logic.
   * </pre>
   */
  public static final class ServiceStateApiStub extends io.grpc.stub.AbstractStub<ServiceStateApiStub> {
    private ServiceStateApiStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServiceStateApiStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceStateApiStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServiceStateApiStub(channel, callOptions);
    }

    /**
     */
    public void health(com.freiheit.trainings.user.grpc.HealthReq request,
        io.grpc.stub.StreamObserver<com.freiheit.trainings.user.grpc.HealthRsp> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHealthMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void ready(com.freiheit.trainings.user.grpc.ReadyReq request,
        io.grpc.stub.StreamObserver<com.freiheit.trainings.user.grpc.ReadyRsp> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * We call this API instead of service in order to be able to differentiate between API and service logic.
   * </pre>
   */
  public static final class ServiceStateApiBlockingStub extends io.grpc.stub.AbstractStub<ServiceStateApiBlockingStub> {
    private ServiceStateApiBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServiceStateApiBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceStateApiBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServiceStateApiBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.freiheit.trainings.user.grpc.HealthRsp health(com.freiheit.trainings.user.grpc.HealthReq request) {
      return blockingUnaryCall(
          getChannel(), getHealthMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.freiheit.trainings.user.grpc.ReadyRsp ready(com.freiheit.trainings.user.grpc.ReadyReq request) {
      return blockingUnaryCall(
          getChannel(), getReadyMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * We call this API instead of service in order to be able to differentiate between API and service logic.
   * </pre>
   */
  public static final class ServiceStateApiFutureStub extends io.grpc.stub.AbstractStub<ServiceStateApiFutureStub> {
    private ServiceStateApiFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServiceStateApiFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceStateApiFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServiceStateApiFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.freiheit.trainings.user.grpc.HealthRsp> health(
        com.freiheit.trainings.user.grpc.HealthReq request) {
      return futureUnaryCall(
          getChannel().newCall(getHealthMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.freiheit.trainings.user.grpc.ReadyRsp> ready(
        com.freiheit.trainings.user.grpc.ReadyReq request) {
      return futureUnaryCall(
          getChannel().newCall(getReadyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HEALTH = 0;
  private static final int METHODID_READY = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServiceStateApiImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServiceStateApiImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HEALTH:
          serviceImpl.health((com.freiheit.trainings.user.grpc.HealthReq) request,
              (io.grpc.stub.StreamObserver<com.freiheit.trainings.user.grpc.HealthRsp>) responseObserver);
          break;
        case METHODID_READY:
          serviceImpl.ready((com.freiheit.trainings.user.grpc.ReadyReq) request,
              (io.grpc.stub.StreamObserver<com.freiheit.trainings.user.grpc.ReadyRsp>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ServiceStateApiBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServiceStateApiBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.freiheit.trainings.user.grpc.ServiceStateProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ServiceStateApi");
    }
  }

  private static final class ServiceStateApiFileDescriptorSupplier
      extends ServiceStateApiBaseDescriptorSupplier {
    ServiceStateApiFileDescriptorSupplier() {}
  }

  private static final class ServiceStateApiMethodDescriptorSupplier
      extends ServiceStateApiBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServiceStateApiMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ServiceStateApiGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServiceStateApiFileDescriptorSupplier())
              .addMethod(getHealthMethod())
              .addMethod(getReadyMethod())
              .build();
        }
      }
    }
    return result;
  }
}

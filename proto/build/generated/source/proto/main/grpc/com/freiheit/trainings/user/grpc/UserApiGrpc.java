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
    comments = "Source: users.proto")
public final class UserApiGrpc {

  private UserApiGrpc() {}

  public static final String SERVICE_NAME = "user.UserApi";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.freiheit.trainings.user.grpc.GetUserReq,
      com.freiheit.trainings.user.grpc.GetUserRsp> getGetUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUser",
      requestType = com.freiheit.trainings.user.grpc.GetUserReq.class,
      responseType = com.freiheit.trainings.user.grpc.GetUserRsp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.freiheit.trainings.user.grpc.GetUserReq,
      com.freiheit.trainings.user.grpc.GetUserRsp> getGetUserMethod() {
    io.grpc.MethodDescriptor<com.freiheit.trainings.user.grpc.GetUserReq, com.freiheit.trainings.user.grpc.GetUserRsp> getGetUserMethod;
    if ((getGetUserMethod = UserApiGrpc.getGetUserMethod) == null) {
      synchronized (UserApiGrpc.class) {
        if ((getGetUserMethod = UserApiGrpc.getGetUserMethod) == null) {
          UserApiGrpc.getGetUserMethod = getGetUserMethod = 
              io.grpc.MethodDescriptor.<com.freiheit.trainings.user.grpc.GetUserReq, com.freiheit.trainings.user.grpc.GetUserRsp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "user.UserApi", "GetUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.freiheit.trainings.user.grpc.GetUserReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.freiheit.trainings.user.grpc.GetUserRsp.getDefaultInstance()))
                  .setSchemaDescriptor(new UserApiMethodDescriptorSupplier("GetUser"))
                  .build();
          }
        }
     }
     return getGetUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.freiheit.trainings.user.grpc.GetUsersReq,
      com.freiheit.trainings.user.grpc.GetUsersRsp> getGetUsersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUsers",
      requestType = com.freiheit.trainings.user.grpc.GetUsersReq.class,
      responseType = com.freiheit.trainings.user.grpc.GetUsersRsp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.freiheit.trainings.user.grpc.GetUsersReq,
      com.freiheit.trainings.user.grpc.GetUsersRsp> getGetUsersMethod() {
    io.grpc.MethodDescriptor<com.freiheit.trainings.user.grpc.GetUsersReq, com.freiheit.trainings.user.grpc.GetUsersRsp> getGetUsersMethod;
    if ((getGetUsersMethod = UserApiGrpc.getGetUsersMethod) == null) {
      synchronized (UserApiGrpc.class) {
        if ((getGetUsersMethod = UserApiGrpc.getGetUsersMethod) == null) {
          UserApiGrpc.getGetUsersMethod = getGetUsersMethod = 
              io.grpc.MethodDescriptor.<com.freiheit.trainings.user.grpc.GetUsersReq, com.freiheit.trainings.user.grpc.GetUsersRsp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "user.UserApi", "GetUsers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.freiheit.trainings.user.grpc.GetUsersReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.freiheit.trainings.user.grpc.GetUsersRsp.getDefaultInstance()))
                  .setSchemaDescriptor(new UserApiMethodDescriptorSupplier("GetUsers"))
                  .build();
          }
        }
     }
     return getGetUsersMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserApiStub newStub(io.grpc.Channel channel) {
    return new UserApiStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserApiBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserApiBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserApiFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserApiFutureStub(channel);
  }

  /**
   * <pre>
   * We call this API instead of service in order to be able to differentiate between API and service logic.
   * </pre>
   */
  public static abstract class UserApiImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Returns a user given her/his id can be found.
     * </pre>
     */
    public void getUser(com.freiheit.trainings.user.grpc.GetUserReq request,
        io.grpc.stub.StreamObserver<com.freiheit.trainings.user.grpc.GetUserRsp> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUserMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns all users. No criteria is needed, which may quickly end up in an expensive request.
     * In GRPC there is always a request object to simplify preventing breaking changes.
     * </pre>
     */
    public void getUsers(com.freiheit.trainings.user.grpc.GetUsersReq request,
        io.grpc.stub.StreamObserver<com.freiheit.trainings.user.grpc.GetUsersRsp> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUsersMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.freiheit.trainings.user.grpc.GetUserReq,
                com.freiheit.trainings.user.grpc.GetUserRsp>(
                  this, METHODID_GET_USER)))
          .addMethod(
            getGetUsersMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.freiheit.trainings.user.grpc.GetUsersReq,
                com.freiheit.trainings.user.grpc.GetUsersRsp>(
                  this, METHODID_GET_USERS)))
          .build();
    }
  }

  /**
   * <pre>
   * We call this API instead of service in order to be able to differentiate between API and service logic.
   * </pre>
   */
  public static final class UserApiStub extends io.grpc.stub.AbstractStub<UserApiStub> {
    private UserApiStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserApiStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserApiStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserApiStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns a user given her/his id can be found.
     * </pre>
     */
    public void getUser(com.freiheit.trainings.user.grpc.GetUserReq request,
        io.grpc.stub.StreamObserver<com.freiheit.trainings.user.grpc.GetUserRsp> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns all users. No criteria is needed, which may quickly end up in an expensive request.
     * In GRPC there is always a request object to simplify preventing breaking changes.
     * </pre>
     */
    public void getUsers(com.freiheit.trainings.user.grpc.GetUsersReq request,
        io.grpc.stub.StreamObserver<com.freiheit.trainings.user.grpc.GetUsersRsp> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUsersMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * We call this API instead of service in order to be able to differentiate between API and service logic.
   * </pre>
   */
  public static final class UserApiBlockingStub extends io.grpc.stub.AbstractStub<UserApiBlockingStub> {
    private UserApiBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserApiBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserApiBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserApiBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns a user given her/his id can be found.
     * </pre>
     */
    public com.freiheit.trainings.user.grpc.GetUserRsp getUser(com.freiheit.trainings.user.grpc.GetUserReq request) {
      return blockingUnaryCall(
          getChannel(), getGetUserMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns all users. No criteria is needed, which may quickly end up in an expensive request.
     * In GRPC there is always a request object to simplify preventing breaking changes.
     * </pre>
     */
    public com.freiheit.trainings.user.grpc.GetUsersRsp getUsers(com.freiheit.trainings.user.grpc.GetUsersReq request) {
      return blockingUnaryCall(
          getChannel(), getGetUsersMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * We call this API instead of service in order to be able to differentiate between API and service logic.
   * </pre>
   */
  public static final class UserApiFutureStub extends io.grpc.stub.AbstractStub<UserApiFutureStub> {
    private UserApiFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserApiFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserApiFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserApiFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns a user given her/his id can be found.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.freiheit.trainings.user.grpc.GetUserRsp> getUser(
        com.freiheit.trainings.user.grpc.GetUserReq request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns all users. No criteria is needed, which may quickly end up in an expensive request.
     * In GRPC there is always a request object to simplify preventing breaking changes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.freiheit.trainings.user.grpc.GetUsersRsp> getUsers(
        com.freiheit.trainings.user.grpc.GetUsersReq request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUsersMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER = 0;
  private static final int METHODID_GET_USERS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserApiImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserApiImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USER:
          serviceImpl.getUser((com.freiheit.trainings.user.grpc.GetUserReq) request,
              (io.grpc.stub.StreamObserver<com.freiheit.trainings.user.grpc.GetUserRsp>) responseObserver);
          break;
        case METHODID_GET_USERS:
          serviceImpl.getUsers((com.freiheit.trainings.user.grpc.GetUsersReq) request,
              (io.grpc.stub.StreamObserver<com.freiheit.trainings.user.grpc.GetUsersRsp>) responseObserver);
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

  private static abstract class UserApiBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserApiBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.freiheit.trainings.user.grpc.UserApiProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserApi");
    }
  }

  private static final class UserApiFileDescriptorSupplier
      extends UserApiBaseDescriptorSupplier {
    UserApiFileDescriptorSupplier() {}
  }

  private static final class UserApiMethodDescriptorSupplier
      extends UserApiBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserApiMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserApiGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserApiFileDescriptorSupplier())
              .addMethod(getGetUserMethod())
              .addMethod(getGetUsersMethod())
              .build();
        }
      }
    }
    return result;
  }
}

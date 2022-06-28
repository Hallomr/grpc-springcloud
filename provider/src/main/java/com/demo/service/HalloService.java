package com.demo.service;

import com.coding.grpc.hallo.HalloReq;
import com.coding.grpc.hallo.HalloRes;
import com.coding.grpc.hallo.HalloServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * grpc 外部调用接口
 * @author 
 * @name HalloService
 * @date 2022-06-27 18:40
 */
@GrpcService
public class HalloService extends HalloServiceGrpc.HalloServiceImplBase {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(HalloService.class);


    @Override
    public void sayHello(HalloReq request, StreamObserver<HalloRes> responseObserver) {
        //super.sayHello(request, responseObserver);
        //业务开发
        LOGGER.info("HalloReq name:{},msg:{}",request.getName(),request.getMsg());
        HalloRes halloRes = HalloRes.newBuilder().setCode("200").setMessage("请求成功").build();
        responseObserver.onNext(halloRes);
        responseObserver.onCompleted();
    }
}

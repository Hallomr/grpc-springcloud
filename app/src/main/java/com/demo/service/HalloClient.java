package com.demo.service;

import com.coding.grpc.hallo.HalloReq;
import com.coding.grpc.hallo.HalloRes;
import com.coding.grpc.hallo.HalloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author olym
 * @name HalloClient
 * @date 2022-06-27 19:02
 */
@Component
public class HalloClient {
    private HalloServiceGrpc.HalloServiceBlockingStub halloServiceBlockingStub;

    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6566).usePlaintext().build();
        halloServiceBlockingStub = HalloServiceGrpc.newBlockingStub(managedChannel);
    }

    public HalloRes sayHallo(HalloReq req){
        HalloRes halloRes = halloServiceBlockingStub.sayHello(req);
        return halloRes;
    }
}

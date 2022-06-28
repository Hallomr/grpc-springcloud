package com.demo.controller;

import com.coding.grpc.hallo.HalloReq;
import com.coding.grpc.hallo.HalloRes;
import com.coding.grpc.hallo.HalloServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author olym
 * @name ConsumerContorller
 * @date 2022-06-27 16:41
 */
@RestController
public class ConsumerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerController.class);

    @GrpcClient("provider")
    private HalloServiceGrpc.HalloServiceBlockingStub halloServiceBlockingStub;

    @PostMapping(value = "/hallo")
    public void hallo(String name,String msg){
        HalloRes halloRes = halloServiceBlockingStub.sayHello(HalloReq.newBuilder().setName(name).setMsg(msg).build());
        LOGGER.info("halloRes code:{},msg:{}",halloRes.getCode(),halloRes.getMessage());
    }
}

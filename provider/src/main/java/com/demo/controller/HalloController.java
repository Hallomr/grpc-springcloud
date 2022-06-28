package com.demo.controller;

import com.coding.grpc.hallo.HalloReq;
import com.coding.grpc.hallo.HalloRes;
import com.demo.service.HalloService;
import com.demo.vo.HelloReq;
import com.demo.vo.HelloRes;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 
 * @name HalloController
 * @date 2022-06-28 14:58
 */
@RestController
public class HalloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HalloController.class);

    @PostMapping(value = "/hello")
    public HelloRes sayHello(@RequestBody HelloReq request) {
        //super.sayHello(request, responseObserver);
        //业务开发
        LOGGER.info("HalloReq name:{},msg:{}",request.getName(),request.getMsg());
        HelloRes halloRes = HelloRes.builder().code("200").message("请求成功").build();
        return halloRes;
    }
}

package com.demo.controller;

import com.coding.grpc.hallo.HalloReq;
import com.coding.grpc.hallo.HalloRes;
import com.demo.service.HalloClient;
import com.demo.vo.HelloReq;
import com.demo.vo.HelloRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author olym
 * @name HalloController
 * @date 2022-06-28 9:27
 */
@RestController
public class HalloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HalloController.class);

    @Autowired
    private HalloClient halloClient;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * grpc接口调用测试
     * */
    @PostMapping(value = "/hallo/grpc")
    public void halloGrpc(String name,String msg){
        HalloRes halloRes = halloClient.sayHallo(HalloReq.newBuilder().setName(name).setMsg(msg).build());
        LOGGER.info("grpc halloRes code:{},msg:{}",halloRes.getCode(),halloRes.getMessage());
    }

    /**
     * http接口调用测试
     * */
    @PostMapping(value = "/hallo/http")
    public void halloHttp(String name,String msg){
        HelloReq helloReq = HelloReq.builder().name(name).msg(msg).build();
        //请求地址
        String url = "http://127.0.0.1:8988/hello";
        //发送post请求
        HelloRes helloRes = restTemplate.postForObject(url, helloReq, HelloRes.class);
        LOGGER.info("http halloRes code:{},msg:{}",helloRes.getCode(),helloRes.getMessage());
    }
}

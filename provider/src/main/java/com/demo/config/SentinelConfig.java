package com.demo.config;

import com.alibaba.csp.sentinel.adapter.grpc.SentinelGrpcClientInterceptor;
import com.alibaba.csp.sentinel.adapter.grpc.SentinelGrpcServerInterceptor;
import io.grpc.ClientInterceptor;
import io.grpc.ServerInterceptor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.interceptor.GlobalServerInterceptorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Order(Ordered.LOWEST_PRECEDENCE)
@Configuration
@Slf4j
public class SentinelConfig {
    @Bean
    public ServerInterceptor sentinelGrpcServerInterceptor(){
        return new SentinelGrpcServerInterceptor();
    }
    @Bean
    public GlobalServerInterceptorConfigurer globalInterceptorConfigurerAdapter(ServerInterceptor sentinelGrpcServerInterceptor) {
        return registry -> registry.add(sentinelGrpcServerInterceptor);
    }
}
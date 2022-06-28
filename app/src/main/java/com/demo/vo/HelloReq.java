package com.demo.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author olym
 * @name HelloReq
 * @date 2022-06-28 15:01
 */
@Data
@Builder
public class HelloReq {
    private String name;
    private String msg;
}

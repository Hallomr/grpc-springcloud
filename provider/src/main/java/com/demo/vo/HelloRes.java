package com.demo.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author 
 * @name HelloRes
 * @date 2022-06-28 15:01
 */
@Data
@Builder
public class HelloRes {
    private String code;
    private String message;
}

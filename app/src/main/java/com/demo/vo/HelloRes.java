package com.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 
 * @name HelloRes
 * @date 2022-06-28 15:01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HelloRes {
    private String code;
    private String message;
}

package com.lzl.aoyama.pay.req;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author lzl
 * @Date 2022/1/28 12:00
 * @Description:
 */
@Data
public class PayDto {

    private String payType;

    private BigDecimal price;

    private String comment;

}

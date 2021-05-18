package com.lzl.aoyama.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author lzl
 * @ClassName GlobalException
 * @date: 2021/5/17 上午10:55
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GlobalException extends Exception{

    private String message;

    private String code;


    private  GlobalException(String message) {
        this.message = message;
    }


    // 参数错误 private List<ValidMessage> validMessages;
    public static GlobalException newInstance(Exception e) {
        return new GlobalException(e.getMessage());
    }

    public static GlobalException newInstance(String message) {
        return new GlobalException(message);
    }
}

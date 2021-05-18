package com.lzl.aoyama.common.response;

import cn.hutool.http.HttpStatus;
import com.lzl.aoyama.common.exception.GlobalException;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lzl
 * @ClassName CommonResponse
 * @date: 2021/5/17 上午10:47
 * @Description:
 */
@Data
public class CommonResponse<T> implements Serializable {

    private static final long serialVersionUID = -4328418794860954124L;

    private int code;

    private String message;

    private T data;

    private CommonResponse() {
    }

    private CommonResponse(int code, T data) {
        this.code = code;
        this.data = data;
    }

    private CommonResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(HttpStatus.HTTP_OK, data);
    }

    public static <T> CommonResponse<T> exception(GlobalException e) {
        return new CommonResponse<>(HttpStatus.HTTP_INTERNAL_ERROR, e.getMessage());
    }


    public boolean isSuccess() {
        return this.code == HttpStatus.HTTP_OK;
    }

    public boolean unSuccess() {
        return this.code != HttpStatus.HTTP_OK;
    }

}

package com.lzl.aoyama.common.advice;

import com.lzl.aoyama.common.exception.GlobalException;
import com.lzl.aoyama.common.response.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lzl
 * @ClassName ExceptionAdvice
 * @date: 2021/5/17 上午10:51
 * @Description:
 */
@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {


    /**
     * 用户行为导致的错误
     *
     * @param e
     * @return
     */
    @ExceptionHandler(GlobalException.class)
    public CommonResponse<String> handleEagleException(
            GlobalException e, HttpServletRequest request, HttpServletResponse response) {
        log.error("request-url:{},exception:{}", request.getRequestURI(), e.getMessage());
        return CommonResponse.exception(e);
    }

}

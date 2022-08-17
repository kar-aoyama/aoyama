package com.lzl.aoyama.common.advice;


import com.lzl.aoyama.common.exception.GlobalException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface ExceptionNotifier {

    /**
     * 是否支持处理该异常
     *
     * @param exceptionKey
     * @return
     */
    boolean support(String exceptionKey);

    /**
     * 处理该异常
     *
     * @param e
     * @param request
     */
    void handle(GlobalException e, HttpServletRequest request, HttpServletResponse response);
}

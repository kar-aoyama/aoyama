package com.lzl.aoyama.common.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author lzl
 * @Date 2022/1/20 10:09
 * @Description:
 */
public class BaseController {
    @Autowired
    protected HttpServletResponse response;

}

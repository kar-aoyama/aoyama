package com.lzl.aoyama.user.controller;

import com.lzl.aoyama.common.exception.GlobalException;
import com.lzl.aoyama.common.response.CommonResponse;
import com.lzl.aoyama.user.service.UserService;
import com.lzl.aoyama.user.service.dto.UserAccountDto;
import com.lzl.aoyama.user.service.fegin.UserAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzl
 * @ClassName UserController
 * @date: 2021/5/13 下午2:19
 * @Description:
 */

@RestController
public class UserController implements UserAPI {

    @Autowired
    UserService userService;

    @Override
    public CommonResponse<String> saveUser(UserAccountDto userAccountDto) throws GlobalException {
        return CommonResponse.success(userService.saveUser(userAccountDto));
    }


}

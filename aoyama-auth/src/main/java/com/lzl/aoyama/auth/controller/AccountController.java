package com.lzl.aoyama.auth.controller;

import com.lzl.aoyama.auth.service.AccountService;
import com.lzl.aoyama.auth.api.dto.AccountDto;
import com.lzl.aoyama.auth.api.fegin.AccountAPI;
import com.lzl.aoyama.common.annotation.PermissionCheck;
import com.lzl.aoyama.common.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzl
 * @ClassName AccountController
 * @date: 2021/5/17 下午3:57
 * @Description:
 */

@RestController

public class AccountController implements AccountAPI {

    @Autowired
    AccountService accountService;

    @PermissionCheck(required = false)
    @Override
    public CommonResponse<String> saveAccount(AccountDto accountDto) {
        return CommonResponse.success(accountService.saveAccount(accountDto));
    }
    @PermissionCheck(required = false)
    @Override
    public CommonResponse<Boolean> hasAccount(String phone) {
        return CommonResponse.success(accountService.hasAccount(phone));
    }
}

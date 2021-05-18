package com.lzl.aoyama.auth.service;

import com.lzl.aoyama.auth.api.dto.AccountDto;

/**
 * @author lzl
 * @ClassName AccountService
 * @date: 2021/5/17 下午3:59
 * @Description:
 */
public interface AccountService {
    String saveAccount(AccountDto accountDto);

    boolean hasAccount(String phone);
}

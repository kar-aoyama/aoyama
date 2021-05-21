package com.lzl.aoyama.user.service;

import com.lzl.aoyama.user.service.dto.UserAccountDto;
import com.lzl.aoyama.common.exception.GlobalException;

/**
 * @author lzl
 * @ClassName UserService
 * @date: 2021/5/17 上午10:41
 * @Description:
 */
public interface UserService {


    String saveUser(UserAccountDto userAccountDto) throws GlobalException;
}

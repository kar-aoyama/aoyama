package com.lzl.aoyama.user.api;

import com.lzl.aoyama.common.exception.GlobalException;
import com.lzl.aoyama.user.api.dto.UserAccountDto;

/**
 * @author lzl
 * @ClassName UserService
 * @date: 2021/5/17 上午10:41
 * @Description:
 */
public interface UserService {


    String saveUser(UserAccountDto userAccountDto) throws GlobalException;
}

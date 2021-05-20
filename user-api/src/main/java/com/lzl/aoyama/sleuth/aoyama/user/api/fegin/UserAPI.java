package com.lzl.aoyama.sleuth.aoyama.user.api.fegin;

import com.lzl.aoyama.sleuth.aoyama.common.annotation.PermissionCheck;
import com.lzl.aoyama.sleuth.aoyama.common.exception.GlobalException;
import com.lzl.aoyama.sleuth.aoyama.common.response.CommonResponse;
import com.lzl.aoyama.sleuth.aoyama.user.api.dto.UserAccountDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lzl
 * @ClassName UserAPI
 * @date: 2021/4/26 下午3:02
 * @Description:
 */


@RequestMapping("/user")
public interface UserAPI {

    @PermissionCheck(required = false)
    @PostMapping(value = "/saveUser")
    CommonResponse<String> saveUser(@RequestBody UserAccountDto userAccountDto) throws GlobalException;


}

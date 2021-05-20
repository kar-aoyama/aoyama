package com.lzl.aoyama.auth.api.fegin;

import com.lzl.aoyama.auth.api.dto.AccountDto;
import com.lzl.aoyama.sleuth.aoyama.common.response.CommonResponse;
import org.springframework.web.bind.annotation.*;

/**
 * @author lzl
 * @ClassName AccountAPI
 * @date: 2021/5/17 下午2:36
 * @Description:
 */

@RequestMapping(value = "/auth")
public interface AccountAPI {

    @PostMapping(value = "saveAccount")
    CommonResponse<String> saveAccount(@RequestBody AccountDto accountDto);

    @GetMapping(value = "hasAccount")
    CommonResponse<Boolean> hasAccount(@RequestParam(name = "phone")  String phone);
}

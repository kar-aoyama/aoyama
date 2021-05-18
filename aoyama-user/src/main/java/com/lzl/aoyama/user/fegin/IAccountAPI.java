package com.lzl.aoyama.user.fegin;

import com.lzl.aoyama.auth.api.dto.AccountDto;
import com.lzl.aoyama.auth.api.fegin.AccountAPI;
import com.lzl.aoyama.common.response.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author lzl
 * @ClassName IAccountAPI
 * @date: 2021/5/17 下午2:58
 * @Description:
 */
@FeignClient(value = "auth", contextId = "accountAPI")
public interface IAccountAPI extends AccountAPI {
}

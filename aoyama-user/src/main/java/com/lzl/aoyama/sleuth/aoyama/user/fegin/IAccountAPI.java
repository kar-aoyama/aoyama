package com.lzl.aoyama.sleuth.aoyama.user.fegin;

import com.lzl.aoyama.auth.api.fegin.AccountAPI;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author lzl
 * @ClassName IAccountAPI
 * @date: 2021/5/17 下午2:58
 * @Description:
 */
@FeignClient(name = "auth", contextId = "accountAPI")
public interface IAccountAPI extends AccountAPI {
}

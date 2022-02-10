package com.lzl.aoyama.auth.feign;

import com.lzl.aoyama.user.service.fegin.UserAPI;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author lzl
 * @ClassName UserAPI
 * @date: 2021/4/26 下午2:50
 * @Description:
 */
@FeignClient(name = "user", contextId = "userAPI")
public interface IUserAPI extends UserAPI {
}

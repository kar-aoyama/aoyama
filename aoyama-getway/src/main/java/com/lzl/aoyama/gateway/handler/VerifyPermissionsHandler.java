/*
package com.lzl.aoyama.gateway.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;


*/
/**
 * @author lzl
 * @ClassName VerifyPermissions
 * @date: 2021/4/14 下午4:14
 * @Description:
 *//*

@Component
public class VerifyPermissionsHandler {




    AntPathMatcher antPathMatcher = new AntPathMatcher();

    public boolean hasPermission(Authentication authentication) {
        return true;
    }


   */
/* private boolean checkPermissions(HttpServletRequest request, Authentication authentication) {
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        String userId = authentication.getName();
        List<UserAuthorityEntity> authorityList = userAuthorityService.findByAccountIdAndMethod(userId, method);
        if (CollUtil.isNotEmpty(authorityList)) {
            Optional<UserAuthorityEntity> optional = authorityList.stream()
                    .filter(Objects::nonNull)
                    .filter(
                            e -> antPathMatcher.match(e.getActionUrl(), requestURI)
                                    && StrUtil.equalsIgnoreCase(e.getMethod(), method)
                    )
                    .findAny();
            return optional.isPresent();
        }
        return false;
    }


    private boolean isNoAuthority(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        BoundHashOperations<String, String, Set<String>> ops = getUrls(UrlType.NO_AUTHORITY);
        Set<String> noAuthrity = ops.get(UrlType.NO_AUTHORITY);
        if (CollUtil.isEmpty(noAuthrity)) {
            return false;
        }
        if (noAuthrity.contains(requestURI)) {
            return true;
        }
        return false;
    }

    public BoundHashOperations<String, String, Set<String>> getUrls(UrlType urlType) {
        return redisTemplate.boundHashOps(urlType.name());
    }*//*


}
*/

package com.lzl.aoyama.auth.handler;

import cn.hutool.core.util.StrUtil;
import com.lzl.aoyama.auth.entity.AccountEntity;
import com.lzl.aoyama.auth.entity.UserDetailDto;
import com.lzl.aoyama.auth.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author lzl
 * @ClassName UserDetailServiceHandler
 * @date: 2021/5/14 下午4:45
 * @Description:
 */
@Slf4j
@Component(value = "userDetailServiceHandler")
public class UserDetailServiceHandler implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StrUtil.isEmpty(username)) {
            throw new UsernameNotFoundException("账号名不能为空");
        }
        Optional<AccountEntity> optional = accountRepository.findByAccountId(username);
        if (optional.isEmpty()) {
            throw new UsernameNotFoundException("未找到当前用户");
        }
        AccountEntity authAccount = optional.get();
        return converterUserDetailDto(authAccount);
    }

    private UserDetailDto converterUserDetailDto(AccountEntity authAccount) {
        return new UserDetailDto(
                authAccount.getId(),
                authAccount.getAccountId(),
                authAccount.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_USER"));
    }
}

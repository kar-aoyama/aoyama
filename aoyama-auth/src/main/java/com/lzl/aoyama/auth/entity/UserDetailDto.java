package com.lzl.aoyama.auth.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.security.Principal;
import java.util.Collection;


/**
 * @author lzl
 * @ClassName UserDetailDto
 * @date: 2021/5/14 下午5:23
 * @Description:
 */
@Setter
@Getter
public class UserDetailDto extends User implements Principal {

    private String id;

    private String accountId;

    private String password;


    public UserDetailDto(String id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.accountId = username;
        this.password = password;
        this.id = id;
    }


    @Override
    public String getName() {
        return accountId;
    }

}

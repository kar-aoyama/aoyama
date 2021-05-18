package com.lzl.aoyama.user.api.dto;

import lombok.Data;

/**
 * @author lzl
 * @ClassName UserAccount
 * @date: 2021/5/17 下午1:56
 * @Description:
 */
@Data
public class UserAccountDto {

    private String phone;

    private String password;

    private String idCardNo;

    private String email;

    private String chinaName;
}

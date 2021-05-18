package com.lzl.aoyama.auth.api.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author lzl
 * @ClassName AccountDto
 * @date: 2021/5/17 下午2:39
 * @Description:
 */
@Data
public class AccountDto {

    //id
    private String id;

    //账号
    private String accountId;

    //手机号
    private String phone;

    //密码
    private String password;

    //邮箱
    private String email;

    //身份证
    private String idCardNo;

    //修改时间
    private Timestamp createTime;

    //创建时间
    private Timestamp updateTime;

}

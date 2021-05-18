package com.lzl.aoyama.auth.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author lzl
 * @ClassName UserAccount
 * @date: 2021/5/14 下午5:28
 * @Description:
 */
@Data
@Entity
@Table(name = "auth_account")
public class AccountEntity {

    @Id
    @Column(name = "id")
    private String id;

    /**
     * 账号名
     */
    @Column(name = "account_id")
    private String accountId;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 手机号码
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 电子邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 身份证号
     */
    @Column(name = "id_card_no")
    private String idCardNo;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Timestamp createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Timestamp updateTime;
}

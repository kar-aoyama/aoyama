package com.lzl.aoyama.sleuth.aoyama.user.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author lzl
 * @ClassName UserEntity
 * @date: 2021/5/17 上午10:42
 * @Description:
 */
@Data
@Entity
@Table(name = "user_account")
public class UserEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "id_card_no")
    private String idCardNo;

    @Column(name = "email")
    private String email;

    @Column(name = "isAvailable")
    private Boolean isAvailable;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "update_time")
    private Timestamp updateTime;
}

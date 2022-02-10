package com.lzl.aoyama.pay.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @Author lzl
 * @Date 2022/2/6 23:41
 * @Description:
 */
@Data
@Entity
@Table(name = "pay_record")
public class PayRecordEntity {
    @Id
    private String id;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "status")
    private String status;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "update_time")
    private Timestamp updateTime;

    @Column(name = "update_user")
    private String updateUser;

}

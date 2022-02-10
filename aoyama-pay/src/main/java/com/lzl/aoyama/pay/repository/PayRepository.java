package com.lzl.aoyama.pay.repository;

import com.lzl.aoyama.pay.entity.PayRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author lzl
 * @Date 2022/2/6 23:44
 * @Description:
 */
@Repository
public interface PayRepository extends JpaRepository<PayRecordEntity, String> {
}

package com.lzl.aoyama.auth.repository;

import com.lzl.aoyama.auth.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author lzl
 * @ClassName AccountRepository
 * @date: 2021/5/17 下午1:36
 * @Description:
 */
@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, String> {

    Optional<AccountEntity> findByAccountId(String username);
}

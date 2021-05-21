package com.lzl.aoyama.user.repository;

import com.lzl.aoyama.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lzl
 * @ClassName UserRepository
 * @date: 2021/5/17 上午11:56
 * @Description:
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {




}

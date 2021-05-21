package com.lzl.aoyama.auth.service.impl;

import com.lzl.aoyama.auth.service.AccountService;
import com.lzl.aoyama.auth.api.dto.AccountDto;
import com.lzl.aoyama.auth.entity.AccountEntity;
import com.lzl.aoyama.auth.repository.AccountRepository;
import com.lzl.aoyama.common.util.UUidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author lzl
 * @ClassName AccountServiceImpl
 * @date: 2021/5/17 下午3:59
 * @Description:
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public String saveAccount(AccountDto accountDto) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountId(accountDto.getAccountId());
        accountEntity.setEmail(accountDto.getEmail());
        accountEntity.setIdCardNo(accountDto.getIdCardNo());
        accountEntity.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        accountEntity.setId(UUidUtil.uid());
        accountEntity.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        accountEntity.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        accountEntity.setPhone(accountDto.getAccountId());
        accountRepository.save(accountEntity);
        return "SUCCESS";
    }

    @Override
    public boolean hasAccount(String phone) {
        Optional<AccountEntity> optional = accountRepository.findByAccountId(phone);
        if (optional.isPresent()) {
            return false;
        }
        return true;
    }
}

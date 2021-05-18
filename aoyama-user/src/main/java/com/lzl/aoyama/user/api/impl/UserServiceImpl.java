package com.lzl.aoyama.user.api.impl;

import com.lzl.aoyama.auth.api.dto.AccountDto;
import com.lzl.aoyama.common.exception.GlobalException;
import com.lzl.aoyama.common.response.CommonResponse;
import com.lzl.aoyama.common.util.UUidUtil;
import com.lzl.aoyama.user.fegin.IAccountAPI;
import com.lzl.aoyama.user.api.dto.UserAccountDto;
import com.lzl.aoyama.user.entity.UserEntity;
import com.lzl.aoyama.user.api.UserService;
import com.lzl.aoyama.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author lzl
 * @ClassName UserServiceImpl
 * @date: 2021/5/17 上午10:42
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IAccountAPI accountAPI;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public String saveUser(UserAccountDto userAccountDto) throws GlobalException {
        CommonResponse<Boolean> response = accountAPI.hasAccount(userAccountDto.getPhone());
        if (response.unSuccess()) {
            throw GlobalException.newInstance("校验手机号是否注册异常");
        }
        if (!response.getData()) {
            throw GlobalException.newInstance("手机号已注册");
        }

        AccountDto account = createAccount(userAccountDto);
        CommonResponse<String> authResponse = accountAPI.saveAccount(account);
        if (authResponse.unSuccess()) {
            throw GlobalException.newInstance("注册账号发生异常");
        }

        UserEntity userEntity = converterUserEntiry(userAccountDto);
        userRepository.save(userEntity);
        return "SUCCESS";
    }

    private UserEntity converterUserEntiry(UserAccountDto userAccountDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUidUtil.uid("us"));
        userEntity.setEmail(userAccountDto.getEmail());
        userEntity.setIdCardNo(userAccountDto.getIdCardNo());
        userEntity.setIsAvailable(Boolean.TRUE);
        userEntity.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        userEntity.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        return userEntity;
    }

    private AccountDto createAccount(UserAccountDto userAccountDto) {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(userAccountDto.getPhone());
        accountDto.setPhone(userAccountDto.getPhone());
        accountDto.setPassword(userAccountDto.getPassword());
        accountDto.setEmail(userAccountDto.getEmail());
        accountDto.setIdCardNo(userAccountDto.getIdCardNo());
        accountDto.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        accountDto.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        return accountDto;
    }

}

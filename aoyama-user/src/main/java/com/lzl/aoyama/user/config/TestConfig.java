package com.lzl.aoyama.user.config;

import com.lzl.aoyama.user.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

/**
 * @author lzl
 * @ClassName TestConfig
 * @date: 2021/6/2 上午10:37
 * @Description:
 */
@Slf4j
@Configuration
public class TestConfig {

    @Bean
    public UserEntity a() {
        log.info("初始化 userEntity");
        return new UserEntity();
    }


}

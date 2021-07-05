package com.lzl.aoyama.user.annotation;

import com.lzl.aoyama.user.config.TestConfig;
import com.lzl.aoyama.user.selector.TestSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author lzl
 * @ClassName EnableConfig
 * @date: 2021/6/2 上午10:35
 * @Description:
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(TestSelector.class)
public @interface EnableConfig {

}

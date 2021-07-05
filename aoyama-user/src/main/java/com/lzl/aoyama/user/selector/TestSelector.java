package com.lzl.aoyama.user.selector;

import com.lzl.aoyama.user.annotation.EnableConfig;
import com.lzl.aoyama.user.config.TestConfig;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lzl
 * @ClassName TestSelector
 * @date: 2021/6/2 上午11:01
 * @Description:
 */
public class TestSelector implements ImportSelector, DeferredImportSelector {

    private static final Map<String, Object> concurrentHashMap = new ConcurrentHashMap<>();

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        importingClassMetadata.getAnnotationAttributes(EnableConfig.class.getName());

       // maps.forEach(concurrentHashMap::put);
        return new String[]{TestConfig.class.getName()};
    }
}

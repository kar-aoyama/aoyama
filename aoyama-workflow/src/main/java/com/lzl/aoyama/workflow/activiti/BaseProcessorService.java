package com.lzl.aoyama.workflow.activiti;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * @author lzl
 * @ClassName BaseProcessor
 * @date: 2021/7/23 下午4:59
 * @Description:
 */
public abstract class BaseProcessorService {

    @Autowired

    //在依赖注入后执行
    @PostConstruct
    void init(){

    }

    //钩子方法 留着给子类实现
    protected abstract String processorKey();
}

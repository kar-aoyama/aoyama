package com.lzl.aoyama.workflow.activiti;

import org.activiti.engine.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author lzl
 * @ClassName AbstractActivitiService
 * @date: 2021/7/23 下午5:25
 * @Description:
 */
public class AbstractActivitiService implements ApplicationContextAware {


    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private FormService formService;

    @Autowired
    private HistoryService historyService;

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

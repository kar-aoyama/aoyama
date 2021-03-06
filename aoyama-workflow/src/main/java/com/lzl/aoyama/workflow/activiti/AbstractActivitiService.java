package com.lzl.aoyama.workflow.activiti;

import com.lzl.aoyama.workflow.activiti.service.IActivitiService;
import org.activiti.engine.*;
import org.activiti.engine.task.Task;
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
public class AbstractActivitiService implements ApplicationContextAware, IActivitiService {


    @Autowired
    protected RuntimeService runtimeService;

    @Autowired
    protected RepositoryService repositoryService;

    @Autowired
    protected TaskService taskService;

    @Autowired
    protected FormService formService;

    @Autowired
    protected HistoryService historyService;

    protected ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 获取task代办
     *
     * @param taskId 代办任务id
     * @param userId 执行人id
     * @return
     */
    @Override
    public Task queryTask(String taskId, String userId) {
        return taskService.createTaskQuery()
                .taskId(taskId)
                .taskAssignee(userId).singleResult();
    }
}

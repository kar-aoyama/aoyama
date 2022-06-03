package com.lzl.aoyama.workflow.listen;

import cn.hutool.core.collection.CollUtil;
import com.lzl.aoyama.common.util.ApplicationHolder;
import com.lzl.aoyama.workflow.activiti.AbstractElement;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

/**
 * @author lzl
 * @date 2021/9/7 17:23
 * @Description:
 */
@Component
public class ActivitiTaskListen implements TaskListener, ExecutionListener {


    @Override
    public void notify(DelegateExecution execution) {
        Map<String, AbstractElement> elementMap =
                ApplicationHolder.getApplicationContext().getBeansOfType(AbstractElement.class);
        if (CollUtil.isEmpty(elementMap)) {
            return;
        }
        //获取当前正在执行的ActivitiId
        String currentActivityId = execution.getCurrentActivityId();
        AbstractElement abstractElement = elementMap.get(currentActivityId);
        if (Objects.nonNull(abstractElement)) {
            abstractElement.notify(execution);
        }
    }

    @Override
    public void notify(DelegateTask delegateTask) {
        //不同的Handler 实现 UserTaskListen  从而获取不同的流程节点handler
        DelegateExecution execution = delegateTask.getExecution();
        UserTaskListen userTaskHandler = ApplicationHolder.getApplicationContext().getBean(execution.getProcessInstanceBusinessKey(), UserTaskListen.class);
        userTaskHandler.notify(delegateTask);
    }
}

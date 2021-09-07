package com.lzl.aoyama.workflow.listen;

import cn.hutool.core.collection.CollUtil;
import com.lzl.aoyama.common.util.ApplicationHolder;
import com.lzl.aoyama.workflow.activiti.AbstractElement;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.delegate.TaskListener;

import java.util.Map;
import java.util.Objects;

/**
 * @author simba@onlying.cn
 * @date 2021/9/7 17:23
 * @Description:
 */
public class ActivitiTaskListen implements TaskListener, ExecutionListener {


    @Override
    public void notify(DelegateExecution execution) {
        Map<String, AbstractElement> handlerMap =
                ApplicationHolder.getApplicationContext().getBeansOfType(AbstractElement.class);
        if (CollUtil.isEmpty(handlerMap)){
            return;
        }
        //获取执行流程节点id
        String id = execution.getId();
        AbstractElement element = handlerMap.get(id);
    }

    @Override
    public void notify(DelegateTask delegateTask) {
        //不同的Handler 实现 UserTaskListen  从而获取不同的流程节点handler
        UserTaskListen userTaskHandler = ApplicationHolder.getApplicationContext().getBean(execution.getProcessInstanceBusinessKey(), UserTaskListen.class);
        if (Objects.nonNull(userTaskHandler)) {
            userTaskHandler.notify(delegateTask);
        }
    }
}

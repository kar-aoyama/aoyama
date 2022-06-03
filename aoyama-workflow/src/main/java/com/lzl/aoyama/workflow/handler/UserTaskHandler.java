package com.lzl.aoyama.workflow.handler;

import com.lzl.aoyama.workflow.activiti.AbstractTaskHandler;
import com.lzl.aoyama.workflow.api.dto.AbstractTaskInfo;
import com.lzl.aoyama.workflow.api.dto.ExecutionPerson;
import com.lzl.aoyama.workflow.listen.UserTaskListen;
import org.activiti.engine.delegate.DelegateTask;

import java.util.Map;

/**
 * @author lzl
 * @date 2021/9/7 17:34
 * @Description:
 */
public class UserTaskHandler extends AbstractTaskHandler implements UserTaskListen {

    @Override
    public void processData() {

    }

    @Override
    public void completeTaskBefore(String businessKey, ExecutionPerson executionPerson, Map<String, Object> nodeDataMap, Map<String, Object> variableMap) {
        
    }

    @Override
    public void complete(AbstractTaskInfo taskInfo) {

    }

    @Override
    public void completeTaskAfter(String businessKey, ExecutionPerson executionPerson, Map<String, Object> nodeDataMap, Map<String, Object> variableMap) {

    }

    @Override
    public void taskNodeData() {

    }

    @Override
    public void notify(DelegateTask delegateTask) {
        //回去流程定义id 通过流程定义id去查代办人
        String processDefinitionId = delegateTask.getProcessDefinitionId();

    }
}

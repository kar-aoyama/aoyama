package com.lzl.aoyama.workflow.activiti;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.base.Preconditions;
import com.lzl.aoyama.common.exception.GlobalException;
import com.lzl.aoyama.workflow.api.dto.ExecutionPerson;
import com.lzl.aoyama.workflow.handler.UserTaskHandler;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.StartEvent;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author lzl
 * @ClassName BaseProcessor
 * @date: 2021/7/23 下午4:59
 * @Description:
 */
public abstract class BaseProcessorService extends AbstractActivitiService {

    //流程节点定义
    private ProcessDefinition processDefinition;

    //流程flow
    private Collection<FlowElement> flowElements;

    //启动事件
    private StartEvent startEvent;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private Map<String, UserTaskHandler> handlerMap = new HashMap<>();

    //在依赖注入后执行
    @PostConstruct
    void init() {
        //不同的子类实现获取不同的流程定义
        processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey(processorKey()).singleResult();
        //通过不同流程定义id 获取流程实例id
        BpmnModel bpmnModel = repositoryService.getBpmnModel(processDefinition.getId());
        //获取流程
        Process process = bpmnModel.getProcessById(processorKey());
        //获取所有流程节点
        flowElements = process.getFlowElements();
        //获取启动时间
        startEvent = (StartEvent) process.getInitialFlowElement();
    }

    //钩子方法 留着给子类实现
    protected abstract String processorKey();

    //启动流程
    public void startProcess(String processDefinitionKey, String businessKey,
                             ExecutionPerson execution,
                             Map<String, Object> nodeDataMap, Map<String, Object> variableMap) {
        Preconditions.checkArgument(StrUtil.isBlankIfStr(businessKey), "businessKey is empty");
        // startProcessBefore
        startProcessBefore(processorKey(), businessKey, execution, nodeDataMap, variableMap);
        //逻辑
        // startProcessAfter
        startProcessAfter(processorKey(), businessKey, execution, nodeDataMap, variableMap);
    }

    public void startProcessBefore(String processDefinitionKey, String businessKey,
                                   ExecutionPerson executionPerson,
                                   Map<String, Object> nodeDataMap, Map<String, Object> variableMap) {

    }

    public void startProcessAfter(String processDefinitionKey, String businessKey,
                                  ExecutionPerson executionPerson,
                                  Map<String, Object> nodeDataMap, Map<String, Object> variableMap) {

    }

    //完成代办任务执行
    public void completeTask(String taskId,
                             String businessKey,
                             ExecutionPerson executionPerson,
                             Map<String, Object> nodeDataMap,
                             Map<String, Object> variableMap) throws GlobalException {
        //执行人id
        String executionPersonId = executionPerson.getId();
        Preconditions.checkArgument(StrUtil.isBlank(taskId), "taskId is empty");
        Task task = queryTask(taskId, executionPersonId);
        Preconditions.checkArgument(Objects.isNull(task), "task not found");
        //获取task 定义key
        String taskDefinitionKey = task.getTaskDefinitionKey();
        UserTaskHandler userTaskHandler = handlerMap.get(taskDefinitionKey);
        if (Objects.isNull(userTaskHandler)) {
            throw GlobalException.newInstance("userTaskHandler not Found");
        }

        userTaskHandler.completeTaskBefore(businessKey, executionPerson, nodeDataMap, variableMap);
        // completeTaskBefore
        //逻辑
        //completeTaskAfter
        if (CollUtil.isNotEmpty(variableMap)) {
            taskService.complete(taskId, variableMap);
        } else {
            taskService.complete(taskId);
        }
        userTaskHandler.completeTaskAfter(businessKey, executionPerson, nodeDataMap, variableMap);
    }

}

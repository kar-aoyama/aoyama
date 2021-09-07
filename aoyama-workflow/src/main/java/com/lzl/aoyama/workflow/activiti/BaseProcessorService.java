package com.lzl.aoyama.workflow.activiti;

import cn.hutool.core.util.StrUtil;
import com.google.common.base.Preconditions;
import com.lzl.aoyama.workflow.api.dto.ExecutionPerson;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.StartEvent;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Map;

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
        Preconditions.checkArgument(StrUtil.isBlankIfStr(businessKey),"businessKey is empty");
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
    public void completeTask(String businessKey,
                             ExecutionPerson executionPerson,
                             Map<String, Object> nodeDataMap, Map<String, Object> variableMap) {
        //执行人id
        String executionId = executionPerson.getId();

        completeTaskBefore(processorKey(), businessKey, , nodeDataMap, variableMap);
        // completeTaskBefore
        //逻辑
        //completeTaskAfter
        completeTaskAfter(processorKey(), businessKey, executionPerson, nodeDataMap, variableMap);
    }

    public void completeTaskBefore(String processDefinitionKey, String businessKey,
                                   ExecutionPerson executionPerson,
                                   Map<String, Object> nodeDataMap, Map<String, Object> variableMap) {

    }

    public void completeTaskAfter(String processDefinitionKey, String businessKey,
                                  ExecutionPerson executionPerson,
                                  Map<String, Object> nodeDataMap, Map<String, Object> variableMap) {

    }
}

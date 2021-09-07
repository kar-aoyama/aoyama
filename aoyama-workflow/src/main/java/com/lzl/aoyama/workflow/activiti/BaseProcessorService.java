package com.lzl.aoyama.workflow.activiti;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.StartEvent;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Collection;

/**
 * @author lzl
 * @ClassName BaseProcessor
 * @date: 2021/7/23 下午4:59
 * @Description:
 */
public abstract class BaseProcessorService {

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
    public void startProcess(){
        // startProcessBefore
        //逻辑
        // startProcessAfter
    }

    //完成代办任务执行
    public void completeTask(){
        // completeTaskBefore
        //逻辑
        //completeTaskAfter
    }

}

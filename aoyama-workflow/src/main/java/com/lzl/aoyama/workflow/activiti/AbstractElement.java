package com.lzl.aoyama.workflow.activiti;

import com.google.common.collect.Maps;
import org.activiti.engine.delegate.DelegateExecution;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author lzl
 * @date 2021/9/7 17:31
 * @Description:
 */
public abstract class AbstractElement {


    public void notify(DelegateExecution execution) {
        Map<Object, Object> variablesMap = Maps.newHashMap();
        Map<Object, Object> nodeDataMap = Maps.newHashMap();
        beforeExecution(execution, variablesMap, nodeDataMap);
        execute(execution, variablesMap, nodeDataMap);
        afterExecution(execution, variablesMap, nodeDataMap);
    }

    /**
     * 执行流程节点前执行
     *
     * @param execution
     * @param variablesMap
     * @param nodeDataMap
     */
    protected void beforeExecution(DelegateExecution execution, Map<Object, Object> variablesMap, Map<Object, Object> nodeDataMap) {
        //正在执行的task key
        String taskDefinitionKey = execution.getCurrentActivityId();
        Object key = execution.getVariable("processDefinitionKey");
        String processDefinitionKey = null;
        if (Objects.nonNull(key)) {
            processDefinitionKey = key.toString();
        }
        //待扩展  可以拿到processDefinitionKey 方便去操作  比如去数据库读取默认代办人

    }

    /**
     * 执行流程节点
     *
     * @param execution
     * @param variablesMap
     * @param nodeDataMap
     */
    protected void execute(DelegateExecution execution, Map<Object, Object> variablesMap, Map<Object, Object> nodeDataMap) {
        //待扩展
    }



    /**
     * 执行流程节点后执行
     *
     * @param execution
     * @param variablesMap
     * @param nodeDataMap
     */
    protected void afterExecution(DelegateExecution execution, Map<Object, Object> variablesMap, Map<Object, Object> nodeDataMap) {
        //待扩展
    }


}

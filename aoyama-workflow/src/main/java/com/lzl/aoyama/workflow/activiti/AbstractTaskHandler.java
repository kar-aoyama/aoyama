package com.lzl.aoyama.workflow.activiti;

import com.lzl.aoyama.workflow.api.dto.AbstractTaskInfo;
import com.lzl.aoyama.workflow.api.dto.ExecutionPerson;

import java.util.Map;

/**
 * @author lzl
 * @date 2021/9/7 16:39
 * @Description: 抽象task 处理
 */
public abstract class AbstractTaskHandler extends AbstractElement {

    //存储当前节点数据
    public abstract void processData();

    /**
     * 完成任务前回调
     *
     * @param businessKey
     * @param executionPerson
     * @param nodeDataMap
     * @param variableMap
     */
    public abstract void completeTaskBefore(
            String businessKey,
            ExecutionPerson executionPerson,
            Map<String, Object> nodeDataMap,
            Map<String, Object> variableMap);

    //代办完成
    public abstract void complete(AbstractTaskInfo taskInfo);


    public abstract void completeTaskAfter(String businessKey,
                                           ExecutionPerson executionPerson,
                                           Map<String, Object> nodeDataMap, Map<String, Object> variableMap);

    //存储流程数据
    public abstract void taskNodeData();
}

package com.lzl.aoyama.workflow.activiti;

import com.lzl.aoyama.workflow.api.dto.AbstractTaskInfo;

/**
 * @author lzl
 * @date 2021/9/7 16:39
 * @Description: 抽象task 处理
 */
public abstract class AbstractTaskHandler extends AbstractElement {

    //存储当前节点数据
    public abstract void processData();

    //代办完成
    public abstract void complete(AbstractTaskInfo taskInfo);

    //存储流程数据
    public abstract void taskNodeData();
}

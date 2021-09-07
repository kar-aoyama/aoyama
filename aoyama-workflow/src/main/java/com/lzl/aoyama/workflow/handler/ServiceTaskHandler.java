package com.lzl.aoyama.workflow.handler;

import com.lzl.aoyama.workflow.activiti.AbstractTaskHandler;
import com.lzl.aoyama.workflow.api.dto.AbstractTaskInfo;
import com.lzl.aoyama.workflow.listen.UserTaskListen;
import org.activiti.engine.delegate.DelegateTask;

/**
 * @author simba@onlying.cn
 * @date 2021/9/7 17:35
 * @Description:
 */
public class ServiceTaskHandler extends AbstractTaskHandler implements UserTaskListen {

    @Override
    public void processData() {

    }

    @Override
    public void complete(AbstractTaskInfo taskInfo) {

    }

    @Override
    public void taskNodeData() {

    }

    @Override
    public void notify(DelegateTask delegateTask) {

    }
}

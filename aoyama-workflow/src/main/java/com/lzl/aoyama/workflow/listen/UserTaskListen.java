package com.lzl.aoyama.workflow.listen;

import org.activiti.engine.delegate.DelegateTask;

/**
 * @author lzl
 * @date 2021/9/7 17:21
 * @Description:
 */
public interface UserTaskListen {

    //分配代办用户
    void notify(DelegateTask delegateTask);
}

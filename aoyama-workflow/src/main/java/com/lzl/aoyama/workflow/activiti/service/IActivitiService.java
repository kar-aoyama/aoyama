package com.lzl.aoyama.workflow.activiti.service;


import org.activiti.engine.task.Task;

/**
 * @author lzl
 * @date 2021/9/7 17:03
 * @Description:
 */
public interface IActivitiService {


    Task queryTask( String taskId,String userId);
}

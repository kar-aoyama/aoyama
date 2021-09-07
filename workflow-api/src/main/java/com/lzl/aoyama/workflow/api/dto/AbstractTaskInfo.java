package com.lzl.aoyama.workflow.api.dto;

import com.lzl.aoyama.workflow.api.enums.Approve;
import lombok.Data;

/**
 * @author simba@onlying.cn
 * @date 2021/9/7 17:12
 * @Description: task 代办完成必要数据
 */
@Data
public class AbstractTaskInfo {

    //代办任务id
    private String taskId;

    //执行人id
    private String userId;

    //审批结果
    private Approve approve;
}

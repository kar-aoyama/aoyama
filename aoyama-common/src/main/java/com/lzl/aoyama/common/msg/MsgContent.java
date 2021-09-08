package com.lzl.aoyama.common.msg;

import lombok.Data;

/**
 * @author lzl
 * @ClassName MsgContent
 * @date: 2021/8/23 上午11:26
 * @Description:
 */
@Data
public class MsgContent {

    //id
    private String id;

    //内容
    private String content;

    //发送目标
    private String[] to;

    //是否广播
    private boolean isBroadCast;
}

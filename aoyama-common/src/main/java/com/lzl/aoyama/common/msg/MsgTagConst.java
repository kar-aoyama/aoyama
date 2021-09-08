package com.lzl.aoyama.common.msg;

import lombok.Data;

/**
 * @author simba@onlying.cn
 * @date 2021/9/8 16:32
 * @Description:
 */
@Data
public final class MsgTagConst {

    //key值
    public static final String TAGS = "tags";

    //广播
    public static final String BROADCAST_TAG = "broadcast_tag";

    //单对单
    public static final String CLUSTER_TAG = "cluster_tag";
}

package com.lzl.aoyama.common.util;

import java.util.UUID;

/**
 * @author lzl
 * @ClassName UUidUtil
 * @date: 2021/5/17 下午3:37
 * @Description:
 */
public class UUidUtil {

    public static String uid(String prefix) {
        return prefix + "-" + UUID.randomUUID().toString().replaceAll("-", "");
    }


    public static String uid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}

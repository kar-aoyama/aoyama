package com.lzl.aoyama.common.util;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lzl
 * @ClassName RedisUtil
 * @date: 2021/5/21 下午3:14
 * @Description:
 */
@Component
public class RedisUtil {

    //@Autowired
    RedissonClient redissonClient;


    public boolean tryLock(String key) {
        RLock lock = redissonClient.getLock(key);
        return lock.tryLock();
    }

    public void unLock(String key) {
        RLock lock = redissonClient.getLock(key);
        lock.unlock();
    }

}

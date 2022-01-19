package com.lzl.aoyama.file.handler;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author lzl
 * @Date 2022/1/18 14:51
 * @Description:
 */
@Component
public class MinioHandler {

    @Autowired
    private MinioClient minioClient;



}

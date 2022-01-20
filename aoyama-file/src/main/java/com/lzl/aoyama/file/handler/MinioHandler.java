package com.lzl.aoyama.file.handler;

import com.lzl.aoyama.file.config.MinioConfig;
import io.minio.*;
import io.minio.errors.*;
import io.minio.http.Method;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

/**
 * @Author lzl
 * @Date 2022/1/18 14:51
 * @Description:
 */
@Slf4j
@Component
public class MinioHandler {

    @Autowired
    private MinioClient minioClient;

    @Autowired
    private MinioConfig minioConfig;

    public String upload(InputStream inputStream, String contentType, String fileName, long size) {
        PutObjectArgs putObjectArgs = PutObjectArgs.builder().bucket(minioConfig.getBucketName())
                .stream(inputStream, size, PutObjectArgs.MIN_MULTIPART_SIZE)
                .contentType(contentType).object(fileName).build();
        try {
            minioConfig.getClient().putObject(putObjectArgs);
            return getFileUrl(minioConfig.getBucketName(), fileName);
        } catch (ServerException | InternalException | XmlParserException | InvalidResponseException | InvalidKeyException | NoSuchAlgorithmException | InsufficientDataException | ErrorResponseException | IOException e) {
            log.error("文件上传失败:{}", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public byte[] download(String fileNmea) {
        GetObjectArgs args = GetObjectArgs.builder()
                .bucket(minioConfig.getBucketName())
                .object(fileNmea).build();
        try {
            GetObjectResponse response = minioClient.getObject(args);
            return response.readAllBytes();
        } catch (ServerException | InsufficientDataException | ErrorResponseException | IOException | NoSuchAlgorithmException | InvalidKeyException | InvalidResponseException | XmlParserException | InternalException e) {
            e.printStackTrace();
        }
        return null;
    }


    private String getFileUrl(String bucketName, String fileName) {
        try {
            GetPresignedObjectUrlArgs args = GetPresignedObjectUrlArgs.builder()
                    .method(Method.GET).expiry(1, TimeUnit.DAYS)
                    .bucket(bucketName).object(fileName).build();
            return minioClient.getPresignedObjectUrl(args);
        } catch (ServerException | InsufficientDataException | ErrorResponseException | IOException | InvalidKeyException | InvalidResponseException | XmlParserException | InternalException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}

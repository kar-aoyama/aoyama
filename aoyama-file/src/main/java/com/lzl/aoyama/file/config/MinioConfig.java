package com.lzl.aoyama.file.config;


import io.minio.MinioClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author lzl
 * @Date 2022/1/18 9:48
 * @Description:
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "minio")
public class MinioConfig {

    private String endpoint;

    private String bucketName;

    private String accessKey;

    private String secretKey;


    @Bean(name = "minioClient")
    public MinioClient getClient() {
        return MinioClient.builder().endpoint(this.getEndpoint())
                .credentials(this.getAccessKey(), this.getSecretKey()).build();
    }
}

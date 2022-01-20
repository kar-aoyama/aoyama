package com.lzl.aoyama.file.service.impl;

import cn.hutool.core.util.ArrayUtil;
import com.lzl.aoyama.file.handler.MinioHandler;
import com.lzl.aoyama.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author lzl
 * @Date 2022/1/19 16:18
 * @Description:
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private MinioHandler minioHandler;

    @Override
    public String upload(MultipartFile multipartFile) throws IOException {
        InputStream inputStream = multipartFile.getInputStream();
        String contentType = multipartFile.getContentType();
        String originalFilename = multipartFile.getOriginalFilename();
        long size = multipartFile.getSize();
        return minioHandler.upload(inputStream, contentType, originalFilename, size);
    }

    public void download(String fileName, HttpServletResponse response) {
        byte[] bytes = minioHandler.download(fileName);
        if (ArrayUtil.isNotEmpty(bytes)) {
            try {
                response.getOutputStream().write(bytes);
                response.addHeader("Content-Disposition", " attachment;filename=" + fileName);
                response.setContentType("application/octet-stream");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

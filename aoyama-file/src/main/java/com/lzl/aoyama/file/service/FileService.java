package com.lzl.aoyama.file.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author lzl
 * @Date 2022/1/19 16:18
 * @Description:
 */
public interface FileService {

    String upload(MultipartFile multipartFile) throws IOException;

    void download(String fileName, HttpServletResponse response);
}

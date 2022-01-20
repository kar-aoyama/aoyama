package com.lzl.aoyama.file.controller;

import com.lzl.aoyama.common.annotation.PermissionCheck;
import com.lzl.aoyama.common.controller.BaseController;
import com.lzl.aoyama.common.response.CommonResponse;
import com.lzl.aoyama.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author lzl
 * @Date 2022/1/19 16:16
 * @Description:
 */
@RestController
@RequestMapping("/file")
public class FileController extends BaseController {
    @Autowired
    private FileService fileService;


    @PermissionCheck
    @PostMapping("/upload")
    public CommonResponse<String> upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        return CommonResponse.success(fileService.upload(multipartFile));
    }

    @PermissionCheck
    @GetMapping("/download")
    public void download(@RequestParam("fileName") String fileName) {
        fileService.download(fileName, response);
    }


}

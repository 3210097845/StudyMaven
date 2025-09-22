package com.zzzj.controller;

import com.zzzj.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.zzzj.utils.AliyunOSSOperator;

import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("上传文件：{}", file);
        if (!file.isEmpty()) {
            // 上传文件
            String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());//上传文件字节码（文件内容）和文件名
            log.info("上传成功，文件地址为：{}", url);
            return Result.success(url);
        }
        return Result.error("上传失败");
    }

}
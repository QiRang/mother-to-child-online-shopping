package com.example.mothertochild.controller;

import com.example.mothertochild.util.JsonResult;
import com.example.mothertochild.util.MD5Util;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Wrapper;
import java.util.Objects;
import java.util.UUID;

@RestController
public class FileController {
    @PostMapping("user/userImageUpload")
    public JsonResult userImagesUpload(MultipartFile file) {
        JsonResult jsonResult = new JsonResult();
        System.out.println("传输文件");
        if (Objects.isNull(file) || file.isEmpty()) {
            jsonResult.setMessage("文件为空，请重新上传");
        }
        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //重新生成文件名
        fileName = UUID.randomUUID()+suffixName;
        //指定本地文件夹存储图片
        String filePath = "F:/Projects/IdeaProjects/mother-to-child/src/main/resources/static/images";
        try {
            //将图片保存到static文件夹里
            file.transferTo(new File(filePath+fileName));
            String path = filePath + fileName;
            jsonResult.setCode(200);
            jsonResult.setMessage("上传成功");
            jsonResult.setValue(path);
            //return new Massage(0,"success to upload");
        } catch (Exception e) {
            e.printStackTrace();
            //return new Massage(-1,"fail to upload");
        }
        return jsonResult;
    }
}

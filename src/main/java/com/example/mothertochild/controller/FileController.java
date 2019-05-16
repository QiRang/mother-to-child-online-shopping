package com.example.mothertochild.controller;

import com.example.mothertochild.util.JsonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.*;

@RestController
public class FileController {
    @PostMapping("/fileUpload")
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
        //String filePath = "F:/Projects/IdeaProjects/mother-to-child/src/main/resources/static/images/";
        String filePath = "F:/Projects/Images/mother-to-child/static/images/";

        //创建文件路径
        File dest = new File(filePath + fileName);

        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            //假如文件不存在即重新创建新的文件已防止异常发生
            dest.getParentFile().mkdirs();
        }
        try {
            //将图片保存到static文件夹里
            file.transferTo(new File(filePath+fileName));
            //String path = "http://localhost:8081/static/images/" + fileName;
            String path = "http://localhost:8081/images/" + fileName;
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

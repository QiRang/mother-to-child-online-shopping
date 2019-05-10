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
    //@Value("${web.upload-path}")
//    private String filePath = "F:/Project/Images/mother-to-child/static/images/";
    @PostMapping("user/userImageUpload")
    public JsonResult userImagesUpload(MultipartFile file) {
        List paths = new ArrayList();
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

        String filePath = "F:/Projects/IdeaProjects/mother-to-child/src/main/resources/static/images/";
        try {
            //将图片保存到static文件夹里
            file.transferTo(new File(filePath+fileName));
            String path = "http://localhost:8081/static/images/" + fileName;
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

    @PostMapping("/filesUpload")
    public JsonResult imageUpload(MultipartFile[] files) {
        List paths = new ArrayList();
        String filePath = "F:/Projects/IdeaProjects/mother-to-child/src/main/resources/static/images/";
        JsonResult jsonResult = new JsonResult();
        System.out.println(files);
        if(files != null && files.length >= 1 ){
            for (int i=0;i<files.length;i++){
                System.out.println("第"+i+"个文件名为:"+files[i].getName());
                //获取文件名
                String fileName = files[i].getOriginalFilename();
                //获取文件后缀名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                //重新生成文件名
                fileName = UUID.randomUUID() + suffixName;
                //指定本地文件夹存储图片
                try {
                    //将图片保存到static文件夹里
                    files[i].transferTo(new File(filePath + fileName));
                    System.out.println("value:" + jsonResult.getValue().toString());
                    String path = "http://localhost:8081/static/images/" + fileName +"," + jsonResult.getValue().toString();
                    System.out.println("path:" + path);
                    paths.add(path);
                    jsonResult.setCode(200);
                    jsonResult.setMessage("上传成功");
                    jsonResult.setValue(path);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


        return jsonResult;
    }
}

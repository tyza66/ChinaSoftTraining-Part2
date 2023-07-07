package com.sdm.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Author: tyza66
 * Date: 2023/7/6 13:08
 * Github: https://github.com/tyza66
 **/

@RestController
public class UpFileController {
    @PostMapping("/upfile")
    public String upfile(@RequestParam MultipartFile file) throws IOException {
        if(file!=null&& !file.isEmpty()){
            byte[] bytes = file.getBytes();
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\Project\\ChinaSoftTraining-Part2\\练习\\Spring\\SpringMVC_Demo0704\\upload\\"+file.getOriginalFilename());
            fileOutputStream.write(bytes);
            //文件名乱码可以new String(file.getOriginalFilename().getBytes("iso-8859-1"),"utf-8")
            //文件名冲突可以使用UUID或者时间错来解决
        }else {
            System.out.println("用户要请求文件进行上传");
            return "用户要请求文件进行上传";
        }
        return file.getOriginalFilename();
    }

    //下载文件的方法
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam("filename") String fileName) throws IOException{
        HttpHeaders headers = new HttpHeaders();
        String filename=new String(fileName.getBytes("iso-8859-1"),"utf-8");//为了解决中文名称乱码问题
        String path="D:\\Project\\ChinaSoftTraining-Part2\\练习\\Spring\\SpringMVC_Demo0704\\upload\\"+filename;
        System.out.println(path);
        File file=new File(path);

        headers.setContentDispositionFormData("attachment", filename);//不自动打开
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   //头文件内容类型
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);

    }
}

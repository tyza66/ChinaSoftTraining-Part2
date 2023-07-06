package com.sdm.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
            //文件名乱码可以new String(file.getOriginalFilename().getBytes(),"utf-8)
            //文件名冲突可以使用UUID或者时间错来解决
        }else {
            System.out.println("用户要请求文件进行上传");
            return "用户要请求文件进行上传";
        }
        return file.getOriginalFilename();
    }
}

package com.icss.test.controller;

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
import java.util.Date;
import java.util.UUID;

@RestController
public class UpFileController {

//    R类 所有的响应的数据都以R类形式返回
//    Code 状态码(成功 001 失败 004 未登录 002)  msg 信息(成功或者错误显示信息) data 数据

    @PostMapping("/upfile")
    public String upfile(@RequestParam  MultipartFile file) throws IOException {
        System.out.println(1/0);
        String newname = "";
//            如果用户选择文件 后端接收的文件则不为空
        if (file != null && !file.isEmpty()) {
            byte[] bytes = file.getBytes();
            //            解决文件名字中文乱码
            System.out.println(new String(file.getOriginalFilename().getBytes("iso-8859-1"),"utf-8"));
//            如果传入相同文件名字 会发生覆盖
//            1 采用时间戳方式 生成新的名字
//            2 采用生成uuid 唯一 生成新的名字
//            UUID.randomUUID()

//            原始名字
//            String oldname = file.getOriginalFilename();
            String oldname = new String(file.getOriginalFilename().getBytes("iso-8859-1"),"utf-8");
//          生成新名字
//            先获取文件的扩展名
            String extendName  = oldname.substring(oldname.lastIndexOf("."));
//            利用时间戳生成新的名字 new Date() 当前系统时间  getTime() 获取时间的毫秒数
//            newname = new Date().getTime() + extendName;
//            利用uuid生成文件新名字
            newname = UUID.randomUUID() + extendName;

            FileOutputStream fileOutputStream = new FileOutputStream("d://upload//" + newname);
            fileOutputStream.write(bytes);

            fileOutputStream.close();
        } else {
            System.out.println("用户要选择文件进行上传");
            return "用户要选择文件进行上传";
        }
        return newname;
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]>  download(@RequestParam("filename") String fileName) throws IOException{
        HttpHeaders headers = new HttpHeaders();
        String filename=new String(fileName.getBytes("iso-8859-1"),"utf-8");//为了解决中文名称乱码问题
        String path="d:\\upload\\"+filename;
        System.out.println(path);
        File file=new File(path);

        headers.setContentDispositionFormData("attachment", filename);//不自动打开
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   //头文件内容类型
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);

    }




}

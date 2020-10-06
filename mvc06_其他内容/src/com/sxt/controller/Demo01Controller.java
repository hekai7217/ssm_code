package com.sxt.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 黄药师
 * @date 2020-10-06 14:07
 * @desc 百战程序员 http://www.itbaizhan.com
 *    mvc的文件上传
 *
 *    01  文件上传的页面
 *       1.1  方法必须是post
 *       1.2  enctype 必须是多文件类型  enctype="multipart/form-data"
 *       1.3  文件上传的 type 必须是file 类型
 *
 *    02 服务器
 *      2.1   拿到文件
 *            直接参数绑定
 *            MultipartFile 可以和文件直接绑定
 *      2.2   创建一个文件夹,创建一个新文件
 *      2.3   把上传的文件保存到 到新文件中
 *      2.4   需要配置 图片解析器 (springmvc 提供好了 )
 *            需要导入第三方的 解析jar 包
 *
 *
 *
 */
@Controller
public class Demo01Controller {

    @RequestMapping("/image")
    public String saveImage(MultipartFile img,String name) throws IOException {

        // 看下多文件的数据
        // 全名
        String originalFilename = img.getOriginalFilename();
        System.out.println("originalFilename = " + originalFilename);
        // 拿到名字
        String name1 = img.getName();
        System.out.println("name1 = " + name1);
        long size = img.getSize();
        System.out.println("size = " + size);

        //  创建一个文件夹
        File dir = new File("C:/upload");
        if (!dir.exists()) {
            dir.mkdirs(); // 判断是否存在 如果不存在创建一个
        }

        // 创建一个新文件 保存图片

        // 新文件要求   文件名称.图片的后缀
        // 文件名称 防止图片重名  UUId  / 时间戳
        String fileName = UUID.randomUUID().toString().replaceAll("-", "");

        // 获取文件的后缀 名称
        String extension = FilenameUtils.getExtension(originalFilename);
        String newFile = fileName + "." + extension;

        File f = new File(dir, newFile);
        // 保存图片
        img.transferTo(f);

        return "/success.jsp";
    }


}

package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Custom;
import com.cskaoyan14th.mapper.CustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/*一个Controller模板，没有具体功能，测试时使用*/
@Controller
public class TestController {
    @Autowired
    CustomMapper customMapper;

    /*测试逆向工程，即测试操作数据库*/
    @RequestMapping("/test/sql")
    public String testConverter() {
        Custom custom = customMapper.selectByPrimaryKey("001");
        System.out.println(custom);
        return "404";
    }

    /*测试处理器，即数据转换器*/
    @RequestMapping("/test/converter")
    public String testConverter(Date date) {
        System.out.println(date);
        return "404";
    }

    /*测试拦截器*/
    @RequestMapping("/test/auth/test")
    public String testInterceptor() {
        return "404";
    }

    /*测试文件上传*/
    @RequestMapping("/test/fileUpload")
    public ModelAndView fileUpload(HttpServletRequest req, MultipartFile headico) {
        ModelAndView modelAndView = new ModelAndView();

        String realPath = "E:\\file2233/" + headico.getOriginalFilename();
        File file = new File(realPath);                                        //创建文件，准备上传文件
        if(!file.getParentFile().exists()){                                    //如果保存文件的父目录不存在，则创建该目录
            file.getParentFile().mkdirs();
        }
        try {
            headico.transferTo(file);                                          //文件上传
        } catch (IOException e) {
            e.printStackTrace();
        }

        modelAndView.setViewName("404");
        return modelAndView;
    }
}

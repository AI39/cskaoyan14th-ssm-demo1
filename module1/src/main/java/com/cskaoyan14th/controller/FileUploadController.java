package com.cskaoyan14th.controller;

import com.cskaoyan14th.vo.UploadMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileUploadController {

    @RequestMapping("file/upload")
    @ResponseBody
    public UploadMsg FujianUpload(MultipartFile file){
        UploadMsg uploadMsg = new UploadMsg();
        String originalFilename = file.getOriginalFilename();
        String realPath = "D:\\upload\\temp\\file\\" + originalFilename;
        File localFile = new File(realPath);
        if (!localFile.getParentFile().exists()){
            localFile.getParentFile().mkdir();
        }
        try {
            file.transferTo(localFile);
        } catch (IOException e) {
            e.printStackTrace();
            uploadMsg.setError(-1);
            return uploadMsg;
        }
        uploadMsg.setError(0);
        uploadMsg.setUrl("file",realPath);
        System.out.println(uploadMsg);
        return uploadMsg;
    }

    @RequestMapping("file/delete")
    @ResponseBody
    public String delete(String fileName){
        String data = "success";
        String path = fileName.replace("/file/","");
        File deleteFile = new File(path);
        boolean delete = false;
        if (deleteFile.exists()) {
            delete = deleteFile.delete();
        }
        if (delete){
            data = "success";
        }else {
            data = "false";
        }
        return data;
    }

    @RequestMapping("pic/upload")
    @ResponseBody
    public UploadMsg imgUpload(String dir,MultipartFile uploadFile,String Filename){
        System.out.println("进来了没啊");
        UploadMsg uploadMsg = new UploadMsg();
//        if (dir == "image"){
            //String originalFilename = Filename.getOriginalFilename();
            String type = Filename.substring(Filename.indexOf("."));
            String uuidFileName = "/pic/" + UUID.randomUUID().toString().replace("-", "") + type;
            System.out.println("uuidFileName=" + uuidFileName);
            String path = "D:\\upload" + uuidFileName;
            System.out.println("path=" + path);
            File localFile = new File(path);
            if (!localFile.getParentFile().exists()){
                localFile.getParentFile().mkdir();
            }
            try {
                uploadFile.transferTo(localFile);
            } catch (IOException e) {
                e.printStackTrace();
                uploadMsg.setError(-1);
                return uploadMsg;
            }
            uploadMsg.setError(0);
            uploadMsg.setUrl(uuidFileName);
            return uploadMsg;
//        }
//        uploadMsg.setError(0);
//        return uploadMsg;
    }


}

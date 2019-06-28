package com.cskaoyan14th.controller;

import com.cskaoyan14th.util.UploadRealPath;
import com.cskaoyan14th.vo.FileDeleteMsg;
import com.cskaoyan14th.vo.UploadMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileUploadController {

    @Autowired
    UploadRealPath REALPATH;

    @RequestMapping("file/upload")
    @ResponseBody
    public UploadMsg FujianUpload(MultipartFile file){
        UploadMsg uploadMsg = new UploadMsg();
        String originalFilename = file.getOriginalFilename();
        String url = "/temp/file/" + originalFilename;
        String realPath = REALPATH.getFilePath() + url;
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
        uploadMsg.setUrl(url);
        return uploadMsg;
    }

    /**
     * 文档下载
     * @param fileName 相对路径+文件名，例如：/pic/18759812598125.jpg
     * @param request
     * @param response
     */
    @RequestMapping("file/download")
    public void download(String fileName, HttpServletRequest request, HttpServletResponse response){
        //获取文件名，用于给用户下载的文件取名
        String downloadFileName = fileName.substring(fileName.lastIndexOf("/"));
        //文件在服务器的真实路径
        String realPath = REALPATH.getFilePath() + fileName;
        File file = new File(realPath);
        if (!file.exists()){
            try {
                request.getRequestDispatcher("/404.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //设置下载文档需要的相应头设置
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition","attachment;fileName="+downloadFileName);
        //IO流传输
        FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream(file);
                ServletOutputStream outputStream = response.getOutputStream();
                byte[] bytes = new byte[2048];
                int length = 0;
                while ((length = inputStream.read(bytes)) != -1){
                    outputStream.write(bytes,0,length);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null){
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
    }


    @RequestMapping("file/delete")
    @ResponseBody
    public FileDeleteMsg delete(String fileName){
        FileDeleteMsg msg = new FileDeleteMsg();
        String path = fileName.replace("/file/","");
        File deleteFile = new File(path);
        boolean delete = false;
        if (deleteFile.exists()) {
            delete = deleteFile.delete();
            if (delete){
                msg.setData("success");
            }else {
                msg.setData("false");
            }
        }else {
            msg.setData("success");
        }
        return msg;
    }

    @RequestMapping("pic/upload")
    @ResponseBody
    public UploadMsg imgUpload(String dir,MultipartFile uploadFile,String Filename){
        //System.out.println("进来了没啊");
        UploadMsg uploadMsg = new UploadMsg();
//        if (dir == "image"){
            //String originalFilename = Filename.getOriginalFilename();
            String type = Filename.substring(Filename.indexOf("."));
            String uuidFileName = "/pic/" + UUID.randomUUID().toString().replace("-", "") + type;
            //System.out.println("uuidFileName=" + uuidFileName);
            String path = "D:\\upload" + uuidFileName;
            //System.out.println("path=" + path);
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

    @RequestMapping("pic/delete")
    @ResponseBody
    public FileDeleteMsg picDelete(String picName){
        FileDeleteMsg msg = new FileDeleteMsg();
        String path = REALPATH.getFilePath() + "/pic/" + picName;
        //System.out.println(path);
        File file = new File(path);
        boolean delete = true;
        if (file.exists()){
            delete = file.delete();
            if (delete == true){
                msg.setData("success");
            }else {
                msg.setData("false");
            }
        }else {
            //表示服务器不存在这个文件，返回success是为了让前端直接删除改文件
            msg.setData("success");
        }
        return msg;
    }

}

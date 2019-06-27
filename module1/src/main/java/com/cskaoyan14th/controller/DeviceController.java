package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.service.DeviceService;
import com.cskaoyan14th.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DeviceController {
    @Autowired
    DeviceService deviceService;

    //deviceType前端增删改按钮显示
    @RequestMapping("/device/deviceType")
    public String deviceType(HttpServletRequest request) {
        MyUtil.sysPermissionList(request);
        return "/WEB-INF/jsp/deviceType";
    }

    //deviceType分页
    @RequestMapping("/deviceType/list")
    @ResponseBody
    public Page<DeviceType> deviceTypeList(int page, int rows) {
        Page<DeviceType> deviceTypePage = deviceService.getDeviceTypePage(page, rows);
        return deviceTypePage;
    }
    /*public PageInfo<DeviceType> deviceTypeList(int page, int rows) {
        PageInfo<DeviceType> deviceTypePage = deviceService.getDeviceTypePageInfo(page, rows);
        return deviceTypePage;
    }*/

    //deviceType新增检查
    @RequestMapping("/deviceType/add_judge")
    @ResponseBody
    public ResponseVo<DeviceType> deviceTypeAdd_judge() {
        ResponseVo data = new ResponseVo();
        return data;
    }

    //deviceType新增页面显示
    @RequestMapping("/deviceType/add")
    public String deviceTypeAdd() {
        return "/WEB-INF/jsp/deviceType_add";
    }

    //deviceType数据库新增
    @RequestMapping("deviceType/insert")
    @ResponseBody
    public ResponseVo<DeviceType> deviceTypeInsert(DeviceType deviceType) {
        ResponseVo<DeviceType> responseVo = new ResponseVo<>();
        //检查该deviceType
        Boolean flag = deviceService.deviceTypeIsExists(deviceType.getDeviceTypeId());
        if(flag) {
            responseVo.setStatus(0);
            responseVo.setMsg("该设备种类编号已经存在，请更换设备种类编号！");
            return responseVo;
        }

        //新增
        int i = deviceService.insertDeviceType(deviceType);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;
    }

}

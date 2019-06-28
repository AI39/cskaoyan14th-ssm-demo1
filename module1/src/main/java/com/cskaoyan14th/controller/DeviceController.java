package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.service.DeviceService;
import com.cskaoyan14th.util.MyUtil;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class DeviceController {
    @Autowired
    DeviceService deviceService;
    //一、DeviceType
    //(一)DeviceTyp显示
    //1.deviceType前端增删改按钮显示
    @RequestMapping("/device/deviceType")
    public String deviceType(HttpServletRequest request) {
        MyUtil.sysPermissionList(request, "deviceType");
        return "/WEB-INF/jsp/deviceType";
    }

    //2.deviceType分页
    @RequestMapping("/deviceType/list")
    @ResponseBody
    public Vo<DeviceType> deviceTypeList(int page, int rows){
        Vo<DeviceType> deviceTypeVo = deviceService.getDeviceTypeVo(page, rows);
        return deviceTypeVo;
    }
    //(二)DeviceType新增
    //1.deviceType新增检查
    @RequestMapping("/deviceType/add_judge")
    @ResponseBody
    public ResponseVo<DeviceType> deviceTypeAddJudge() {
        ResponseVo<DeviceType> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //2.deviceType新增页面显示
    @RequestMapping("/deviceType/add")
    public String deviceTypeAdd() {
        return "/WEB-INF/jsp/deviceType_add";
    }

    //3.deviceType数据库新增
    @RequestMapping("deviceType/insert")
    @ResponseBody
    public ResponseVo<DeviceType> deviceTypeInsert(DeviceType deviceType) {
        ResponseVo<DeviceType> responseVo = new ResponseVo<>();
        //检查该deviceType的id是否存在
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
            return responseVo;
        }
        return responseVo;
    }
    //(三)DeviceType编辑
    //1.DeviceType编辑检查
    @RequestMapping("/deviceType/edit_judge")
    @ResponseBody
    public ResponseVo<DeviceType> deviceTypeEditJudge() {
        ResponseVo<DeviceType> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //2.deviceType编辑页面显示
    @RequestMapping("/deviceType/edit")
    public String deviceTypeEdit() {
        return "/WEB-INF/jsp/deviceType_edit";
    }

    //3.deviceType数据库编辑
    @RequestMapping("/deviceType/update")
    @ResponseBody
    public ResponseVo<DeviceType> deviceTypeUpdate(DeviceType deviceType) {
        ResponseVo<DeviceType> responseVo = new ResponseVo<>();

        //编辑
        int i = deviceService.updateDeviceType(deviceType);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            return responseVo;
        }
        return responseVo;
    }

    //(四)DeviceType删除
    //1.DeviceType删除检查
    @RequestMapping("/deviceType/delete_judge")
    @ResponseBody
    public ResponseVo<DeviceType> deviceTypeDeleteJudge() {
        ResponseVo<DeviceType> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //2.deviceType数据库删除
    @RequestMapping("/deviceType/delete_batch")
    @ResponseBody
    public ResponseVo<DeviceType> deviceTypeDeleteBatch(String[] ids) {
        ResponseVo<DeviceType> responseVo = new ResponseVo<>();
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(ids));


        //删除
        int i = deviceService.deleteDeviceTypeByIds(list);
        if (i >= 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            return responseVo;
        }
        return responseVo;
    }

    //(五)DeviceType查询
    //1.按id查询
    @ResponseBody
    @RequestMapping("/deviceType/search_deviceType_by_deviceTypeId")
    public Vo<DeviceType> searchDeviceTypeByDeviceTypeId(String searchValue, int page, int rows) {
        Vo<DeviceType> deviceTypeVo = deviceService.searchDeviceTypeByDeviceTypeId(searchValue, page, rows);
        return deviceTypeVo;
    }
    //2.按名称查询
    @ResponseBody
    @RequestMapping("/deviceType/search_deviceType_by_deviceTypeName")
    public Vo<DeviceType> searchDeviceTypeByDeviceTypeName(String searchValue, int page, int rows) {
        Vo<DeviceType> deviceTypeVo = deviceService.searchDeviceTypeByDeviceTypeName(searchValue, page, rows);
        return deviceTypeVo;
    }


    //二、DeviceList
    //(一)DeviceList显示
    //1.deviceList前端增删改按钮显示
    @RequestMapping("/device/deviceList")
    public String deviceList(HttpServletRequest request) {
        MyUtil.sysPermissionList(request, "device");
        return "/WEB-INF/jsp/deviceList";
    }

    //2.deviceList分页
    @RequestMapping("/deviceList/list")
    @ResponseBody
    public Vo<DeviceShow> deviceList(int page, int rows){
        Vo<DeviceShow> deviceShowVo = deviceService.getDeviceShowVo(page, rows);
        return deviceShowVo;
    }

    //3.获得部门数据(待修改)
    @RequestMapping("/department/get_data")
    @ResponseBody
    public List<Department> getDepartment() {
        List<Department> list = deviceService.getDepartment();
        return list;
    }

    //4.设备种类显示(待修改)
    @RequestMapping("deviceType/get/{deviceTypeId}")
    @ResponseBody
    public DeviceType getDeviceTypeById(@PathVariable("deviceTypeId") String deviceTypeId) {
        DeviceType deviceType = deviceService.getDeviceTypeById(deviceTypeId);
        return deviceType;
    }



    //(二)DeviceList新增
    //1.DeviceList新增检查
    @RequestMapping("/deviceList/add_judge")
    @ResponseBody
    public ResponseVo<Device> deviceListAddJudge() {
        ResponseVo<Device> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //2.DeviceList新增页面显示
    @RequestMapping("/deviceList/add")
    public String deviceListAdd() {
        return "/WEB-INF/jsp/deviceList_add";
    }

    //3.DeviceType全部显示
    @RequestMapping("/deviceType/get_data")
    @ResponseBody
    public List<DeviceType> deviceTypeGetData() {
        List<DeviceType> list = deviceService.getDeviceType();
        return list;
    }

    //4.保管人全部显示(待修改)
    @RequestMapping("/employee/get_data")
    @ResponseBody
    public List<Employee> employeeGetData() {
        List<Employee> list = deviceService.getEmployee();
        return list;
    }

    //5.DeviceList数据库新增
    @RequestMapping("deviceList/insert")
    @ResponseBody
    public ResponseVo<Device> deviceListInsert(Device device) {
        ResponseVo<Device> responseVo = new ResponseVo<>();
        //检查该Device的id是否存在
        Boolean flag = deviceService.deviceIsExists(device.getDeviceId());
        if(flag) {
            responseVo.setStatus(0);
            responseVo.setMsg("该设备编号已经存在，请更换设备编号！");
            return responseVo;
        }

        //新增
        int i = deviceService.insertDevice(device);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            return responseVo;
        }
        return responseVo;
    }
}

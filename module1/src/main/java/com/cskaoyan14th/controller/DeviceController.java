package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.service.DeviceService;
import com.cskaoyan14th.util.MyUtil;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;

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
        responseVo.setStatus(99);
        responseVo.setMsg("未知的错误");
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
    @RequestMapping(value = {"/deviceType/update", "/deviceType/update_all"})
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
        responseVo.setStatus(99);
        responseVo.setMsg("未知的错误");
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
        if (i >= 0) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            return responseVo;
        }
        responseVo.setStatus(99);
        responseVo.setMsg("未知的错误");
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

    //3.DeviceList数据库新增
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

        //检查该Device的deviceTypeId是否存在
        flag = deviceService.deviceTypeIsExists(device.getDeviceTypeId());
        if(!flag) {
            responseVo.setStatus(1);
            responseVo.setMsg("该设备种类已删除，请刷新后再试！");
            return responseVo;
        }

        //新增
        int i = deviceService.insertDevice(device);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            return responseVo;
        }
        responseVo.setStatus(99);
        responseVo.setMsg("未知的错误");
        return responseVo;
    }

    //(三)DeviceList编辑
    //1.DeviceList编辑检查
    @RequestMapping("/deviceList/edit_judge")
    @ResponseBody
    public ResponseVo<Device> deviceListEditJudge() {
        ResponseVo<Device> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //2.deviceList编辑页面显示
    @RequestMapping("/deviceList/edit")
    public String deviceListEdit() {
        return "/WEB-INF/jsp/deviceList_edit";
    }

    //3.deviceList数据库编辑
    @RequestMapping(value = {"/deviceList/update", "/deviceList/update_all"})
    @ResponseBody
    public ResponseVo<Device> deviceListUpdate(Device device) {
        ResponseVo<Device> responseVo = new ResponseVo<>();

        //编辑
        int i = deviceService.updateDevice(device);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            return responseVo;
        }
        responseVo.setStatus(99);
        responseVo.setMsg("未知的错误");
        return responseVo;
    }

    //4.deviceList的update_note
    @RequestMapping("/deviceList/update_note")
    @ResponseBody
    public ResponseVo<Device> deviceListUpdateNode(Device device) {
        ResponseVo<Device> responseVo = new ResponseVo<>();

        //编辑
        int i = deviceService.updateDeviceNoteByDeviceId(device);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            return responseVo;
        }
        responseVo.setStatus(99);
        responseVo.setMsg("未知的错误");
        return responseVo;
    }


    //(四)DeviceList删除
    //1.DeviceList删除检查
    @RequestMapping("/deviceList/delete_judge")
    @ResponseBody
    public ResponseVo<Device> deviceListDeleteJudge() {
        ResponseVo<Device> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //2.DeviceList数据库删除
    @RequestMapping("/deviceList/delete_batch")
    @ResponseBody
    public ResponseVo<Device> deviceListDeleteBatch(String[] ids) {
        ResponseVo<Device> responseVo = new ResponseVo<>();
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(ids));


        //删除
        int i = deviceService.deleteDeviceByIds(list);
        if (i >= 0) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            return responseVo;
        }
        responseVo.setStatus(99);
        responseVo.setMsg("未知的错误");
        return responseVo;
    }

    //(五)DeviceList查询
    //1.按id查询
    @ResponseBody
    @RequestMapping("/deviceList/search_device_by_deviceId")
    public Vo<DeviceShow> searchDeviceByDeviceId(String searchValue, int page, int rows) {
        Vo<DeviceShow> deviceVo = deviceService.searchDeviceShowByDeviceId(searchValue, page, rows);
        return deviceVo;
    }
    //2.按名称查询
    @ResponseBody
    @RequestMapping("/deviceList/search_device_by_deviceName")
    public Vo<DeviceShow> searchDeviceByDeviceName(String searchValue, int page, int rows) {
        Vo<DeviceShow> deviceVo = deviceService.searchDeviceShowByDeviceName(searchValue, page, rows);
        return deviceVo;
    }

    //3.按设备种类名称查询
    @ResponseBody
    @RequestMapping("/deviceList/search_device_by_deviceTypeName")
    public Vo<DeviceShow> searchDeviceByDeviceTypeName(String searchValue, int page, int rows) {
        Vo<DeviceShow> deviceVo = deviceService.searchDeviceByDeviceTypeName(searchValue, page, rows);
        return deviceVo;
    }

    //三、DeviceCheck
    //(一)DeviceCheck显示
    //1.DeviceCheck前端增删改按钮显示
    @RequestMapping("/device/deviceCheck")
    public String deviceCheck(HttpServletRequest request) {
        MyUtil.sysPermissionList(request, "deviceCheck");
        return "/WEB-INF/jsp/deviceCheck";
    }

    //2.DeviceCheck分页
    @RequestMapping("/deviceCheck/list")
    @ResponseBody
    public Vo<DeviceCheckShow> deviceCheck(int page, int rows){
        Vo<DeviceCheckShow> deviceCheckShowVo = deviceService.getDeviceCheckShowVo(page, rows);
        return deviceCheckShowVo;
    }

    //(二)DeviceCheck新增
    //1.DeviceCheck新增检查
    @RequestMapping("/deviceCheck/add_judge")
    @ResponseBody
    public ResponseVo<DeviceCheck> deviceCheckAddJudge() {
        ResponseVo<DeviceCheck> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //2.DeviceCheck新增页面显示
    @RequestMapping("/deviceCheck/add")
    public String deviceCheckAdd() {
        return "/WEB-INF/jsp/deviceCheck_add";
    }

    //3.DeviceList数据库新增
    @RequestMapping("deviceCheck/insert")
    @ResponseBody
    public ResponseVo<DeviceCheck> deviceCheckInsert(DeviceCheck deviceCheck) {
        ResponseVo<DeviceCheck> responseVo = new ResponseVo<>();
        //检查该DeviceCheck的id是否存在
        Boolean flag = deviceService.deviceCheckIsExists(deviceCheck.getDeviceCheckId());
        if(flag) {
            responseVo.setStatus(0);
            responseVo.setMsg("该设备例检编号已经存在，请更换设备例检编号！");
            return responseVo;
        }

        //检查该DeviceCheck的deviceId是否存在
        flag = deviceService.deviceIsExists(deviceCheck.getDeviceId());
        if(!flag) {
            responseVo.setStatus(1);
            responseVo.setMsg("该设备已删除，请刷新后再试！");
            return responseVo;
        }

        //新增
        int i = deviceService.insertDeviceCheck(deviceCheck);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            return responseVo;
        }
        responseVo.setStatus(99);
        responseVo.setMsg("未知的错误");
        return responseVo;
    }

    //(三)DeviceCheck编辑
    //1.DeviceCheck编辑检查
    @RequestMapping("/deviceCheck/edit_judge")
    @ResponseBody
    public ResponseVo<DeviceCheck> deviceCheckEditJudge() {
        ResponseVo<DeviceCheck> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //2.deviceCheck编辑页面显示
    @RequestMapping("/deviceCheck/edit")
    public String deviceCheckEdit() {
        return "/WEB-INF/jsp/deviceCheck_edit";
    }

    //3.deviceCheck数据库编辑
    @RequestMapping("/deviceCheck/update")
    @ResponseBody
    public ResponseVo<DeviceCheck> deviceCheckUpdate(DeviceCheck deviceCheck) {
        ResponseVo<DeviceCheck> responseVo = new ResponseVo<>();

        //编辑
        int i = deviceService.updateDeviceCheck(deviceCheck);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            return responseVo;
        }
        responseVo.setStatus(99);
        responseVo.setMsg("未知的错误");
        return responseVo;
    }

    //4.deviceCheck的update_note
    @RequestMapping("/deviceCheck/update_note")
    @ResponseBody
    public ResponseVo<DeviceCheck> deviceCheckUpdateNode(DeviceCheck deviceCheck) {
        ResponseVo<DeviceCheck> responseVo = new ResponseVo<>();

        //编辑
        int i = deviceService.updateDeviceCheckNoteByDeviceCheckId(deviceCheck);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            return responseVo;
        }
        responseVo.setStatus(99);
        responseVo.setMsg("未知的错误");
        return responseVo;
    }

    //(四)DeviceCheck删除
    //1.DeviceCheck删除检查
    @RequestMapping("/deviceCheck/delete_judge")
    @ResponseBody
    public ResponseVo<DeviceCheck> deviceCheckDeleteJudge() {
        ResponseVo<DeviceCheck> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //2.DeviceCheck数据库删除
    @RequestMapping("/deviceCheck/delete_batch")
    @ResponseBody
    public ResponseVo<DeviceCheck> deviceCheckDeleteBatch(String[] ids) {
        ResponseVo<DeviceCheck> responseVo = new ResponseVo<>();
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(ids));


        //删除
        int i = deviceService.deleteDeviceCheckByIds(list);
        if (i >= 0) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            return responseVo;
        }
        responseVo.setStatus(99);
        responseVo.setMsg("未知的错误");
        return responseVo;
    }

    //(五)DeviceCheck查询
    //1.按id查询
    @ResponseBody
    @RequestMapping("/deviceCheck/search_deviceCheck_by_deviceCheckId")
    public Vo<DeviceCheckShow> searchDeviceCheckByDeviceId(String searchValue, int page, int rows) {
        Vo<DeviceCheckShow> deviceCheckShowVo = deviceService.searchDeviceCheckShowByDeviceCheckId(searchValue, page, rows);
        return deviceCheckShowVo;
    }
    //2.按设备名称查询
    @ResponseBody
    @RequestMapping("/deviceCheck/search_deviceCheck_by_deviceName")
    public Vo<DeviceCheckShow> searchDeviceCheckByDeviceName(String searchValue, int page, int rows) {
        Vo<DeviceCheckShow> deviceCheckShowVo = deviceService.searchDeviceCheckShowByDeviceName(searchValue, page, rows);
        return deviceCheckShowVo;
    }

    //四、DeviceFault
    //(一)DeviceFault显示
    //1.DeviceFault前端增删改按钮显示
    @RequestMapping("/device/deviceFault")
    public String deviceFault(HttpServletRequest request) {
        MyUtil.sysPermissionList(request, "deviceFault");
        return "/WEB-INF/jsp/deviceFault";
    }

    //2.DeviceFault分页
    @RequestMapping("/deviceFault/list")
    @ResponseBody
    public Vo<DeviceFaultShow> deviceFault(int page, int rows){
        Vo<DeviceFaultShow> deviceFaultShowVo = deviceService.getDeviceFaultShowVo(page, rows);
        return deviceFaultShowVo;
    }

    //(二)DeviceFault新增
    //1.DeviceFault新增检查
    @RequestMapping("/deviceFault/add_judge")
    @ResponseBody
    public ResponseVo<DeviceFault> deviceFaultAddJudge() {
        ResponseVo<DeviceFault> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //2.DeviceFault新增页面显示
    @RequestMapping("/deviceFault/add")
    public String deviceFaultAdd() {
        return "/WEB-INF/jsp/deviceFault_add";
    }

    //3.DeviceList数据库新增
    @RequestMapping("/deviceFault/insert")
    @ResponseBody
    public ResponseVo<DeviceFault> deviceFaultInsert(DeviceFault deviceFault) {
        ResponseVo<DeviceFault> responseVo = new ResponseVo<>();
        //检查该DeviceFault的id是否存在
        Boolean flag = deviceService.deviceFaultIsExists(deviceFault.getDeviceFaultId());
        if(flag) {
            responseVo.setStatus(0);
            responseVo.setMsg("该设备例检编号已经存在，请更换设备例检编号！");
            return responseVo;
        }

        //检查该DeviceFault的deviceId是否存在
        flag = deviceService.deviceIsExists(deviceFault.getDeviceId());
        if(!flag) {
            responseVo.setStatus(1);
            responseVo.setMsg("该设备已删除，请刷新后再试！");
            return responseVo;
        }

        //新增
        int i = deviceService.insertDeviceFault(deviceFault);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            return responseVo;
        }
        responseVo.setStatus(99);
        responseVo.setMsg("未知的错误");
        return responseVo;
    }

    //(三)DeviceFault编辑
    //1.DeviceFault编辑检查
    @RequestMapping("/deviceFault/edit_judge")
    @ResponseBody
    public ResponseVo<DeviceFault> deviceFaultEditJudge() {
        ResponseVo<DeviceFault> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //2.deviceFault编辑页面显示
    @RequestMapping("/deviceFault/edit")
    public String deviceFaultEdit() {
        return "/WEB-INF/jsp/deviceFault_edit";
    }

    //3.deviceFault数据库编辑
    @RequestMapping(value = {"/deviceFault/update", "/deviceFault/update_all"})
    @ResponseBody
    public ResponseVo<DeviceFault> deviceFaultUpdate(DeviceFault deviceFault) {
        ResponseVo<DeviceFault> responseVo = new ResponseVo<>();

        //编辑
        int i = deviceService.updateDeviceFault(deviceFault);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            return responseVo;
        }
        responseVo.setStatus(99);
        responseVo.setMsg("未知的错误");
        return responseVo;
    }

    //4.deviceFault的update_note
    @RequestMapping("/deviceFault/update_note")
    @ResponseBody
    public ResponseVo<DeviceFault> deviceFaultUpdateNode(DeviceFault deviceFault) {
        ResponseVo<DeviceFault> responseVo = new ResponseVo<>();

        //编辑
        int i = deviceService.updateDeviceFaultNoteByDeviceFaultId(deviceFault);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            return responseVo;
        }
        responseVo.setStatus(99);
        responseVo.setMsg("未知的错误");
        return responseVo;
    }

    //(四)DeviceFault删除
    //1.DeviceFault删除检查
    @RequestMapping("/deviceFault/delete_judge")
    @ResponseBody
    public ResponseVo<DeviceFault> deviceFaultDeleteJudge() {
        ResponseVo<DeviceFault> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //2.DeviceCheck数据库删除
    @RequestMapping("/deviceFault/delete_batch")
    @ResponseBody
    public ResponseVo<DeviceFault> deviceFaultDeleteBatch(String[] ids) {
        ResponseVo<DeviceFault> responseVo = new ResponseVo<>();
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(ids));


        //删除
        int i = deviceService.deleteDeviceFaultByIds(list);
        if (i >= 0) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            return responseVo;
        }
        responseVo.setStatus(99);
        responseVo.setMsg("未知的错误");
        return responseVo;
    }

    //(五)DeviceFault查询
    //1.按id查询
    @ResponseBody
    @RequestMapping("/deviceFault/search_deviceFault_by_deviceFaultId")
    public Vo<DeviceFaultShow> searchDeviceFaultShowByDeviceFaultId(String searchValue, int page, int rows) {
        Vo<DeviceFaultShow> deviceFaultShowVo = deviceService.searchDeviceFaultShowByDeviceFaultId(searchValue, page, rows);
        return deviceFaultShowVo;
    }
    //2.按设备名称查询
    @ResponseBody
    @RequestMapping("/deviceFault/search_deviceFault_by_deviceName")
    public Vo<DeviceFaultShow> searchDeviceFaultByDeviceName(String searchValue, int page, int rows) {
        Vo<DeviceFaultShow> deviceFaultShowVo = deviceService.searchDeviceFaultShowByDeviceName(searchValue, page, rows);
        return deviceFaultShowVo;
    }

    //五、DeviceMaintain
    //(一)DeviceMaintain显示
    //1.DeviceMaintain前端增删改按钮显示
    @RequestMapping("/device/deviceMaintain")
    public String deviceMaintain(HttpServletRequest request) {
        MyUtil.sysPermissionList(request, "deviceMaintain");
        return "/WEB-INF/jsp/deviceMaintain";
    }

    //2.DeviceMaintain分页
    @RequestMapping("/deviceMaintain/list")
    @ResponseBody
    public Vo<DeviceMaintainShow> deviceMaintain(int page, int rows){
        Vo<DeviceMaintainShow> deviceMaintainShowVo = deviceService.getDeviceMaintainShowVo(page, rows);
        return deviceMaintainShowVo;
    }

    //(二)DeviceMaintain新增
    //1.DeviceMaintain新增检查
    @RequestMapping("/deviceMaintain/add_judge")
    @ResponseBody
    public ResponseVo<DeviceMaintain> deviceMaintainAddJudge() {
        ResponseVo<DeviceMaintain> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //2.DeviceMaintain新增页面显示
    @RequestMapping("/deviceMaintain/add")
    public String deviceMaintainAdd() {
        return "/WEB-INF/jsp/deviceMaintain_add";
    }

    //3.DeviceMaintain数据库新增
    @RequestMapping("/deviceMaintain/insert")
    @ResponseBody
    public ResponseVo<DeviceMaintain> deviceMaintainInsert(DeviceMaintain deviceMaintain) {
        ResponseVo<DeviceMaintain> responseVo = new ResponseVo<>();
        //检查该DeviceFault的id是否存在
        Boolean flag = deviceService.deviceMaintainIsExists(deviceMaintain.getDeviceMaintainId());
        if(flag) {
            responseVo.setStatus(0);
            responseVo.setMsg("该设备例检编号已经存在，请更换设备例检编号！");
            return responseVo;
        }

        //检查该DeviceMaintain的deviceFaultId是否存在
        flag = deviceService.deviceFaultIsExists(deviceMaintain.getDeviceFaultId());
        if(!flag) {
            responseVo.setStatus(1);
            responseVo.setMsg("该故障已删除，请刷新后再试！");
            return responseVo;
        }

        //新增
        int i = deviceService.insertDeviceMaintain(deviceMaintain);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            return responseVo;
        }
        responseVo.setStatus(99);
        responseVo.setMsg("未知的错误");
        return responseVo;
    }
    //(三)DeviceMaintain编辑
    //1.DeviceMaintain编辑检查
    @RequestMapping("/deviceMaintain/edit_judge")
    @ResponseBody
    public ResponseVo<DeviceMaintain> deviceMaintainEditJudge() {
        ResponseVo<DeviceMaintain> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //2.deviceMaintain编辑页面显示
    @RequestMapping("/deviceMaintain/edit")
    public String deviceMaintainEdit() {
        return "/WEB-INF/jsp/deviceMaintain_edit";
    }

   //3.deviceMaintain数据库编辑
    @RequestMapping(value = {"/deviceMaintain/update", "/deviceMaintain/update_all"})
    @ResponseBody
    public ResponseVo<DeviceMaintain> deviceMaintainUpdate(DeviceMaintain deviceMaintain) {
        ResponseVo<DeviceMaintain> responseVo = new ResponseVo<>();

        //编辑
        int i = deviceService.updateDeviceMaintain(deviceMaintain);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            return responseVo;
        }
        responseVo.setStatus(99);
        responseVo.setMsg("未知的错误");
        return responseVo;
    }

    //4.deviceMaintain的update_note
    @RequestMapping("/deviceMaintain/update_note")
    @ResponseBody
    public ResponseVo<DeviceMaintain> deviceMaintainUpdateNode(DeviceMaintain deviceMaintain) {
        ResponseVo<DeviceMaintain> responseVo = new ResponseVo<>();

        //编辑
        int i = deviceService.updateDeviceMaintainNoteByDeviceMaintainId(deviceMaintain);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            return responseVo;
        }
        responseVo.setStatus(99);
        responseVo.setMsg("未知的错误");
        return responseVo;
    }

    //(四)DeviceMaintain删除
    //1.DeviceMaintain删除检查
    @RequestMapping("/deviceMaintain/delete_judge")
    @ResponseBody
    public ResponseVo<DeviceMaintain> deviceMaintainDeleteJudge() {
        ResponseVo<DeviceMaintain> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //2.DeviceMaintain数据库删除
    @RequestMapping("/deviceMaintain/delete_batch")
    @ResponseBody
    public ResponseVo<DeviceMaintain> deviceMaintainDeleteBatch(String[] ids) {
        ResponseVo<DeviceMaintain> responseVo = new ResponseVo<>();
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(ids));


        //删除
        int i = deviceService.deleteDeviceMaintainByIds(list);
        if (i >= 0) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            return responseVo;
        }
        responseVo.setStatus(99);
        responseVo.setMsg("未知的错误");
        return responseVo;
    }

    //(五)DeviceMaintain查询
    //1.按id查询
    @ResponseBody
    @RequestMapping("/deviceMaintain/search_deviceMaintain_by_deviceMaintainId")
    public Vo<DeviceMaintainShow> searchDeviceMaintainShowByDeviceMaintainId(String searchValue, int page, int rows) {
        Vo<DeviceMaintainShow> deviceMaintainShowVo = deviceService.searchDeviceMaintainShowByDeviceMaintainId(searchValue, page, rows);
        return deviceMaintainShowVo;
    }
    //2.按故障编号查询
    @ResponseBody
    @RequestMapping("/deviceMaintain/search_deviceMaintain_by_deviceFaultId")
    public Vo<DeviceMaintainShow> searchDeviceMaintainByDeviceFaultId(String searchValue, int page, int rows) {
        Vo<DeviceMaintainShow> deviceMaintainShowVo = deviceService.searchDeviceMaintainShowByDeviceFaultId(searchValue, page, rows);
        return deviceMaintainShowVo;
    }

}

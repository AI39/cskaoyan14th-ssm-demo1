package com.cskaoyan14th.controller;


import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 处理所有下拉列表框需要加载的JSON数据的请求，***get_data请求
 */
@Controller
public class GetDataController {

    @Autowired
    ProductService productService;
    @Autowired
    CustomService customService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DeviceService deviceService;
    @Autowired
    ManufactureService manufactureService;
    @Autowired
    WorkService workService;


    @RequestMapping("product/get_data")
    @ResponseBody
    public List<Product> getProductData(){
        List<Product> productList = productService.queryProducts();
        return productList;
    }

    @RequestMapping("custom/get_data")
    @ResponseBody
    public List<Custom> getCustomData(){
        List<Custom> customList = customService.queryCustoms();
        return customList;
    }


    /**
     * 人员的列表查询
     * @return
     */
    @RequestMapping("employee/get_data")
    @ResponseBody
    public List<Employee> getEmployeeData() {
        List<Employee> employeeList = employeeService.queryMember();
        return employeeList;
    }
    @RequestMapping("/deviceType/get_data")
    @ResponseBody
    public List<DeviceType> deviceTypeGetData() {
        List<DeviceType> list = deviceService.getDeviceType();
        return list;
    }

    @RequestMapping("/deviceList/get_data")
    @ResponseBody
    public List<Device> deviceGetData() {
        List<Device> list = deviceService.getDevice();
        return list;
    }

    @RequestMapping("/deviceFault/get_data")
    @ResponseBody
    public List<DeviceFaultShow> deviceFaultGetData() {
        List<DeviceFaultShow> list = deviceService.getDeviceFaultShow();
        return list;
    }

    @RequestMapping("deviceType/get/{deviceTypeId}")
    @ResponseBody
    public DeviceType getDeviceTypeById(@PathVariable("deviceTypeId") String deviceTypeId) {
        DeviceType deviceType = deviceService.getDeviceTypeById(deviceTypeId);
        return deviceType;
    }

    @RequestMapping("deviceList/get/{deviceId}")
    @ResponseBody
    public Device getDeviceById(@PathVariable("deviceId") String deviceId) {
        Device device = deviceService.getDeviceById(deviceId);
        return device;

    }

    @RequestMapping("/manufacture/get_data")
    @ResponseBody
    public List<Manufacture> manufactureGetData() {
        List<Manufacture> list = manufactureService.multiSelectAll();
        return list;
    }

    @RequestMapping("manufacture/get/{manufactureSn}")
    @ResponseBody
    public Manufacture getManufactureById(@PathVariable("manufactureSn") String manufactureSn) {
        Manufacture manufacture = manufactureService.multiSelectByManufactureSn(manufactureSn);
        return manufacture;
    }

    @RequestMapping("/work/get_data")
    @ResponseBody
    public List<Work> workGetData() {
        List<Work> list = workService.multiSelectAll();
        return list;
    }

    @RequestMapping("work/get/{workId}")
    @ResponseBody
    public Work getWorkById(@PathVariable("workId") String workId) {
        Work work = workService.multiSelectByWorkId(workId);
        return work;
    }
}

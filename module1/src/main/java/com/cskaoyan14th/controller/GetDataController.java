package com.cskaoyan14th.controller;


import com.cskaoyan14th.bean.Custom;
import com.cskaoyan14th.bean.Employee;
import com.cskaoyan14th.bean.Product;
import com.cskaoyan14th.service.*;

import com.cskaoyan14th.bean.*;

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
    OrderService orderService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    DeviceService deviceService;

    @Autowired
    MaterialService materialService;


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



    @RequestMapping("order/get_data")
    @ResponseBody
    public List<COrder> getOrderData(){
        List<COrder> orderList = orderService.queryOrders();
        return orderList;
    }

    /*以下是employee功能块*/
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
    /*以下是department功能块*/
    /**
     * 部门列表查询
     * @return
     */
    @RequestMapping("department/get_data")
    @ResponseBody
    public List<Department> getDempartmentData(){
        List<Department> departmentList = departmentService.queryDepartmentAll();
        return departmentList;
    }
    /**
     *
     * @return
     */
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



    //material数据获取
    @RequestMapping("material/get_data")
    @ResponseBody
    public List<Material> getMaterialData(){
        List<Material> materialList = materialService.getAllMaterial();
        return materialList;
    }

    //work数据获取
    @RequestMapping("work/get_data")
    @ResponseBody
    public List<Work> getWorkData(){
        List<Work> workList = materialService.getAllWork();
        return workList;
    }


    @RequestMapping("deviceFault/get/{deviceFaultId}")
    @ResponseBody
    public DeviceFault getDeviceFaultById(@PathVariable("deviceFaultId") String deviceFaultId) {
        DeviceFault deviceFault = deviceService.getDeviceFaultById(deviceFaultId);
        return deviceFault;
    }

}

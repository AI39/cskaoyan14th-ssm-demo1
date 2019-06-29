package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Custom;
import com.cskaoyan14th.bean.Product;
import com.cskaoyan14th.bean.Technology;
import com.cskaoyan14th.bean.TechnologyPlan;
import com.cskaoyan14th.service.CustomService;
import com.cskaoyan14th.service.ProductService;
import com.cskaoyan14th.service.TechnologyService;
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
    TechnologyService technologyService;

    @RequestMapping("product/get_data")
    @ResponseBody
    public List<Product> getProductData(){
        List<Product> productList = productService.queryProductList();
        return productList;
    }

    @RequestMapping("custom/get_data")
    @ResponseBody
    public List<Custom> getCustomData(){
        List<Custom> customList = customService.queryCustoms();
        return customList;
    }
    @RequestMapping("technology/get/{technologyId}")
    @ResponseBody
    public Technology getTechnologyById(@PathVariable("technologyId") String technologyId){
        Technology technology = technologyService.getTechnologyById(technologyId);
        return technology;
    }
    @RequestMapping("/technology/get_data")
    @ResponseBody
    public List<Technology> getTechnologyData(){
        List<Technology> allTechnologyData = technologyService.getAllTechnologyData();
        return allTechnologyData;
    }
    @RequestMapping("/technologyPlan/get_data")
    @ResponseBody
    public List<TechnologyPlan> getTechnologyPlanData(){
        List<TechnologyPlan> allTechnologyPlanData = technologyService.getAllTechnologyPlanData();
        return allTechnologyPlanData;
    }

}

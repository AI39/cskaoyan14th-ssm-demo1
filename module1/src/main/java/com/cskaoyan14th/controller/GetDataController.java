package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Custom;
import com.cskaoyan14th.bean.Product;
import com.cskaoyan14th.service.CustomService;
import com.cskaoyan14th.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
